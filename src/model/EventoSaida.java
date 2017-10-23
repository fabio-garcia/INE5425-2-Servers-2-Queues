package model;

import control.Sistema;
import model.Servidor.EstadoServidor;
import model.Tempo.UnidadeTempo;

public class EventoSaida extends Evento {

	public EventoSaida(Entidade e, Tempo tExecucao) {
		super(e, tExecucao, null);
	}

	@Override
	public void executa(Servidor serv1, Servidor serv2) {
		// se tiver alguem na fila, puxa o primeiro, se não só sai.
		if (entidade.getTipo() == 1) {
			if (serv1.getEstado() == EstadoServidor.MANUTENCAO) {
//				System.out.println("Entrou Delay:");
//				System.out.println("Serv volta = "+serv1.getTempoVoltaFuncionar().getEmSegundos());
//				System.out.println("Falta = "+ entidade.quantoFaltaPraTerminar());
				EventoSaida e = new EventoSaida(entidade,
						new Tempo(serv1.getTempoVoltaFuncionar().getEmSegundos() + entidade.quantoFaltaPraTerminar(),
								UnidadeTempo.SEGUNDOS));
				Sistema.getInstance(null).adicionaNovoEvento(e);
//				System.out.println(entidade.quantoFaltaPraTerminar());
//				System.out.println(e.getTExecucao().getEmSegundos()+"\n");
			} else {
				if (!serv1.getFila().isEmpty()) {
					Entidade e1 = serv1.retiraFila();
					EventoSaida e = new EventoSaida(e1,
							new Tempo(Relogio.getInstance().getTempo().getEmSegundos() + e1.getTServ().getEmSegundos(),
									UnidadeTempo.SEGUNDOS));
					e1.atender(Relogio.getInstance().getTempo());
					serv1.setRodando(e1);
					Sistema.getInstance(null).adicionaNovoEvento(e);
					Tempo tEmFila = new Tempo (e1.getTInicioAtendimento().getEmSegundos()-e1.getChegada().getEmSegundos(),UnidadeTempo.SEGUNDOS);
					Estatisticas.getInstance().setTempoMedioEntidadeNaFilaServ1(tEmFila);
				} else {
					serv1.setEstado(EstadoServidor.LIVRE);
					serv1.setRodando(null);
				}
				Estatisticas.getInstance().incNumeroEntidadesSaidaTipo1();
				Estatisticas.getInstance().setTempoMedioNoSistemaTipo1(entidade, tExecucao);
			}
		} else {
			//tipo 2
			if (serv2.getEstado() == EstadoServidor.MANUTENCAO) {
				EventoSaida e = new EventoSaida(entidade,
						new Tempo(serv2.getTempoVoltaFuncionar().getEmSegundos() + entidade.quantoFaltaPraTerminar(),
								UnidadeTempo.SEGUNDOS));
				Sistema.getInstance(null).adicionaNovoEvento(e);
//				System.out.println(entidade.quantoFaltaPraTerminar());
//				System.out.println(e.getTExecucao().getEmSegundos()+"\n");
			} else {
				if (!serv2.getFila().isEmpty()) {
					Entidade e1 = serv2.retiraFila();
					EventoSaida e = new EventoSaida(e1,
							new Tempo(Relogio.getInstance().getTempo().getEmSegundos() + e1.getTServ().getEmSegundos(),
									UnidadeTempo.SEGUNDOS));
					e1.atender(Relogio.getInstance().getTempo());
					serv2.setRodando(e1);
					Sistema.getInstance(null).adicionaNovoEvento(e);
					Tempo tEmFila = new Tempo (e1.getTInicioAtendimento().getEmSegundos()-e1.getChegada().getEmSegundos(),UnidadeTempo.SEGUNDOS);
					Estatisticas.getInstance().setTempoMedioEntidadeNaFilaServ2(tEmFila);
				} else {
					serv2.setEstado(EstadoServidor.LIVRE);
					serv2.setRodando(null);
				}
				Estatisticas.getInstance().incNumeroEntidadesSaidaTipo2();
				Estatisticas.getInstance().setTempoMedioNoSistemaTipo2(entidade, tExecucao);
			}
		}
	}

}

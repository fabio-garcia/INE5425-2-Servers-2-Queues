package model;

import control.Gerador;
import control.Sistema;
import model.Servidor.EstadoServidor;

public class EventoFalha extends Evento {

	public EventoFalha(Servidor serv, Tempo tExecucao) {
		super(null, tExecucao, serv);
	}

	@Override
	public void executa(Servidor serv1, Servidor serv2) {
		if (serv.getEstado() != EstadoServidor.MANUTENCAO) {
			Tempo tempoVoltaFunc;
			if (serv.getTipo() == 1) {
				Estatisticas.getInstance().incNumeroFalhasServ1();
				tempoVoltaFunc = Gerador.geraTempoFalhaServ1(tExecucao.getEmSegundos());
			} else {
				Estatisticas.getInstance().incNumeroFalhasServ2();
				tempoVoltaFunc = Gerador.geraTempoFalhaServ2(tExecucao.getEmSegundos());
			}
			serv.falhar(tempoVoltaFunc);
			Sistema.getInstance(null).adicionaNovoEvento(new EventoConsertar(serv, tempoVoltaFunc));
		}
	}

}

package model;

import model.Servidor.EstadoServidor;

public class EventoCriacao extends Evento {

	public EventoCriacao(Entidade e, Tempo tExecucao) {
		super(e, tExecucao, null);
	}

	@Override
	public void executa(Servidor serv1, Servidor serv2) {
		if (entidade.getTipo() == 1) {
			if (serv1.getEstado() == EstadoServidor.MANUTENCAO) {
				if (serv2.getEstado() == EstadoServidor.MANUTENCAO){
					serv1.ocupar(entidade);
					Estatisticas.getInstance().incNumeroEntidadesTipo1();
				} else {
					entidade.setTipo(2);
					Estatisticas.getInstance().incnumeroTrocas();
					serv2.ocupar(entidade);
					Estatisticas.getInstance().incNumeroEntidadesTipo2();
				}
			} else {
				serv1.ocupar(entidade);
				Estatisticas.getInstance().incNumeroEntidadesTipo1();
			}
		} else {
			if (serv2.getEstado() == EstadoServidor.MANUTENCAO) {
				if (serv1.getEstado() == EstadoServidor.MANUTENCAO){
					serv2.ocupar(entidade);
					Estatisticas.getInstance().incNumeroEntidadesTipo2();
				} else {
					entidade.setTipo(1);
					Estatisticas.getInstance().incnumeroTrocas();
					serv1.ocupar(entidade);
					Estatisticas.getInstance().incNumeroEntidadesTipo1();
				}
			} else {
				serv2.ocupar(entidade);
				Estatisticas.getInstance().incNumeroEntidadesTipo2();
			}
		}
	}

}

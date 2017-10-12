package model;

public class EventoConsertar extends Evento {

	public EventoConsertar(Servidor serv, Tempo tExecucao) {
		super(null, tExecucao, serv);
		
	}

	@Override
	public void executa(Servidor serv1, Servidor serv2) {
		serv.consertar();
	}

}

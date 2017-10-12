package model;

public abstract class Evento implements Comparable<Evento> {
	
	protected Tempo tExecucao;
	protected Entidade entidade;
	protected Servidor serv;
	
	public Evento (Entidade e, Tempo tExecucao, Servidor serv) {
		this.entidade = e;
		this.tExecucao = tExecucao;
		this.serv = serv;
	}

	@Override
	public int compareTo(Evento e1) {
		if (this.tExecucao.getEmSegundos() > e1.getTExecucao().getEmSegundos()) {
			return 1;
		} else if (this.tExecucao.getEmSegundos() == e1.getTExecucao().getEmSegundos()) {
			return 0;
		}
		return -1;
	}
	
	public Tempo getTExecucao() {
		return tExecucao;
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public abstract void executa(Servidor serv1, Servidor serv2);

}

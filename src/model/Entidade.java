package model;

public class Entidade {
	
	private int tipo;
	private Tempo tChegada;
	private Tempo tInicioAtendimento;
	private Tempo tServ;
	private double faltaPraTerminar;
	
	public Entidade (int tipo, Tempo tChegada, Tempo tServ) {
		this.tipo = tipo;
		this.tChegada = tChegada;
		this.tServ = tServ;
		this.faltaPraTerminar = tServ.getEmSegundos();
	}
	
	public Tempo getChegada() {
		return tChegada;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void atender(Tempo tInicioAtendimento) {
		this.tInicioAtendimento = tInicioAtendimento;
	}
	
	public void decFaltaPraTerminar(double tempo) {
		faltaPraTerminar = faltaPraTerminar - (tempo - tInicioAtendimento.getEmSegundos());
	}
	
	public Tempo getTInicioAtendimento() {
		return tInicioAtendimento;
	}
	
	public Tempo getTServ() {
		return tServ;
	}

	public double quantoFaltaPraTerminar() {
		return faltaPraTerminar;
	}

	public void setTipo(int i) {
		tipo = i;
	}

}

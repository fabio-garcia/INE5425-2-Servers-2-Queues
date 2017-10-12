package model;

import model.Servidor.EstadoServidor;

public class Estatisticas {

	private static Estatisticas e;

	private double numeroMedioDeEntidadeFila1;
	private double numeroMedioDeEntidadeFila2;
	private double numeroMedioDeEntidadeFilas;
	private double pesoAcumulado;

	private double taxaMediaOcupacaoDoServidor1;
	private double taxaMediaOcupacaoDoServidor2;

	private double tempoMedioEntidadeNaFilaServ1;
	private double tempoMedioEntidadeNaFilaServ2;
	private double tempoMedioEntidadeNaFilaTotal;

	private double tempoMedioNoSistemaTipo1;
	private double tempoMedioNoSistemaTipo2;

	private int numeroEntidadesTipo1;
	private int numeroEntidadesTipo2;

	private int numeroEntidadesSaidaTipo1;
	private int numeroEntidadesSaidaTipo2;

	private int numeroFalhasServ1;
	private int numeroFalhasServ2;
	
	private double percentTempoEmFalhaServ1;
	private double percentTempoEmFalhaServ2;

	private int numeroTrocas;

	private int auxContFila1;
	private int auxContFila2;

	private Estatisticas() {
		numeroMedioDeEntidadeFila1 = 0;
		numeroMedioDeEntidadeFila2 = 0;
		numeroMedioDeEntidadeFilas = 0;
		pesoAcumulado = 0;

		taxaMediaOcupacaoDoServidor1 = 0;
		taxaMediaOcupacaoDoServidor2 = 0;

		tempoMedioEntidadeNaFilaServ1 = 0;
		tempoMedioEntidadeNaFilaServ2 = 0;
		tempoMedioEntidadeNaFilaTotal = 0;

		tempoMedioNoSistemaTipo1 = 0;
		tempoMedioNoSistemaTipo2 = 0;

		numeroEntidadesTipo1 = 0;
		numeroEntidadesTipo2 = 0;

		numeroEntidadesSaidaTipo1 = 0;
		numeroEntidadesSaidaTipo2 = 0;

		numeroFalhasServ1 = 0;
		numeroFalhasServ2 = 0;
		
		percentTempoEmFalhaServ1 = 0;
		percentTempoEmFalhaServ2 = 0;

		numeroTrocas = 0;

		auxContFila1 = 0;
		auxContFila2 = 0;
	}

	public static Estatisticas getInstance() {
		if (e == null) {
			e = new Estatisticas();
		}
		return e;
	}

	public double getNumeroMedioDeEntidadeFila1() {
		return numeroMedioDeEntidadeFila1;
	}

	public double getNumeroMedioDeEntidadeFila2() {
		return numeroMedioDeEntidadeFila2;
	}

	public double getNumeroMedioDeEntidadeFilas() {
		return numeroMedioDeEntidadeFilas;
	}

	public void setNumeroMedioDeEntidadeFila1(Tempo atual, Servidor serv) {
		this.numeroMedioDeEntidadeFila1 = (numeroMedioDeEntidadeFila1 * pesoAcumulado
				+ serv.getFila().size() * (atual.getEmSegundos() - pesoAcumulado)) / (atual.getEmSegundos());
	}

	public void setNumeroMedioDeEntidadeFila2(Tempo atual, Servidor serv) {
		this.numeroMedioDeEntidadeFila2 = (numeroMedioDeEntidadeFila2 * pesoAcumulado
				+ serv.getFila().size() * (atual.getEmSegundos() - pesoAcumulado)) / (atual.getEmSegundos());
	}

	public void setNumeroMedioDeEntidadeFilas(Tempo atual, Servidor serv, Servidor serv2) {
		this.numeroMedioDeEntidadeFilas = (numeroMedioDeEntidadeFilas * pesoAcumulado
				+ (serv.getFila().size() + serv2.getFila().size()) * (atual.getEmSegundos() - pesoAcumulado))
				/ (atual.getEmSegundos());
	}

	public void setTaxaMediaOcupacaoDoServidor1(Tempo atual, Servidor serv) {
		double tempoOcupadoAcumulado = taxaMediaOcupacaoDoServidor1 * pesoAcumulado;
		double tempoDesdeUltimaVerificacao = atual.getEmSegundos() - pesoAcumulado;
		if (serv.getEstado() == EstadoServidor.OCUPADO) {
			this.taxaMediaOcupacaoDoServidor1 = (tempoOcupadoAcumulado + tempoDesdeUltimaVerificacao)
					/ atual.getEmSegundos();
			this.percentTempoEmFalhaServ1 = (percentTempoEmFalhaServ1 * pesoAcumulado)
					/ atual.getEmSegundos();
		} else {
			this.taxaMediaOcupacaoDoServidor1 = tempoOcupadoAcumulado / atual.getEmSegundos();
			if (EstadoServidor.MANUTENCAO == serv.getEstado()) {
				this.percentTempoEmFalhaServ1 = (percentTempoEmFalhaServ1 * pesoAcumulado +
						tempoDesdeUltimaVerificacao)/atual.getEmSegundos();
			} else {
				this.percentTempoEmFalhaServ1 = (percentTempoEmFalhaServ1 * pesoAcumulado)
						/ atual.getEmSegundos();
			}
		}
	}

	public void setTaxaMediaOcupacaoDoServidor2(Tempo atual, Servidor serv) {
		double tempoOcupadoAcumulado = taxaMediaOcupacaoDoServidor2 * pesoAcumulado;
		double tempoDesdeUltimaVerificacao = atual.getEmSegundos() - pesoAcumulado;
		if (serv.getEstado() == EstadoServidor.OCUPADO) {
			this.taxaMediaOcupacaoDoServidor2 = (tempoOcupadoAcumulado + tempoDesdeUltimaVerificacao)
					/ atual.getEmSegundos();
			this.percentTempoEmFalhaServ2 = (percentTempoEmFalhaServ1 * pesoAcumulado)
					/ atual.getEmSegundos();
		} else {
			this.taxaMediaOcupacaoDoServidor2 = tempoOcupadoAcumulado / atual.getEmSegundos();
			if (EstadoServidor.MANUTENCAO == serv.getEstado()) {
				this.percentTempoEmFalhaServ2 = (percentTempoEmFalhaServ2 * pesoAcumulado +
						tempoDesdeUltimaVerificacao)/atual.getEmSegundos();
			} else {
				this.percentTempoEmFalhaServ2 = (percentTempoEmFalhaServ2 * pesoAcumulado)
						/ atual.getEmSegundos();
			}
		}
	}

	public double getTaxaMediaOcupacaoDoServidor1() {
		return taxaMediaOcupacaoDoServidor1;
	}

	public double getTaxaMediaOcupacaoDoServidor2() {
		return taxaMediaOcupacaoDoServidor2;
	}

	// Método chamado a todo evento que acontece
	public void recalcula(Tempo tempo, Servidor serv1, Servidor serv2) {
		setNumeroMedioDeEntidadeFila1(tempo, serv1);
		setNumeroMedioDeEntidadeFila2(tempo, serv2);
		setNumeroMedioDeEntidadeFilas(tempo, serv1, serv2);
		setTaxaMediaOcupacaoDoServidor1(tempo, serv1);
		setTaxaMediaOcupacaoDoServidor2(tempo, serv2);
		pesoAcumulado = tempo.getEmSegundos();
	}

	public double getTempoMedioEntidadeNaFilaServ1() {
		return tempoMedioEntidadeNaFilaServ2;
	}

	public void setTempoMedioEntidadeNaFilaServ1(Tempo tEmFila) {
		auxContFila1++;
		this.tempoMedioEntidadeNaFilaServ1 = (tempoMedioEntidadeNaFilaServ1 + tEmFila.getEmSegundos()) / auxContFila1;
		setTempoMedioEntidadeNaFilaTotal(tEmFila);
	}

	public double getTempoMedioEntidadeNaFilaServ2() {
		return tempoMedioEntidadeNaFilaServ2;
	}

	public void setTempoMedioEntidadeNaFilaServ2(Tempo tEmFila) {
		auxContFila2++;
		this.tempoMedioEntidadeNaFilaServ2 = (tempoMedioEntidadeNaFilaServ2 + tEmFila.getEmSegundos()) / auxContFila1;
		setTempoMedioEntidadeNaFilaTotal(tEmFila);
	}

	public double getTempoMedioEntidadeNaFilaTotal() {
		return tempoMedioEntidadeNaFilaTotal;
	}

	private void setTempoMedioEntidadeNaFilaTotal(Tempo tEmFila) {
		this.tempoMedioEntidadeNaFilaTotal = (tempoMedioEntidadeNaFilaTotal + tEmFila.getEmSegundos())
				/ (auxContFila1 + auxContFila2);
	}

	public double getTempoMedioNoSistemaTipo1() {
		return tempoMedioNoSistemaTipo1;
	}

	// numeroEntidadesSaidaTipo1 ja deve estar incrementado
	public void setTempoMedioNoSistemaTipo1(Entidade e, Tempo saida) {
		this.tempoMedioNoSistemaTipo1 = (tempoMedioNoSistemaTipo1
				+ (saida.getEmSegundos() - e.getChegada().getEmSegundos())) / numeroEntidadesSaidaTipo1;
	}

	public double getTempoMedioNoSistemaTipo2() {
		return tempoMedioNoSistemaTipo2;
	}

	public void setTempoMedioNoSistemaTipo2(Entidade e, Tempo saida) {
		this.tempoMedioNoSistemaTipo2 = (tempoMedioNoSistemaTipo2
				+ (saida.getEmSegundos() - e.getChegada().getEmSegundos())) / numeroEntidadesSaidaTipo2;
	}

	public double getTempoMedioNoSistemaTotal() {
		return (tempoMedioNoSistemaTipo1 + tempoMedioNoSistemaTipo2)/2;
	}

	public int getNumeroEntidadesTipo1() {
		return numeroEntidadesTipo1;
	}

	public void incNumeroEntidadesTipo1() {
		numeroEntidadesTipo1++;
	}

	public int getNumeroEntidadesTipo2() {
		return numeroEntidadesTipo2;
	}

	public void incNumeroEntidadesTipo2() {
		numeroEntidadesTipo2++;
	}

	public int getNumeroEntidades() {
		return numeroEntidadesTipo2 + numeroEntidadesTipo1;
	}

	public int getNumeroEntidadesSaidaTipo1() {
		return numeroEntidadesSaidaTipo1;
	}

	public void incNumeroEntidadesSaidaTipo1() {
		numeroEntidadesSaidaTipo1++;
	}

	public int getNumeroEntidadesSaidaTipo2() {
		return numeroEntidadesSaidaTipo2;
	}

	public void incNumeroEntidadesSaidaTipo2() {
		numeroEntidadesSaidaTipo2++;
	}

	public int getNumeroEntidadesSaida() {
		return numeroEntidadesSaidaTipo2 + numeroEntidadesSaidaTipo1;
	}
	
	public int getNumeroFalhasServ1() {
		return numeroFalhasServ1;
	}

	public void incNumeroFalhasServ1() {
		numeroFalhasServ1++;
	}

	public int getnumeroFalhasServ2() {
		return numeroFalhasServ2;
	}

	public void incNumeroFalhasServ2() {
		numeroFalhasServ2++;
	}
	
	public double getPercentTempoEmFalhaServ1() {return percentTempoEmFalhaServ1;};
	
	public double getPercentTempoEmFalhaServ2() {return percentTempoEmFalhaServ2;};

	public int getnumeroTrocas() {
		return numeroTrocas;
	}

	public void incnumeroTrocas() {
		numeroTrocas++;
	}

}

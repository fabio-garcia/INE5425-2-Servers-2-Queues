package control;

import model.Estatisticas;
import model.Tempo;
import visao.JanelaEntradas;

public class Main {

	public static void main(String[] args) {
		//Tempo fim = new Tempo(10, UnidadeTempo.MINUTOS);
		//configConst(fim);
		//configNorm(fim);
		//configExp(fim);
		//configUnif(fim);
		//configTriag(fim);
		JanelaEntradas j = new JanelaEntradas();
		j.frame.setVisible(true);
		while(!j.validos); //{
			//System.out.println("AQUI1");
		//}
		j.frame.setVisible(false);
		//j.frame.dispatchEvent(new WindowEvent(j.frame, WindowEvent.WINDOW_CLOSING));
		//System.out.println("AQUI");
		Sistema s = Sistema.getInstance(Gerador.tempoFinalSim, j.passoAPasso);
		s.iniciaSistema();
		//imprimeEstatisticas();
	}
	
	public static void configTriag(Tempo fim) {
		Gerador.tempoFinalSim = fim;
		Gerador.teChegadas1 = 't';
		Gerador.a1 = 3.5;
		Gerador.b1 = 4.5;
		Gerador.c1 = 3;
		Gerador.tServico1 = 't';
		Gerador.a1TS = 1;
		Gerador.b1TS = 2;
		Gerador.c1TS = 2;
		Gerador.teChegadas2 = 't';
		Gerador.a2 = 3.5;
		Gerador.b2 = 4.5;
		Gerador.c2 = 4.5;
		Gerador.tServico2 = 't';
		Gerador.a2TS = 1;
		Gerador.b2TS = 2;
		Gerador.c2TS = 2;
		Gerador.tEmFalhaServidor1 = 't';
		Gerador.aFS1 = 1;
		Gerador.bFS1 = 2;
		Gerador.cFS1 = 2;
		Gerador.tEmFalhaServidor2 = 't';
		Gerador.aFS2 = 1;
		Gerador.bFS2 = 2;
		Gerador.cFS2 = 2;
		Gerador.tEntreFalhasServidor1 = 't';
		Gerador.aNFS1 = 1;
		Gerador.bNFS1 = 10;
		Gerador.cNFS1 = 10;
		Gerador.tEntreFalhasServidor2 = 't';
		Gerador.aNFS2 = 1;
		Gerador.bNFS2 = 10;
		Gerador.cNFS2 = 10;
	}

	public static void configConst(Tempo fim) {
		Gerador.tempoFinalSim = fim;
		Gerador.teChegadas1 = 'c';
		Gerador.constante1 = 4;
		Gerador.constante1TS = 2;
		Gerador.teChegadas2 = 'c';
		Gerador.constante2 = 4;
		Gerador.constante2TS = 2;
		Gerador.tEmFalhaServidor1 = 'c';
		Gerador.constanteFS1 = 60;
		Gerador.tEmFalhaServidor2 = 'c';
		Gerador.constanteFS2 = 60;
		Gerador.tEntreFalhasServidor1 = 'c';
		Gerador.constanteNFS1 = 60;
		Gerador.tEntreFalhasServidor2 = 'c';
		Gerador.constanteNFS2 = 60;
	}
	
	public static void configNorm(Tempo fim) {
		Gerador.tempoFinalSim = fim;
		Gerador.teChegadas1 = 'n';
		Gerador.media1 = 4;
		Gerador.desvioPadrao1 = 1;
		Gerador.tServico1 = 'n';
		Gerador.media1TS = 2;
		Gerador.desvioPadrao1TS = 0.5;
		Gerador.teChegadas2 = 'n';
		Gerador.media2 = 4;
		Gerador.desvioPadrao2 = 1;
		Gerador.tServico2 = 'n';
		Gerador.media2TS = 2;
		Gerador.desvioPadrao2TS = 0.5;
		Gerador.tEmFalhaServidor1 = 'n';
		Gerador.mediaFS1 = 50;
		Gerador.desvioPadraoFS1 = 1;
		Gerador.tEmFalhaServidor2 = 'n';
		Gerador.mediaFS2 = 50;
		Gerador.desvioPadraoFS2 = 1;
		Gerador.tEntreFalhasServidor1 = 'n';
		Gerador.mediaNFS1 = 60;
		Gerador.desvioPadraoNFS1 = 5;
		Gerador.tEntreFalhasServidor2 = 'n';
		Gerador.mediaNFS2 = 60;
		Gerador.desvioPadraoNFS2 = 5;
	}
	
	public static void configExp(Tempo fim) {
		Gerador.tempoFinalSim = fim;
		Gerador.teChegadas1 = 'e';
		Gerador.media1 = 0.2;
		Gerador.tServico1 = 'e';
		Gerador.media1TS = 1;
		Gerador.teChegadas2 = 'e';
		Gerador.media2 = 0.2;
		Gerador.tServico2 = 'e';
		Gerador.media2TS = 1;
		Gerador.tEmFalhaServidor1 = 'e';
		Gerador.mediaFS1 = 1;
		Gerador.tEmFalhaServidor2 = 'e';
		Gerador.mediaFS2 = 1;
		Gerador.tEntreFalhasServidor1 = 'e';
		Gerador.mediaNFS1 = 0.002;
		Gerador.tEntreFalhasServidor2 = 'e';
		Gerador.mediaNFS2 = 0.002;
	}
	
	public static void configUnif(Tempo fim) {
		Gerador.tempoFinalSim = fim;
		Gerador.teChegadas1 = 'u';
		Gerador.min1 = 3.5;
		Gerador.max1 = 4.5;
		Gerador.tServico1 = 'u';
		Gerador.min1TS = 1;
		Gerador.max1TS = 2;
		Gerador.teChegadas2 = 'u';
		Gerador.min2 = 3.5;
		Gerador.max2 = 4.5;
		Gerador.tServico2 = 'u';
		Gerador.min2TS = 1;
		Gerador.max2TS = 2;
		Gerador.tEmFalhaServidor1 = 'u';
		Gerador.minFS1 = 1;
		Gerador.maxFS1 = 2;
		Gerador.tEmFalhaServidor2 = 'u';
		Gerador.minFS2 = 1;
		Gerador.maxFS2 = 2;
		Gerador.tEntreFalhasServidor1 = 'u';
		Gerador.minNFS1 = 1;
		Gerador.maxNFS1 = 10;
		Gerador.tEntreFalhasServidor2 = 'u';
		Gerador.minNFS2 = 1;
		Gerador.maxNFS2 = 10;
	}
	
	public static void imprimeEstatisticas() {
		Estatisticas e = Estatisticas.getInstance();
		System.out.println("Entidades Tipo1 = "+ e.getNumeroEntidadesTipo1());
		System.out.println("Entidades Tipo2 = "+ e.getNumeroEntidadesTipo2());
		System.out.println("Entidades Total = "+e.getNumeroEntidades());
		System.out.println("Entidades Saida Total = "+e.getNumeroEntidadesSaida());
		System.out.println("Entidades Saida Tipo1 = "+e.getNumeroEntidadesSaidaTipo1());
		System.out.println("Entidades Saida Tipo2 = "+e.getNumeroEntidadesSaidaTipo2());
		System.out.println("Num Falhas Serv1 = "+e.getNumeroFalhasServ1());
		System.out.println("Porcentagem do Tempo em Falha Serv1 = "+ e.getPercentTempoEmFalhaServ1());
		System.out.println("Num Falhas Serv2 = "+e.getnumeroFalhasServ2());
		System.out.println("Porcentagem do Tempo em Falha Serv2 = "+ e.getPercentTempoEmFalhaServ2());
		System.out.println("Num Medio Entidades Fila 1 = "+ e.getNumeroMedioDeEntidadeFila1());
		System.out.println("Num Medio Entidades Fila 2 = "+e.getNumeroMedioDeEntidadeFila2());
		System.out.println("Num Medio Entidades em Filas = "+e.getNumeroMedioDeEntidadeFilas());
		System.out.println("Taxa Media de Ocupação Serv1 = "+e.getTaxaMediaOcupacaoDoServidor1());
		System.out.println("Taxa Media de Ocupação Serv2 = "+e.getTaxaMediaOcupacaoDoServidor2());
		System.out.println("Num Trocas = "+e.getnumeroTrocas());
		System.out.println("Tempo Medio No Sistema Tipo1 = "+e.getTempoMedioNoSistemaTipo1());
		System.out.println("Tempo Medio No Sistema Tipo2 = "+e.getTempoMedioNoSistemaTipo2());
		System.out.println("Tempo Medio No Sistema Total = "+e.getTempoMedioNoSistemaTotal());
		System.out.println("Tempo Medio Entidades em Fila Serv1 = "+ e.getTempoMedioEntidadeNaFilaServ1());
		System.out.println("Tempo Medio Entidades em Fila Serv2 = "+ e.getTempoMedioEntidadeNaFilaServ2());
		System.out.println("Tempo Medio Entidades em Fila Total = "+ e.getTempoMedioEntidadeNaFilaTotal());
	}

}

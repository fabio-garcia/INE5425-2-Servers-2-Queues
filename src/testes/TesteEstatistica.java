package testes;

import model.Estatisticas;
import model.Servidor;
import model.Servidor.EstadoServidor;
import model.Tempo;
import model.Tempo.UnidadeTempo;

public class TesteEstatistica {
	
	public static void main(String[] args) {
		
		//1
		Servidor s1 = new Servidor(1);
		
		Estatisticas e = Estatisticas.getInstance();
		
		Tempo t1 = new Tempo(30, UnidadeTempo.SEGUNDOS);
		
		e.setTaxaMediaOcupacaoDoServidor1(t1, s1);
		
		System.out.println("1 = " + e.getTaxaMediaOcupacaoDoServidor1());
		
		e.setTaxaMediaOcupacaoDoServidor1(t1, s1);
		
		System.out.println("1 = " + e.getTaxaMediaOcupacaoDoServidor1());
		
		s1.setEstado(EstadoServidor.OCUPADO);
		
		//2
		
		t1 = new Tempo(50, UnidadeTempo.SEGUNDOS);
		
		e.setTaxaMediaOcupacaoDoServidor1(t1, s1);
		
		System.out.println("2 = " + e.getTaxaMediaOcupacaoDoServidor1());
		
		s1.setEstado(EstadoServidor.LIVRE);
		
		//3
		
		t1 = new Tempo(80, UnidadeTempo.SEGUNDOS);
		
		e.setTaxaMediaOcupacaoDoServidor1(t1, s1);

		System.out.println("3 = " + e.getTaxaMediaOcupacaoDoServidor1());
		
		s1.setEstado(EstadoServidor.OCUPADO);
		
		//4
		t1 = new Tempo(200, UnidadeTempo.SEGUNDOS);
		
		e.setTaxaMediaOcupacaoDoServidor1(t1, s1);
		
		System.out.println("4 = " + e.getTaxaMediaOcupacaoDoServidor1());
		
	}

}

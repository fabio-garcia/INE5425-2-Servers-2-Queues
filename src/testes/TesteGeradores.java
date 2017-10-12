package testes;

import java.util.PriorityQueue;

import control.Gerador;
import model.Tempo;
import model.Tempo.UnidadeTempo;

public class TesteGeradores {

	public static void main(String[] args) {
		
		Tempo TEC = new Tempo(0.2, UnidadeTempo.SEGUNDOS);
		Tempo tempoFinalSim = new Tempo(3, UnidadeTempo.HORAS);
		PriorityQueue<Double> q = Gerador.geraChegadasConst(TEC, tempoFinalSim);
		double media = 0.2; double desvioP = 0.05;
		PriorityQueue<Double> q1 = Gerador.geraChegadasNormal(media, desvioP, tempoFinalSim);
		double min = 0.19; double max = 0.21;
		PriorityQueue<Double> q2 = Gerador.geraChegadasUniforme(min, max, tempoFinalSim);
		double a = 0.1; double b = 0.2; double c = 1.5;
		PriorityQueue<Double> q3 = Gerador.geraChegadasTriangular(a, b, c, tempoFinalSim);
		PriorityQueue<Double> q4 = Gerador.geraChegadasExponencial(media, tempoFinalSim);
		
		System.out.println("Tamanho Gerado Const       = " + q.size());
		System.out.println("Tamanho Gerado Normal      = " + q1.size());
		System.out.println("Tamanho Gerado Uniforme    = " + q2.size());
		System.out.println("Tamanho Gerado Triangular  = " + q3.size());
		System.out.println("Tamanho Gerado Exponencial = " + q4.size());
	}

}

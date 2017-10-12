package control;

import java.util.PriorityQueue;
import java.util.Random;

import model.Evento;
import model.Tempo;
import model.Tempo.UnidadeTempo;

public class Gerador {

	public static final int RANDSEED = 1;

	public static Random r = new Random();

	private static char tefServ1;

	private static char tefServ2;

	private static char tfServ2;

	private static char tfServ1;

	private static char teChegadas;

	public static void configurar() {
		// TODO
	}

	public static PriorityQueue<Double> geraChegadasConst(Tempo TEC, Tempo tempoFinalSim) {
		PriorityQueue<Double> eventos = new PriorityQueue<Double>();
		double fim = tempoFinalSim.getEmSegundos();
		for (double i = 0; i < fim; i += TEC.getEmSegundos()) {
			eventos.offer(i);
		}
		return eventos;
	}

	public static PriorityQueue<Double> geraChegadasNormal(double media, double desvioPadrao, Tempo tempoFinalSim) {
		PriorityQueue<Double> eventos = new PriorityQueue<Double>();
		double proxValor = 0;
		double fim = tempoFinalSim.getEmSegundos();
		for (double i = 0; i < fim; i += proxValor) {
			eventos.offer(i);
			proxValor = norm(media, desvioPadrao);
		}
		return eventos;
	}

	public static PriorityQueue<Double> geraChegadasUniforme(double min, double max, Tempo tempoFinalSim) {
		PriorityQueue<Double> eventos = new PriorityQueue<Double>();
		double proxValor = 0;
		double fim = tempoFinalSim.getEmSegundos();
		for (double i = 0; i < fim; i += proxValor) {
			eventos.offer(i);
			proxValor = unif(min, max);
		}
		return eventos;
	}

	public static PriorityQueue<Double> geraChegadasTriangular(double a, double b, double c, Tempo tempoFinalSim) {
		PriorityQueue<Double> eventos = new PriorityQueue<Double>();
		double proxValor = 0;
		double fim = tempoFinalSim.getEmSegundos();
		for (double i = 0; i < fim; i += proxValor) {
			eventos.offer(i);
			proxValor = triang(a, b, c);
		}
		return eventos;
	}

	public static PriorityQueue<Double> geraChegadasExponencial(double media, Tempo tempoFinalSim) {
		PriorityQueue<Double> eventos = new PriorityQueue<Double>();
		double proxValor = 0;
		double fim = tempoFinalSim.getEmSegundos();
		for (double i = 0; i < fim; i += proxValor) {
			eventos.offer(i);
			proxValor = exp(media);
		}
		return eventos;
	}

	public static double norm(double media, double desvioPadrao) {
		double u1 = r.nextDouble();
		double u2 = r.nextDouble();
		double z1 = Math.sqrt(-2 * Math.log(u1)) * Math.cos(2 * Math.PI * u2);

		return media + desvioPadrao * z1;
	}

	public static double unif(double min, double max) {
		double u = r.nextDouble();
		return min + u * (max - min);
	}

	public static double triang(double a, double b, double c) {
		double u = r.nextDouble();

		if (u <= ((b - a) / (c - a))) {
			return a + Math.sqrt(u * (b - a) * (c - a));
		}

		return c - Math.sqrt((1 - u) * (c - b) * (c - a));
	}

	public static double exp(double media) {
		double u = r.nextDouble();
		return (-1 / media) * Math.log(1 - u);
	}

	public static void gerarChegadas(PriorityQueue<Evento> fila) {
		// TODO Auto-generated method stub
		switch (teChegadas) {
		case 'n':
			break;
		case 't':
			break;
		case 'e':
			break;
		case 'u':
			break;
		default:
			break;
		}
	}

	public static Tempo geraTempoFalhaServ1(double d) {
		//TODO
		switch (tfServ1) {
		case 'n':
			return new Tempo(d, UnidadeTempo.SEGUNDOS);
		case 't':
			return new Tempo(d, UnidadeTempo.SEGUNDOS);
		case 'e':
			return new Tempo(d, UnidadeTempo.SEGUNDOS);
		case 'u':
			return new Tempo(d, UnidadeTempo.SEGUNDOS);
		default:
			return new Tempo(d, UnidadeTempo.SEGUNDOS);
		}
	}

	public static Tempo geraTempoFalhaServ2(double d) {
		//TODO
		switch (tfServ2) {
		case 'n':
			return new Tempo(d, UnidadeTempo.SEGUNDOS);
		case 't':
			return new Tempo(d, UnidadeTempo.SEGUNDOS);
		case 'e':
			return new Tempo(d, UnidadeTempo.SEGUNDOS);
		case 'u':
			return new Tempo(d, UnidadeTempo.SEGUNDOS);
		default:
			return new Tempo(d, UnidadeTempo.SEGUNDOS);
		}
	}

	public static void geraFalhasServ1(PriorityQueue<Evento> fila) {
		// TODO Auto-generated method stub
		switch (tefServ1) {
		case 'n':
			break;
		case 't':
			break;
		case 'e':
			break;
		case 'u':
			break;
		default:
			break;
		}
	}

	public static void geraFalhasServ2(PriorityQueue<Evento> fila) {
		// TODO Auto-generated method stub
		switch (tefServ2) {
		case 'n':
			break;
		case 't':
			break;
		case 'e':
			break;
		case 'u':
			break;
		default:
			break;
		}
	}

}

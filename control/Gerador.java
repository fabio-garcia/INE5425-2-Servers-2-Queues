package control;

import java.util.PriorityQueue;
import java.util.Random;

import model.Entidade;
import model.Evento;
import model.EventoCriacao;
import model.EventoFalha;
import model.Servidor;
import model.Tempo;
import model.Tempo.UnidadeTempo;

public class Gerador {

	public static final int RANDSEED = 1;

	public static Random r = new Random();

	public static Tempo tempoFinalSim;
	
	//atribEntidade1
	public static char teChegadas1;
	public static double media1;
	public static double desvioPadrao1;
	public static double a1;
	public static double b1;
	public static double c1;
	public static double min1;
	public static double max1;
	public static double constante1;
	
	public static char tServico1;
	public static double media1TS;
	public static double desvioPadrao1TS;
	public static double a1TS;
	public static double b1TS;
	public static double c1TS;
	public static double min1TS;
	public static double max1TS;
	public static double constante1TS;
	
	//atribEntidade2
	public static char teChegadas2;
	public static double media2;
	public static double desvioPadrao2;
	public static double a2;
	public static double b2;
	public static double c2;
	public static double min2;
	public static double max2;
	public static double constante2;
	
	public static char tServico2;
	public static double media2TS;
	public static double desvioPadrao2TS;
	public static double a2TS;
	public static double b2TS;
	public static double c2TS;
	public static double min2TS;
	public static double max2TS;
	public static double constante2TS;
	
	//atribServ1
	public static char tEmFalhaServidor1;
	public static char tEntreFalhasServidor1;
	public static double mediaFS1;
	public static double desvioPadraoFS1;
	public static double aFS1;
	public static double bFS1;
	public static double cFS1;
	public static double minFS1;
	public static double maxFS1;
	public static double constanteFS1;
	
	public static double mediaNFS1;
	public static double desvioPadraoNFS1;
	public static double aNFS1;
	public static double bNFS1;
	public static double cNFS1;
	public static double minNFS1;
	public static double maxNFS1;
	public static double constanteNFS1;
	
	//atribServ2
	public static char tEmFalhaServidor2;
	public static char tEntreFalhasServidor2;
	public static double mediaFS2;
	public static double desvioPadraoFS2;
	public static double aFS2;
	public static double bFS2;
	public static double cFS2;
	public static double minFS2;
	public static double maxFS2;
	public static double constanteFS2;
	
	public static double mediaNFS2;
	public static double desvioPadraoNFS2;
	public static double aNFS2;
	public static double bNFS2;
	public static double cNFS2;
	public static double minNFS2;
	public static double maxNFS2;
	public static double constanteNFS2;

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
		geraChegadasTipo1(fila);
		
		geraChegadasTipo2(fila);
	}

	private static void geraChegadasTipo1(PriorityQueue<Evento> fila) {
		switch (teChegadas1) {
		case 'n':
			geraChegadaTipo1PorNormal(fila);
			break;
		case 't':
			geraChegadaTipo1PorTriangular(fila);
			break;
		case 'e':
			geraChegadaTipo1PorExponencial(fila);
			break;
		case 'u':
			geraChegadaTipo1PorUniforme(fila);
			break;
		default:
			geraChegadaTipo1Constante(fila);
			break;
		}
	}

	private static void geraChegadaTipo1Constante(PriorityQueue<Evento> fila) {
		Tempo t;
		Tempo serv;
		Entidade e;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = 0; i < fim; i += constante1) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			serv = geraTempoServicoTipo1();
			e = new Entidade(1, t, serv);
			ev = new EventoCriacao(e,t);
			fila.offer(ev);
		}
	}

	private static void geraChegadaTipo1PorUniforme(PriorityQueue<Evento> fila) {
		double proxValor = 0;
		Tempo t;
		Tempo serv;
		Entidade e;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = 0; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			serv = geraTempoServicoTipo1();
			e = new Entidade(1, t, serv);
			ev = new EventoCriacao(e,t);
			fila.offer(ev);
			
			proxValor = unif(min1, max1);
		}
	}

	private static void geraChegadaTipo1PorExponencial(PriorityQueue<Evento> fila) {
		double proxValor = 0;
		Tempo t;
		Tempo serv;
		Entidade e;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = 0; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			serv = geraTempoServicoTipo1();
			e = new Entidade(1, t, serv);
			ev = new EventoCriacao(e,t);
			fila.offer(ev);
			
			proxValor = exp(media1);
		}
	}

	private static void geraChegadaTipo1PorTriangular(PriorityQueue<Evento> fila) {
		double proxValor = 0;
		Tempo t;
		Tempo serv;
		Entidade e;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = 0; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			serv = geraTempoServicoTipo1();
			e = new Entidade(1, t, serv);
			ev = new EventoCriacao(e,t);
			fila.offer(ev);
			
			proxValor = triang(a1,b1,c1);
		}
	}

	private static void geraChegadaTipo1PorNormal(PriorityQueue<Evento> fila) {
		double proxValor = 0;
		Tempo t;
		Tempo serv;
		Entidade e;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = 0; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			serv = geraTempoServicoTipo1();
			e = new Entidade(1, t, serv);
			ev = new EventoCriacao(e,t);
			fila.offer(ev);
			
			proxValor = norm(media1, desvioPadrao1);
		}
		
	}

	private static Tempo geraTempoServicoTipo1() {
		switch (tServico1) {
		case 'n':
			return new Tempo(norm(media1TS, desvioPadrao1TS), UnidadeTempo.SEGUNDOS);
		case 't':
			return new Tempo(triang(a1TS, b1TS, c1TS), UnidadeTempo.SEGUNDOS);
		case 'e':
			return new Tempo(exp(media1TS), UnidadeTempo.SEGUNDOS);
		case 'u':
			return new Tempo(unif(min1TS, max1TS), UnidadeTempo.SEGUNDOS);
		default:
			return new Tempo(constante1TS, UnidadeTempo.SEGUNDOS);
		}
	}

	private static void geraChegadasTipo2(PriorityQueue<Evento> fila) {
		switch (teChegadas2) {
		case 'n':
			geraChegadaTipo2PorNormal(fila);
			break;
		case 't':
			geraChegadaTipo2PorTriangular(fila);
			break;
		case 'e':
			geraChegadaTipo2PorExponencial(fila);
			break;
		case 'u':
			geraChegadaTipo2PorUniforme(fila);
			break;
		default:
			geraChegadaTipo2Constante(fila);
			break;
		}
	}

	private static void geraChegadaTipo2Constante(PriorityQueue<Evento> fila) {
		Tempo t;
		Tempo serv;
		Entidade e;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = 0; i < fim; i += constante2) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			serv = geraTempoServicoTipo2();
			e = new Entidade(2, t, serv);
			ev = new EventoCriacao(e,t);
			fila.offer(ev);
		}
	}

	private static void geraChegadaTipo2PorUniforme(PriorityQueue<Evento> fila) {
		double proxValor = 0;
		Tempo t;
		Tempo serv;
		Entidade e;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = 0; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			serv = geraTempoServicoTipo2();
			e = new Entidade(2, t, serv);
			ev = new EventoCriacao(e,t);
			fila.offer(ev);
			
			proxValor = unif(min2, max2);
		}
	}

	private static void geraChegadaTipo2PorExponencial(PriorityQueue<Evento> fila) {
		double proxValor = 0;
		Tempo t;
		Tempo serv;
		Entidade e;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = 0; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			serv = geraTempoServicoTipo2();
			e = new Entidade(2, t, serv);
			ev = new EventoCriacao(e,t);
			fila.offer(ev);
			
			proxValor = exp(media2);
		}
	}

	private static void geraChegadaTipo2PorTriangular(PriorityQueue<Evento> fila) {
		double proxValor = 0;
		Tempo t;
		Tempo serv;
		Entidade e;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = 0; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			serv = geraTempoServicoTipo2();
			e = new Entidade(2, t, serv);
			ev = new EventoCriacao(e,t);
			fila.offer(ev);
			
			proxValor = triang(a2,b2,c2);
		}
	}

	private static void geraChegadaTipo2PorNormal(PriorityQueue<Evento> fila) {
		double proxValor = 0;
		Tempo t;
		Tempo serv;
		Entidade e;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = 0; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			serv = geraTempoServicoTipo2();
			e = new Entidade(2, t, serv);
			ev = new EventoCriacao(e,t);
			fila.offer(ev);
			
			proxValor = norm(media2, desvioPadrao2);
		}
		
	}

	private static Tempo geraTempoServicoTipo2() {
		switch (tServico2) {
		case 'n':
			return new Tempo(norm(media2TS, desvioPadrao2TS), UnidadeTempo.SEGUNDOS);
		case 't':
			return new Tempo(triang(a2TS, b2TS, c2TS), UnidadeTempo.SEGUNDOS);
		case 'e':
			return new Tempo(exp(media2TS), UnidadeTempo.SEGUNDOS);
		case 'u':
			return new Tempo(unif(min2TS, max2TS), UnidadeTempo.SEGUNDOS);
		default:
			return new Tempo(constante2TS, UnidadeTempo.SEGUNDOS);
		}
	}

	public static Tempo geraTempoFalhaServ1(double d) {
		switch (tEmFalhaServidor1) {
		case 'n':
			return new Tempo(norm(mediaFS1, desvioPadraoFS1)+d, UnidadeTempo.SEGUNDOS);
		case 't':
			return new Tempo(triang(aFS1, bFS1, cFS1)+d, UnidadeTempo.SEGUNDOS);
		case 'e':
			return new Tempo(exp(mediaFS1)+d, UnidadeTempo.SEGUNDOS);
		case 'u':
			return new Tempo(unif(minFS1, maxFS1)+d, UnidadeTempo.SEGUNDOS);
		default:
			return new Tempo(constanteFS1+d, UnidadeTempo.SEGUNDOS);
		}
	}

	public static Tempo geraTempoFalhaServ2(double d) {
		switch (tEmFalhaServidor2) {
		case 'n':
			return new Tempo(norm(mediaFS2, desvioPadraoFS2)+d, UnidadeTempo.SEGUNDOS);
		case 't':
			return new Tempo(triang(aFS2, bFS2, cFS2)+d, UnidadeTempo.SEGUNDOS);
		case 'e':
			return new Tempo(exp(mediaFS2)+d, UnidadeTempo.SEGUNDOS);
		case 'u':
			return new Tempo(unif(minFS2, maxFS2)+d, UnidadeTempo.SEGUNDOS);
		default:
			return new Tempo(constanteFS2+d, UnidadeTempo.SEGUNDOS);
		}
	}

	public static void geraFalhasServ1(PriorityQueue<Evento> fila, Servidor serv) {
		switch (tEntreFalhasServidor1) {
		case 'n':
			geraFalhasServ1PorNormal(fila, serv);
			break;
		case 't':
			geraFalhasServ1PorTriangular(fila, serv);
			break;
		case 'e':
			geraFalhasServ1PorExponencial(fila, serv);
			break;
		case 'u':
			geraFalhasServ1PorUniforme(fila, serv);
			break;
		default:
			geraFalhasServ1Constante(fila, serv);
			break;
		}
	}

	private static void geraFalhasServ1Constante(PriorityQueue<Evento> fila, Servidor serv) {
		//TODO
		Tempo t;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = constanteNFS1; i < fim; i += constanteNFS1) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			ev = new EventoFalha(serv, t);
			fila.offer(ev);
		}
	}

	private static void geraFalhasServ1PorUniforme(PriorityQueue<Evento> fila, Servidor serv) {
		double proxValor = unif(minNFS1, maxNFS1);
		Tempo t;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = proxValor; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			ev = new EventoFalha(serv, t);
			fila.offer(ev);
			
			proxValor = unif(minNFS1, maxNFS1);
		}
	}

	private static void geraFalhasServ1PorExponencial(PriorityQueue<Evento> fila, Servidor serv) {
		double proxValor = exp(mediaNFS1);
		Tempo t;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = proxValor; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			ev = new EventoFalha(serv, t);
			fila.offer(ev);
			
			proxValor = exp(mediaNFS1);
		}
	}

	private static void geraFalhasServ1PorTriangular(PriorityQueue<Evento> fila, Servidor serv) {
		double proxValor = triang(aNFS1,bNFS1,cNFS1);
		Tempo t;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = proxValor; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			ev = new EventoFalha(serv, t);
			fila.offer(ev);
			
			proxValor = triang(aNFS1,bNFS1,cNFS1);
		}
	}

	private static void geraFalhasServ1PorNormal(PriorityQueue<Evento> fila, Servidor serv) {
		double proxValor = norm(mediaNFS1, desvioPadraoNFS1);
		Tempo t;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = proxValor; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			ev = new EventoFalha(serv, t);
			fila.offer(ev);
			
			proxValor = norm(mediaNFS1, desvioPadraoNFS1);
		}
		
	}

	public static void geraFalhasServ2(PriorityQueue<Evento> fila, Servidor serv) {
		switch (tEntreFalhasServidor2) {
		case 'n':
			geraFalhasServ2PorNormal(fila, serv);
			break;
		case 't':
			geraFalhasServ2PorTriangular(fila, serv);
			break;
		case 'e':
			geraFalhasServ2PorExponencial(fila, serv);
			break;
		case 'u':
			geraFalhasServ2PorUniforme(fila, serv);
			break;
		default:
			geraFalhasServ2Constante(fila, serv);
			break;
		}
	}

	private static void geraFalhasServ2Constante(PriorityQueue<Evento> fila, Servidor serv) {
		Tempo t;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = constanteNFS2; i < fim; i += constanteNFS2) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			ev = new EventoFalha(serv, t);
			fila.offer(ev);
		}
	}

	private static void geraFalhasServ2PorUniforme(PriorityQueue<Evento> fila, Servidor serv) {
		double proxValor = unif(minNFS2, maxNFS2);
		Tempo t;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = proxValor; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			ev = new EventoFalha(serv, t);
			fila.offer(ev);
			
			proxValor = unif(minNFS2, maxNFS2);
		}
	}

	private static void geraFalhasServ2PorExponencial(PriorityQueue<Evento> fila, Servidor serv) {
		double proxValor = exp(mediaNFS2);
		Tempo t;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = proxValor; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			ev = new EventoFalha(serv, t);
			fila.offer(ev);
			
			proxValor = exp(mediaNFS2);
		}
	}

	private static void geraFalhasServ2PorTriangular(PriorityQueue<Evento> fila, Servidor serv) {
		double proxValor = triang(aNFS2,bNFS2,cNFS2);
		Tempo t;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = proxValor; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			ev = new EventoFalha(serv, t);
			fila.offer(ev);
			
			proxValor = triang(aNFS2,bNFS2,cNFS2);
		}
	}

	private static void geraFalhasServ2PorNormal(PriorityQueue<Evento> fila, Servidor serv) {
		double proxValor = norm(mediaNFS2, desvioPadraoNFS2);
		Tempo t;
		Evento ev;
		double fim = tempoFinalSim.getEmSegundos();
		
		for (double i = proxValor; i < fim; i += proxValor) {
			t = new Tempo(i,UnidadeTempo.SEGUNDOS);
			ev = new EventoFalha(serv, t);
			fila.offer(ev);
			
			proxValor = norm(mediaNFS2, desvioPadraoNFS2);
		}
		
	}

}

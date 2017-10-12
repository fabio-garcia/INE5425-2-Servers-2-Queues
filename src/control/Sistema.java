package control;

import java.util.PriorityQueue;

import model.Estatisticas;
import model.Evento;
import model.Relogio;
import model.Servidor;
import model.Tempo;

public class Sistema {
	
	private PriorityQueue<Evento> fila;
	private Relogio r;
	private Estatisticas estatistica;
	private Servidor serv1;
	private Servidor serv2;
	private Tempo tFinal;
	private static Sistema s;
	
	private Sistema(Tempo fim) {
		fila = new PriorityQueue<Evento>();
		tFinal = fim;
		r = Relogio.getInstance();
		serv1 = new Servidor(1);
		serv2 = new Servidor(2);
	}
	
	public static Sistema getInstance(Tempo fim) {
		if (s == null) {
			s = new Sistema(fim);
		}
		return s;
	}
	
	public void iniciaSistema() {
		Gerador.gerarChegadas(fila);
		Gerador.geraFalhasServ1(fila);
		Gerador.geraFalhasServ2(fila);
		Evento e;
		while (r.getTempo().getEmSegundos() < tFinal.getEmSegundos() && !fila.isEmpty()) {
			//enquanto tempo do primeiro for igual a tempo, consome.
			do {
				e = fila.poll();
				r.avanca(e.getTExecucao());
				estatistica.recalcula(r.getTempo(), serv1, serv2);
				e.executa(serv1, serv2);
				if (fila.isEmpty()) {
					break;
				}
			} while (fila.peek().getTExecucao().getEmSegundos() == r.getTempo().getEmSegundos());
		}
		estatistica.recalcula(r.getTempo(), serv1, serv2);
	}

	public void adicionaNovoEvento(Evento e) {
		fila.offer(e);
	}

}

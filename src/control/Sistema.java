package control;

import java.util.PriorityQueue;

import model.Estatisticas;
import model.Evento;
import model.Relogio;
import model.Servidor;
import model.Tempo;
import visao.JanelaTeste;

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
		estatistica = Estatisticas.getInstance();
	}

	public static Sistema getInstance(Tempo fim) {
		if (s == null) {
			s = new Sistema(fim);
		}
		return s;
	}

	public void iniciaSistema() {
		Gerador.gerarChegadas(fila);
		Gerador.geraFalhasServ1(fila, serv1);
		Gerador.geraFalhasServ2(fila, serv2);
		Evento e;
		JanelaTeste j = new JanelaTeste();
		j.getFrame().setVisible(true);
		boolean acabou = false;
		while (r.getTempo().getEmSegundos() < tFinal.getEmSegundos() && !fila.isEmpty() && !acabou) {
			// enquanto tempo do primeiro for igual a tempo, consome.
			do {
				// System.out.println("i = "+i+"; j = "+j);
				if (!j.getPause()) {
					e = fila.poll();
					if (e.getTExecucao().getEmSegundos() > tFinal.getEmSegundos()) {
						acabou = true;
						break;
					}
					r.avanca(e.getTExecucao());
					estatistica.recalcula(r.getTempo(), serv1, serv2);
					e.executa(serv1, serv2);
					j.atualiza();
					try {
						Thread.sleep(j.getDelay());
					} catch (InterruptedException except) {
						except.printStackTrace();
					}
					if (fila.isEmpty()) {
						break;
					}
				}
			} while (fila.peek().getTExecucao().getEmSegundos() == r.getTempo().getEmSegundos());
		}
		r.avanca(tFinal);
		estatistica.recalcula(r.getTempo(), serv1, serv2);
		j.atualiza();
	}

	public void adicionaNovoEvento(Evento e) {
		fila.offer(e);
	}

}

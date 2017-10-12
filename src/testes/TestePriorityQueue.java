package testes;

import java.util.PriorityQueue;

import model.Entidade;
import model.Evento;
import model.EventoCriacao;
import model.Tempo;
import model.Tempo.UnidadeTempo;

public class TestePriorityQueue {
	
	public static void main(String[] args) {
		Entidade e1 = new Entidade(1, new Tempo(0, UnidadeTempo.HORAS), new Tempo(0, UnidadeTempo.HORAS));
		Entidade e2 = new Entidade(2, new Tempo(2, UnidadeTempo.SEGUNDOS), new Tempo(2, UnidadeTempo.SEGUNDOS));
		Entidade e3 = new Entidade(3, new Tempo(0, UnidadeTempo.SEGUNDOS), new Tempo(0, UnidadeTempo.SEGUNDOS));
		Entidade e4 = new Entidade(4, new Tempo(0, UnidadeTempo.SEGUNDOS), new Tempo(0, UnidadeTempo.SEGUNDOS));
		Entidade e5 = new Entidade(5, new Tempo(0, UnidadeTempo.SEGUNDOS), new Tempo(0, UnidadeTempo.SEGUNDOS));
		Entidade e6 = new Entidade(6, new Tempo(0, UnidadeTempo.SEGUNDOS), new Tempo(0, UnidadeTempo.SEGUNDOS));
		
		
		Evento ev1 = new EventoCriacao(e1, new Tempo(0, UnidadeTempo.HORAS));
		Evento ev2 = new EventoCriacao(e2, new Tempo(2, UnidadeTempo.SEGUNDOS));
		Evento ev3 = new EventoCriacao(e3, new Tempo(0, UnidadeTempo.SEGUNDOS));
		Evento ev4 = new EventoCriacao(e4, new Tempo(0, UnidadeTempo.SEGUNDOS));
		Evento ev5 = new EventoCriacao(e5, new Tempo(0, UnidadeTempo.SEGUNDOS));
		Evento ev6 = new EventoCriacao(e6, new Tempo(0, UnidadeTempo.SEGUNDOS));
		
		
		PriorityQueue<Evento> q = new PriorityQueue<Evento>();
		
		q.offer(ev2);
		q.offer(ev3);
		q.offer(ev1);
		q.offer(ev4);
		q.offer(ev5);
		//q.offer(ev6);
		//q.poll();
		//q.offer(ev3);
		System.out.println("1º = " + q.peek().getEntidade().getTipo());
		System.out.println("1º = " + q.poll().getEntidade().getTipo());
		q.offer(ev6);
		System.out.println("2º = " + q.poll().getEntidade().getTipo());
		System.out.println("3º = " + q.poll().getEntidade().getTipo());
	
	}

}

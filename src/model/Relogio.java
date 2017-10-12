package model;

import model.Tempo.UnidadeTempo;

public class Relogio {

	private Tempo atual;
	private static Relogio r;
	
	private Relogio () {
		atual = new Tempo(0, UnidadeTempo.SEGUNDOS);
	}
	
	public static Relogio getInstance() {
		if (r == null) {
			r = new Relogio();
		}
		return r;
	}
	
	public Tempo getTempo() {
		return atual;
	}
	
	public void avanca(Tempo t) {
		atual = t;
	}

}

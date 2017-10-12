package model;

public class Tempo {
	
	public enum UnidadeTempo {
		SEGUNDOS(1), MINUTOS(60), HORAS(3600);
		
		public int multiplicador;
		UnidadeTempo (int valor) {
			multiplicador = valor;
		}
	}
	
	private double tempo;
	
	public Tempo (double tempo, UnidadeTempo uTempo) {
		this.tempo = tempo * uTempo.multiplicador;
	}
	
	public double getEmHoras() {
		return tempo * UnidadeTempo.HORAS.multiplicador;
	}
	
	public double getEmMinutos() {
		return tempo * UnidadeTempo.MINUTOS.multiplicador;
	}
	
	public double getEmSegundos() {
		return tempo;
	}

}

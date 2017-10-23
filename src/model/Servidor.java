package model;

import java.util.LinkedList;
import java.util.Queue;

import control.Sistema;
import model.Tempo.UnidadeTempo;

public class Servidor {

	public enum EstadoServidor {
		LIVRE, OCUPADO, MANUTENCAO
	}

	private EstadoServidor estado;
	private Tempo tempoVoltaFuncionar;
	private Queue<Entidade> fila;
	private Entidade rodando;
	private int tipo;

	public Servidor(int tipo) {
		fila = new LinkedList<Entidade>();
		setEstado(EstadoServidor.LIVRE);
		setTempoVoltaFuncionar(new Tempo(0, UnidadeTempo.SEGUNDOS));
		setRodando(null);
		setTipo(tipo);
	}

	public void addFila(Entidade e) {
		fila.add(e);
	}

	// so chamado por executar do criar...
	public void ocupar(Entidade e) {
		if (estado == EstadoServidor.LIVRE && fila.isEmpty()) {
			estado = EstadoServidor.OCUPADO;
			e.atender(Relogio.getInstance().getTempo());
			setRodando(e);
			EventoSaida s = new EventoSaida(e,
					new Tempo(e.getTServ().getEmSegundos() + Relogio.getInstance().getTempo().getEmSegundos(),
							UnidadeTempo.SEGUNDOS));
			Sistema.getInstance(null).adicionaNovoEvento(s);
			Tempo tEmFila = new Tempo(e.getTInicioAtendimento().getEmSegundos() - e.getChegada().getEmSegundos(),
					UnidadeTempo.SEGUNDOS);
			if (this.tipo == 1)
				Estatisticas.getInstance().setTempoMedioEntidadeNaFilaServ1(tEmFila);
			else 
				Estatisticas.getInstance().setTempoMedioEntidadeNaFilaServ2(tEmFila);
		} else {
			addFila(e);
		}
	}

	public Entidade retiraFila() {
		return fila.remove();
	}

	public EstadoServidor getEstado() {
		return estado;
	}

	public void setEstado(EstadoServidor estado) {
		this.estado = estado;
	}

	public Tempo getTempoVoltaFuncionar() {
		return tempoVoltaFuncionar;
	}

	public void setTempoVoltaFuncionar(Tempo tempoVoltaFuncionar) {
		this.tempoVoltaFuncionar = tempoVoltaFuncionar;
	}

	public Queue<Entidade> getFila() {
		return fila;
	}

	public void falhar(Tempo t) {
		tempoVoltaFuncionar = t;
		estado = EstadoServidor.MANUTENCAO;
		if (rodando != null) {
			rodando.decFaltaPraTerminar(Relogio.getInstance().getTempo().getEmSegundos());
		}
	}

	public Entidade getRodando() {
		return rodando;
	}

	public void setRodando(Entidade rodando) {
		if (rodando != null) {
			this.rodando = rodando;
			estado = EstadoServidor.OCUPADO;
		} else {
			this.rodando = null;
			estado = EstadoServidor.LIVRE;
		}
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void consertar() {
		if (rodando != null) {
			estado = EstadoServidor.OCUPADO;
		} else {
			if (!fila.isEmpty()) {
				estado = EstadoServidor.OCUPADO;
				Entidade e1 = this.retiraFila();
				EventoSaida e = new EventoSaida(e1,
						new Tempo(Relogio.getInstance().getTempo().getEmSegundos() + e1.getTServ().getEmSegundos(),
								UnidadeTempo.SEGUNDOS));
				e1.atender(Relogio.getInstance().getTempo());
				this.setRodando(e1);
				Sistema.getInstance(null).adicionaNovoEvento(e);
				Tempo tEmFila = new Tempo(e1.getTInicioAtendimento().getEmSegundos() - e1.getChegada().getEmSegundos(),UnidadeTempo.SEGUNDOS);
				if (this.tipo == 1)
					Estatisticas.getInstance().setTempoMedioEntidadeNaFilaServ1(tEmFila);
				else 
					Estatisticas.getInstance().setTempoMedioEntidadeNaFilaServ2(tEmFila);
			} else {
				estado = EstadoServidor.LIVRE;
			}
		}
	}

}

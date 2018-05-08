package edu.upb.lp.progra.TowerDefense;

public abstract class Torre {
	private String tipo;
	private String nivel;
	private int potenciaDeAtaque;
	private int posicionV;
	private int posicionH;
	private int dinero;
	private TowerDefenseGame game;

	public Torre(String tipo, String nivel, int potenciaDeAtaque, int posicionV, int posicionH, int dinero, TowerDefenseGame game) {
		this.tipo = tipo;
		this.nivel = nivel;
		this.potenciaDeAtaque = potenciaDeAtaque;
		this.posicionV = posicionV;
		this.posicionH = posicionH;
		this.dinero = dinero;
		this.game = game;
	}
	
	public TowerDefenseGame getGame() {
		return game;
	}

	public int getDinero() {
		return dinero;
	}

	public int getPosicionV() {
		return posicionV;
	}

	public int getPosicionH() {
		return posicionH;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getTipo() {
		return tipo;
	}

	public int getPotenciaDeAtaque() {
		return potenciaDeAtaque;
	}

	public void setPotenciaDeAtaque(int potenciaDeAtaque) {
		this.potenciaDeAtaque = potenciaDeAtaque;
	}

	public abstract void atacar();

}

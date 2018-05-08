package edu.upb.lp.progra.TowerDefense;

public class Bicho {
	private int vida;
	private int dineroGenerado;
	private int lugar;
	
	public Bicho(int vida, int dineroGenerado, int lugar) {
		this.vida = vida;
		this.dineroGenerado = dineroGenerado;
		this.lugar = lugar;
	}
	
	public int getLugar() {
		return lugar;
	}

	public int getVida() {
		return vida;
	}

	public int getDineroGenerado() {
		return dineroGenerado;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

}

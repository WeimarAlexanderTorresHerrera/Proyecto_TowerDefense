package edu.upb.lp.progra.TowerDefense;

public class TorreBasica extends Torre {

	public TorreBasica(String tipo, int potenciaDeAtaque, int posicionV, int posicionH, TowerDefenseGame game) {
		super(tipo, "i", potenciaDeAtaque, posicionV, posicionH, 2, game);
	}

	public void atacar() {
		getGame().disparar(getPosicionV() - 1, getPosicionH() - 1, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() - 1, getPosicionH(), getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() - 1, getPosicionH() + 1, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV(), getPosicionH() - 1, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV(), getPosicionH() + 1, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() + 1, getPosicionH() - 1, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() + 1, getPosicionH(), getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() + 1, getPosicionH() + 1, getPotenciaDeAtaque());
	}

}

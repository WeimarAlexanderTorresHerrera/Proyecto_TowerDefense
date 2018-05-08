package edu.upb.lp.progra.TowerDefense;

public class Rayo extends Torre {

	public Rayo(int posicionV, int posicionH, TowerDefenseGame game) {
		super("rayo", "iii", 5, posicionV, posicionH, 3, game);
	}

	public void atacar() {
		getGame().disparar(getPosicionV() - 2, getPosicionH() - 2, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() - 2, getPosicionH() - 1, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() - 2, getPosicionH(), getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() - 2, getPosicionH() + 1, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() - 2, getPosicionH() + 2, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() - 1, getPosicionH() - 2, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() - 1, getPosicionH() - 1, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() - 1, getPosicionH(), getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() - 1, getPosicionH() + 1, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() - 1, getPosicionH() + 2, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV(), getPosicionH() - 2, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV(), getPosicionH() - 1, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV(), getPosicionH() + 1, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV(), getPosicionH() + 2, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() + 1, getPosicionH() - 2, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() + 1, getPosicionH() - 1, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() + 1, getPosicionH(), getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() + 1, getPosicionH() + 1, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() + 1, getPosicionH() + 2, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() + 2, getPosicionH() - 2, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() + 2, getPosicionH() - 1, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() + 2, getPosicionH(), getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() + 2, getPosicionH() + 1, getPotenciaDeAtaque());
		getGame().disparar(getPosicionV() + 2, getPosicionH() + 2, getPotenciaDeAtaque());
	}

}

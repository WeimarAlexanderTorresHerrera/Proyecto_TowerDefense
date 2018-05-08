package edu.upb.lp.progra.TowerDefense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TowerDefenseGame {
	private TowerDefenseUI ui;
	private int tamañoVertical = 8;
	private int tamañoHorizontal = 8;
	private int costoTorreArqueras = 40;
	private int costoTorreBalistico = 60;
	private int costoTorrePosion = 80;
	private int costoTorreRayo = 150;
	private int dinero = 80;
	private int numeroBichos = 0;
	private Movedor mov;
	// Tipo de torres
	// Arqueras = 0
	// Balistico = 1
	// Posion = 2
	// Rayo = 3
	// Ninguno = 4
	// Incremento de nivel = 5
	private int tipoDeTorreElegido = 4;
	private int incrementoDeBichos = 0;

	// Matriz para saber que contiene una casilla
	// Torre = 3
	// Blanco = 4
	// Negro = 5
	// Bicho = 6
	private int[][] casillasDeJuego = new int[8][8];
	private Bicho[][] casillasDeBichos = new Bicho[8][8];
	private int[] vidaDeBichos = new int[50];

	// private Torre[][] casillasDeTorres = new Torre[8][8];
	// Matriz para saber que torre esta en una determinada coordenada
	private List<Torre> casillasDeTorres = new ArrayList<Torre>();
	private Queue<Bicho> colaDeBichos = new LinkedList<Bicho>();
	private Map<String, Integer> coordenadasBichos = new HashMap<String, Integer>();

	public TowerDefenseGame(TowerDefenseUI ui) {
		this.ui = ui;
	}

	public void interfazDeInicio() {
		ui.configuracionesIniciales(tamañoVertical, tamañoHorizontal);
		imagenBase();
	}

	public void imagenBase() {
		for (int v = 0; v < tamañoVertical; v++) {
			for (int h = 0; h < tamañoHorizontal; h++) {
				ui.ponerImagen(v, h, "i");
			}
		}
	}

	public void iniciarJuego() {
		habilitarCasillas();
		casillasNoHabilitadasI();
		vidaDeBichos();
		dibujarTablero();
		ui.añadirTextoBotonesInicio(costoTorreArqueras, costoTorreBalistico, costoTorrePosion, costoTorreRayo, dinero);
	}

	public void habilitarCasillas() {
		for (int i = 0; i < tamañoHorizontal; i++) {
			for (int j = 0; j < tamañoVertical; j++) {
				casillasDeJuego[i][j] = 4;
			}
		}
	}

	public void casillasNoHabilitadasI() {
		casillasDeJuego[0][1] = 5;
		casillasDeJuego[0][5] = 7;
		casillasDeJuego[1][1] = 5;
		casillasDeJuego[1][5] = 5;
		casillasDeJuego[1][6] = 5;
		casillasDeJuego[2][1] = 5;
		casillasDeJuego[2][6] = 5;
		casillasDeJuego[3][0] = 5;
		casillasDeJuego[3][1] = 5;
		casillasDeJuego[3][4] = 5;
		casillasDeJuego[3][5] = 5;
		casillasDeJuego[3][6] = 5;
		casillasDeJuego[4][0] = 5;
		casillasDeJuego[4][4] = 5;
		casillasDeJuego[5][0] = 5;
		casillasDeJuego[5][1] = 5;
		casillasDeJuego[5][2] = 5;
		casillasDeJuego[5][4] = 5;
		casillasDeJuego[5][5] = 5;
		casillasDeJuego[5][6] = 5;
		casillasDeJuego[5][7] = 5;
		casillasDeJuego[6][2] = 5;
		casillasDeJuego[6][7] = 5;
		casillasDeJuego[7][2] = 5;
		casillasDeJuego[7][3] = 5;
		casillasDeJuego[7][4] = 5;
		casillasDeJuego[7][5] = 5;
		casillasDeJuego[7][6] = 5;
		casillasDeJuego[7][7] = 5;
	}

	public void vidaDeBichos() {
		vidaDeBichos[0] = 10;
		vidaDeBichos[1] = 10;
		vidaDeBichos[2] = 10;
		vidaDeBichos[3] = 10;
		vidaDeBichos[4] = 20;
		vidaDeBichos[5] = 20;
		vidaDeBichos[6] = 20;
		vidaDeBichos[7] = 20;
		vidaDeBichos[8] = 30;
		vidaDeBichos[9] = 30;
		vidaDeBichos[10] = 30;
		vidaDeBichos[11] = 30;
		vidaDeBichos[12] = 100;
		vidaDeBichos[13] = 20;
		vidaDeBichos[14] = 20;
		vidaDeBichos[15] = 20;
		vidaDeBichos[16] = 20;
		vidaDeBichos[17] = 20;
		vidaDeBichos[18] = 30;
		vidaDeBichos[19] = 30;
		vidaDeBichos[20] = 30;
		vidaDeBichos[21] = 30;
		vidaDeBichos[22] = 30;
		vidaDeBichos[23] = 40;
		vidaDeBichos[24] = 40;
		vidaDeBichos[25] = 40;
		vidaDeBichos[26] = 40;
		vidaDeBichos[27] = 40;
		vidaDeBichos[28] = 200;
		vidaDeBichos[29] = 30;
		vidaDeBichos[30] = 30;
		vidaDeBichos[31] = 30;
		vidaDeBichos[32] = 30;
		vidaDeBichos[33] = 30;
		vidaDeBichos[34] = 30;
		vidaDeBichos[35] = 40;
		vidaDeBichos[36] = 40;
		vidaDeBichos[37] = 40;
		vidaDeBichos[38] = 40;
		vidaDeBichos[39] = 40;
		vidaDeBichos[40] = 40;
		vidaDeBichos[41] = 50;
		vidaDeBichos[42] = 50;
		vidaDeBichos[43] = 50;
		vidaDeBichos[44] = 50;
		vidaDeBichos[45] = 50;
		vidaDeBichos[46] = 50;
		vidaDeBichos[47] = 60;
		vidaDeBichos[48] = 60;
		vidaDeBichos[49] = 300;
	}

	public void dibujarTablero() {
		for (int v = 0; v < tamañoVertical; v++) {
			for (int h = 0; h < tamañoHorizontal; h++) {
				if (casillasDeJuego[v][h] == 4) {
					ui.ponerImagen(v, h, "i");
				} else if (casillasDeJuego[v][h] == 5) {
					ui.ponerImagen(v, h, "ii");
				} else if (casillasDeJuego[v][h] == 7) {
					ui.ponerImagen(v, h, "iii");
				} else if (casillasDeJuego[v][h] == 6) {
					ui.ponerImagenBicho(v, h);
				} else {
					for (Torre torre : casillasDeTorres) {
						if (torre.getPosicionV() == v && torre.getPosicionH() == h) {
							ui.ponerImagenTorre(v, h, torre.getTipo(), torre.getNivel());
						}
					}
				}
			}
		}
		ui.actualizarDinero(dinero);
	}

	public void iniciar() {
		colaDeBichos(5 + incrementoDeBichos);
		incrementoDeBichos += 1;
		mov = new Movedor(this);
		mov.start();
	}

	public void colaDeBichos(int numeroDeBichos) {
		numeroBichos = numeroDeBichos;
		for (int i = 0; i < numeroDeBichos; i++) {
			Bicho b = new Bicho(vidaDeBichos[i], 2 + i, i + 1);
			colaDeBichos.offer(b);
		}
	}

	public void step() {
		atacar();
		avanzar();
		introducirBicho();
		actualizarTablero();
		incrementarDineroTorres();
		dibujarTablero();
		if (partidaGanada()) {
			ui.partidaGanada();
			mov.stop();
			mov = null;
		} else if (partidaPerdida()) {
			reiniciarJuego();
			ui.partidaPerdida();
			mov.stop();
			mov = null;
		}
	}

	public void atacar() {
		for (Torre torre : casillasDeTorres) {
			torre.atacar();
		}
		/*
		 * for (int v = 0; v < tamañoVertical; v++) { for (int h = 0; h <
		 * tamañoHorizontal; h++) { if (casillasDeTorres[v][h] != null) { if (v > 0 && h
		 * > 0 && casillasDeBichos[v - 1][h - 1] != null) { casillasDeBichos[v - 1][h -
		 * 1].setVida(casillasDeBichos[v - 1][h - 1].getVida() -
		 * casillasDeTorres[v][h].getPotenciaDeAtaque()); } if (v > 0 &&
		 * casillasDeBichos[v - 1][h] != null) { casillasDeBichos[v - 1][h].setVida(
		 * casillasDeBichos[v - 1][h].getVida() -
		 * casillasDeTorres[v][h].getPotenciaDeAtaque()); } if (v > 0 && h < 7 &&
		 * casillasDeBichos[v - 1][h + 1] != null) { casillasDeBichos[v - 1][h +
		 * 1].setVida(casillasDeBichos[v - 1][h + 1].getVida() -
		 * casillasDeTorres[v][h].getPotenciaDeAtaque()); } if (h > 0 &&
		 * casillasDeBichos[v][h - 1] != null) { casillasDeBichos[v][h - 1].setVida(
		 * casillasDeBichos[v][h - 1].getVida() -
		 * casillasDeTorres[v][h].getPotenciaDeAtaque()); } if (h < 7 &&
		 * casillasDeBichos[v][h + 1] != null) { casillasDeBichos[v][h + 1].setVida(
		 * casillasDeBichos[v][h + 1].getVida() -
		 * casillasDeTorres[v][h].getPotenciaDeAtaque()); } if (v < 7 && h > 0 &&
		 * casillasDeBichos[v + 1][h - 1] != null) { casillasDeBichos[v + 1][h -
		 * 1].setVida(casillasDeBichos[v + 1][h - 1].getVida() -
		 * casillasDeTorres[v][h].getPotenciaDeAtaque()); } if (v < 7 &&
		 * casillasDeBichos[v + 1][h] != null) { casillasDeBichos[v + 1][h].setVida(
		 * casillasDeBichos[v + 1][h].getVida() -
		 * casillasDeTorres[v][h].getPotenciaDeAtaque()); } if (v < 7 && h < 7 &&
		 * casillasDeBichos[v + 1][h + 1] != null) { casillasDeBichos[v + 1][h +
		 * 1].setVida(casillasDeBichos[v + 1][h + 1].getVida() -
		 * casillasDeTorres[v][h].getPotenciaDeAtaque()); } } } }
		 */
	}

	public void disparar(int v, int h, int potenciaDeAtaque) {
		if (v > -1 && v < 8 && h > -1 && h < 8 && casillasDeBichos[v][h] != null) {
			casillasDeBichos[v][h].setVida(casillasDeBichos[v][h].getVida() - potenciaDeAtaque);
		}
	}

	public void avanzar() {
		for (int i = 1; i <= numeroBichos; i++) {
			if (coordenadasBichos.containsKey(i + "v")) {
				Integer a = coordenadasBichos.get(i + "v");
				Integer b = coordenadasBichos.get(i + "h");
				Integer c = coordenadasBichos.get(i + "vAnt");
				Integer d = coordenadasBichos.get(i + "hAnt");
				if (a + 1 < 8 && casillasDeJuego[a + 1][b] == 5 && (a + 1 != c || b != d)) {
					casillasDeBichos[a + 1][b] = casillasDeBichos[a][b];
					casillasDeBichos[a][b] = null;
					casillasDeJuego[a][b] = 5;
					casillasDeJuego[a + 1][b] = 6;
					Integer e = a + 1;
					coordenadasBichos.put(i + "v", e);
					coordenadasBichos.put(i + "h", b);
					coordenadasBichos.put(i + "vAnt", a);
					coordenadasBichos.put(i + "hAnt", b);
				} else if (a - 1 > -1 && (casillasDeJuego[a - 1][b] == 5 || casillasDeJuego[a - 1][b] == 7)
						&& (a - 1 != c || b != d)) {
					casillasDeBichos[a - 1][b] = casillasDeBichos[a][b];
					casillasDeBichos[a][b] = null;
					casillasDeJuego[a][b] = 5;
					casillasDeJuego[a - 1][b] = 6;
					Integer e = a - 1;
					coordenadasBichos.put(i + "v", e);
					coordenadasBichos.put(i + "h", b);
					coordenadasBichos.put(i + "vAnt", a);
					coordenadasBichos.put(i + "hAnt", b);
				} else if (b + 1 < 8 && casillasDeJuego[a][b + 1] == 5 && (a != c || b + 1 != d)) {
					casillasDeBichos[a][b + 1] = casillasDeBichos[a][b];
					casillasDeBichos[a][b] = null;
					casillasDeJuego[a][b] = 5;
					casillasDeJuego[a][b + 1] = 6;
					Integer e = b + 1;
					coordenadasBichos.put(i + "v", a);
					coordenadasBichos.put(i + "h", e);
					coordenadasBichos.put(i + "vAnt", a);
					coordenadasBichos.put(i + "hAnt", b);
				} else if (b - 1 > -1 && casillasDeJuego[a][b - 1] == 5 && (a != c || b - 1 != d)) {
					casillasDeBichos[a][b - 1] = casillasDeBichos[a][b];
					casillasDeBichos[a][b] = null;
					casillasDeJuego[a][b] = 5;
					casillasDeJuego[a][b - 1] = 6;
					Integer e = b - 1;
					coordenadasBichos.put(i + "v", a);
					coordenadasBichos.put(i + "h", e);
					coordenadasBichos.put(i + "vAnt", a);
					coordenadasBichos.put(i + "hAnt", b);
				}
			}
		}
	}

	public void introducirBicho() {
		if (colaDeBichos.peek() != null) {
			casillasDeBichos[0][1] = colaDeBichos.poll();
			casillasDeJuego[0][1] = 6;
			coordenadasBichos.put(casillasDeBichos[0][1].getLugar() + "v", 0);
			coordenadasBichos.put(casillasDeBichos[0][1].getLugar() + "h", 1);
			coordenadasBichos.put(casillasDeBichos[0][1].getLugar() + "vAnt", -1);
			coordenadasBichos.put(casillasDeBichos[0][1].getLugar() + "hAnt", -1);
		}
	}

	public void actualizarTablero() {
		for (int v = 0; v < tamañoVertical; v++) {
			for (int h = 0; h < tamañoHorizontal; h++) {
				if (casillasDeBichos[v][h] != null && !vidaBicho(v, h)) {
					coordenadasBichos.remove(casillasDeBichos[v][h].getLugar() + "v");
					coordenadasBichos.remove(casillasDeBichos[v][h].getLugar() + "h");
					coordenadasBichos.remove(casillasDeBichos[v][h].getLugar() + "vAnt");
					coordenadasBichos.remove(casillasDeBichos[v][h].getLugar() + "hAnt");
					casillasDeBichos[v][h] = null;
					casillasDeJuego[v][h] = 5;
				}
			}
		}
	}

	public boolean vidaBicho(int v, int h) {
		if (casillasDeBichos[v][h].getVida() <= 0) {
			return false;
		} else {
			return true;
		}
	}

	public void incrementarDineroTorres() {
		for (Torre torre : casillasDeTorres) {
			dinero += torre.getDinero();
		}
	}

	public boolean partidaGanada() {
		int bichos = 0;
		for (int v = 0; v < this.tamañoVertical; v++) {
			for (int h = 0; h < this.tamañoHorizontal; h++) {
				if (casillasDeBichos[v][h] != null) {
					bichos += 1;
				}
			}
		}
		if (bichos == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean partidaPerdida() {
		if (casillasDeBichos[0][5] != null) {
			return true;
		} else {
			return false;
		}
	}

	public void reiniciarJuego() {
		for (int v = 0; v < this.tamañoVertical; v++) {
			for (int h = 0; h < this.tamañoHorizontal; h++) {
				casillasDeBichos[v][h] = null;
			}
		}
		casillasDeTorres.clear();
		colaDeBichos.clear();
		coordenadasBichos.clear();
		tipoDeTorreElegido = 4;
		dinero = 80;
		incrementoDeBichos = 0;
	}

	public void executeLater(Runnable r, int tiempo) {
		ui.executeLater(r, tiempo);
	}

	public void celdaPresionada(int v, int h) {
		boolean torreExistente = false;
		for (Torre torre : casillasDeTorres) {
			if (torre.getPosicionH() == h && torre.getPosicionV() == v) {
				torreExistente = true;
			}
		}
		if (!torreExistente && casillasDeJuego[v][h] == 4) {
			if (tipoDeTorreElegido == 0 && compraPosible(0)) {
				comprarTorre(0, v, h);
				dibujarTablero();
				tipoDeTorreElegido = 4;
			} else if (tipoDeTorreElegido == 0 && !compraPosible(0)) {
				ui.mensajeCompraImposible();
				tipoDeTorreElegido = 4;
			} else if (tipoDeTorreElegido == 1 && compraPosible(1)) {
				comprarTorre(1, v, h);
				dibujarTablero();
				tipoDeTorreElegido = 4;
			} else if (tipoDeTorreElegido == 1 && !compraPosible(1)) {
				ui.mensajeCompraImposible();
				tipoDeTorreElegido = 4;
			} else if (tipoDeTorreElegido == 2 && compraPosible(2)) {
				comprarTorre(2, v, h);
				dibujarTablero();
				tipoDeTorreElegido = 4;
			} else if (tipoDeTorreElegido == 2 && !compraPosible(2)) {
				ui.mensajeCompraImposible();
				tipoDeTorreElegido = 4;
			} else if (tipoDeTorreElegido == 3 && compraPosible(3)) {
				comprarTorre(3, v, h);
				dibujarTablero();
				tipoDeTorreElegido = 4;
			} else if (tipoDeTorreElegido == 3 && !compraPosible(3)) {
				ui.mensajeCompraImposible();
				tipoDeTorreElegido = 4;
			}
		} else if (torreExistente && tipoDeTorreElegido == 5) {
			for (Torre torre : casillasDeTorres) {
				if (torre.getPosicionH() == h && torre.getPosicionV() == v) {
					if (torre.getTipo() == "arqueras") {
						if (torre.getNivel() == "i" && compraPosible(0)) {
							torre.setNivel("ii");
							torre.setPotenciaDeAtaque(torre.getPotenciaDeAtaque() + 1);
							comprarActualizacion(0);
							dibujarTablero();
							tipoDeTorreElegido = 4;
						} else if (torre.getNivel() == "ii" && compraPosible(0)) {
							torre.setNivel("iii");
							torre.setPotenciaDeAtaque(torre.getPotenciaDeAtaque() + 1);
							comprarActualizacion(0);
							dibujarTablero();
							tipoDeTorreElegido = 4;
						} else if (!compraPosible(0)) {
							ui.mensajeActualizacionImposible();
							tipoDeTorreElegido = 4;
						}
					} else if (torre.getTipo() == "balistico") {
						if (torre.getNivel() == "i" && compraPosible(1)) {
							torre.setNivel("ii");
							torre.setPotenciaDeAtaque(torre.getPotenciaDeAtaque() + 1);
							comprarActualizacion(1);
							dibujarTablero();
							tipoDeTorreElegido = 4;
						} else if (torre.getNivel() == "ii" && compraPosible(1)) {
							torre.setNivel("iii");
							torre.setPotenciaDeAtaque(torre.getPotenciaDeAtaque() + 1);
							comprarActualizacion(1);
							dibujarTablero();
							tipoDeTorreElegido = 4;
						} else if (!compraPosible(1)) {
							ui.mensajeActualizacionImposible();
							tipoDeTorreElegido = 4;
						}
					} else if (torre.getTipo() == "posion") {
						if (torre.getNivel() == "i" && compraPosible(2)) {
							torre.setNivel("ii");
							torre.setPotenciaDeAtaque(torre.getPotenciaDeAtaque() + 1);
							comprarActualizacion(2);
							dibujarTablero();
							tipoDeTorreElegido = 4;
						} else if (torre.getNivel() == "ii" && compraPosible(2)) {
							torre.setNivel("iii");
							torre.setPotenciaDeAtaque(torre.getPotenciaDeAtaque() + 1);
							comprarActualizacion(2);
							dibujarTablero();
							tipoDeTorreElegido = 4;
						} else if (!compraPosible(2)) {
							ui.mensajeActualizacionImposible();
							tipoDeTorreElegido = 4;
						}
					}
				}
			}
		}
	}

	public boolean compraPosible(int i) {
		if (i == 0 && dinero >= costoTorreArqueras) {
			return true;
		} else if (i == 1 && dinero >= costoTorreBalistico) {
			return true;
		} else if (i == 2 && dinero >= costoTorrePosion) {
			return true;
		} else if (i == 3 && dinero >= costoTorreRayo) {
			return true;
		} else {
			return false;
		}
	}

	public void comprarTorre(int i, int v, int h) {
		if (i == 0) {
			Torre a = new TorreBasica("arqueras", 1, v, h, this);
			casillasDeTorres.add(a);
			dinero -= 40;
		} else if (i == 1) {
			Torre b = new TorreBasica("balistico", 2, v, h, this);
			casillasDeTorres.add(b);
			dinero -= 60;
		} else if (i == 2) {
			Torre c = new TorreBasica("posion", 3, v, h, this);
			casillasDeTorres.add(c);
			dinero -= 80;
		} else if (i == 3) {
			Torre d = new Rayo(v, h, this);
			casillasDeTorres.add(d);
			dinero -= 150;
		}
		casillasDeJuego[v][h] = 3;
	}

	public void comprarActualizacion(int i) {
		if (i == 0) {
			dinero -= 40;
		} else if (i == 1) {
			dinero -= 60;
		} else if (i == 2) {
			dinero -= 80;
		}
	}

	public void setTipoDeTorreElegido(int tipoDeTorreElegido) {
		this.tipoDeTorreElegido = tipoDeTorreElegido;
	}

}

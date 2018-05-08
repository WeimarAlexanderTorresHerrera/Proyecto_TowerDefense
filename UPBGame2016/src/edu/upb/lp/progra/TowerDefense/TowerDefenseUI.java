package edu.upb.lp.progra.TowerDefense;

import edu.upb.lp.progra.adapterFiles.AndroidGameGUI;
import edu.upb.lp.progra.adapterFiles.TextListener;
import edu.upb.lp.progra.adapterFiles.UI;

public class TowerDefenseUI implements UI {
	private TowerDefenseGame game;
	private AndroidGameGUI gui;

	// Tipo de torres
	// Arqueras = 0
	// Balistico = 1
	// Posion = 2
	// Rayo = 3
	// Ninguno = 4
	// Incremento de nivel = 5
	int tipoDeTorreElegido = 4;
	int incrementoDeBichos = 0;

	TextListener listener = new TextListener() {

		public void receiveText(String text) {
			try {
				if (text.isEmpty()) {
					throw new NombreInexistenteException();
				}
				gui.addTextField("Nombre jugador", "Nombre Jugador: " + text, 15, 50);
			} catch (NombreInexistenteException error) {
				gui.showTemporaryMessage("Este campo no puede quedar vacio", true);
				gui.askUserText("Introducir nombre", listener);
			}
		}
	};

	public TowerDefenseUI(AndroidGameGUI gui) {
		this.game = new TowerDefenseGame(this);
		this.gui = gui;
	}

	public void initialiseInterface() {
		this.game.interfazDeInicio();
	}

	public void onButtonPressed(String name) {
		if (name.equals("Iniciar Juego")) {
			gui.removeButton("Iniciar Juego");
			this.game.iniciarJuego();
		} else if (name.equals("Torre Arqueras")) {
			this.game.setTipoDeTorreElegido(0);
		} else if (name.equals("Torre Balistico")) {
			this.game.setTipoDeTorreElegido(1);
		} else if (name.equals("Torre Posion")) {
			this.game.setTipoDeTorreElegido(2);
		} else if (name.equals("Torre Rayo")) {
			this.game.setTipoDeTorreElegido(3);
		} else if (name.equals("Mejorar Torre")) {
			this.game.setTipoDeTorreElegido(5);
		} else if (name.equals("Iniciar")) {
			gui.removeButton("Iniciar");
			this.game.iniciar();
		}
	}

	public void onCellPressed(int v, int h) {
		game.celdaPresionada(v, h);
	}

	public void ponerImagen(int v, int h, String tipo) {
		gui.setImageOnCell(v, h, "base_" + tipo);
	}

	public void configuracionesIniciales(int v, int h) {
		gui.configureGrid(v, h, 0, 0, 15);
		gui.setBottomSectionProportion(0.25);
		gui.addButton("Iniciar Juego", 15, 40);
	}

	public void añadirTextoBotonesInicio(int arqueras, int balistico, int posion, int rayo, int dinero) {
		gui.askUserText("Introducir nombre", listener);
		gui.addButton("Torre Arqueras", 15, 40);
		gui.addButton("Torre Balistico", 15, 40);
		gui.addButton("Torre Posion", 15, 40);
		gui.addButton("Torre Rayo", 15, 40);
		gui.addButton("Mejorar Torre", 15, 40);
		gui.addButton("Iniciar", 15, 40);
		gui.addTextField("Arqueras", "Torre Arquera: " + arqueras + "$", 15, 25);
		gui.addTextField("Balistico", "Torre Balistico: " + balistico + "$", 15, 25);
		gui.addTextField("Posion", "Torre Posion: " + posion + "$", 15, 25);
		gui.addTextField("Rayo", "Torre Rayo: " + rayo + "$", 15, 25);
		gui.addTextField("Dinero", "Dinero: " + dinero + "$", 15, 25);
	}

	public void ponerImagenTorre(int v, int h, String tipo, String nivel) {
		gui.setImageOnCell(v, h, "torre_" + tipo + "_" + nivel);
	}

	public void ponerImagenBicho(int v, int h) {
		gui.setImageOnCell(v, h, "bicho");
	}

	public void actualizarDinero(int dinero) {
		gui.addTextField("Dinero", "Dinero: " + dinero + "$", 15, 25);

	}

	public void partidaGanada() {
		gui.addButton("Iniciar", 15, 40);
		gui.showTemporaryMessage("Ganaste la partida", true);
	}

	public void partidaPerdida() {
		gui.removeAllButtons();
		gui.addButton("Iniciar Juego", 15, 40);
		gui.showTemporaryMessage("Perdiste el juego", true);
	}

	public void executeLater(Runnable r, int tiempo) {
		gui.executeLater(r, tiempo);
	}

	public void mensajeCompraImposible() {
		gui.showTemporaryMessage("No hay dinero disponible para comprar la Torre", true);
	}

	public void mensajeActualizacionImposible() {
		gui.showTemporaryMessage("No hay dinero disponible para actualizar la Torre", true);
	}

}

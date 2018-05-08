package edu.upb.lp.progra.TowerDefense;

public class Movedor implements Runnable {
	private TowerDefenseGame game;
	public boolean running = false;

	public Movedor(TowerDefenseGame game) {
		super();
		this.game = game;
	}

	public void start() {
		running = true;
		run();
	}

	public void stop() {
		running = false;
	}

	@Override
	public void run() {
		if (running) {
			game.step();
			game.executeLater(this, 400);
		}
	}

}

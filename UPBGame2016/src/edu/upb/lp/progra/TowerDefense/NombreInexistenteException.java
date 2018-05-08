package edu.upb.lp.progra.TowerDefense;

public class NombreInexistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NombreInexistenteException() {
		super("Este campo no puede quedar vacio");
	}

}

package logica;

import logica.casillas.Casilla;
import logica.casillas.Espacio;
import logica.casillas.Invasor;
import logica.casillas.Meteorito;

/**
 * Titulo: Clase Tablero
 * 
 * @author UO281847
 * @version 28/10/2021
 */
public class Tablero {	
	/**
	 * Constante DIM
	 */
	public static final int DIM = 8;
	/**
	 * Array de casillas
	 */
	Casilla[] casillas;
	/**
	 * Atributo posicionInvasor
	 */
	private int posicionInvasor;
	/**
	 * Atributo posicionMeteorito
	 */
	private int posicionMeteorito;
	/**
	 * Atributo dim
	 */
	private int dim;
	/**
	 * Atribto nInvasores
	 */
	private int nInvasores;
	/**
	 * Atributo nMeteoritos
	 */
	private int nMeteoritos;
	
	/**
	 * Constructor del tablero
	 */
	public Tablero(int dim, int nInvasores, int nMeteoritos) {
		this.dim = dim;
		this.nInvasores = nInvasores;
		this.nMeteoritos = nMeteoritos;
		casillas = new Casilla[dim];
		for (int i = 0; i < dim; i++) {
			casillas[i] = new Espacio();
		}
		colocarInvasores();
		colocarMeteoritos();
	}

	/**
	 * MMétodo que coloca al Invasor
	 */
	private void colocarInvasores() {
		posicionInvasor = (int) (Math.random() * DIM);
		for (int i = 0; i < nInvasores; i++) {
			do {
				posicionInvasor = (int) (Math.random() * dim);
			} while (!hayEspacio(posicionInvasor));
			casillas[posicionInvasor] = new Invasor();
			System.out.println("Invasor en " + posicionInvasor);
		}	
	}
	
	/**
	 * MMétodo que coloca al Invasor
	 */
	private void colocarMeteoritos() {
		posicionMeteorito = (int) (Math.random() * DIM);
		for (int i = 0; i < nMeteoritos; i++) {
			do {
				posicionMeteorito = (int) (Math.random() * dim);
			} 
			while (!hayEspacio(posicionMeteorito));
			casillas[posicionMeteorito] = new Meteorito();
			System.out.println("Meteorito en " + posicionMeteorito);
		}
	}
	
	/**
	 * Método que comprueba si hay espacio en el tablero
	 * 
	 * @param i
	 * @return true o false
	 */
	private boolean hayEspacio(int i) {
		if (getCasillas()[i] instanceof Espacio)
			return true;
		return false;
	}

	/**
	 * Método que setea las casillas
	 * 
	 * @param casillas
	 */
	public void setCasillas(Casilla[] casillas) {
		this.casillas = casillas;
	}	
	/**
	 * Método que devuelve el array de casillas
	 */
	public Casilla[] getCasillas() {
		return casillas;
	}
	
	/**
	 * Método que devuelve el atributo posicionInvasor
	 * 
	 * @return posicionInvasor
	 */
	public int getPosicionInvasor() {
		return posicionInvasor;
	}
	
	/**
	 * Método que devuelve el atributo posicionMeteorito
	 * 
	 * @return posicionMeteorito
	 */
	public int getPosicionMeteorito() {
		return posicionMeteorito;
	}
}

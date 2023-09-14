package logica;

/**
 * Titulo: Clase Tablero
 * 
 * @author UO281847
 * @version 21/10/2021
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
	 * Constructor del tablero
	 */
	public Tablero() {
		casillas = new Casilla[DIM];
		for (int i=0;i<DIM;i++)
			casillas[i] = new Espacio();
		colocaInvasor();
		colocaMeteorito();
	}

	/**
	 * MMétodo que coloca al Invasor
	 */
	private void colocaInvasor() {
		posicionInvasor = (int) (Math.random() * DIM);
		while (posicionMeteorito==posicionInvasor) {
			posicionInvasor = (int) (Math.random() * DIM);
		}
		System.out.println("Invasor en: "+ posicionInvasor);
		casillas[posicionInvasor] = new Invasor();	
	}
	
	/**
	 * MMétodo que coloca al Invasor
	 */
	private void colocaMeteorito() {
		posicionMeteorito = (int) (Math.random() * DIM);
		while (posicionMeteorito==posicionInvasor) {
			posicionMeteorito = (int) (Math.random() * DIM);
		}
		System.out.println("Meteorito en: "+ posicionMeteorito);
		casillas[posicionMeteorito] = new Meteorito();	
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
	
	/**
	 * Método que devuelve el array de casillas
	 */
	public Casilla[] getCasillas() {
		return casillas;
	}
}

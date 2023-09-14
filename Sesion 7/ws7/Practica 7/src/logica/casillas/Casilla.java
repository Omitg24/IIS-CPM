package logica.casillas;

/**
 * Titulo: Clase Casilla
 * 
 * @author UO281847
 * @version 28/10/2021
 */
public abstract class Casilla {
	/**
	 * Atributo puntos
	 */
	private int puntos;
	
	/**
	 * M�todo que devuelve los puntos
	 * 
	 * @return puntos
	 */
	public int getPuntos() {
		return puntos;
	}
	
	/**
	 * M�todo que modifica el valor de los puntos
	 * 
	 * @param puntos
	 */
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}

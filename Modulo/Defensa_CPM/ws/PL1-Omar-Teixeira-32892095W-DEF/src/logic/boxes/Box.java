package logic.boxes;

/**
 * T�tulo: Clase Box
 * Descripci�n: Clase general que guarda los puntos de las diferentes casillas
 *
 * @author Omar Teixeira, UO281847
 * @version 30 dic. 2021
 */
public class Box {
//-- ATRIBUTOS -----------------------------------------------------------------
	/**
	 * Atributo points
	 */
	private int points;
	
	/**
	 * M�todo que devuelve los puntos
	 * 
	 * @return points, puntos
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * M�todo que setea los puntos
	 * 
	 * @param points, puntos
	 */
	protected void setPoints(int points) {
		this.points=points;
	}
}

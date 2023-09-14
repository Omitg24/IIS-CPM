package logica;

/**
 * Titulo: Clase Dado
 * 
 * @author UO281847
 * @version 21/10/2021
 */
public class Dado {
	/**
	 * Método que lanza el dado
	 * 
	 * @return int, valor del dado
	 */
	public static int lanzar()
	{ 
		return ((int) (Math.random() * Juego.maxDisparos) + 1);
	}
}

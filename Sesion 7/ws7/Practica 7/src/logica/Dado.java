package logica;

/**
 * Titulo: Clase Dado
 * 
 * @author UO281847
 * @version 28/10/2021
 */
public class Dado {
	/**
	 * Método que lanza el dado
	 * 
	 * @return int, valor del dado
	 */
	public static int lanzar(int maxDisparos)
	{ 
		return ((int) (Math.random() * maxDisparos) + 1);
	}
}

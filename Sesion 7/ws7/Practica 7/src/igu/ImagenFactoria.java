package igu;

import javax.swing.ImageIcon;

import logica.casillas.Casilla;
import logica.casillas.Espacio;
import logica.casillas.Invasor;
import logica.casillas.Meteorito;

/**
 * Titulo: Clase ImagenFactoria
 * 
 * @author UO281847
 * @version 28/10/2021
 */
public class ImagenFactoria {
	
	/**
	 * Constante imagen invasor
	 */
	private static final String IMAGEN_INVASOR = "/img/invader.jpg";
	/**
	 * Constante imagen space
	 */
	private static final String IMAGEN_SPACE = "/img/space.jpg";
	/**
	 * Constante imagen shoot
	 */
	private static final String IMAGEN_SHOOT = "/img/shoot.png";
	/**
	 * Constante imagen meteorite
	 */
	private static final String IMAGEN_METEORITE = "/img/meteorite.jpg";

	/**
	 * Método que devuelve la imagen de la casilla
	 * 
	 * @param casilla, casilla
	 * @return imagenIcon
	 */
	public static ImageIcon getImagen(Casilla casilla) {
		if (casilla instanceof Invasor)
			return cargaImagen(IMAGEN_INVASOR);
		else if (casilla instanceof Meteorito)
			return cargaImagen(IMAGEN_METEORITE);
		else if (casilla instanceof Espacio)
			return cargaImagen(IMAGEN_SPACE);		
		return null;
	}
	
	/**
	 * Método que devuelve la imagen
	 * 
	 * @return imagenIcon
	 */
	public static ImageIcon getImagen()
	{
		return cargaImagen(IMAGEN_SHOOT);
	}
	
	/**
	 * Método que carga la imagen
	 * 
	 * @param fichero, fichero
	 * @return imageIcon
	 */
	private static ImageIcon cargaImagen(String fichero) {
		return new ImageIcon(ImagenFactoria.class.getResource(fichero));
	}
}

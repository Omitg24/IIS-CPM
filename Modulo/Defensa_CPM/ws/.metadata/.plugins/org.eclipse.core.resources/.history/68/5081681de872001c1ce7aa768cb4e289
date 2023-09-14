package graphic_interface;

import javax.swing.ImageIcon;

import logic.boxes.Box;
import logic.boxes.Box1000Points;
import logic.boxes.Box250Points;
import logic.boxes.Box50Points;
import logic.boxes.BoxSpecial;
import logic.boxes.BoxX2Points;

/**
 * Título: Clase ImageFactory
 * Descripción: Clase encargada de cargar las imágenes al panel de botones, de forma que,
 * cuando el jugador presione en una de estas, la casilla revele lo que llevaba en su interior. 
 *
 * @author Omar Teixeira, UO281847
 * @version 31 dic. 2021
 */
public class ImageFactory {
//-- CONSTANTE -----------------------------------------------------------------
	/**
	 * Constante BOX1000
	 */
	private static final String BOX1000 ="/images/boxes/Box1000.png";
	/**
	 * Constante BOX250
	 */
	private static final String BOX250 ="/images/boxes/Box250.png";
	/**
	 * Constante BOX50
	 */
	private static final String BOX50 ="/images/boxes/Box50.png";
	/**
	 * Constante BOXX2
	 */
	private static final String BOXX2 ="/images/boxes/BoxX2.png";
	/**
	 * Constante BOXSpecial
	 */
	private static final String BOXSPECIAL ="/images/boxes/BoxSpecial.png";
	
	/**
	 * Método que devuelve el icono correspondiente a cada casilla
	 * 
	 * @param box, casila
	 * @return icon, icono de cada casilla
	 */
	public static ImageIcon getIcon(Box box) {
		if (box instanceof Box1000Points) {
			return uploadImage(BOX1000);
		} else if (box instanceof Box250Points) {
			return uploadImage(BOX250);
		} else if (box instanceof Box50Points) {
			return uploadImage(BOX50);
		} else if (box instanceof BoxX2Points) {
			return uploadImage(BOXX2);
		} else if (box instanceof BoxSpecial) {
			return uploadImage(BOXSPECIAL);
		}
		return null;
	}

	/**
	 * Nétodo que carga las imagenes de las casillas
	 * 
	 * @param boxFile, direccion de la casilla
	 * @return ImageIcon. icono de la imagen
	 */
	private static ImageIcon uploadImage(String boxFile) {
		return new ImageIcon(ImageFactory.class.getResource(boxFile));
	}
}

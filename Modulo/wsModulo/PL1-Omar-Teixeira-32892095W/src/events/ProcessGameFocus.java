package events;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 * Titulo: Clase ProcessGameFocus
 * Descripción: Clase que procesa cuando el ratón se posa sobre uno de los 
 * botones cambiando así el color de su borde.
 *
 * @author Omar Teixeira, UO281847
 * @version 2 ene. 2022
 */
public class ProcessGameFocus extends MouseAdapter {
	/**
	 * Método que capta el evento de cuando el ratón se posa sobre el boton
	 * 
	 * @param e, evento
	 */
	public void mouseEntered(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn.isEnabled()) {
			btn.setBorder(new LineBorder(new Color(212,175,55), 8, true));
		}			
	}
	
	/**
	 * Método que capta el evento de cuando el ratón sale del boton
	 * 
	 * @param e, evento
	 */
	public void mouseExited(MouseEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn.isEnabled()) {
			btn.setBorder(new LineBorder(new Color(165, 42, 42), 4, true));
		}
	}
}
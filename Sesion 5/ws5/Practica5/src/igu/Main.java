package igu;

import java.awt.EventQueue;

import javax.swing.UIManager;

import logica.Carta;
import logica.Pedido;

/**
 * Titulo: Clase Main
 * 
 * @author UO281847
 * @version 14/10/2021
 */
public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Pedido pedido = new Pedido();		
		Carta carta = new Carta();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					VentanaPrincipal frame = new VentanaPrincipal(carta, pedido);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

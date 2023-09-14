package igu;
import java.awt.EventQueue;

import javax.swing.UIManager;

import logica.*;

/**
 * Titulo: Clase Main
 * 
 * @author Omitg
 * @version 06/12/2021
 */
public class Main {

	/**
	 * Lanza el programa
	 * @param args
	 */
	public static void main(String[] args) {
		final Carta carta = new Carta();
		final Pedido pedido = new Pedido();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					VentanaPrincipal frame = new VentanaPrincipal(carta,pedido);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			
	}
}

package igu;

import java.awt.EventQueue;

import javax.swing.UIManager;

import logica.Juego;

/**
 * Titulo: Clase Main
 * 
 * @author UO281847
 * @version 21/10/2021
 */
public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Juego juego = new Juego();		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal(juego);
					frame.setVisible(true);
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

package igu;

import java.awt.EventQueue;

import logica.Juego;
import logica.Producto;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Juego juego = new Juego();
		Producto producto = new Producto();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal(juego, producto);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

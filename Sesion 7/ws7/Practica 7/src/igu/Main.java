package igu;

import java.awt.EventQueue;
import java.util.Properties;

import javax.swing.UIManager;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import logica.Juego;

/**
 * Titulo: Clase Main
 * 
 * @author UO281847
 * @version 28/10/2021
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
					Properties p = new Properties();
					p.put("logoString", "");
					HiFiLookAndFeel.setCurrentTheme(p);
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					VentanaPrincipal frame = new VentanaPrincipal(juego);
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

package igu;

import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import player.MusicPlayer;

/**
 * Titulo: Clase Main
 * 
 * @author UO281847
 * @version 21/10/2021d
 */
public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MusicPlayer mP = new MusicPlayer();
		SwingUtilities.invokeLater(new Runnable() {		
			public void run() {
				try {
					Properties p = new Properties();
					p.put("logoString", "");
					p.put("focusColor", "0 0 0");
					HiFiLookAndFeel.setCurrentTheme(p);
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					VentanaPrincipal v = new VentanaPrincipal(mP);
					v.setVisible(true);					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error: " + e);
				}
			}
		});
	}
}

package igu;
import java.awt.EventQueue;
import logica.*;
/**
 * Titulo: Clase Main
 * 
 * @author UO281847
 * @version 25/11/2021
 */
public class Main {

	/**
	 * Método main
	 * @param args
	 */
	public static void main(String[] args) {
		final Carta carta = new Carta();
		final Pedido pedido = new Pedido();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//					UIDefaults uiDefaults = UIManager.getDefaults();
//					uiDefaults.put("activeCaption", new javax.swing.plaf.ColorUIResource(Color.green));
//					uiDefaults.put("activeCaptionText", new javax.swing.plaf.ColorUIResource(Color.white));
//					JFrame.setDefaultLookAndFeelDecorated(true);
//					JDialog.setDefaultLookAndFeelDecorated(true);
					VentanaPrincipal frame = new VentanaPrincipal(carta,pedido);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			
	}
}

package graphic_interface;


import javax.swing.SwingUtilities;

import logic.Game;

/**
 * Título: Clase Main
 * Descripción: Clase que ejecuta el programa creando la ventana de inicio, donde
 * se seleccionara el idioma, comprobará el codigo de cliente y si puede jugar lo 
 * llevará a la ventana principal, donde jugará al panel de botones, y canjeará 
 * los regalos que haya escogido.
 * 
 * @author Omar Teixeira, UO281847
 * @version 25 dic. 2021
 */
public class Main {
	
	/**
	 * Método main empleado para la ejecución del programa
	 * 
	 * @param args, argumento
	 */
	public static void main(String[] args) {
		Game game = new Game();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		      try {		    	  
		    	  //Se ha eliminado el Look&Feel para evitar errores de aspecto
//		    	  UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//		    	  UIManager.put("Button[Disabled].backgroundPainter", new Color(165, 42, 42));
		    	  VentanaInicio vI = new VentanaInicio(game);
		    	  vI.setVisible(true); 
		      } catch (Exception e) {
		          e.printStackTrace();
		      }
		    }
		  });
	}
}

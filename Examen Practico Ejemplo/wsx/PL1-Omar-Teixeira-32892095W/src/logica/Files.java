package logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Files {
	// Método que lee un fichero y lo carga en una lista
	public static void loadFile (String nombreFicheroEntrada, List<Articulo> listaCatalogo) {
		   String linea;
		   String[] datosArticulo= null;	   
		   try {
		    	   BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
		    		while (fichero.ready()) {
		    			linea = fichero.readLine();
		    			datosArticulo = linea.split("@");
		    			listaCatalogo.add(new Articulo(datosArticulo[0],datosArticulo[1],datosArticulo[2],Float.parseFloat(datosArticulo[3]),0));
		    		}
		    		fichero.close();
		    }
		    catch (FileNotFoundException fnfe) {
		      System.out.println("El archivo no se ha encontrado.");
		    }
		    catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida.");
		    } 
		  }
}

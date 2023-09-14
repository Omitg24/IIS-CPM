package logica;

import java.io.*;
import java.util.*;

/**
 * TItulo: Clase FileUtil
 * 
 * @author Omitg
 * @version 09/10/2021
 */
public abstract class FileUtil {
	
	/**
	 * Método que carga los ficheros
	 * 
	 * @param nombreFicheroEntrada
	 * @param listaCatalogo
	 */
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
	
	/**
	 * Método que guarda los ficheros
	 * 
	 * @param nombreFicheroSalida
	 * @param listaPedido
	 */
	public static void saveToFile(String nombreFicheroSalida, List<Articulo> listaPedido, boolean enLocal ){
		try {
		        BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + nombreFicheroSalida + ".dat"));
		        String linea = listaPedido.toString();
		        if (enLocal==true) {
		        	linea = linea + "\n\n El pedido es para consumir en el local";
		        } else if (enLocal==false) {
		        	linea = linea + "\n\n El pedido es para llevar";
		        }
		        fichero.write(linea);
		        fichero.close();
			}

		catch (FileNotFoundException fnfe) {
		      System.out.println("El archivo no se ha podido guardar");
		    }
		catch (IOException ioe) {
		      new RuntimeException("Error de entrada/salida");
		}
	}
}

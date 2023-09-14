package logic;

import java.io.*;
import java.util.*;
import java.nio.file.*;

/**
 * Título: Clase FileUtil
 * Descripción: Clase FileUtil utilizada para la carga, escritura y reescritura 
 * de ficheros. 
 *
 * @author Omar Teixeira, UO281847
 * @version 27 dic. 2021
 */
public abstract class FileUtil {
	
	/**
	 * Método que carga los ficheros de los clientes
	 * 
	 * @param nombreFicheroEntrada, fichero de entrada de donde cargar
	 * @param listaCliente, lista donde cargar los clientes
	 */
	public static void loadClientFile (String nombreFicheroEntrada, List<Client> listaCliente) {		
	    String linea;
	    String[] datosCliente= null;	   
	    
	    try {
	    	   BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
	    		while (fichero.ready()) {
	    			linea = fichero.readLine();
	    			datosCliente = linea.split("@");
	    			listaCliente.add(new Client(datosCliente[0], datosCliente[1], datosCliente[2]));
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
	 * Método que carga los ficheros de los regalos
	 * 
	 * @param nombreFicheroEntrada, fichero de entrada de donde cargar
	 * @param listaRegalo, lista donde cargar los regalos
	 */
	public static void loadGiftFile (String nombreFicheroEntrada, List<Gift> listaRegalo) {		
	    String linea;
	    String[] datosRegalo= null;	   
	    
	    try {
	    	   BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
	    		while (fichero.ready()) {
	    			linea = fichero.readLine();
	    			datosRegalo = linea.split("@");
	    			listaRegalo.add(new Gift(datosRegalo[0], datosRegalo[1], datosRegalo[2], datosRegalo[3], datosRegalo[4]));
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
	 * Método que guarda los ficheros de clientes
	 * 
	 * @param nombreFicheroSalida, fichero de salida donde guardar
	 * @param listaCliente, lista del cliente a guardar
	 */
	public static void saveClientsToFile(String nombreFicheroSalida, List<Client> listaCliente) {
		try {
			String fileCliente = nombreFicheroSalida;
			Path path = Paths.get(fileCliente);
			if (!Files.exists(path.getParent())) {
				Files.createDirectory(path.getParent());
			}
			BufferedWriter fichero = new BufferedWriter(new FileWriter(fileCliente));
			for (int i=0; i < listaCliente.size(); i++) {
				if (i == listaCliente.size()-1) {
					fichero.write(listaCliente.get(i).fileToString());
				} else {
					fichero.write(listaCliente.get(i).fileToString() + "\n");
				}				
			}			
			fichero.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}
	
	/**
	 * Método que guarda los ficheros de entregas
	 * 
	 * @param nombreFicheroSalida, fichero de salida donde guardar
	 * @param listaEntrega, lista de entrega a guardar
	 */
	public static void saveDeliveriesToFile(String nombreFicheroSalida, List<String> listaEntrega) {
		try {
			String fileEntrega = nombreFicheroSalida;
			Path path = Paths.get(fileEntrega);
			if (!Files.exists(path.getParent())) {
				Files.createDirectory(path.getParent());
			}
			BufferedWriter fichero = new BufferedWriter(new FileWriter(fileEntrega, true));
			for (int i=0; i < listaEntrega.size(); i++) {
				fichero.append(listaEntrega.get(i) + "\n");			
			}			
			fichero.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}
}

package logica;

import java.io.*;
import java.util.*;

/**
 * Titulo: Clase FileUtil
 * 
 * @author Omitg
 * @version 06/12/2021
 */
public abstract class FileUtil {

	/**
	 * Carga el fichero
	 * @param nombreFicheroEntrada
	 * @param listaCatalogo
	 */
	public static void loadFile(String nombreFicheroEntrada, List<Articulo> listaCatalogo) {

		String linea;
		String[] datosArticulo = null;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosArticulo = linea.split("@");
				listaCatalogo.add(new Articulo(datosArticulo[0], datosArticulo[1], datosArticulo[2],
						Float.parseFloat(datosArticulo[3]), 0));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	/**
	 * Salva en fichero
	 * @param nombreFicheroSalida
	 * @param txPedido
	 */
	public static void saveToFile(String nombreFicheroSalida, String txPedido) {
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + nombreFicheroSalida + ".dat"));
			fichero.write(txPedido);
			fichero.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}
}

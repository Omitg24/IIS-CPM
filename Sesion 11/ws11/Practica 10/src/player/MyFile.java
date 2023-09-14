package player;

import java.io.*;

/**
 * Titulo: Clase MyFile
 * 
 * @author UO281847
 * @version 18/11/2021
 */
public class MyFile {
	/**
	 * Atributo f
	 */
	private File f;
	/**
	 * Constructor 
	 * 
	 * @param f, param
	 */
	public MyFile (File f) {
		this.f = f;
	}
	
	/**
	 * Método que devuelve el fichero
	 * @return f
	 */
	public File getF() {
		return f;
	}
	/**
	 * ToString
	 * @return cadena
	 */
	public String toString() {
		String[] name = f.getName().split(".mp3");
		return name[0].replace("_", " ");
	}
}

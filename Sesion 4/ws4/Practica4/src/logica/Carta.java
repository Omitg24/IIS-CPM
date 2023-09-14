package logica;

import java.util.*;

/**
 * Titulo: Clase Carta
 * 
 * @author Omitg
 * @version 09/10/2021
 */
public class Carta {
	/**
	 * Atributo FICHERO_ARTICULOS
	 */
	private static final String FICHERO_ARTICULOS = "files/articulos.dat";
	/**
	 * Atributo listaArticulos
	 */
	private List<Articulo> listaArticulos = null;
	
	/**
	 * Constructor Carta
	 */
	public Carta(){
		listaArticulos = new ArrayList<Articulo>();
		cargarArticulos();
	}
	
	/**
	 * Método que carga los articulos
	 */
	private void cargarArticulos(){
		FileUtil.loadFile (FICHERO_ARTICULOS, listaArticulos);
	}
	
	/**
	 * Método que devuelve los articulos
	 * 
	 * @return articulos
	 */
	public Articulo[] getArticulos(){
		Articulo[] articulos = listaArticulos.toArray(new Articulo[listaArticulos.size()]);
		return articulos;	
	}	
}

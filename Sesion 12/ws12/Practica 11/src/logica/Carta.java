package logica;

import java.util.*;

/**
 * Titulo: Clase Carta
 * 
 * @author Omitg
 * @version 06/12/2021
 */
public class Carta {
	/**
	 * Constante FICHERO_ARTICULOS
	 */
	private static final String FICHERO_ARTICULOS = "files/articulos.dat";
	
	/**
	 * Atributo listaArticulos
	 */
	private List<Articulo> listaArticulos = null;

	/**
	 * Constructor
	 */
	public Carta() {
		listaArticulos = new ArrayList<Articulo>();
		cargarArticulos();
	}

	/**
	 * Cargar articulos
	 */
	private void cargarArticulos() {
		FileUtil.loadFile(FICHERO_ARTICULOS, listaArticulos);
	}

	/**
	 * Devuelve los articulos
	 * @return articulos
	 */
	public Articulo[] getArticulos() {
		Articulo[] articulos = listaArticulos.toArray(new Articulo[listaArticulos.size()]);
		return articulos;
	}

	/**
	 * Devuelve la lista de articulos
	 * @return listaArticulos
	 */
	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}

}

package logica;

import java.util.*;

/**
 * Titulo: Clase Carta
 * 
 * @author Omitg
 * @version 14/10/2021
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
	
	/**
	 * Método que devuelve los productos pasados como parametro
	 * 
	 * @return productos
	 */
	public Articulo[] getProducto(String producto) {
		Articulo[] articulos = getArticulos(); 
		List<Articulo> productosLista = new ArrayList<Articulo>();		
		for (int i=0; i<articulos.length; i++) {
			if (articulos[i].getTipo().equals(producto)) {
				productosLista.add(articulos[i]);
			}
		}
		Articulo[] productos = productosLista.toArray(new Articulo[productosLista.size()]);
		return productos;
	}
}

package logica;

import java.util.ArrayList;
import java.util.List;

public class Producto {
	private static final String FICHERO_ARTICULOS = "files/premios.dat";
	
	private List<Articulo> listaArticulos;
	
	public Producto() {
		listaArticulos = new ArrayList<Articulo>();
		cargarArticulos();
	}

	private void cargarArticulos() {
		Files.loadFile(FICHERO_ARTICULOS, listaArticulos);
	}
	
	public Articulo[] getArticulos(){
		Articulo[] articulos = listaArticulos.toArray(new Articulo[listaArticulos.size()]);
		return articulos;	
	}
	
	public Articulo[] getArticulosFiltro(String tipo) {
		Articulo[] articulos = getArticulos();
		List<Articulo> productosLista = new ArrayList<Articulo>();
		for (int i=0; i<articulos.length; i++) {
			if (articulos[i].getTipo().equals(tipo)) {
				productosLista.add(articulos[i]);
			}
		}
		return productosLista.toArray(new Articulo[productosLista.size()]);
	}
}

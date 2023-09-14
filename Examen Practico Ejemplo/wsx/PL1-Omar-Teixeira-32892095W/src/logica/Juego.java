package logica;

import java.util.ArrayList;
import java.util.List;

public class Juego {
	
	private List<Articulo> listaPedido;
	
	private float puntos;	

	public Juego() {
		listaPedido = new ArrayList<Articulo>();
		inicializar();
	}
	
	public  void inicializar() {		
		listaPedido.clear();
		this.puntos = 0;
	}

	public void add (Articulo articuloDelCatalogo, int unidades){
		Articulo articuloEnPedido = null;
	
		for (Articulo a : listaPedido){
			if (a.getCodigo().equals(articuloDelCatalogo.getCodigo()))
				articuloEnPedido = a;
		}
		
		if (articuloEnPedido == null){
			Articulo articuloAPedido = new Articulo(articuloDelCatalogo);
			articuloAPedido.setUnidades(unidades);
			listaPedido.add(articuloAPedido);
		}
		else {
			int totalUnidades = articuloEnPedido.getUnidades() + unidades;
			articuloEnPedido.setUnidades(totalUnidades);
		}
	}
	
	public String productosToString() {
		String result = "";
		for (int i=0; i<listaPedido.size(); i++) {
			result = result + listaPedido.get(i).getDenominacion() + 
					" - " + listaPedido.get(i).getUnidades() + 
					" - " + listaPedido.get(i).getUnidades()*listaPedido.get(i).getPuntos() + " Pts."+  "\n";
		}
		return result;
	}
	
	public void lanzar() { 
		setPuntos(((int) (Math.random()*5)+1)*100);
	}
	
	public float getPuntos() {
		return puntos;
	}

	public void setPuntos(float puntos) {
		this.puntos = puntos;
	}
}

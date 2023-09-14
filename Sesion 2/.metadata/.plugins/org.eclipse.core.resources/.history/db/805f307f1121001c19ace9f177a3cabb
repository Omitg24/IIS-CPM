package logica;

import java.util.*;

public class Pedido {
	
	private List<Articulo> listaPedido;
	private String codigo;
	
	public Pedido(){
		listaPedido = new ArrayList<Articulo>();
		inicializar();
	}

	public void inicializar(){
		listaPedido.clear();
		generarCodigo();
	}
	
	public void add(Articulo articuloDelCatalogo, int unidades){
		Articulo articuloEnPedido = null;
	
		for (Articulo a : listaPedido){
			if (a.getCodigo().equals(articuloDelCatalogo.getCodigo()))
			{
				articuloEnPedido = a;
				articuloEnPedido.setUnidades(articuloEnPedido.getUnidades() + unidades);
				break;
			}
		}
		
		if (articuloEnPedido == null){
			Articulo articuloAPedido = new Articulo(articuloDelCatalogo);
			articuloAPedido.setUnidades(unidades);
			listaPedido.add(articuloAPedido);
		}
		
	}
	
	public float getTotal() {
		float precio = 0;
		for (Articulo a : listaPedido){
			precio += a.getPrecio()* a.getUnidades();
		}
		return precio;
	}
	
	public void grabarPedido(){
		FileUtil.saveToFile(codigo, listaPedido);
	  }

	public String getCodigo() {
		return codigo;
	}

	private void generarCodigo() {
		codigo = "";
		String base = "0123456789abcdefghijklmnopqrstuvwxyz";
		int longitudCodigo = 8;
		for(int i=0; i<longitudCodigo;i++){ 
			int numero = (int)(Math.random()*(base.length())); 
			codigo += base.charAt(numero);
		}
	}
}


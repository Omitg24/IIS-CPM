package logica;

import java.util.*;

/**
 * Titulo: Clase Pedido
 * 
 * @author Omitg
 * @version 09/10/2021
 */
public class Pedido {
	/**
	 * Atributo listaPedido
	 */
	private List<Articulo> listaPedido;
	/**
	 * Atributo codigo
	 */
	private String codigo;
	/**
	 * Atributo precio
	 */
	private float precio;
	
	/**
	 * Atributo descuentoAplicado
	 */
	private boolean descuentoAplicado;
	
	/**
	 * Atributo enLocal
	 */
	private boolean enLocal;
	
	/**
	 * Constructor del pedido
	 */
	public Pedido(){
		listaPedido = new ArrayList<Articulo>();
		inicializar();
	}

	/**
	 * Método que inicializa
	 */
	public void inicializar(){
		listaPedido.clear();
		setDescuentoAplicado(false);
		generarCodigo();
	}
	
	/**
	 * Método que añade articulos
	 * 
	 * @param articuloDelCatalogo
	 * @param unidades
	 */
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
	
	/**
	 * Método que elimina un articulo del pedido
	 * 
	 * @param articuloDelCatalogo, articulo a eliminar
	 * @param unidades, unidades a eliminar
	 */
	public void remove(Articulo articuloDelCatalogo, int unidades) {
		Articulo articuloEnPedido = null;
		
		for (int i=0; i<listaPedido.size();i++){
			if (listaPedido.get(i).getCodigo().equals(articuloDelCatalogo.getCodigo()))
			{
				articuloEnPedido = listaPedido.get(i);
				if (unidades==articuloEnPedido.getUnidades()) {
					listaPedido.remove(i);
					break;
				} else if (unidades>articuloEnPedido.getUnidades()) {
					listaPedido.remove(i);
					break;
				} else {
					articuloEnPedido.setUnidades(articuloEnPedido.getUnidades() - unidades);
					break;
				}				
			}
		}	
	}
	
	/**
	 * Método que calcula las uniaddes del producto
	 */
	public int unidadesProducto(Articulo arti) {		
		int uni = 0;
		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(arti.getCodigo())) {	
				uni=a.getUnidades();
			} 
		}		
		return uni;
	}
	
	/**
	 * Método que devuelve si la lista del pedido está vacía
	 * 
	 * @return true o false
	 */
	public boolean listaPedidoVacia() {
		return listaPedido.isEmpty();
	}
	
	/**
	 * Método que devuelve si el articulo está en el pedido
	 * 
	 * @param arti, articulo
	 * @return true o false
	 */
	public boolean estaEnPedido(Articulo arti) {
		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(arti.getCodigo())) {
				return true;
			}		
		}
		return false;
	}
	
	/**
	 * Método que devuelve el total
	 * 
	 * @return precio
	 */
	public float getTotal() {
		precio = 0;
		for (Articulo a : listaPedido){
			precio += a.getPrecio()* a.getUnidades();
		}
		if (precio>=50) {
			setDescuentoAplicado(true);
			precio=precio-(precio*10)/100;			
		} else {
			setDescuentoAplicado(false);
		}
		return precio;
	}
	
	/**
	 * Método que graba el pedido
	 */
	public void grabarPedido(){
		FileUtil.saveToFile(codigo, listaPedido, enLocal);
	  }
	
	/**
	 * Método que devuelve el codigo
	 * 
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Método que genera codigo
	 */
	private void generarCodigo() {
		codigo = "";
		String base = "0123456789abcdefghijklmnopqrstuvwxyz";
		int longitudCodigo = 8;
		for(int i=0; i<longitudCodigo;i++){ 
			int numero = (int)(Math.random()*(base.length())); 
			codigo += base.charAt(numero);
		}
	}
	
	/**
	 * Método que devuelve el valor del atributo descuentoAplicado
	 * 
	 * @return descuentoAplicado
	 */
	public boolean isDescuentoAplicado() {
		return descuentoAplicado;
	}
	
	/**
	 * Método que modifica el valor del atributo descuentoAplicado
	 * 
	 * @param descuentoAplicado
	 */
	private void setDescuentoAplicado(boolean descuentoAplicado) {
		this.descuentoAplicado = descuentoAplicado;
	}
	
	/**
	 * Método que modifica el valor del atributo enLocal
	 * 
	 * @param enLocal
	 */
	public void setEnLocal(boolean enLocal) {
		this.enLocal = enLocal;
	}
	
	/**
	 * Método que devuelve el toString de la lista del pedido
	 * 
	 * @return pedido
	 */
	public String toString() {
		String pedido = "";
		if (listaPedido.isEmpty()) {
			return pedido;
		}
		for (Articulo a : listaPedido) {
			pedido = pedido + a.getDenominacion() + " - " + a.getUnidades() + " uds.\n";
		}
		pedido = pedido + "\nTotal: " + String.format("%.2f",getTotal()) + "€";
		return pedido;
	}
}


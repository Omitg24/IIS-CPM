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
	 * M�todo que inicializa
	 */
	public void inicializar(){
		listaPedido.clear();
		setDescuentoAplicado(false);
		generarCodigo();
	}
	
	/**
	 * M�todo que a�ade articulos
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
	 * M�todo que elimina un articulo del pedido
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
	 * M�todo que calcula las uniaddes del producto
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
	 * M�todo que devuelve si la lista del pedido est� vac�a
	 * 
	 * @return true o false
	 */
	public boolean listaPedidoVacia() {
		return listaPedido.isEmpty();
	}
	
	/**
	 * M�todo que devuelve si el articulo est� en el pedido
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
	 * M�todo que devuelve el total
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
	 * M�todo que graba el pedido
	 */
	public void grabarPedido(){
		FileUtil.saveToFile(codigo, listaPedido, enLocal);
	  }
	
	/**
	 * M�todo que devuelve el codigo
	 * 
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * M�todo que genera codigo
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
	 * M�todo que devuelve el valor del atributo descuentoAplicado
	 * 
	 * @return descuentoAplicado
	 */
	public boolean isDescuentoAplicado() {
		return descuentoAplicado;
	}
	
	/**
	 * M�todo que modifica el valor del atributo descuentoAplicado
	 * 
	 * @param descuentoAplicado
	 */
	private void setDescuentoAplicado(boolean descuentoAplicado) {
		this.descuentoAplicado = descuentoAplicado;
	}
	
	/**
	 * M�todo que modifica el valor del atributo enLocal
	 * 
	 * @param enLocal
	 */
	public void setEnLocal(boolean enLocal) {
		this.enLocal = enLocal;
	}
	
	/**
	 * M�todo que devuelve el toString de la lista del pedido
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
		pedido = pedido + "\nTotal: " + String.format("%.2f",getTotal()) + "�";
		return pedido;
	}
}


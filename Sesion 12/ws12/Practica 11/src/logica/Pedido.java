package logica;

import java.util.*;
/**
 * Titulo: Clase Pedido
 * 
 * @author Omitg
 * @version 06/12/2021
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
	 * Titulo: Enumeracion TipoPedido
	 * 
	 * @author Omitg
	 * @version 06/12/2021
	 */
	public enum TipoPedido {LOCAL, LLEVAR, NOINDICADO};
	/**
	 * Atributo tipo
	 */
	private TipoPedido tipo;

	/**
	 * Método que devuelve el tipo
	 * @return tipo
	 */
	public TipoPedido getTipo() {
		return tipo;
	}

	/**
	 * Método que setea el tipo
	 * @param tipo
	 */
	public void setTipo(TipoPedido tipo) {
		this.tipo = tipo;
	}

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
	public void inicializar() {
		listaPedido.clear();
		generarCodigo();
		setTipo(TipoPedido.NOINDICADO);
	}

	/**
	 * Método que devuelve si esta vacío
	 * @return
	 */
	public boolean isVacio() {
		return listaPedido.size() == 0;
	}

	/**
	 * Método que añade al pedido
	 * @param articuloDelCatalogo
	 * @param unidades
	 */
	public void add(Articulo articuloDelCatalogo, int unidades) {
		Articulo articuloEnPedido = null;

		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(articuloDelCatalogo.getCodigo())) {
				articuloEnPedido = a;
				articuloEnPedido.setUnidades(articuloEnPedido.getUnidades() + unidades);
				break;
			}
		}

		if (articuloEnPedido == null) {
			Articulo articuloAPedido = new Articulo(articuloDelCatalogo);
			articuloAPedido.setUnidades(unidades);
			listaPedido.add(articuloAPedido);
		}

	}

	/**
	 * Método que elimina del pedido
	 * @param articulo
	 * @param unidades
	 */
	public void remove(Articulo articulo, int unidades) {
		Articulo articuloEnPedido = null;
		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(articulo.getCodigo()))
				articuloEnPedido = a;
		}
		if (articuloEnPedido != null) {
			int totalUnidades = articuloEnPedido.getUnidades() - unidades;
			if (totalUnidades <= 0) {
				listaPedido.remove(articuloEnPedido);
			} else
				articuloEnPedido.setUnidades(totalUnidades);
		}
	}

	/**
	 * Método que devuelve el total
	 * @return
	 */
	public float getTotal() {
		float precio = 0;
		for (Articulo a : listaPedido) {
			precio += a.getPrecio() * a.getUnidades();
		}
		return precio;
	}

	/**
	 * Método que graba el pedido
	 */
	public void grabarPedido() {
		FileUtil.saveToFile(codigo, this.toString());
	}

	/**
	 * Método que genera el codigo
	 */
	private void generarCodigo() {
		codigo = "";
		String base = "0123456789abcdefghijklmnopqrstuvwxyz";
		int longitudCodigo = 8;
		for (int i = 0; i < longitudCodigo; i++) {
			int numero = (int) (Math.random() * (base.length()));
			codigo += base.charAt(numero);
		}
	}

	/**
	 * Método que devuelve el codigo
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método que busca las unidades
	 * @param articuloSeleccionado
	 * @return unidades
	 */
	public int buscarUnidades(Articulo articuloSeleccionado) {
		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(articuloSeleccionado.getCodigo()))
				return (a.getUnidades());
		}
		return 0;
	}

	/**
	 * ToString
	 * 
	 * @return strPedido
	 */
	public String toString() {
		String strPedido = "";
		for (Articulo a : listaPedido) {
			strPedido = strPedido + a.getDenominacion() + " - " + a.getUnidades() + (" uds.") + ("\n");
		}
		strPedido = strPedido + ("Total: " + (String.format("%.2f", getTotal()))) + ("\n");
		if (!getTipo().equals(TipoPedido.NOINDICADO)) {
			strPedido = strPedido + ("Pedido para ") + ((getTipo()==TipoPedido.LLEVAR ? "llevar" : "consumir en local"));
		}
		return strPedido;
	}
}

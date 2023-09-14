package logica;

import java.util.*;

public class Pedido {

	private List<Articulo> listaPedido;
	private String codigo;
	public enum TipoPedido {LOCAL, LLEVAR, NOINDICADO};
	private TipoPedido tipo;

	public TipoPedido getTipo() {
		return tipo;
	}

	public void setTipo(TipoPedido tipo) {
		this.tipo = tipo;
	}

	public Pedido() {
		listaPedido = new ArrayList<Articulo>();
		inicializar();
	}

	public void inicializar() {
		listaPedido.clear();
		generarCodigo();
		setTipo(TipoPedido.NOINDICADO);
	}

	public boolean isVacio() {
		return listaPedido.size() == 0;
	}

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

	public float getTotal() {
		float precio = 0;
		for (Articulo a : listaPedido) {
			precio += a.getPrecio() * a.getUnidades();
		}
		return precio;
	}

	public void grabarPedido() {
		FileUtil.saveToFile(codigo, this.toString());
	}

	private void generarCodigo() {
		codigo = "";
		String base = "0123456789abcdefghijklmnopqrstuvwxyz";
		int longitudCodigo = 8;
		for (int i = 0; i < longitudCodigo; i++) {
			int numero = (int) (Math.random() * (base.length()));
			codigo += base.charAt(numero);
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public int buscarUnidades(Articulo articuloSeleccionado) {
		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(articuloSeleccionado.getCodigo()))
				return (a.getUnidades());
		}
		return 0;
	}

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

package logica;

public class Articulo {
	
	private String codigo;
	private String tipo;
	private String denominacion;
	private float precio;
	private int unidades;
	
	public Articulo(String codigo, String tipo, String denominacion, float precio, int unidades){
		this.codigo = codigo;
		this.tipo = tipo;
		this.denominacion = denominacion;
		this.precio = precio;
		this.unidades = unidades;
	}
	
	public Articulo (Articulo otroArticulo) {
        	this(otroArticulo.codigo, otroArticulo.tipo, otroArticulo.denominacion, otroArticulo.precio, otroArticulo.unidades);
    }

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String toString() {
		String strArticulo;
		strArticulo = this.tipo + " - " + this.denominacion + " - " + this.precio + " €";
		if (this.unidades!=0){
			strArticulo += " (" + this.unidades + " uds." + ")";
		}
		return strArticulo;
	   }
}

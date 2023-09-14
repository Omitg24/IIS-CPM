package logica;

/**
 * Titulo: Clase Articulo
 * 
 * @author Omitg
 * @version 06/12/2021
 */
public class Articulo {
	/**
	 * Atributo codigo
	 */
	private String codigo;
	/**
	 * Atributo tipo
	 */
	private String tipo;
	/**
	 * Atributo denominacion
	 */
	private String denominacion;
	/**
	 * Atributo precio
	 */
	private float precio;
	/**
	 * Atributo unidades 
	 */
	private int unidades;	

	/**
	 * Constructor
	 * 
	 * @param codigo
	 * @param tipo
	 * @param denominacion
	 * @param precio
	 * @param unidades
	 */
	public Articulo(String codigo, String tipo, String denominacion, float precio, int unidades) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.denominacion = denominacion;
		this.precio = precio;
		this.unidades = unidades;
	}

	/**
	 * Constructor
	 * @param otroArticulo
	 */
	public Articulo(Articulo otroArticulo) {
		this(otroArticulo.codigo, otroArticulo.tipo, otroArticulo.denominacion, otroArticulo.precio,
				otroArticulo.unidades);
	}

	/**
	 * Devuelve 
	 * @return
	 */
	public String getDenominacion() {
		return denominacion;
	}

	/**
	 * Método que setea la denominacion 
	 * @param denominacion
	 */
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	/**
	 * Devuelve el precio
	 * @return precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Método que setea el precio 
	 * @param precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Devuelve el codigo 
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Método que setea el codigo 
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Devuelve las unidades
	 * @return unidades
	 */
	public int getUnidades() {
		return unidades;
	}

	/**
	 * Método que setea las unidades 
	 * @param unidades
	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	/**
	 * Devuelve el tipo
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * ToString 
	 * @return strArticulo
	 */
	public String toString() {
		String strArticulo;
		strArticulo = this.tipo + " - " + this.denominacion + " - " + this.precio + " €";
		if (this.unidades != 0) {
			strArticulo += " (" + this.unidades + " uds." + ")";
		}
		return strArticulo;
	}
}

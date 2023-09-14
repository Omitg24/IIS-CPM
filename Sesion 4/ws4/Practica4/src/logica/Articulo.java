package logica;

/**
 * Titulo: Clase Articulo
 * 
 * @author UO281847
 * @version 09/10/2021
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
	 * Constructor del art�culo
	 * 
	 * @param codigo
	 * @param tipo
	 * @param denominacion
	 * @param precio
	 * @param unidades
	 */
	public Articulo(String codigo, String tipo, String denominacion, float precio, int unidades){
		this.codigo = codigo;
		this.tipo = tipo;
		this.denominacion = denominacion;
		this.precio = precio;
		this.unidades = unidades;
	}
	
	/**
	 * Constructor del articulo
	 * 
	 * @param otroArticulo
	 */
	public Articulo (Articulo otroArticulo) {
        	this(otroArticulo.codigo, otroArticulo.tipo, otroArticulo.denominacion, otroArticulo.precio, otroArticulo.unidades);
    }
	
	/**
	 * M�todo que devuelve el valor de denominacion
	 * 
	 * @return denominacion
	 */
	public String getDenominacion() {
		return denominacion;
	}
	
	/**
	 * M�todo que modifica el valor del atributo denominacion
	 * 
	 * @param denominacion
	 */
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
	/**
	 * M�todo que devuelve el valor de precio
	 * 
	 * @return precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * M�todo que modifica el valor del atributo precio
	 * 
	 * @param precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	/**
	 * M�todo que devuelve el valor de codigo
	 * 
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * M�todo que modifica el valor del atributo codigo
	 * 
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * M�todo que devuelve el valor de unidades
	 * 
	 * @return unidades
	 */
	public int getUnidades() {
		return unidades;
	}

	/**
	 * M�todo que modifica el valor del atributo unidades
	 * 
	 * @param unidades
	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	/**
	 * M�todo que devuelve los datos del articulo
	 */
	public String toString() {
		String strArticulo;
		strArticulo = this.tipo + " - " + this.denominacion + " - " + this.precio + " �";
		if (this.unidades!=0){
			strArticulo += " (" + this.unidades + " uds." + ")";
		}
		return strArticulo;
	   }
}

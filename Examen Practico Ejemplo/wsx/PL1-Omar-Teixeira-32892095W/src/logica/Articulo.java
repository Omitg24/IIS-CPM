package logica;

public class Articulo {
	
	private String codigo;
	private String tipo;	
	private String denominacion;
	private float puntos;
	private int unidades;
	
	public Articulo(String codigo, String tipo, String denominacion, float puntos, int unidades) {
		setCodigo(codigo);
		setTipo(tipo);
		setDenominacion(denominacion);
		setPuntos(puntos);
		setUnidades(unidades);
	}
	
	public Articulo(Articulo articuloDelCatalogo) {
		this(articuloDelCatalogo.codigo, articuloDelCatalogo.tipo, articuloDelCatalogo.denominacion, articuloDelCatalogo.puntos, articuloDelCatalogo.unidades);
	}

	// Método que redefine toString
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.tipo);
		buffer.append(" - ");
		buffer.append(this.denominacion);
		buffer.append(" - ");
		buffer.append(this.puntos);
		buffer.append(" €");
		if (this.unidades!=0){
			buffer.append(" (");
			buffer.append(this.unidades);
			buffer.append(" uds)");
			}
		return buffer.toString();
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public void setPuntos(float puntos) {
		this.puntos = puntos;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public float getPuntos() {
		return puntos;
	}

	public int getUnidades() {
		return unidades;
	}
	
}

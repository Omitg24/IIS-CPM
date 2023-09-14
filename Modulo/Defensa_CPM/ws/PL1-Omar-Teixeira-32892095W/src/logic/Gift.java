package logic;

/**
 * Titulo: Clase Gift
 * Descripción: Clase que almacena los campos de los productos que están en la aplicación
 *
 * @author Omar Teixeira, UO281847
 * @version 1 ene. 2022
 */
public class Gift {
//-- CONSTANTES ----------------------------------------------------------------
	/**
	 * Constante TRIPS
	 */
	public static final String TRIPS = "V";
//-- ATRIBUTOS -----------------------------------------------------------------
	/**
	 * Aributo id
	 */
	private String id;
	/**
	 * Atributo section
	 */
	private String section;
	/**
	 * Atributo denomination
	 */
	private String denomination;
	/**
	 * Atributo description
	 */
	private String description;
	/**
	 * Atributo points
	 */
	private String points;	
	/**
	 * Atributo units
	 */
	private int units;
	/**
	 * Atributo fecha
	 */
	private String date = "";
	/**
	 * Atributo observaciones
	 */
	private String observations;
	
	/**
	 * Constructor de la clase Gift
	 * 
	 * @param id, id del producto
	 * @param section, seccion a la que pertenece el producto
	 * @param denomination, denominación del producto
	 * @param description, descripción del producto
	 * @param points, puntos que cuesta el producto
	 */
	public Gift(String id, String section, String denomination, String description, String points) {
		this.id = id;
		this.section = section;
		this.denomination = denomination;
		this.description = description;
		this.points = points;
	}
	
	/**
	 * Constructor de la clase Gift al que se le pasa un regalo
	 * 
	 * @param gift, regalo
	 */
	public Gift(Gift gift) {
		this(gift.getId(), gift.getSection(), gift.getDenomination(), gift.getDescription(), gift.getPoints());
	}

	/**
	 * Método que devuelve el id del producto
	 * 
	 * @return id, id del producto
	 */
	public String getId() {
		return id;
	}

	/**
	 * Método que devuelve la sección del producto
	 * 
	 * @return section, seccion del producto
	 */
	public String getSection() {
		return section;
	}

	/**
	 * Método que devuelve la denominación del producto
	 * 
	 * @return denomination, denominación del producto
	 */
	public String getDenomination() {
		return denomination;
	}

	/**
	 * Método que devuelve la descripcion del producto
	 * 
	 * @return description, descripcion del producto
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Método que devuelve los puntos que cuesta el producto
	 * 
	 * @return points, puntos que cuesta el producto
	 */
	public String getPoints() {
		return points;
	}
	
	/**
	 * Método que devuelve las unidades de los regales seleccionados
	 * 
	 * @return units, unidades
	 */
	public int getUnits() {
		return units;
	}
	
	/**
	 * Método que devuelve la fecha
	 * 
	 * @return date, fecha
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Método que devuelve las observaciones
	 * 
	 * @return observations, observaciones
	 */
	public String getObservations() {
		return observations;
	}
	
	/**
	 * Método que añade las unidades a las anteriores
	 * 
	 * @param value, valor a añadir
	 */
	public void setSummaryUnits(int value) {
		this.units = units + value;
	}
	
	/**
	 * Método que setea las unidades
	 * 
	 * @param units, unidades
	 */
	public void setUnits(int units) {
		this.units = units;
	}
	
	/**
	 * Método que setea la fecha
	 * 
	 * @param date, fecha
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * Método que setea las observaciones
	 * 
	 * @param observations, observaciones
	 */
	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	/**
	 * Método que devuelve el toString del producto
	 * 
	 * @return strGift, toString del producto
	 */
	public String toString() {
		String strGift = getUnits() + " -> " + getDenomination() + " - (" + pointsToString() + ")";
		if (getSection().equals(TRIPS)) {
			strGift += " - (" +  getDate() + ")";			
		}		
		return strGift;
	}
	
	/**
	 * Método que devuelve el toString utilizado para guardar en el fichero
	 * 
	 * @return fileStrGift, toString utilizado para guardar en el fichero
	 */
	public String fileToString() {
		String fileStrGift = "";
		if (getSection().equals(TRIPS)) {
			if (getObservations().equals(null) || getObservations().equals("")) {
				fileStrGift = getId() + "@" + getDate();
			} else {
				fileStrGift = getId() + "@" + getDate() + "@" + getObservations();
			}			
		} else {
			fileStrGift = getId();
		}
		return fileStrGift;
	}
	
	/**
	 * Método que devuelve el toString de la info del producto
	 * 
	 * @return infoStrGift, toString de la info del producto
	 */
	public String infoToString() {		
		String infoStrGift = getDenomination() + " - (" + getPoints() + " pts.)" + "\n\n" + getDescription();
		return infoStrGift;
	}

	/**
	 * Método que devuelve el toString de los puntos
	 * 
	 * @return pointsToString, puntos toString
	 */
	public String pointsToString() {
		return getPoints() + " pts.";
	}	
}

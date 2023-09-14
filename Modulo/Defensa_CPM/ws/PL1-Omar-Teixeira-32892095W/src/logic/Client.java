package logic;

/**
 * Título: Clase Client
 * Descripción: Clase que almacena los campos de los clientes que usarán la aplicación
 *
 * @author Omar Teixeira, UO281847
 * @version 27 dic. 2021
 */
public class Client {
//-- Atributos -----------------------------------------------------------------
	/**
	 * Atributo id
	 */
	private String id;
	/**
	 * Atributo fullName
	 */
	private String fullName;
	/**
	 * Atributo canPlay
	 */
	private String canPlay;
	
	/**
	 * Constructor de la clase Client
	 * 
	 * @param id, id del cliente
	 * @param fullName, nombre completo del cliente
	 * @param canPlay, valor sobre si puede jugar el cliente
	 */
	public Client(String id, String fullName, String canPlay) {
		setId(id);
		setFullName(fullName);
		setCanPlay(canPlay);
	}

	/**
	 * Método que devuelve el id
	 * 
	 * @return id, id del cliente
	 */
	public String getId() {
		return id;
	}

	/**
	 * Método que devuelve el nombre completo del cliente
	 * 
	 * @return fullName, nombre completo del cliente
	 */
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * Método que devuelve el valor sobre si puede jugar el cliente
	 * 
	 * @return canPlay, valor sobre si puede jugar el cliente
	 */
	public String canPlay() {
		return canPlay;
	}
	
	/**
	 * Método que setea el id del cliente
	 * 
	 * @param id, id del cliente
	 */
	private void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Método que setea el nombre completo del cliente
	 * 
	 * @param fullName, nombre completo del cliente
	 */
	private void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * Método que setea si el cliente puede jugar 
	 * (se cambia a boolean para un uso más claro)
	 * 
	 * @param canPlay, valor sobre si puede jugar el cliente
	 */
	public void setCanPlay(String canPlay) {
		this.canPlay=canPlay;
	}
	
	/**
	 * Método que devuelve el toString del cliente
	 * 
	 * @return strClient, toString del cliente
	 */
	public String toString() {
		String strClient = getFullName() + " - (" + getId() + ")"; 
		return strClient;
	}
	
	/**
	 * Método que devuelve el toString utilizado para guardar en el fichero
	 * 
	 * @return fileStrClient, toString utilizado para guardar en el fichero
	 */
	public String fileToString() {
		String fileStrClient = getId() + "@" + getFullName() + "@" + canPlay();
		return fileStrClient;
	}
}

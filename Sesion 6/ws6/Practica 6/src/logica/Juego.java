package logica;

/**
 * Título: Clase Juego
 * 
 * @author UO2181847
 * @version 21/10/2021
 */
public class Juego {	
	/**
	 * Constante maxDisparos
	 */
	public static final int maxDisparos = 4;
	/**
	 * Atributo puntos
	 */
	int puntos;
	/**
	 * Atributo disparos
	 */
	int disparos;
	/**
	 * Atributo tablero
	 */
	private Tablero tablero;
	/**
	 * Atributo invasorEncontrado
	 */
	private boolean invasorEncontrado;
	/**
	 * Atributo meteoritoEncontrado
	 */
	private boolean meteoritoEncontrado;
	
	/**
	 * Constructor del juego
	 */
	public Juego(){
		inicializarJuego();
	}
	
	/**
	 * Método que devuelve el valor del atributo invasorEncontrado
	 * 
	 * @return invasorEncontrado
	 */
	public boolean isInvasorEncontrado() {
		return invasorEncontrado;
	}

	/**
	 * Método que devuelve el valor del atributo meteoritoEncontrado
	 * 
	 * @return meteoritoEncontrado
	 */
	public boolean isMeteoritoEncontrado() {
		return meteoritoEncontrado;
	}
	
	/**
	 * Método que inicializa el juego
	 */
	public void inicializarJuego(){
		tablero = new Tablero();
		puntos = 1000;
		disparos = 0;
		invasorEncontrado = false;
		meteoritoEncontrado = false;
	}

	/**
	 * Método que devuelve el tablero
	 * 
	 * @return tablero
	 */
	public Tablero getTablero() {
		return tablero;
	}
	
	/**
	 * Método que dispara
	 * 
	 * @param i, disparos
	 */
	public void dispara(int i){
		disparos --;
		if (tablero.getCasillas()[i] instanceof Invasor) {
			invasorEncontrado = true;
		} else if (tablero.getCasillas()[i] instanceof Meteorito) {
			meteoritoEncontrado = true;
			puntos = 0;
		} 
		puntos += tablero.getCasillas()[i].getPuntos();
	}
	
	/**
	 * Método que devuelve si la partida ha acabado
	 * 
	 * @return true o false
	 */
	public boolean isPartidaFinalizada() {
		return (invasorEncontrado || meteoritoEncontrado || disparos == 0);
	}

	/**
	 * Método que devuelve los puntos
	 * 
	 * @return puntos
	 */
	public int getPuntos() {
		return puntos;
	}

	/**
	 * Método que lanza el dado y calcula los disparos
	 */
	public void lanzar() {
		setDisparos(Dado.lanzar());	
	}
	
	/**
	 * Método que devuelve los disparos
	 * 
	 * @return disparos
	 */
	public int getDisparos() {
		return disparos;
	}
	
	/**
	 * Método que modifica el valor de los disparos
	 * 
	 * @param disparos
	 */
	private void setDisparos(int disparos) {
		this.disparos = disparos;
	}
}

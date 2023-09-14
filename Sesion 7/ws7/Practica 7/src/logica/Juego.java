package logica;

import logica.casillas.Invasor;
import logica.casillas.Meteorito;

/**
 * T�tulo: Clase Juego
 * 
 * @author UO2181847
 * @version 28/10/2021
 */
public class Juego {	
	/**
	 * Atributo puntos
	 */
	int puntos;
	/**
	 * Atributo disparos
	 */
	int disparos;
	/**
	 * Atributo dim
	 */
	private int dim;
	/**
	 * Atributo nInvasores
	 */
	private int nInvasores;
	/**
	 * Atributo nMeteoritos
	 */
	private int nMeteoritos;
	/**
	 * Atributo maxDisparos
	 */
	private int maxDisparos;
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
	 * Atributo nivel
	 */
	private Nivel nivel;

	/**
	 * Enumeraci�n Nivel
	 * 
	 * @author UO281847
	 * @version 28/10/2021
	 */
	public enum Nivel {
		FACIL,
		INTERMEDIO,
		DIFICIL
	};

	/**
	 * Constructor del juego
	 */
	public Juego() {
		inicializarJuego(Nivel.INTERMEDIO);
	}
	
	/**
	 * M�todo que devuelve el valor del atributo invasorEncontrado
	 * 
	 * @return invasorEncontrado
	 */
	public boolean isInvasorEncontrado() {
		return invasorEncontrado;
	}

	/**
	 * M�todo que devuelve el valor del atributo meteoritoEncontrado
	 * 
	 * @return meteoritoEncontrado
	 */
	public boolean isMeteoritoEncontrado() {
		return meteoritoEncontrado;
	}
	
	/**
	 * M�todo que inicializa el juego
	 */
	public void inicializarJuego(Nivel nivel) {
		this.nivel = nivel;
		puntos = 1000;
		disparos = 0;
		invasorEncontrado = false;
		meteoritoEncontrado = false;
		System.out.println("nivel = " + nivel);
		switch (nivel) {
			case FACIL: {
				setParametros(10, 2, 0, 5);
				break;
			} case INTERMEDIO: {
				setParametros(8, 1, 1, 4);
				break;
			} case DIFICIL: {
				setParametros(6, 1, 2, 3);
				break;
			}
		}
		tablero = new Tablero(dim, nInvasores, nMeteoritos);
	}

	/**
	 * M�todo que setea los parametros
	 * 
	 * @param dim
	 * @param nInvasores
	 * @param nMeteoritos
	 * @param maxDisparos
	 */
	private void setParametros(int dim, int nInvasores, int nMeteoritos, int maxDisparos) {
		this.dim = dim;
		this.nInvasores = nInvasores;
		this.nMeteoritos = nMeteoritos;
		this.maxDisparos = maxDisparos;
	}
	
	/**
	 * M�todo que devuelve el nivel
	 * 
	 * @return nivel
	 */
	public Nivel getNivel() {
		return nivel;
	}

	/**
	 * M�todo que setea el nivel
	 * 
	 * @param nivel
	 */
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	/**
	 * M�todo que devuelve la dimension
	 * 
	 * @return dim
	 */
	public int getDim() {
		return dim;
	}
	
	/**
	 * M�todo que setea la dimension
	 * 
	 * @param dim
	 */
	public void setDim(int dim) {
		this.dim = dim;
	}

	
	/**
	 * M�todo que devuelve el tablero
	 * 
	 * @return tablero
	 */
	public Tablero getTablero() {
		return tablero;
	}
	
	/**
	 * M�todo que dispara
	 * 
	 * @param i, disparos
	 */
	public void dispara(int i){
		disparos--;
		if (tablero.getCasillas()[i] instanceof Invasor)
			invasorEncontrado = true;
		else if (tablero.getCasillas()[i] instanceof Meteorito) {
			meteoritoEncontrado = true;
			tablero.getCasillas()[i].setPuntos(puntos * tablero.getCasillas()[i].getPuntos());
		}
		puntos += tablero.getCasillas()[i].getPuntos();
	}
	
	/**
	 * M�todo que devuelve si la partida ha acabado
	 * 
	 * @return true o false
	 */
	public boolean isPartidaFinalizada() {
		return (invasorEncontrado || meteoritoEncontrado || disparos == 0);
	}

	/**
	 * M�todo que devuelve los puntos
	 * 
	 * @return puntos
	 */
	public int getPuntos() {
		return puntos;
	}

	/**
	 * M�todo que lanza el dado y calcula los disparos
	 */
	public void lanzar() {
		setDisparos(Dado.lanzar(maxDisparos));	
	}
	
	/**
	 * M�todo que devuelve los disparos
	 * 
	 * @return disparos
	 */
	public int getDisparos() {
		return disparos;
	}

	/**
	 * M�todo que setea los disparos
	 * 
	 * @param disparos
	 */
	private void setDisparos(int disparos) {
		this.disparos = disparos;
	}
}

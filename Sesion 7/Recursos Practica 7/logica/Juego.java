package logica;

public class Juego {
	int puntos;
	int disparos;
	private int dim;
	private int nInvasores;
	private int nMeteoritos;
	private int maxDisparos;
	private Tablero tablero;
	private boolean invasorEncontrado;
	private boolean meteoritoEncontrado;

	public enum Nivel {
		INTERMEDIO
	};

	private Nivel nivel;

	public Tablero getTablero() {
		return tablero;
	}

	public Juego() {
		inicializarJuego(Nivel.INTERMEDIO);
	}

	public void inicializarJuego(Nivel nivel) {
		this.nivel = nivel;
		puntos = 1000;
		disparos = 0;
		invasorEncontrado = false;
		meteoritoEncontrado = false;
		System.out.println("nivel = " + nivel);
		switch (nivel) {
		case INTERMEDIO: {
			setParametros(8, 1, 1, 4);
			break;
		}
		}
		tablero = new Tablero(dim, nInvasores, nMeteoritos);
	}

	private void setParametros(int dim, int nInvasores, int nMeteoritos, int maxDisparos) {
		this.dim = dim;
		this.nInvasores = nInvasores;
		this.nMeteoritos = nMeteoritos;
		this.maxDisparos = maxDisparos;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public int getDim() {
		return dim;
	}

	public void setDim(int dim) {
		this.dim = dim;
	}

	public void dispara(int i) {
		disparos--;
		if (tablero.getCasillas()[i] instanceof Invasor)
			invasorEncontrado = true;
		else if (tablero.getCasillas()[i] instanceof Meteorito) {
			meteoritoEncontrado = true;
			tablero.getCasillas()[i].setPuntos(puntos * tablero.getCasillas()[i].getPuntos());
		}
		puntos += tablero.getCasillas()[i].getPuntos();
	}

	public boolean isPartidaFinalizada() {
		return (invasorEncontrado || disparos == 0 || meteoritoEncontrado);
	}

	public int getPuntos() {
		return puntos;
	}

	public void lanzar() {
		setDisparos(Dado.lanzar(maxDisparos));
	}

	public int getDisparos() {
		return disparos;
	}

	private void setDisparos(int disparos) {
		this.disparos = disparos;
	}

	public boolean isInvasorEncontrado() {
		return invasorEncontrado;
	}

	public void setInvasorEncontrado(boolean invasorEncontrado) {
		this.invasorEncontrado = invasorEncontrado;
	}

	public boolean isMeteoritoEncontrado() {
		return meteoritoEncontrado;
	}

	public void setMeteoritoEncontrado(boolean meteoritoEncontrado) {
		this.meteoritoEncontrado = meteoritoEncontrado;
	}
}

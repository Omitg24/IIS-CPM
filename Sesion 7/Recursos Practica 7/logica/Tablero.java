package logica;

public class Tablero {
	Casilla[] casillas;
	private int dim;
	private int nInvasores;
	private int nMeteoritos;

	public Tablero(int dim, int nInvasores, int nMeteoritos) {
		this.dim = dim;
		this.nInvasores = nInvasores;
		this.nMeteoritos = nMeteoritos;
		casillas = new Casilla[dim];
		for (int i = 0; i < dim; i++) {
			casillas[i] = new Espacio();
		}
		colocarInvasores();
		colocarMeteoritos();
	}

	private void colocarInvasores() {
		int posicionInvasor;
		for (int i = 0; i < nInvasores; i++) {
			do {
				posicionInvasor = (int) (Math.random() * dim);
			} while (!hayEspacio(posicionInvasor));
			casillas[posicionInvasor] = new Invasor();
			System.out.println("Invasor en " + posicionInvasor);
		}
	}

	private void colocarMeteoritos() {
		int posicionMeteorito;
		for (int i = 0; i < nMeteoritos; i++) {
			do {
				posicionMeteorito = (int) (Math.random() * dim);
			} 
			while (!hayEspacio(posicionMeteorito));
			casillas[posicionMeteorito] = new Meteorito();
			System.out.println("Meteorito en " + posicionMeteorito);
		}
	}

	private boolean hayEspacio(int i) {
		if (getCasillas()[i] instanceof Espacio)
			return true;
		return false;
	}

	public Casilla[] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[] casillas) {
		this.casillas = casillas;
	}
}

package logica;

public class Tablero {
	
	public static final int DIM = 8;
	Casilla[] casillas;
	
	public Tablero() {
		casillas = new Casilla[DIM];
		for (int i=0;i<DIM;i++)
			casillas[i] = new Espacio();
		colocaInvasor();
	}

	private void colocaInvasor() {
		int posicionInvasor = (int) (Math.random() * DIM);
		System.out.println("Invasor en: "+ posicionInvasor);
		casillas[posicionInvasor] = new Invasor();	
	}

	public Casilla[] getCasillas() {
		return casillas;
	}
}

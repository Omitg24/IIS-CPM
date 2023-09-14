package logica;

public class Dado {
	
	public static int lanzar (int maxDisparos)
	{ 
		return ((int) (Math.random() * maxDisparos) + 1);
	}


}

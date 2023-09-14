package player;

import java.io.File;

import javazoom.jlgui.basicplayer.*;

/**
 * Titulo: Clase MusicPlayer
 * 
 * @author UO281847
 * @version 07/11/2021
 */
public class MusicPlayer {
	/**
	 * Atributo basicPlayer
	 */
	private BasicPlayer basicPlayer = null;
	
	/**
	 * Constructor
	 */
	public MusicPlayer(){
		basicPlayer = new BasicPlayer();
	}
	
	/**
	 * Método que reproduce
	 * @param file, archivo
	 */
	public void play (File file){
		try {
			basicPlayer.open(file);
			basicPlayer.play();
		}
		catch (Exception e){}
	}
	
	/**
	 * Método que para
	 */
	public void stop(){
		try {
			basicPlayer.stop();
		}
		catch (BasicPlayerException e){
		}
	}
	
	/**
	 * Método que setea el volumen
	 * @param vol, volumen
	 * @param volMax, volumen máximo
	 */
	public void setVolume(double vol, double volMax){
		try{			
			basicPlayer.setGain(vol/volMax);
		}
		catch (BasicPlayerException e){
		}
	}
}

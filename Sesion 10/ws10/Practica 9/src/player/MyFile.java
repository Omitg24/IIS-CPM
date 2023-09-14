package player;

import java.io.*;

public class MyFile {
	private File f;
	
	public MyFile (File f) {
		this.f = f;
	}
	
	public File getF() {
		return f;
	}
	
	public String toString() {
		String[] name = f.getName().split(".mp3");
		return name[0].replace("_", " ");
	}
}

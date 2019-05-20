package model;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Tiles {

	private int wartosc; // trzymana w potêdze liczby 2
	private boolean zmiana;
	private boolean zajeta;
	private BufferedImage obraz;
	
	
	public Tiles() {  // tworzy now¹ p³ytkê
		this.wartosc = 0;
		zmiana = false;
	}
	
	public void setPlaceImage(int x,int y) {
		
	}
	
	public void setImage(BufferedImage o) {
		this.obraz = o;
	}
	
	public BufferedImage getImage() {
		return this.obraz;
	}
	
	public int getWartosc() {  // zwraca wartosc
		return this.wartosc;
	}
	
	public void Update() {   // zwiêksza potêge o 1, => podwaja wartoœæ
		this.wartosc++; 
		zmiana = true;
	}
	
	public void Nothing() {
		zmiana = false;
	}
	
	public void Back() {
		if(zmiana) this.wartosc--;
	}
	
	public boolean Losuj() {
		
		if(wartosc == 0 ) {
		Random r = new Random();
		int x = r.nextInt(100);
		if(x>80) wartosc = 2; else wartosc = 1;
		return true;
		}
		else
		return false;
		
	}
	
	public boolean czy_zmiana() {
		return zmiana;
	}
	
	public void zajmij() {
		this.zajeta = true;
	}
	
	public void reset() {
		this.zajeta = false;
	}
	
	public boolean stan() {
		return zajeta;
	}
	
}

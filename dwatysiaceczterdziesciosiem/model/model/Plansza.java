package model;

import java.util.Random;

public class Plansza {

	private Tiles[][] tiles = new Tiles[4][4];
	private boolean[][] zmiana = new boolean[4][4];
	private boolean[] wiersz = new boolean[4];
	private boolean koniec;
	
	public Plansza () {
		
		for(int a=0;a<4;a++)
			for(int b=0;b<4;b++)
				tiles[a][b] = new Tiles();
		
		start();
		reset();
	}
	
	public void wypisz() {
		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		for(int a=0;a<4;a++) {
			for(int b=0;b<4;b++){
				System.out.print(tiles[b][a].getWartosc() + "  |  ");
				
				}
		System.out.println();
		}
			
	}
	
	public void reset() {
		
		for(int a=0;a<4;a++)
			for(int b=0;b<4;b++)
				zmiana[a][b] = false;
	}
	
	public void restart() {
		for(int a=0;a<4;a++)
			for(int b=0;b<4;b++)
				tiles[a][b] = new Tiles();
		
		start();
		reset();
	}
	
	public Tiles plytka(int x,int y) {
		return tiles[x][y];
	}
	
	public void nowa() {
		Random r = new Random();
		int x = r.nextInt(4);
		int y= r.nextInt(4);
		
		while(!tiles[x][y].Losuj()) {
			x= r.nextInt(4);
			y = r.nextInt(4);
		}
		
	}
	
	private void czy_koniec() {
		
		koniec = true;
		
		for(int a=0;a<4;a++) {
			for(int b=0;b<4;b++) {
				if(tiles[a][b].getWartosc() == 0) { koniec = false; break; }
			}
			if(!koniec) break;
		}
		
		
		if(!koniec) nowa(); else { System.out.println("KONIEC !!!!");  wypisz(); }
		
	}
	
	public boolean getKoniec() {
		return koniec;
	}
	
	public void start() {
		
		koniec = false;
		nowa();
		nowa();
		
		
	}
	
	public void ruch_w_dol() {
		przesun_w_dol();
		przesun_w_dol();
		przesun_w_dol();
		przesun_w_dol();
		dodaj_w_dol();
		przesun_w_dol();
		czy_koniec();
	}
	
	public void ruch_w_gore() {
		przesun_w_gore();
		przesun_w_gore();
		przesun_w_gore();
		przesun_w_gore();
		dodaj_w_gore();
		przesun_w_gore();
		czy_koniec();
	}
	
	public void ruch_w_lewo() {
		przesun_w_lewo();
		przesun_w_lewo();
		przesun_w_lewo();
		przesun_w_lewo();
		dodaj_w_lewo();
		przesun_w_lewo();
		czy_koniec();
	}
	
	public void ruch_w_prawo() {
		przesun_w_prawo();
		przesun_w_prawo();
		przesun_w_prawo();
		przesun_w_prawo();
		dodaj_w_prawo();
		przesun_w_prawo();
		czy_koniec();
	}
	
	
	public void przesun_w_dol() {
		
		for(int a=0;a<4;a++) { 
			
			for(int b=0;b<4;b++) {
				if(tiles[a][b].getWartosc() != 0) wiersz[b] = true; else wiersz[b] = false;
			}
			
			for(int b=3;b>0;b--) {
				if(!wiersz[b]) { tiles[a][b] = tiles[a][b-1]; tiles[a][b-1] = new Tiles(); wiersz[b-1]=false; }
			}
			
		}
	}
	
	public void dodaj_w_dol() {
		
		for(int a=0;a<4;a++) { 
			
			for(int b=3;b>0;b--) {
				if(tiles[a][b].getWartosc() == tiles[a][b-1].getWartosc() && tiles[a][b].getWartosc()!=0) { tiles[a][b].Update(); tiles[a][b-1] = new Tiles();}
			}
			
		}
		
	}
	
	public void przesun_w_gore() {
		
		for(int a=0;a<4;a++) { 
			
			for(int b=0;b<4;b++) {
				if(tiles[a][b].getWartosc() != 0) wiersz[b] = true; else wiersz[b] = false;
			}
			
			for(int b=0;b<3;b++) {
				if(!wiersz[b]) { tiles[a][b] = tiles[a][b+1]; tiles[a][b+1] = new Tiles(); wiersz[b+1]=false; }
			}
			
		}
	}
	
	public void dodaj_w_gore() {
		
		for(int a=0;a<4;a++) { 
			
			for(int b=0;b<3;b++) {
				if(tiles[a][b].getWartosc() == tiles[a][b+1].getWartosc() && tiles[a][b].getWartosc()!=0) { tiles[a][b].Update(); tiles[a][b+1] = new Tiles();}
			}
			
		}
		
	}
	
	public void przesun_w_lewo() {
		
		for(int b=0;b<4;b++) { 
			
			for(int a=0;a<4;a++) {
				if(tiles[a][b].getWartosc() != 0) wiersz[a] = true; else wiersz[a] = false;
			}
			
			for(int a=0;a<3;a++) {
				if(!wiersz[a]) { tiles[a][b] = tiles[a+1][b]; tiles[a+1][b] = new Tiles(); wiersz[a+1]=false; }
			}
			
		}
	}
	
	public void dodaj_w_lewo() {
		
		for(int b=0;b<4;b++) { 
			
			for(int a=0;a<3;a++) {
				if(tiles[a][b].getWartosc() == tiles[a+1][b].getWartosc() && tiles[a][b].getWartosc()!=0) { tiles[a][b].Update(); tiles[a+1][b] = new Tiles();}
			}
			
		}
		
	}
	
	public void przesun_w_prawo() {
		
		for(int b=0;b<4;b++) { 
			
			for(int a=0;a<4;a++) {
				if(tiles[a][b].getWartosc() != 0) wiersz[a] = true; else wiersz[a] = false;
			}
			
			for(int a=3;a>0;a--) {
				if(!wiersz[a]) { tiles[a][b] = tiles[a-1][b]; tiles[a-1][b] = new Tiles(); wiersz[a-1]=false; }
			}
			
		}
	}
	
	public void dodaj_w_prawo() {
		
		for(int b=0;b<4;b++) { 
			
			for(int a=3;a>0;a--) {
				if(tiles[a][b].getWartosc() == tiles[a-1][b].getWartosc() && tiles[a][b].getWartosc()!=0) { tiles[a][b].Update(); tiles[a-1][b] = new Tiles();}
			}
			
		}
		
	}
	
}

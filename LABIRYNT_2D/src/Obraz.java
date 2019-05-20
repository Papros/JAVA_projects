
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Obraz extends JPanel{

	private static final long serialVersionUID = 1L;
	private BufferedImage[] cell_text = new BufferedImage[17];
	private BufferedImage gracz_t;
	private BufferedImage wizja,darknes,gate;
	private boolean[][] sciezka;
	private int zasieg = 2;
	private Labirynt maze;
	private Random generator = new Random();
	private Gracz gracz;
	private int szer,wys;
	private boolean tryb_hard = true; //true;
	private int[][] cells; 
	
	
	public Obraz(){
			
	
	maze = new Labirynt(40,40); // 93,45 max wyswietlenie na ekranie
	szer = maze.getSize_x();
	wys = maze.getSize_y();
	gracz = new Gracz(1,wys);
	cells = new int[szer+2][wys+2];
	ubierz(maze);
	this.wczytaj();
	
	setPreferredSize(new Dimension( (szer+2)*20, (wys+2)*20) );
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		
		
		if(tryb_hard){ //tryb z ograniczon¹ widocznosci¹ 
			
			int x = gracz.getPoz_x();
			int y = gracz.getPoz_y();
			
		for(int a=0;a<szer+zasieg;a++)
			for(int b=0;b<wys+zasieg;b++){
				g2d.drawImage(darknes, 20*a, 20*b, this);	
				}	
			
			
		for(int a=x-2;a<x+2;a++)
			for(int b=y-2;b<y+2;b++){
				if(a>=0 && a<=maze.getSize_x() && b>=0 && b<=maze.getSize_y())
					g2d.drawImage(cell_text[cells[a][b]], 20*a, 20*b, this);
		}
				
		g2d.drawImage(wizja,gracz.getPoz_x()*20-45, gracz.getPoz_y()*20-45, this);
		g2d.drawImage(gracz_t, gracz.getPoz_x()*20+5 , gracz.getPoz_y()*20+5, this);
					
		for(int a=0;a<maze.getSize_y()+2;a++){
		g2d.drawImage(cell_text[cells[0][a]], 0,20*a, this);                 
		g2d.drawImage(cell_text[cells[maze.getSize_x()+1][a]],20*(maze.getSize_x()+1),20*a,this);
				        }
					 
		for(int a=0;a<maze.getSize_x()+2;a++){
		g2d.drawImage(cell_text[cells[a][0]], 20*a, 0, this);                 
		g2d.drawImage(cell_text[cells[a][maze.getSize_y()+1]],20*a, 20*(maze.getSize_y()+1), this);
				        }
		g2d.drawImage(gate,maze.getSize_x()*20,0,this);
		
		}
		else{
			
			
			
			for(int a=0;a<szer+2;a++)
				for(int b=0;b<wys+2;b++){
				g2d.drawImage(cell_text[cells[a][b]], 20*a, 20*b, this);	
				}
			
			g2d.drawImage(gracz_t, gracz.getPoz_x()*20+5 , gracz.getPoz_y()*20+5, this);
			g2d.drawImage(gate,maze.getSize_x()*20,0,this);
		}
		
	
	}
	
	public int GetSzOkna(){
		return (szer+2)*20;		
	}
	
	public int GetWysOkna(){
		return (wys+2)*20;		
	}
	
	
	private void wczytaj(){
		try {	
			cell_text[0] = ImageIO.read(Obraz.class.getResource("/image/cell_0.png"));
			cell_text[1] = ImageIO.read(Obraz.class.getResource("/image/cell_1.png"));
			cell_text[2] = ImageIO.read(Obraz.class.getResource("/image/cell_2.png"));
			cell_text[3] = ImageIO.read(Obraz.class.getResource("/image/cell_3.png"));
			cell_text[4] = ImageIO.read(Obraz.class.getResource("/image/cell_4.png"));
			cell_text[5] = ImageIO.read(Obraz.class.getResource("/image/cell_12.png"));
			cell_text[6] = ImageIO.read(Obraz.class.getResource("/image/cell_13.png"));
			cell_text[7] = ImageIO.read(Obraz.class.getResource("/image/cell_14.png"));
			cell_text[8] = ImageIO.read(Obraz.class.getResource("/image/cell_23.png"));
			cell_text[9] = ImageIO.read(Obraz.class.getResource("/image/cell_24.png"));
			cell_text[10] = ImageIO.read(Obraz.class.getResource("/image/cell_34.png"));
			cell_text[11] = ImageIO.read(Obraz.class.getResource("/image/cell_123.png"));
			cell_text[12] = ImageIO.read(Obraz.class.getResource("/image/cell_124.png"));
			cell_text[13] = ImageIO.read(Obraz.class.getResource("/image/cell_134.png"));
			cell_text[14] = ImageIO.read(Obraz.class.getResource("/image/cell_234.png"));
			cell_text[15] = ImageIO.read(Obraz.class.getResource("/image/cell_1234.png"));
			cell_text[16] = ImageIO.read(Obraz.class.getResource("/image/cell_brick.png"));
			gracz_t = ImageIO.read(Obraz.class.getResource("/image/gracz.png"));
			wizja = ImageIO.read(Obraz.class.getResource("/image/wizja.png"));
			darknes = ImageIO.read(Obraz.class.getResource("/image/darknes.png"));			
			gate = ImageIO.read(Obraz.class.getResource("/image/cell_brick_gate.png"));
			
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		
		
		
		
	}
	
	 public void ubierz(Labirynt maze){
		
	
	    for(int a=1;a<maze.getSize_x()+1;a++)
	        for(int b=1;b<maze.getSize_y()+1;b++)
	        {

	        if(!maze.getCell(a,b,0) && !maze.getCell(a,b,1) && !maze.getCell(a,b,2) && !maze.getCell(a,b,3))
	            cells[a][b] = 0;
	            else
	        if(maze.getCell(a,b,0) && !maze.getCell(a,b,1) && !maze.getCell(a,b,2) && !maze.getCell(a,b,3))
	            cells[a][b] = 1;
	            else
	        if(!maze.getCell(a,b,0) && maze.getCell(a,b,1)&& !maze.getCell(a,b,2) && !maze.getCell(a,b,3))
	            cells[a][b] = 2;
	            else
	        if(!maze.getCell(a,b,0) && !maze.getCell(a,b,1) && maze.getCell(a,b,2) && !maze.getCell(a,b,3))
	            cells[a][b] = 3;
	            else
	        if(!maze.getCell(a,b,0) && !maze.getCell(a,b,1) && !maze.getCell(a,b,2) && maze.getCell(a,b,3))
	            cells[a][b] = 4;
	            else
	        if(maze.getCell(a,b,0) && maze.getCell(a,b,1) && !maze.getCell(a,b,2) && !maze.getCell(a,b,3))
	            cells[a][b] = 5;
	            else
	        if(maze.getCell(a,b,0) && !maze.getCell(a,b,1) && maze.getCell(a,b,2) && !maze.getCell(a,b,3))
	            cells[a][b] = 6;
	            else
	        if(maze.getCell(a,b,0) && !maze.getCell(a,b,1) && !maze.getCell(a,b,2) && maze.getCell(a,b,3))
	            cells[a][b] = 7;
	            else
	        if(!maze.getCell(a,b,0) && maze.getCell(a,b,1) && maze.getCell(a,b,2) && !maze.getCell(a,b,3))
	            cells[a][b] = 8;
	            else
	        if(!maze.getCell(a,b,0) && maze.getCell(a,b,1) && !maze.getCell(a,b,2) && maze.getCell(a,b,3))
	            cells[a][b] = 9;
	            else
	        if(!maze.getCell(a,b,0) && !maze.getCell(a,b,1) && maze.getCell(a,b,2) && maze.getCell(a,b,3))
	            cells[a][b] = 10;
	            else
	        if(maze.getCell(a,b,0) && maze.getCell(a,b,1) && maze.getCell(a,b,2) && !maze.getCell(a,b,3))
	            cells[a][b] = 11;
	            else
	        if(maze.getCell(a,b,0) && maze.getCell(a,b,1) && !maze.getCell(a,b,2) && maze.getCell(a,b,3))
	            cells[a][b] = 12;
	            else
	        if(maze.getCell(a,b,0) && !maze.getCell(a,b,1) && maze.getCell(a,b,2) && maze.getCell(a,b,3))
	            cells[a][b] = 13;
	            else
	        if(!maze.getCell(a,b,0) && maze.getCell(a,b,1) && maze.getCell(a,b,2) && maze.getCell(a,b,3))
	            cells[a][b] = 14;
	            else
	        if(maze.getCell(a,b,0) && maze.getCell(a,b,1) && maze.getCell(a,b,2) && maze.getCell(a,b,3))
	            cells[a][b] = 15;
	        	else
	        	cells[a][b] = 15;

	        }
	    
	    for(int a=0;a<maze.getSize_y()+2;a++)
        {
            cells[0][a] = 16;                   
            cells[maze.getSize_x()+1][a] = 16;
        }
	    
	    for(int a=0;a<maze.getSize_x()+2;a++)
        {
            cells[a][0] = 16;
           cells[a][maze.getSize_y()+1] = 16;       
        }
	    
	} 
	
	public int getCell(int a,int b){
		return cells[a][b];
	}

	private boolean test_ruchu(int x,int y){
		
		
		if( y ==(-1) && !maze.getCell(gracz.getPoz_x(),gracz.getPoz_y(),0)){
			//W
			return true;
		}
		else
		if( y == 1 && !maze.getCell(gracz.getPoz_x(),gracz.getPoz_y(),2)){
			//S
			return true;
		}
		else
		if( x == 1 && !maze.getCell(gracz.getPoz_x(),gracz.getPoz_y(),1)){
			//D
				return true;
		}
		else
		if( x == (-1) && !maze.getCell(gracz.getPoz_x(),gracz.getPoz_y(),3)){
			//A
				return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public void ruch_gracza(int x,int y){
		
		if(test_ruchu(x,y)){
		gracz.setPoz_x(gracz.getPoz_x()+x);
		gracz.setPoz_y(gracz.getPoz_y()+y);
		}
		
		czyKoniec(y);
		
	}

	public void odswiez() {
		repaint();
	}
	
	public void rebuild(){
		maze.reset();
		ubierz(maze);
		gracz.setPoz_x(1);
		gracz.setPoz_y(wys);
	}
	
	private void czyKoniec(int _y){
		if(gracz.getPoz_x() == maze.getSize_x() && gracz.getPoz_y() == 1 && -1 ==_y){
			rebuild();
		}
	}
	
	public void odslon(){
		tryb_hard = !tryb_hard;
	}
	
	
	public void szukaj_drogi(int x_start, int y_start, int x_meta, int y_meta){
		
		sciezka = new boolean[szer][wys];
		for(int a=0;a<=szer;a++)
			for(int b=0;b<=wys;b++)
				sciezka[a][b] = false;
		
		int x_a = x_start;
		int y_a = y_start;
		int dlugosc = 0;
		int kier;
		
		while(x_a != x_meta && y_a != y_meta)
		{
			kier = generator.nextInt(4);
			switch(kier){
			case 0: 
				
				
				break;
			case 1: 
				
				
				break;
			case 2: break;
			case 3: break;
			}
			
			
		}
		
	}
	
	
}

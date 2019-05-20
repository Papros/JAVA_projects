package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Plansza;

public class MyPanel extends JPanel{

	private static final long serialVersionUID = 4589290012870870L;
	
	private BufferedImage[] tiles_t = new BufferedImage[12];
	private BufferedImage panel; 
	private BufferedImage koniec;
	private boolean kon = false;
	
	Plansza plansza;
	
	public MyPanel(Plansza p){
		this.plansza = p;
		wczytaj();
		setPreferredSize(new Dimension(800,800));
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(panel,0,0,this);
		
		for(int a=0;a<4;a++)
			for(int b=0;b<4;b++)
				g2d.drawImage(ubierz(plansza.plytka(a, b).getWartosc()),a*196+15,b*196+15, this);
		
		
		if(plansza.getKoniec()) { 
			g2d.drawImage(koniec, 0, 0, this);
		}
		
		odswiez();
		
	}
	
	private void wczytaj(){
		
		try {	
			panel = ImageIO.read(MyPanel.class.getResource("/images/panel.png"));
			koniec= ImageIO.read(MyPanel.class.getResource("/images/koniec.png"));
			tiles_t[0] = ImageIO.read(MyPanel.class.getResource("/images/tiles_0.png"));
			tiles_t[1] = ImageIO.read(MyPanel.class.getResource("/images/tiles_1.png"));
			tiles_t[2] = ImageIO.read(MyPanel.class.getResource("/images/tiles_2.png"));
			tiles_t[3] = ImageIO.read(MyPanel.class.getResource("/images/tiles_3.png"));
			tiles_t[4] = ImageIO.read(MyPanel.class.getResource("/images/tiles_4.png"));
			tiles_t[5] = ImageIO.read(MyPanel.class.getResource("/images/tiles_5.png"));
			tiles_t[6] = ImageIO.read(MyPanel.class.getResource("/images/tiles_6.png"));
			tiles_t[7] = ImageIO.read(MyPanel.class.getResource("/images/tiles_7.png"));
			tiles_t[8] = ImageIO.read(MyPanel.class.getResource("/images/tiles_8.png"));
			tiles_t[9] = ImageIO.read(MyPanel.class.getResource("/images/tiles_9.png"));
			tiles_t[10] = ImageIO.read(MyPanel.class.getResource("/images/tiles_10.png"));
			tiles_t[11] = ImageIO.read(MyPanel.class.getResource("/images/tiles_11.png"));
			
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		
	}
	

	public void odswiez() {
		repaint();
	}
	
	private BufferedImage ubierz(int n) {
		switch(n) {
		case 0: return tiles_t[0]; 
		case 1: return tiles_t[1];
		case 2: return tiles_t[2];
		case 3:	return tiles_t[3];
		case 4:return tiles_t[4];
		case 5:return tiles_t[5];
		case 6:return tiles_t[6];
		case 7:return tiles_t[7];
		case 8:return tiles_t[8];
		case 9:return tiles_t[9];
		case 10:return tiles_t[10];
		case 11:return tiles_t[11];
		default: return tiles_t[0];
		}
	
	}
	
	
	
	
}

package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Control.MyButtonListener;
import Model.Scene;

public class MyPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	private Image background; // nieuzyte
	private Image left_portal_tiles,normal_tiles,right_portal_tiles;
	private Image EffectHolder;
	private Image EffectSprites[] = new Image[7];
	private Image PlayersSprite;
	
	private JDialog game_over_window;
	private JTextField menu_text;
	private boolean is_menu_visible;
	private JButton exit,reset;
	
	Scene MyLevel;
	int Width;// = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int Height;// = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	
	int SimpleTilesWidth;
	int SimpleTilesHeight;
	double barWidth,barHeight;
	
	private MyButtonListener buttonListener;
	MyFrame frame;
	int[][] typ_tab;
	boolean[][] tab;
	int[][] next_space;
	
	public MyPanel(Scene Level,MyFrame f) {
		super();
		this.MyLevel = Level;
		this.frame = f;
		LoadRecources();
	}
	
	
	public void LoadRecources() {
		
		Width = (int)( Toolkit.getDefaultToolkit().getScreenSize().getWidth() ); 
		Height =  (int)( Toolkit.getDefaultToolkit().getScreenSize().getHeight() ); 
		
		SimpleTilesWidth = Width / MyLevel.getWidth();
		SimpleTilesHeight = Height / MyLevel.getHeight();
		barHeight = 0.04*SimpleTilesHeight;
		barWidth = 0.8*SimpleTilesWidth;
		Dimension defoult_dimension = new Dimension(Width,Height);
		setPreferredSize(defoult_dimension);
	
		game_over_window = new JDialog(frame,"OPCJE",false);
		game_over_window.setLocation(100,100);
		game_over_window.setSize(SimpleTilesWidth*2,SimpleTilesHeight);
		game_over_window.setLocation((int)((WIDTH+SimpleTilesHeight)/2),(int)( (HEIGHT+SimpleTilesWidth)/2 ) );
		game_over_window.setVisible(false);
		is_menu_visible = false;
		
		buttonListener = new MyButtonListener(MyLevel,frame);
		
		exit = new JButton("WYJDZ Z GRY");
		exit.addActionListener(buttonListener);
		exit.setActionCommand("exit");

		reset = new JButton("NOWA GRA");
		reset.addActionListener(buttonListener);
		reset.setActionCommand("reset");
		
		menu_text = new JTextField("WYNIK: ");
		
		game_over_window.setLayout(new GridLayout(3,1));
		game_over_window.add(menu_text);
		game_over_window.add(exit);
		game_over_window.add(reset);
		
		try {
			left_portal_tiles = ImageIO.read(new File("Resources/images/left_portal_tiles.png")).getScaledInstance(SimpleTilesWidth,SimpleTilesHeight, 1);//.getScaledInstance(SimpleTilesWidth,SimpleTilesHeight,3);
			right_portal_tiles = ImageIO.read(new File("Resources/images/right_portal_tiles.png")).getScaledInstance(SimpleTilesWidth,SimpleTilesHeight, 1);
			normal_tiles = ImageIO.read(new File("Resources/images/normal_tiles.png")).getScaledInstance(SimpleTilesWidth,SimpleTilesHeight, 1);
			EffectHolder = ImageIO.read(new File("Resources/images/GameObjectHolder.png")).getScaledInstance(SimpleTilesWidth,SimpleTilesHeight, 1);
			PlayersSprite = ImageIO.read(new File("Resources/images/PlayerHolder.png")).getScaledInstance(SimpleTilesWidth,SimpleTilesHeight, 1);
			EffectSprites[0] = ImageIO.read(new File("Resources/images/None_effects.png")).getScaledInstance(SimpleTilesWidth,SimpleTilesHeight, 1);
			EffectSprites[1] = ImageIO.read(new File("Resources/images/teleport.png")).getScaledInstance(SimpleTilesWidth,SimpleTilesHeight, 1);
			EffectSprites[2] = ImageIO.read(new File("Resources/images/heal.png")).getScaledInstance(SimpleTilesWidth,SimpleTilesHeight, 1);
			EffectSprites[3] = ImageIO.read(new File("Resources/images/shield.png")).getScaledInstance(SimpleTilesWidth,SimpleTilesHeight, 1);
			EffectSprites[4] = ImageIO.read(new File("Resources/images/burn.png")).getScaledInstance(SimpleTilesWidth,SimpleTilesHeight, 1);
			EffectSprites[5] = ImageIO.read(new File("Resources/images/control.png")).getScaledInstance(SimpleTilesWidth,SimpleTilesHeight, 1);
			
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
		
		
		
	}
	
	public void refresh() {
		repaint();
	}
	
	public void Menu() {
		is_menu_visible = !is_menu_visible;
		game_over_window.setVisible(is_menu_visible);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		
		for(int i=0;i < MyLevel.getHeight() ; i ++) {
			
			for(int j=0;j<MyLevel.getWidth();j++ ) {
				
				
				
					
					g2d.drawImage(normal_tiles,j*SimpleTilesWidth,i*SimpleTilesHeight,this);
					g2d.drawImage(EffectHolder,j*SimpleTilesWidth,i*SimpleTilesHeight,this);
					
					if(j==0) g2d.drawImage(left_portal_tiles,0+j*SimpleTilesWidth,0+i*SimpleTilesHeight,this); 
					else if(j == MyLevel.getWidth() - 1) g2d.drawImage(right_portal_tiles,j*SimpleTilesWidth,i*SimpleTilesHeight,this);
					
					if(MyLevel.getTiles()[i][j].IfDisplayEffect())
					switch(MyLevel.getTiles()[i][j].getGameObject().getObjectsEfekt()){
					
					case NONE: g2d.drawImage(EffectSprites[0], j*SimpleTilesWidth, i*SimpleTilesHeight, this); break;
					case TELEPORT: g2d.drawImage(EffectSprites[1], j*SimpleTilesWidth, i*SimpleTilesHeight, this); break;
					case HEAL:g2d.drawImage(EffectSprites[2], j*SimpleTilesWidth, i*SimpleTilesHeight, this); break;
					case SHIELD: g2d.drawImage(EffectSprites[3], j*SimpleTilesWidth, i*SimpleTilesHeight, this); break;
					case BURN:	g2d.drawImage(EffectSprites[4], j*SimpleTilesWidth, i*SimpleTilesHeight, this);  break;
					case CONTROL: g2d.drawImage(EffectSprites[5], j*SimpleTilesWidth, i*SimpleTilesHeight, this); break;
					
					default: break;
					}
					
					
					
			}
			
		}
		
		for(int i=0; i<MyLevel.getPlayers().length; i++) {
			g2d.drawImage(PlayersSprite,MyLevel.getPlayers()[i].getPlayersX()*SimpleTilesWidth,MyLevel.getPlayers()[i].getPlayersY()*SimpleTilesHeight,this);
			
		}
		
		for(int i=0; i<MyLevel.getPlayers().length; i++) {
			
			g2d.setColor(Color.GREEN);
			//g2d.setStroke( new BasicStroke( (int)barHeight ) ); 
			
			int x1 = MyLevel.getPlayers()[i].getPlayersX()*SimpleTilesWidth+(int)((SimpleTilesWidth-barWidth)/2);
			int x2 = x1+(int)(MyLevel.getPlayers()[i].getPlayersHealth()*barWidth/MyLevel.getPlayers()[i].getMaxPoints() );
			int y1 =Height-( (MyLevel.getHeight()-MyLevel.getPlayers()[i].getPlayersY())*SimpleTilesHeight-(int)(2*barHeight) );   
			int y2 =Height-( (MyLevel.getHeight()-MyLevel.getPlayers()[i].getPlayersY())*SimpleTilesHeight-(int)(3*barHeight) );
			
			g2d.fillRect(x1, y1,(int)(MyLevel.getPlayers()[i].getPlayersHealth()*barWidth/MyLevel.getPlayers()[i].getMaxPoints()),(int) barHeight);
			
			g2d.setColor(Color.YELLOW);

			g2d.fillRect(x1, y2,(int)(MyLevel.getPlayers()[i].getPlayersShield()*barWidth/MyLevel.getPlayers()[i].getMaxPoints()),(int) barHeight);
			
		}
		
		
		
	} // PaintComponent
	
}

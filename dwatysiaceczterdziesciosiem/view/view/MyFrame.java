package view;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dwatysiaceczterdziesciosiem.Controller;
import model.Plansza;

public class MyFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	Image ImageIcon;
	MyPanel obrazPanel;
	Plansza plansza;
	Controller kontroler;
	
	
	public MyFrame(Plansza p) {
		super("2048");
		this.plansza = p;
		ImageIcon = Toolkit.getDefaultToolkit().getImage(MyFrame.class.getResource("/images/ikona.png"));
		obrazPanel = new MyPanel(p);
		kontroler = new Controller(p);
		addKeyListener(kontroler);
		setResizable(false);
		add(obrazPanel);
		initComponents();;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setLocation(0,0);
	}
	

	private void initComponents() {  //wczytywanie ikony programu
		setIconImage(ImageIcon); 
	}
	
	
}
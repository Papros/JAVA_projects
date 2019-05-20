package View;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Control.Controller1;
import Model.Scene;

public class MyFrame extends JFrame {

	Image ImageIcon;
	MyPanel MyPanel;
	Scene MyLevel;
	Controller1 controller;
	
	public MyFrame(Scene Level) {
		super("RunAndDie");
		ImageIcon =Toolkit.getDefaultToolkit().getImage("Resources/images/icon.jpg");
		this.MyLevel = Level;
		MyPanel = new MyPanel(MyLevel,this);
		add(MyPanel);
		controller = new Controller1(MyLevel,this);
		addKeyListener(controller);
		setResizable(true);
		
		initComponents();;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		pack();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setLocation(0,0);
		
		
	}

	private void initComponents() { 
		setIconImage(ImageIcon); 
	}
	
	public void PanelRefresh() {
		MyPanel.refresh();;
	}
	
	public void menu() {
		MyPanel.Menu();
	}
}

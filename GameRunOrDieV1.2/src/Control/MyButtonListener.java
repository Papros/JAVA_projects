package Control;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;

import Model.Scene;
import View.MyFrame;

public class MyButtonListener implements ActionListener{

	Scene MyLevel;
	MyFrame ActiveFrame;
	
	public MyButtonListener(Scene Level,MyFrame frame) {
		MyLevel = Level;
		ActiveFrame = frame;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		switch(arg0.getActionCommand()) {
		
		case "reset": MyLevel.reset(); ActiveFrame.menu(); ActiveFrame.PanelRefresh();  break;
		case "exit": ActiveFrame.dispose(); break;
		}
		
	}


	

}

package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.Scene;
import View.MyFrame;

public class Controller1 implements KeyListener {
	
	Scene MyLevel;
	MyFrame ActiveFrame;

	public Controller1(Scene Level, MyFrame frame) {
		MyLevel = Level;
		ActiveFrame = frame;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		int wybor = arg0.getKeyCode();

		switch (wybor) {

		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_A:
			MyLevel.goLeft();
			break;

		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_D:
			MyLevel.goRight();
			break;

		case KeyEvent.VK_R:
			MyLevel.reset();
			break;
		case KeyEvent.VK_ESCAPE:
			ActiveFrame.menu();
			break;

		default:
			System.out.println(arg0.getKeyChar());
			break;
		}

		ActiveFrame.PanelRefresh();

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}

package dwatysiaceczterdziesciosiem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Plansza;

public class Controller  implements KeyListener {

	private Plansza board;
	
	public Controller(Plansza b) {
		this.board = b;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		char wybor = arg0.getKeyChar();
		
		if(wybor == 'd'){	
				board.ruch_w_prawo();
		}
		else
		if(wybor == 'a'){		
				board.ruch_w_lewo();
		}
		else
		if(wybor == 's'){		
				board.ruch_w_dol();
		}
		else
		if(wybor == 'w'){		
				board.ruch_w_gore();
		}
		if(wybor == 'b'){ // dev tools XD
			//obrazPanel.cofnij();		
		}
		if(wybor == 'o'){
			board.wypisz();
		}
		if(wybor == 'r'){
			if(board.getKoniec()) board.restart();
		}
		else{
			
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
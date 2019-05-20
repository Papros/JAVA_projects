
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ObrazFrame extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	Image ImageIcon;
	Obraz obrazPanel;
	//private int akt_x_gracza=1,akt_y_gracza=1;
	
	public ObrazFrame() {
		super("LABIRYNT");
		ImageIcon = Toolkit.getDefaultToolkit().getImage(ObrazFrame.class.getResource("/image/icon.png"));
		obrazPanel = new Obraz();
		addKeyListener(this);
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

	@Override
	public void keyPressed(KeyEvent arg0) {
		char wybor = arg0.getKeyChar();
		
		if(wybor == 'd'){		
			obrazPanel.ruch_gracza(1,0);
		}
		else
		if(wybor == 'a'){		
				obrazPanel.ruch_gracza(-1,0);
		}
		else
		if(wybor == 's'){		
				obrazPanel.ruch_gracza(0,1);
		}
		else
		if(wybor == 'w'){		
				obrazPanel.ruch_gracza(0,-1);
		}
		if(wybor == 'r'){ // dev tools XD
				obrazPanel.rebuild();
		}
		if(wybor == 'o'){
			obrazPanel.odslon();
		}
		else{
			
		}
		obrazPanel.odswiez();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		char wybor = arg0.getKeyChar();
		//if(wybor == 'o') obrazPanel.odslon();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}

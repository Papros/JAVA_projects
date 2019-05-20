import java.awt.EventQueue;

import javax.swing.JPanel;

public class GRA {

	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ObrazFrame();
			}
		});
	}
	
	
}

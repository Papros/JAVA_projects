package src;

import java.awt.EventQueue;

import model.Plansza;
import view.MyFrame;

	public class Gra {
		public static void main(String[] args) {
		
			Plansza plansza = new Plansza();
			
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MyFrame(plansza);
			}
		});
	}

}

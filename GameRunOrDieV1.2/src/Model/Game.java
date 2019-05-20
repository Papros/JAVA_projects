package Model;

import java.awt.EventQueue;

import View.MyFrame;

public class Game {

	private static int StartingNumberOfPlayers = 3;
	private static int DeflautWitdh = 5;
	private static Scene LEVEL;
	private static OverallGameStatus GameStatus;

	public static void GameSetting() {
		LEVEL = new Scene(StartingNumberOfPlayers, DeflautWitdh);
		GameStatus = new OverallGameStatus();
		GameStatus.setCommonPlayersHealth(LEVEL.getPlayers());
		GameStatus.setPlayersAlive(StartingNumberOfPlayers);
	}

	public static void main(String[] args) {
		GameSetting();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MyFrame(LEVEL);
			}
		});
	}
}

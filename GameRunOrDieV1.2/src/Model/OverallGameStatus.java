package Model;

public class OverallGameStatus {

	private int CommonPlayersHealth;
	private int PlayersAlive;
	private int Counter;
	
	public OverallGameStatus() {
		Counter = 0;
	}
	
	public void NextRound() {
		Counter++;
	}
	
	public void setPlayersAlive(int Alive) {
		PlayersAlive = Alive;
	}
	
	public void setCommonPlayersHealth(Player[] ActivePlayer) {
		for(int i=0; i < ActivePlayer.length; i++) {
			CommonPlayersHealth += ActivePlayer[i].getPlayersHealth();
		}
	}
	
}

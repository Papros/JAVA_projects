package Model;

public class Scene {

	private int LEVELS_NUMBER;
	private int LEVELS_WIDTH;
	
	private Tiles[][] GameMap;
	private boolean GameOver;
	private Player[] ActivePlayers;
	private int moves;
	
	public Scene(int NumberOfPlayer,int Width) {
		LEVELS_NUMBER = NumberOfPlayer;
		LEVELS_WIDTH = Width;
		reset();
	}
	
	public void reset() {
		
		GameOver = false;
		GameMap = new Tiles[LEVELS_NUMBER][LEVELS_WIDTH];
		moves = 0;
		for(int i =0; i < LEVELS_NUMBER;i++)
			for(int j = 0;j<LEVELS_WIDTH;j++)
				GameMap[i][j] = new Tiles(this);
		
		ActivePlayers = new Player[LEVELS_NUMBER];
		
		for(int i =0;i<LEVELS_NUMBER;i++) {
			ActivePlayers[i] = new Player();
			ActivePlayers[i].setPlayersOnLevel(i);
			ActivePlayers[i].setPlayersX(LEVELS_WIDTH/2);
			GameMap[i][LEVELS_WIDTH/2].PlayersOnIt(true);
		}
		
		for(int i=0;i<LEVELS_NUMBER;i++) {
			GameMap[i][0].getGameObject().setObjectEfekt(Efects.TELEPORT);
			GameMap[i][0].getGameObject().setEffectStatic(true);
			
			GameMap[i][LEVELS_WIDTH-1].getGameObject().setObjectEfekt(Efects.TELEPORT);
			GameMap[i][LEVELS_WIDTH-1].getGameObject().setEffectStatic(true);
			
		}
		
	}
	
	public Player[] getPlayers() {
		return ActivePlayers;
	}
	
	public Tiles[][] getTiles(){
		return GameMap;
	}
	
	public int getWidth() {
		return LEVELS_WIDTH;
	}
	
	public int getHeight() {
		return LEVELS_NUMBER;
	}
	
	public void goLeft() {
		
		
		for(int i =0; i <ActivePlayers.length;i++) {
			GameMap[i][ActivePlayers[i].getPlayersX()].PlayersOnIt(false);
			GameMap[i][ActivePlayers[i].getPlayersX()].setNewEffect();
			ActivePlayers[i].goLeft();
			GameMap[i][ActivePlayers[i].getPlayersX()].PlayersOnIt(true);
		}
		
		EffectTour();
	}
	
	public void goRight() {
		for(int i =0; i <ActivePlayers.length;i++) {
			GameMap[i][ActivePlayers[i].getPlayersX()].PlayersOnIt(false);
			GameMap[i][ActivePlayers[i].getPlayersX()].setNewEffect();
			ActivePlayers[i].goRight();
			GameMap[i][ActivePlayers[i].getPlayersX()].PlayersOnIt(true);
		}
		
		EffectTour();
	}
	
	public void EffectTour() {
		
		for(int i =0; i < ActivePlayers.length; i++) {
			GameMap[i][ActivePlayers[i].getPlayersX()].getGameObject().MakeEffect(ActivePlayers[i]);
		}
		moves++;
		TryIfGameOver();
	}
	
	public int getScore() {
		return moves;
	}
	
	public void TryIfGameOver() {
		
		for(int i=0;i<LEVELS_NUMBER;i++)
			if(!ActivePlayers[i].isAlive()) GameOver = true;
		
		if(GameOver) {
			System.out.println("WYNIK: "+moves+" ,DOBRA ROBOTA!");
			reset();
		}
	}
}

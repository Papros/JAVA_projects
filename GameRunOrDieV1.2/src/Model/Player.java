package Model;

public class Player {

	private int HEALTH_POINTS;  // zdrowie
	private int SHIELD_POINTS;	//tarcza
	private int MAX_POINTS;
	private boolean MindStatus;	//sterowanie
	private int X_cord, Y_cord;
	
	public Player() {
		HEALTH_POINTS = 100;
		SHIELD_POINTS = 25;
		MAX_POINTS = 100;
		MindStatus = true;
	}
	
	public void heal(int x) {
		HEALTH_POINTS = (HEALTH_POINTS+x>MAX_POINTS?MAX_POINTS:(HEALTH_POINTS+x));
	}
	
	public void hurt(int x) {
		int y = x - SHIELD_POINTS;
		destroyShield(x);
		HEALTH_POINTS = (y>HEALTH_POINTS?0:(HEALTH_POINTS-y));
		
	}
	
	public void giveShield(int x) {
		SHIELD_POINTS = (SHIELD_POINTS+x>MAX_POINTS?MAX_POINTS:SHIELD_POINTS+x);
	}
	
	public void destroyShield(int x) {
		SHIELD_POINTS = (x>SHIELD_POINTS?0:SHIELD_POINTS-x);
	}
	
	public boolean isAlive() {
		return HEALTH_POINTS>0;
	}
	
	public void setPlayersOnLevel(int YCord) {
		Y_cord = YCord;
	}
	
	public void setPlayersX(int XCord) {
		X_cord = XCord;
	}
	
	public int getPlayersHealth() {
		return HEALTH_POINTS;
	}
	
	public int getPlayersShield() {
		return SHIELD_POINTS;
	}
	
	public void NegateMindStatus() {
		MindStatus = !MindStatus;
	}
	
	public int getPlayersX() {
		return X_cord;
	}
	
	public int getPlayersY() {
		return Y_cord;
	}
	
	public int getMaxPoints() {
		return MAX_POINTS;
	}
	
	public void goLeft() {
		if(MindStatus) {
			X_cord--;
		}else
		{
			X_cord++;
		}
		
		destroyShield(5);
	}
	
	public void goRight() {
		if(MindStatus) {
			X_cord++;
		}else
		{
			X_cord--;
		}
		
		destroyShield(5);
	}
}

package Model;

import java.util.Random;

public enum Efects {

	NONE(0,0,0),		// Brak efektów
	HEAL(10,0,0),		// punkty zycia
	BURN(0,0,15),		// punkty obrazen, podpalenie?
	CONTROL(0,0,0),	//	zmiana sterowania dla gracza
	ANTI_SHIELD(0,0,0),// obrazenia dotykaj¹ innego gracza
	SHIELD(0,15,0),		// zmniejszaj¹ce siê z czasem ponadstanowe punkty zycia
	TELEPORT(0,0,0),  //portal na drugi koniec mapy
	Random(0,0,0);	//losowe wartosci
	
	private int LIVE_POINTS;
	private int SHIELD_POINTS;
	private int DAMAGE_POINTS;
	
	
	Efects() {
		
		LIVE_POINTS = 0;
		SHIELD_POINTS = 0;
		DAMAGE_POINTS = 0;
		
	}
	
	Efects(int live_pts, int sh_pts, int dmg_pts){
		LIVE_POINTS = live_pts;
		SHIELD_POINTS = sh_pts;
		DAMAGE_POINTS = dmg_pts;

	}
	
	public Efects RandomEfect() {
		
		return this;
	}
	
	public Efects getNoneEfects() {
		return NONE;
	}
	
	public int getHealValue() {
		return LIVE_POINTS;
	}
	
	public int getShieldValue() {
		return SHIELD_POINTS;
	}
	
	public int getDamageValue() {
		return DAMAGE_POINTS;
	}
	
}

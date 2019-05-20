package Model;

import java.util.Random;

public class GameObject {

	Efects efekt;
	Scene ParentsScene;
	boolean static_effect;
	Random generator;

	public GameObject(Scene parents) {
		ParentsScene = parents;
		efekt = Efects.NONE;
		generator = new Random();
		RandomEfect();
	}

	public Efects getObjectsEfekt() {
		return efekt;
	}

	public void setEffectStatic(boolean arg) {
		static_effect = arg;
	}

	public void setObjectEfekt(Efects arg) {
		efekt = arg;
	}

	public void setNoneEfects() {
		efekt.getNoneEfects();
	}

	public void RandomEfect() {

		int x = generator.nextInt(100);

		if (x < 15)
			efekt = Efects.SHIELD;
		else if (x < 35)
			efekt = Efects.HEAL;
		else if (x < 50)
			efekt = Efects.BURN;
		else if (x < 65)
			efekt = Efects.BURN;
		else if (x < 80)
			efekt = Efects.SHIELD;
		else if (x < 90)
			efekt = Efects.BURN;
		else if (x < 100)
			efekt = Efects.CONTROL;

	}

	public void MakeEffect(Player player) {

		switch (efekt) {

		case NONE:
			break;
		case TELEPORT:
			this.ParentsScene.getTiles()[player.getPlayersY()][player.getPlayersX()].PlayersOnIt(false);
			player.setPlayersX((player.getPlayersX() == 0 ? (ParentsScene.getWidth() - 2) : 1));
			this.ParentsScene.getTiles()[player.getPlayersY()][player.getPlayersX()].PlayersOnIt(true);
			break;
		case HEAL:
			player.heal(efekt.getHealValue());
			break;
		case SHIELD:
			player.giveShield(efekt.getShieldValue());
			break;
		case BURN:
			player.hurt(efekt.getDamageValue());
			break;
		case CONTROL:
			player.NegateMindStatus();
			break;
		}

	}

}

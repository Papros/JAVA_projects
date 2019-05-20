package Model;

public class Tiles {

	GameObject game_object;
	Scene ParentsScene;
	private boolean isPlayerOnIt;
	private boolean display_effect;
	
	public Tiles(Scene Parents) {
		ParentsScene = Parents;
		game_object = new GameObject(ParentsScene);
		display_effect = true;
	}
	
	public GameObject getGameObject() {
		return game_object;
	}
	
	public void PlayersOnIt(boolean arg) {
		isPlayerOnIt = arg;
		display_effect = !arg;
	}
	
	public void setNewEffect() {
		game_object.RandomEfect();
	}
	
	private void setIfDisplayEffect(boolean arg) {
		display_effect = arg;
	}
	
	public boolean IfDisplayEffect() {
		return display_effect;
	}
}

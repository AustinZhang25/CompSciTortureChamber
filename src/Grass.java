import java.util.ArrayList;

public class Grass extends Plant {

	ArrayList<LifeForm> arr = myWorld.getCreatureList(); //iterates through the entire creature list
	public Grass(Location l, World w) {
		super(l,w);
		myLifeSpan = 3;
	}
	public boolean isFree(Location l){
		int x = l.getX();
		int y = l.getY();

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).myLocation.getX() == x && arr.get(i).myLocation.getY() == y) {
				return false;
			}
		}
		return true;
	}
	
	public void reproduce() {
		// this is silly code really, but as an example
		if (alive) {
			int newX = (int) (Math.random() * 20);
			int newY = (int) (Math.random() * 20);
				if (isFree(new Location(newX, newY))) {
					myWorld.getCreatureList().add(new Grass(new Location(newX, newY), myWorld));
				}
			}
	}
	public void Eat(){

	}
	public void Move(){

	}

}

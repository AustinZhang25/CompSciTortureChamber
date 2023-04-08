import acm.util.RandomGenerator;
import java.awt.*;
import java.util.ArrayList;

public class Egg extends Animal{

    int eggX = myLocation.getX();
    int eggY = myLocation.getY();

    boolean hasEaten = false;
    ArrayList<LifeForm> arr = myWorld.getCreatureList(); //iterates through the entire creature list

    public Egg(Location l, World w) {
        super(l,w);
        myLifeSpan = 100;
        myColor = Color.PINK;
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
        int hatchTime = 0;
        hatchTime++;
        if (hatchTime == 4){
            Hatch();
        }
    }
    public void Hatch(){
        alive = false;
        Location hatchLocation = new Location(eggX, eggY);
        myWorld.getCreatureList().add(new Bird(hatchLocation, myWorld));
    }

    public void Eat(){

    }
    public void Move(){

    }
    private RandomGenerator rgen = new RandomGenerator();
}



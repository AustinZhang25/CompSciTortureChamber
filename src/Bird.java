import acm.util.RandomGenerator;
import java.awt.*;
import java.util.ArrayList;

public class Bird extends Animal{

    int deerX = myLocation.getX();
    int deerY = myLocation.getY();

    boolean hasEaten = false;
    ArrayList<LifeForm> arr = myWorld.getCreatureList(); //iterates through the entire creature list

    public Bird(Location l, World w) {
        super(l,w);
        myLifeSpan = 6;
        myColor = Color.blue;
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

        boolean deerAdjacent = false;
        for (int i = 0; i<arr.size(); i++){
            if (arr.get(i) instanceof Deer && Math.abs(deerX-arr.get(i).myLocation.getX()) <= 1 && (Math.abs(deerY-arr.get(i).myLocation.getY()) <= 1)
                    && !(arr.get(i).myLocation == myLocation)){
                deerAdjacent = true;
            }
        }
        if (alive && deerAdjacent && hasEaten){
            int newX = myLocation.getX()+rgen.nextInt(-1,1);
            int newY = myLocation.getY()+rgen.nextInt(-1,1);
            for(int i = 0; i < 100; i++){
                if(!isFree(new Location(newX, newY))){
                    newX = myLocation.getX()+rgen.nextInt(-1,1);
                    newY = myLocation.getY()+rgen.nextInt(-1,1);
                }else{
                    break;
                }
            }
            Location newLocation = new Location(newX, newY);
            myWorld.getCreatureList().add(new Egg(newLocation, myWorld));
        }
    }

    public void Eat(){
        hasEaten = false;
        for (int i = 0; i<arr.size(); i++){
            int otherX = arr.get(i).getMyLocation().getX();
            int otherY = arr.get(i).getMyLocation().getY();
            if(arr.get(i) instanceof Grass /*||arr.get(i) instanceof Mushroom*/ && Math.abs(deerX - otherX) <= 1 && Math.abs(deerY - otherY) <= 1) {
                //checks if 2 things are adjacent or 1 square apart.
                arr.get(i).alive=false;
                hasEaten = true;
            }
        }
        if (!hasEaten){
            myAge++;
        }

//        if (Deer.super.getMyLocation().getX()+1)

    }
    public void Move(){
        for (int i = 0; i<3;i++){
            int newX = deerX + rgen.nextInt(-1, 1);
            int newY = deerX + rgen.nextInt(-1, 1);
            Location newLocation = new Location(newX, newY);
            setMyLocation(newLocation);
        }
    }
    private RandomGenerator rgen = new RandomGenerator();
}



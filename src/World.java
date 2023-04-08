import acm.graphics.GRect;
import acm.util.RandomGenerator;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.ArrayList;



public class World {
	
	private int width;
	int yearsSinceFlood = 0;
	private int height;
	private ArrayList<LifeForm> creatureList;
	private ArrayList<Water> waterList;


	public World(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.creatureList = new ArrayList<LifeForm>();
		this.waterList = new ArrayList<Water>();

	}
	boolean timeToFlood = false;


	public void letTimePass(){
		eatThings();
		makeNewCreatures();
		creaturesGetOlder();
		purgeTheDead();
		allCreaturesMove();
	}
	
	public void makeNewCreatures() {
		int currentSizeOfCreatureList = creatureList.size();
		for (int i = 0; i<currentSizeOfCreatureList; i++){
			creatureList.get(i).reproduce();
		}
	}
	public void allCreaturesMove () {
		for(int i=0; i< creatureList.size(); i++) {
			creatureList.get(i).Move();
//			System.out.println(creatureList.get(i).myLocation.getX() + "" + creatureList.get(i).myLocation.getY());

		}
	}
	public void eatThings(){

		for(int i=0; i< creatureList.size(); i++) {
			creatureList.get(i).Eat();
		}
	}
	
	public void purgeTheDead(){
		int i=0;
		while(i<creatureList.size()){
			if(creatureList.get(i).isDead())
				creatureList.remove(i);
			else
				i++;
		}	
	}
	
	public void creaturesGetOlder(){
		for( LifeForm l:creatureList){
			l.age(1);
		}
	}
	public void floodCheck(){
		if (yearsSinceFlood > 5 && rgen.nextInt(1,50) == 23){
			timeToFlood =true;
		}
	}
	public void flood(){
		for (int i = 0;i<creatureList.size();i++){ //wipes half of all creatures statistically
			if(rgen.nextInt(0,1) == 1){
				//if (!(creatureList.get(i) instanceof Bear)){
					creatureList.get(i).alive=false;
				//}
			}
		}
		//
		int floodX = rgen.nextInt(0,100);
		int floodY = rgen.nextInt(0,100);
		for (int i = 0; i<5; i++){
			Water flood = new Water(new Location(floodX, floodY));
			waterList.add(flood);
		}

		int grassIndex = 0;
		for (int i = 0;i<creatureList.size();i++){ //finds index of first grass
			if (creatureList.get(i) instanceof Grass){
				grassIndex = creatureList.indexOf(creatureList.get(i));
				break;
			}
		}
		for (int i = 0;i<1;i++){ //grows a ton of grass
			creatureList.get(grassIndex).reproduce();
		}
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public ArrayList<LifeForm> getCreatureList() {
		return creatureList;
	}
	public ArrayList<Water> getWaterList() {
		return waterList;
	}
	public void setWaterList(ArrayList<Water> waterList) {
		this.waterList = waterList;
	}

	@Override
	public String toString() {
		return "World [width=" + width + ", height=" + height
				+ ", creatureList=" + creatureList + "]";
	}
	private RandomGenerator rgen = new RandomGenerator();
}

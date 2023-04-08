import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class WorldController extends GraphicsProgram {
	
	private World theWorld;
	private GCanvas theWorldCanvas;
	public static final int APPLICATION_WIDTH = 200;
	public static final int APPLICATION_HEIGHT = 200;
	
	public void run(){	
		setUpWorld();
		runWorld();
	}
	
	public void init(){
	    resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
	}
	
	public void setUpWorld(){
		theWorld = new World(20,20);
		for (int i =0;i<50;i++){//change i<x for how much grass you want
			theWorld.getCreatureList().add( new Grass( new Location(rgen.nextInt(0, 20),rgen.nextInt(0,20)), theWorld ));
		}
		//theWorld.getCreatureList().add( new Grass( new Location(3,6), theWorld ));
		theWorld.getCreatureList().add( new Deer( new Location(5,6), theWorld ));
		theWorld.getCreatureList().add( new Bird( new Location(4,6), theWorld ));
		theWorld.getCreatureList().add( new Deer( new Location(6,6), theWorld ));

		theWorldCanvas = this.getGCanvas();
	}
	public void runWorld(){
		drawWorld();
		for(int i=0; i<200;i++){
			waitForClick();
			theWorld.letTimePass();
			pause(500);
			drawWorld();
		}
	}
	public void drawWorld(){
		drawBlankWorld();
		drawCreatures();
		//drawWater();

	}
	public void drawBlankWorld(){
		for(int row = 0 ; row<theWorld.getWidth(); row++)
			for(int col=0; col<theWorld.getHeight(); col++){
				GRect r = new GRect(row*10, col*10, 10, 10);
				r.setFillColor(Color.WHITE);
				r.setFilled(true);
				theWorldCanvas.add(r);
			}
	}
	public void drawCreatures(){
		for(LifeForm x: theWorld.getCreatureList()){
			GRect r = new GRect (x.getMyLocation().getX()*10, x.getMyLocation().getY()*10,10,10);
			r.setFillColor(x.getMyColor());
			r.setFilled(true);
			theWorldCanvas.add(r);
		}
	}
	public void drawWater(){
		for(Water x: theWorld.getWaterList()){
			System.out.println(theWorld.getWaterList().size());
			GRect r = new GRect (x.getMyLocation().getX()*10, x.getMyLocation().getY()*10,10,10);
			r.setFillColor(x.getMyColor());
			r.setFilled(true);
			theWorldCanvas.add(r);
		}
	}
	private RandomGenerator rgen = new RandomGenerator();
}

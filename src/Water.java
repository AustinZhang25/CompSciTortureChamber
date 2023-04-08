import acm.graphics.GObject;

import java.awt.Color;
import java.util.ArrayList;


public class Water {
    protected World myWorld;
    protected Location myLocation;
    protected Color myColor;


    public Water(Location myLocation) {
        super();
        this.myLocation = myLocation;
        this.myColor = Color.CYAN;

    }

    public Location getMyLocation() {
        return myLocation;
    }
    public void setMyLocation(Location myLocation) {
        this.myLocation = myLocation;
    }
    public Color getMyColor() {
        return myColor;
    }

}


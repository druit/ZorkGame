package zork;

import java.io.Serializable;


public class Room implements Serializable{
   private String name;
   private String south;
   private String north;
   private String west;
   private String east;

    public Room(String name, String south,String north,String west,String east) {
        this.name = name;
        this.south = south;
        this.north = north;
        this.east = east;
        this.west = west;
    }
    
    public Room() {
        
    }

   
    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }
    
   
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}

import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Point;
import java.lang.Math;

import javafx.scene.shape.ObservableFaceArray;

public class Obstacle
{
	private String name;
	//private boolean isDeadly = true;
	//private int health;
	private int xcoord;
	private int ycoord;
	private final int height = 100;
	private final int width = 100;
	private Rectangle location = new Rectangle(xcoord, ycoord, width, height);
	
	
	/**
	Constructor methods for obstacles which include both the environment and enemies
	
	@param name is the name of the object
	@param location is a rectangle of the object's location
	@param isDeadly determines whether the object will be deadly to the user or not
	*/
	public Obstacle(Obstacle inputObstacle){
		this.name = inputObstacle.name;
		//this.isDeadly = inputObstacle.isDeadly;
		this.location = new Rectangle(inputObstacle.location);
		//this.health = inputObstacle.health;
	}
	
	public Obstacle(){
	}
	
	public Obstacle(String name, Rectangle location)
	{
		this.name = name;
		this.location = new Rectangle(location);
	}

	public Obstacle(String name, int x, int y){
		this.name = name;
        this.location.setLocation(x,y);
	}
	
	/**
	Get the the object's current location
	
	@return location is a copy of the location variable
	*/
	public Rectangle getLocation()
	{
		return new Rectangle(location);
	}
	
	/**
	Get the name of the object
	
	@return name
	*/
	public String getName()
	{
		return name;
	}

	/**
    This method checks wether or not the obsatcle overalps with an avatar
    @param a : this is the avatar that we want to check if the obstacle overlaps with it
    */
	public boolean overlapsWith(Avatar a){
		
        if ((a.getLocation().contains(this.location.getX(), this.location.getY())) || (a.getLocation().contains(this.location.getX() + this.width, this.location.getY())) ||
            (a.getLocation().contains(this.location.getX(), this.location.getY() + this.height)) || (a.getLocation().contains(this.location.getX() + this.width, this.location.getY() + this.height))){
            //If the obstacle contains the upper left corner, or upper right corner, or bottom right corner, or bottom left conrer, return true
            return true;
        }else {
            return false;
        }
        
        /*
        if((a.getLocation().getX() == this.location.getX()) && (a.getLocation().getY() == this.location.getY())){
            return true;
        }else{
            return false;
        }
        */
	}
	
    /**
    This method checks wether or not the obstacle overlaps with another obstacle
    @param o : this is the obstacle that we want to check if our obsatcle overalps with it
    */
	public boolean overlapsWithObstacle(Obstacle o)
	{
        
        if ((o.getLocation().contains(this.location.getX(), this.location.getY())) || (o.getLocation().contains(this.location.getX() + this.width, this.location.getY())) ||
            (o.getLocation().contains(this.location.getX(), this.location.getY() + this.height)) || (o.getLocation().contains(this.location.getX() + this.width, this.location.getY() + this.height))){
            //If the obstacle contains the upper left corner, or upper right corner, or bottom right corner, or bottom left conrer, return true
            return true;
        }else {
            return false;
        }
        /*
        if((o.getLocation().getX() == this.location.getX()) && (o.getLocation().getY() == this.location.getY())){
            return true;
        }else {
            return false;
        }
        */
	}
	
    //Setter methods
    /**
    This method sets the location of the object
    @param location : this is the location that we wish to set the location of the object to
    */
    public void setLocation(Rectangle location){
        this.location = new Rectangle(location);
    }
    
    /**
    @param xcoordinate
    @param ycoordinate
    */
    public void setLocation(int xcoordinate, int ycoordinate){
        this.location = new Rectangle(xcoordinate, ycoordinate, width, height);
    }
    
    /**
    This sets the name
    */
    public void setName(String aName){
        this.name = aName;
    }

    /**
    This is the to string method
    */
    public String toString(){
        return this.name + " " + this.location.getX() + " " + this.location.getY();
    }
    
    /**
    This method checks if two obstacles are equal
    */
    public boolean equals(Obstacle o1){
        if (this.location.equals(o1.getLocation())){
            return true;
        }else {
            return false;
        }
    }
    
    public static void main(String[] args){
        Obstacle o1 = new Obstacle("Obstacle1", 1, 0);
        Obstacle o2 = new Obstacle("Obstacle2", 1, 0);
        Obstacle o3 = new Obstacle("Obstacle3", 1, 0);
        Obstacle o4 = new Obstacle("Obstacle4", 0, 0);
        Obstacle o5 = new Obstacle("Obstacle5", 1, 0);
        Obstacle o6 = new Obstacle("Obstacle6", 1, 0);
        Obstacle o7 = new Obstacle("Obstacle7", 1, 0);
        Obstacle o8 = new Obstacle("Obstacle8", 1, 0);
        ArrayList<Obstacle> oA1 = new ArrayList<Obstacle>();
        
        oA1.add(o1);
        oA1.add(o2);
        oA1.add(o3);
        oA1.add(o4);
        oA1.add(o5);
        oA1.add(o6);
        oA1.add(o7);
        oA1.add(o8);
        
        Avatar a1 = new Avatar("Avatar1", 0, 0, 0, new Rectangle(0,0,1,1));
        
        System.out.println(o1.toString());
        System.out.println(o2.toString());
        
        System.out.println(o1.overlapsWithObstacle(o2));
        
        //for (int i = 0; i < 10; i++){
          //  o1.randomMove();
        //}
        System.out.println(o1.toString());


        boolean occupied = false;
        for(Obstacle o : oA1){
            if(o.overlapsWith(a1)){
                occupied = true;
                break;
            }
        }
        
        if(occupied == true){
            for(int i = 0; i < oA1.size(); i++){
                if(oA1.get(i).overlapsWith(a1)){
                    System.out.println(oA1.get(i));
                    break;
                }
            }
        }
          

    }
}
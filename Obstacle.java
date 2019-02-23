import java.awt.Rectangle;
import java.awt.Point;
import java.lang.Math;

import javafx.scene.shape.ObservableFaceArray;

public class Obstacle
{
	private String name;
	private boolean isDeadly = true;
	private int health;
	private int xcoord;
	private int ycoord;
	private final int height = 1;
	private final int width = 1;
	private Rectangle location = new Rectangle(xcoord, ycoord, width, height);
	
	
	/**
	Constructor methods for obstacles which include both the environment and enemies
	
	@param name is the name of the object
	@param location is a rectangle of the object's location
	@param isDeadly determines whether the object will be deadly to the user or not
	*/
	public Obstacle(Obstacle inputObstacle){
		this.name = inputObstacle.name;
		this.isDeadly = inputObstacle.isDeadly;
		this.location = new Rectangle(inputObstacle.location);
		this.health = inputObstacle.health;
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
	
	public Obstacle(String name, boolean isDeadly, Rectangle location)
	{
		this.name = name;
		this.isDeadly = isDeadly;
		this.location = new Rectangle(location);
		this.health = 3;
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
	Get whether the object is deadly to the user or not
	
	@return isDeadly
	*/
	public boolean getIsDeadly()
	{
		return isDeadly;
	}

	// checks if obsatcle is in the same spot as the avatar, will be boolean
	public boolean overlapsWith(Avatar a){
		
        
        if (a.getLocation().equals(this.location)){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean overlapsWithObstacle(Obstacle o)
	{
		if (o.getLocation().equals(this.location))
		{
			return true;
		} else
		{
			return false;
		}
	}
	
	/**
	If the enemy got hit, reduce the health by 1
	*/
	public void enemyHit()
	{
		this.health -= 1;
	}
	
	/**
	Move the object in a defined direction
	
	@param direction is the direction to move the object in (up, down, left, right, otherwise the object won't move)
	*/
	public void move(String direction)
	{
		direction = direction.toLowerCase();
		System.out.println(direction);
		int xCoord = (int)(location.getX());
		int yCoord = (int)(location.getY());
		if(direction.equals("up")){
			if (location.getY() > 0){
                //if the obstacle is within the edge, then move up
				this.location.setLocation(xCoord, yCoord - 1);	
			}else if(location.getY() == 0 ){
                //If the obstacle is at the edge, have the obstacle bounce away from it
                this.location.setLocation(xCoord, yCoord + 1);
            }
		} else if(direction.equals("down")){
			if (location.getY() < 10){
                //if the obstcle is within the edge, then move down
				this.location.setLocation(xCoord, yCoord + 1);
			}else if(location.getY() == 10){
                //if the obstacle is at the edge, then move up
                this.location.setLocation(xCoord, yCoord - 1);
            }
		} else if(direction.equals("left")){
			if (location.getX() > 0){
                //if the obstacle is within the edge, then move left
				this.location.setLocation(xCoord - 1, yCoord);
			}else if(location.getX() == 0){
                //if the obstacle is at the edge, then move right
                this.location.setLocation(xCoord + 1, yCoord);
            }
		}else if(direction.equals("right")){
			if (location.getX() < 10){
				//if the obsatcle is within the egde, then move right
                this.location.setLocation(xCoord + 1, yCoord);
			}else if(location.getX() == 10){
                //if the obstacle is at the edge, then move left
                this.location.setLocation(xCoord - 1, yCoord);
            }
		}
	}
	
	/**
	Randomly decide if the object should stay in place or move in a random cardinal direction
	*/
	public void randomMove()
	{
		int dirNum = (int)(Math.random() * 4 + 1);
		String direction = "";
		if (dirNum == 1){
			direction = "up";
		} else if (dirNum == 2){
			direction = "down";
		} else if (dirNum == 3){
			direction = "left";
		} else if (dirNum == 4){
			direction = "right";
		}
		
		//System.out.println(direction);
		
		int xCoord = (int)(location.getX());
		int yCoord = (int)(location.getY());
		
		if(direction.equals("up")){
			if (location.getY() > 0){
                //if the obstacle is within the edge, then move up
				this.location.setLocation(xCoord, yCoord - 1);	
			}else if(location.getY() == 0 ){
                //If the obstacle is at the edge, have the obstacle bounce away from it
                this.location.setLocation(xCoord, yCoord + 1);
            }
		} else if(direction.equals("down")){
			if (location.getY() < 10){
                //if the obstcle is within the edge, then move down
				this.location.setLocation(xCoord, yCoord + 1);
			}else if(location.getY() == 10){
                //if the obstacle is at the edge, then move up
                this.location.setLocation(xCoord, yCoord - 1);
            }
		} else if(direction.equals("left")){
			if (location.getX() > 0){
                //if the obstacle is within the edge, then move left
				this.location.setLocation(xCoord - 1, yCoord);
			}else if(location.getX() == 0){
                //if the obstacle is at the edge, then move right
                this.location.setLocation(xCoord + 1, yCoord);
            }
		}else if(direction.equals("right")){
			if (location.getX() < 10){
				//if the obsatcle is within the egde, then move right
                this.location.setLocation(xCoord + 1, yCoord);
			}else if(location.getX() == 10){
                //if the obstacle is at the edge, then move left
                this.location.setLocation(xCoord - 1, yCoord);
            }
		}
	}
    
    public String toString(){
        return this.name + " " + this.location.getX() + " " + this.location.getY();
    }
    
    
    public static void main(String[] args){
        Obstacle o1 = new Obstacle("Obstacle1", 0, 0);
        Obstacle o2 = new Obstacle("Obstacle2", 0, 0);
        
        System.out.println(o1.toString());
        System.out.println(o2.toString());
        
        System.out.println(o1.overlapsWithObstacle(o2));
        
        for (int i = 0; i < 10; i++){
            o1.randomMove();
        }
        System.out.println(o1.toString());

    }
}
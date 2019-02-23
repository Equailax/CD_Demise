import java.awt.Rectangle;

public class Collectible
{
//Instance Variables 
	private String name;
	private int healthBoost;
	private int collection;
	private int xcoord;
	private int ycoord;
	private final int height = 1;
	private final int width = 1;
	private Rectangle location = new Rectangle(xcoord, ycoord, width, height);


//Getter Methods
/** 
This gets the name of the Collectible object
@return name
*/
	public String getName()
	{
		return new String(name);
	}
    
    public int getCollection(){
        return this.collection;
    }
	
/**
This gets the amount of health the avatar/user will get boosted by the Collectible object
@return healthBoost
*/
	public int getHealthBoost()
	{
		return new Integer(healthBoost);
	}
/**
This gets the location of the Collectible object
@return location
*/
	public Rectangle getLocation()
	{
		return new Rectangle(location);
	}
	

//Setter Methods
/**
This alters/assigns the name of the Collectible object
@param name
*/
	public void setName(String name)
	{
		this.name = new String(name);
	}

/**
This alters/assigns the amount of health the Collectible object raises for the avatar
@param healthBoost
*/
	public void setHealthBoost(int healthBoost)
	{
		this.healthBoost = new Integer(healthBoost);
	}

/**
This alters/assigns the Collectible objects location
@param location
*/
	public void setLocation(int xcoord, int ycoord)
	{
		this.location = new Rectangle(new Integer(xcoord), new Integer(ycoord), width, height);
	}
	
	
//Constructors
/**
The constructors permit the user to intiate the values of variables when creating a new Collectible object.
There is a copy constructor to copy the values of variables from one Collectible object to a new one.
The initial values are: name is "null", healthBoost is 0, and location is positioned at the origin (xcoord and ycoord are zero).

@param name  			 the name of the collectible
@param healthBoost		 the health boost the collectible would provide to the avatar
@param xcoord			 the x-coordinate of the location of the object
@param ycoord			 the y-coordinate of the location of the object
@param copy  			 collectible object used for copying variables
*/
	public Collectible()
	{	}

	public Collectible(String name, int xcoord, int ycoord)
	{
		this.name = new String(name);
		this.location = new Rectangle(new Integer(xcoord), new Integer(ycoord), width, height);
	}

	public Collectible(String name, int healthBoost, int xcoord, int ycoord)
	{
		this.name = new String(name);
		this.healthBoost = new Integer(healthBoost);
		this.location = new Rectangle(new Integer(xcoord), new Integer(ycoord), width, height);
	}
	
	public Collectible(Collectible copy)
	{
		this.name = new String(copy.name);
		this.healthBoost = new Integer(copy.healthBoost);
		this.location = new Rectangle(copy.location);
	}

//Methods
/**
This method is used to detect when the avatar has overlapped on the map with a collectible object.
This is used for the purposes of collecting/interacting with objects by the avatar/user.

@param avatar    the avatar being controlled by the user to interact with the program/game
*/
	public boolean overlapsWith(Avatar avatar)
    {
		if((avatar.getLocation().getX() == this.location.getX()) && (avatar.getLocation().getY() == this.location.getY()))
			return true;
		
		return false;
	}

/**
This method is used to count and update the amount of the Collectible object the user has collected/obtained.
This is used for gauging the progress through the stages of the game based on set completion requirements for each stage.
*/
	public void addToCollection()
	{
		this.collection += 1;
	}
   
    /**
    This is a to string method
    */
    public String toString(){
        return this.name + " " + this.location.getLocation().getX() + " " + this.location.getLocation().getY();
    }


}

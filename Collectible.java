public class Collectible
{
//Instance Variables 
	private String name;
	private int healthBoost;
	private int collection;
	private Rectangle location;


//Getter Methods
/** 
This gets the name of the Collectible object
@return name
*/
	public String getName()
	{
		return name;
	}
	
/**
This gets the amount of health the avatar/user will get boosted by the Collectible object
@return healthBoost
*/
	public int getHealthBoost()
	{
		return healthBoost;
	}
/**
This gets the location of the Collectible object
@return location
*/
	public Rectangle getLocation()
	{
		return location;
	}
	

//Setter Methods
/**
This alters/assigns the name of the Collectible object
@param name
*/
	public void setName(String name)
	{
		this.name = name;
	}

/**
This alters/assigns the amount of health the Collectible object raises for the avatar
@param healthBoost
*/
	public void setHealthBoost(int healthBoost)
	{
		this.healthBoost = healthBoost;
	}

/**
This alters/assigns the Collectible objects location
@param location
*/
	public void setLocation(Rectangle location)
	{
		this.location = location;
	}
	
	
//Constructors
/**
The constructors permit the user to intiate the values of variables when creating a new Collectible object.
There is a copy constructor to copy the values of variables from one Collectible object to a new one.
The initial values are: name is "null", healthBoost is 0, and location is an empty rectangle (all values are zero).

@param name  			 the name of the collectible
@param healthBoost		 the health boost the collectible would provide to the avatar
@param location			 the location of the object
@param copy  			 collectible object used for copying variables
*/
	public Collectible()
	{	}

	public Collectible(String name, Rectangle location)
	{
		this.name = name;
		this.location = location;
	}

	public Collectible(String name, int healthBoost, Rectangle location)
	{
		this.name = name;
		this.healthBoost = healthBoost;
		this.location = location;
	}
	
	public Collectible(Collectible copy)
	{
		this.name = copy.name;
		this.healthBoost = copy.healthBoost;
		this.location = copy.location;
	}

//Methods
/**
This method is used to detect when the avatar has overlapped on the map with a collectible object.
This is used for the purposes of collecting/interacting with objects by the avatar/user.

@param avatar    the avatar being controlled by the user to interact with the program/game
*/
	public boolean overlapsWith(Avatar avatar)
	{
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


}
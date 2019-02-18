import java.awt.Rectangle;
import java.awt.Point;
import java.lang.Math;

public class Obstacle
{
	private String name;
	private boolean isDeadly;
	private Rectangle location;
	private int health;
	
	
	/**
	Constructor methods for obstacles which include both the environment and enemies
	
	@param name is the name of the object
	@param location is a rectangle of the object's location
	@param isDeadly determines whether the object will be deadly to the user or not
	*/
	public Obstacle()
	{
	}
	
	public Obstacle(String name, Rectangle location)
	{
		this.name = name;
		this.location = new Rectangle(location);
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
	
	
	/**
	Check if the inputted avatar overlaps with the object
	
	@return boolean true or false, depending on if the avatar overlaps with the object or not
	
	public boolean overlapsWith(Avatar avatar)
	{
		if (avatar.getLocation().equals(location.getLocation()))
		{
			return true;
		} else
		{
			return false;
		}
		
	}
	*/
	
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
		if (direction.equals("up"))
		{
			if (location.y > 0)
			{
				this.location.setLocation(xCoord, yCoord-1);	
			}
		} else if (direction.equals("down"))
		{
			if (location.y < 10)
			{
				this.location.setLocation(xCoord, yCoord+1);
			}
		} else if (direction.equals("left"))
		{
			if (location.x > 0)
			{
				this.location.setLocation(xCoord-1, yCoord);
			}
		} else if (direction.equals("right"))
		{
			if (location.x < 10)
			{
				this.location.setLocation(xCoord+1, yCoord);
			}
		}
	}
	
	/**
	Randomly decide if the object should stay in place or move in a random cardinal direction
	*/
	public void randomMove()
	{
		int dirNum = (int)(Math.random() * (5-1));
		String direction = "";
		if (dirNum == 1)
		{
			direction = "up";
		} else if (dirNum == 2)
		{
			direction = "down";
		} else if (dirNum == 3)
		{
			direction = "left";
		} else if (dirNum == 4)
		{
			direction = "right";
		}
		
		System.out.println(direction);
		
		int xCoord = (int)(location.getX());
		int yCoord = (int)(location.getY());
		
		if (direction.equals("up"))
		{
			if (location.y > 0)
			{
				this.location.setLocation(xCoord, yCoord-1);	
			}
		} else if (direction.equals("down"))
		{
			if (location.y < 10)
			{
				this.location.setLocation(xCoord, yCoord+1);
			}
		} else if (direction.equals("left"))
		{
			if (location.x > 0)
			{
				this.location.setLocation(xCoord-1, yCoord);
			}
		} else if (direction.equals("right"))
		{
			if (location.x < 10)
			{
				this.location.setLocation(xCoord+1, yCoord);
			}
		}
	}
}
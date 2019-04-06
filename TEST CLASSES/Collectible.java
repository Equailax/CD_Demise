import java.awt.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import ObstaclePackage.*;
import AvatarPackage.*;
import CollectiblePackage.*;

public class Collectible
{
    //Instance Variables 
	private String name;
	private int collection;
	private int xcoord;
	private int ycoord;
	private final int height = 60;
	private final int width = 60;
	private Rectangle location = new Rectangle(xcoord, ycoord, width, height);
    private final int mapHeight = 1000;
    private final int mapWidth = 1000;

    //Image instance variables\\
    private Image collectibleImage;
    protected javafx.scene.shape.Rectangle imageRectangle = new javafx.scene.shape.Rectangle(xcoord, ycoord, height, width);

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
    This alters/assigns the Collectible objects location
    @param location
    */
	public void setLocation(int xcoord, int ycoord)
	{
		this.location = new Rectangle(new Integer(xcoord), new Integer(ycoord), width, height);
	}
        
    /**
    @param location : this is the rectangle location
    */
	public void setLocation(Rectangle locationToCopy)
	{
		this.location = new Rectangle(locationToCopy);
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
        this.collection = 0;
	}
	
	public Collectible(Collectible copy)
	{
		this.name = new String(copy.name);
		this.location = new Rectangle(copy.location);
        this.collection = copy.collection;
	}

    //Methods
    /**
    This method is used to detect when the avatar has overlapped on the map with a collectible object.
    This is used for the purposes of collecting/interacting with objects by the avatar/user.

    @param avatar    the avatar being controlled by the user to interact with the program/game
    */
	public boolean overlapsWith(Avatar avatar)
    {
		if (avatar.getLocation().intersects(this.location)){
            return true;
        } else {
            return false;
        }
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

    //Image Methods\\
    /**
     * This method returns the x position of the image layout
     * 
     * @return double
     */
    public double getXImageLayout() {
        return this.imageRectangle.getLayoutX();
    }

    /**
     * This method returns the y position of the image layout
     */
    public double getYImageLayout() {
        return this.imageRectangle.getLayoutY();
    }

    /**
     * This method sets the image of the obstacle
     */

     public void setImage(){
        if (this.name.toUpperCase().contains("COLLECTIBLE")) {
            this.collectibleImage = new Image("Record.png");
            this.imageRectangle = new javafx.scene.shape.Rectangle(this.location.getX(), this.location.getY(), 60, 60);
            this.imageRectangle.setFill(new ImagePattern(this.collectibleImage));
            this.location.setSize(60, 60);
        } else if (this.name.toUpperCase().contains("HEALTH")) {
            this.collectibleImage = new Image("LifeHeart.png");
            this.imageRectangle = new javafx.scene.shape.Rectangle(this.location.getX(), this.location.getY(), 25, 20);
            this.imageRectangle.setFill(new ImagePattern(this.collectibleImage));
            this.location.setSize(25, 20);
        }
     }

     /**
      * this method returns the rectangle of the image
      */
    public javafx.scene.shape.Rectangle getCollectibleImageRectangle() {
        return this.imageRectangle;
    }

}

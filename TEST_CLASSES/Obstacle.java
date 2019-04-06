import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Point;
import java.lang.Math;

import javafx.scene.shape.ObservableFaceArray;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import ObstaclePackage.*;
import AvatarPackage.*;
import CollectiblePackage.*;

public class Obstacle
{
	private String name;
	//private boolean isDeadly = true;
	//private int health;
	private int xcoord;
	private int ycoord;
	private int height = 54;
	private int width = 67;
	private Rectangle location = new Rectangle(xcoord, ycoord, width, height);
    
        
    ////IMAGE INSTANCE VARIABLES\\\\
    
    private Image obstacleImage;
	protected javafx.scene.shape.Rectangle imageRectangle = new javafx.scene.shape.Rectangle(xcoord, ycoord, height, width);
    private String type = "NOTSET";
	
	
	/**
	Constructor methods for obstacles which include both the environment and enemies
	
	@param name is the name of the object
	@param location is a rectangle of the object's location
	@param isDeadly determines whether the object will be deadly to the user or not
	*/
	public Obstacle(Obstacle inputObstacle){
		this.name = inputObstacle.name;
		this.location = new Rectangle(inputObstacle.location);
	
        /*
        COPY THE TYPE OF OBSTACLE 
        COPY THE IMAGE OF THE OBSTACLE AND LAYOUT LOCATION_FORWARD
        */
        
        this.type = inputObstacle.type;
        this.setImage();
        
        
    }
	
	public Obstacle(){
	}
	
	public Obstacle(String name, Rectangle location)
	{
		this.name = name;
		this.location = new Rectangle(location);
        
	}

	public Obstacle(String name, String aType, int x, int y){
		this.name = name;
        this.location.setLocation(x,y);
        
        /*
        HAVE A SET TYPE AS PARAMETER, WHICH INTURN DECIDES WHICH IMAGE TO USE
        */
        this.type = aType.toUpperCase();
        
        this.setImage();
        
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
		
        if (a.getLocation().intersects(this.location)){
            return true;
        } else {
            return false;
        }
	}
	
    /**
    This method checks wether or not the obstacle overlaps with another obstacle
    @param o : this is the obstacle that we want to check if our obsatcle overalps with it
    */
	public boolean overlapsWithObstacle(Obstacle o){
        
        if (o.getLocation().intersects(this.location)){
            return true;
        } else {
            return false;
        }
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
    
    //////IMAGE METHODS\\\\\\\
    
    /**
    This method returns the x position of the image layout
    @return double
    */
    public double getXImageLayout(){
        return this.imageRectangle.getLayoutX();
    }
    
    /**
    This method returns the y position of the image layout
    */
    public double getYImageLayout(){
        return this.imageRectangle.getLayoutY();
    }
    
    /**
    This method sets the forward image of the obstacle
    */
    public void setImageForward() {
		if(this.type.equals("DOTIFY")) {
            
			this.obstacleImage = new Image("Dotify.png");
			this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
		} else if(this.type.equals("BEATSBYDRO")) {
            
			this.obstacleImage = new Image("BeatsbyDro.png");
			this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
		} else if(this.type.equals("PEARMUSIC")) {
            
			this.obstacleImage = new Image("PearMusic.png");
			this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
		} else if(this.type.equals("MYPHONE")) {
            
			this.obstacleImage = new Image("MyPhone.png");
			this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
		} else if (this.type.equals("NOTE")) {
            
            this.obstacleImage = new Image("MusicNote.png");
            this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
        } else if (this.type.equals("PUDDLE")) {
            
            this.obstacleImage = new Image("Puddle.png");
            this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
        }
	}
    
    /**
    This method sets the backward image of the obstacle
    */
    public void setImageBackward() {
        
		if(this.type.equals("DOTIFY")) {
            
			this.obstacleImage = new Image("Dotify Backward.png");
			this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
		} else if(this.type.equals("BEATSBYDRO")) {
            
			this.obstacleImage = new Image("BeatsbyDro Backward.png");
			this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
		} else if(this.type.equals("PEARMUSIC")) {
            
			this.obstacleImage = new Image("PearMusic Backward.png");
			this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
		} else if(this.type.equals("MYPHONE")) {
            
			this.obstacleImage = new Image("MyPhone Backward.png");
			this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
		}
	}
    
    public void setImage() {
        if(this.type.equals("DOTIFY")) {
            
            this.obstacleImage = new Image("Dotify.png");
            this.imageRectangle = new javafx.scene.shape.Rectangle(this.location.getX(), this.location.getY(), 54, 67);
            this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
            this.location.setSize(54, 67);
        
        } else if(this.type.equals("BEATSBYDRO")) {
            
            this.obstacleImage = new Image("BeatsbyDro.png");
            this.imageRectangle = new javafx.scene.shape.Rectangle(this.location.getX(), this.location.getY(), 37, 67);
            this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
            this.location.setSize(37, 67);
        
        } else if(this.type.equals("PEARMUSIC")) {
            
            this.obstacleImage = new Image("PearMusic.png");
            this.imageRectangle = new javafx.scene.shape.Rectangle(this.location.getX(), this.location.getY(), 40, 67);
            this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
            this.location.setSize(40, 67);
        
        } else if(this.type.equals("MYPHONE")) {
            
            this.obstacleImage = new Image("MyPhone.png");
            this.imageRectangle = new javafx.scene.shape.Rectangle(this.location.getX(), this.location.getY(), 40, 67);
            this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
            this.location.setSize(40, 67);
            
        } else if (this.type.equals("NOTE")) {
            
            this.obstacleImage = new Image("MusicNote.png");
            this.imageRectangle = new javafx.scene.shape.Rectangle(this.location.getX()+14, this.location.getY()+17, 22, 37);
            this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
            this.location.setSize(22, 37);
            
        } else if (this.type.equals("PUDDLE")) {
            
            this.obstacleImage = new Image("Puddle.png");
            this.imageRectangle = new javafx.scene.shape.Rectangle(this.location.getX(), this.location.getY(), 60 , 60);
            this.imageRectangle.setFill(new ImagePattern(this.obstacleImage));
            
            this.location.setSize(60, 60);
            
        }
    }
    
    /**
    This returns the image location of the obstacle
    @return javafx.scene.shape.Rectangle
    */
    public javafx.scene.shape.Rectangle getEnemyImageRectangle() {
        return this.imageRectangle;
    }
    
    /**
    This sets the type of the obstacle, which then subsequently changes the image as well
    @param aType : this is the type we wish to set the obstacle to
    */
    public void setType(String aType) {
        if (aType != null) {
            this.type = aType.toUpperCase();
        }
        this.setImage();
    }
    
    /**
    This method gets the type of the obstacle
    @return String
    */
    public String getType() {
        return this.type;
    }
    
    
    public static void main(String[] args){
        /*
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
         */
         
        Obstacle o = new Obstacle("Obstacle1", "dotify", 0, 0);
        System.out.println(o);

    }
}
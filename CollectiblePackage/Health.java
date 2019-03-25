import java.awt.Rectangle;
import java.util.ArrayList;
import java.lang.Math;

import ObstaclePackage.*;
import AvatarPackage.*;
import CollectiblePackage.*;

public class Health extends Collectible
{
//Instance Variables 
	private int healthBoost;

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
	public Health(){	
        super();
        this.healthBoost = 1;
    }

	public Health(String name, int aHealthBoost,int xcoord, int ycoord)
	{
		super.setName(name);
		super.setLocation(xcoord, ycoord);
        this.healthBoost = aHealthBoost;
	}
	
	public Health(Health healthToCopy)
	{
		super(healthToCopy);
        //super.setName(healthToCopy.getName());
		this.healthBoost = healthToCopy.getHealthBoost();
		//super.setLocation(healthToCopy.getLocation());
	}


    //Getter Methods
    /**
    This gets the amount of health the avatar/user will get boosted by the Collectible object
    @return healthBoost
    */
	public int getHealthBoost()
	{
		return this.healthBoost;
	}

    //Setter Methods
    /**
    This alters/assigns the amount of health the Health object raises for the avatar
    @param healthBoost
    */
	public void setHealthBoost(int healthBoost)
	{
		this.healthBoost = healthBoost;
	}
    
    //Methods
    /**
    This method is used to detect when the avatar has overlapped on the map with a health object.
    This is used for the purposes of collecting/interacting with objects by the avatar/user.
    If the avatar is overlapping with the health collectibles, then it will add the healthBoost of the health object
    to the health of the avatar

    @param avatar    the avatar being controlled by the user to interact with the program/game
    */
	public boolean overlapsWith(Avatar avatar)
    {
		if((avatar.getLocation().getX() == this.getLocation().getX()) && (avatar.getLocation().getY() == this.getLocation().getY())){
			avatar.gainHealth(this.healthBoost);
            return true;
        }else {
            return false;
        }

	}
    
    /**
    This is the toString method for the Health class
    @return String
    */
    public String toString(){
        return super.toString() + " Health Boost: " + this.getHealthBoost();
    }
    
	
    public static void main(String[] args){
        Health h = new Health();
        Avatar a = new Avatar();
        
        System.out.println(h.toString());
        
        ArrayList<Health> aH = new ArrayList<Health>();
        
        for (int i = 0; i < 3; i++){
            int x = (int)(Math.random() * 10 + 0);
            int y = (int)(Math.random() * 10 + 0);
            aH.add(new Health("Health" + i, 1, x, y));
        }
        
        System.out.println(aH);
        
        System.out.println(h.overlapsWith(a));
    
        h.setName("Original Health");
        h.setLocation(0,0);
        Health copyOhH = new Health(h);
        
        System.out.println(copyOhH);
        System.out.println(copyOhH.overlapsWith(a));
    }
    

}
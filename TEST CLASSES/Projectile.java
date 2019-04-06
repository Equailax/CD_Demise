import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.Point;
import java.lang.Math;

import ObstaclePackage.*;
import AvatarPackage.*;
import CollectiblePackage.*;

public class Projectile extends Obstacle{
    
    //Instance variables
    private boolean isDeadlyToAvatar = false;
    private boolean isDeadlyToEnemy = false;
    private boolean isShot = false;
    private String direction = "NONE";
    
    private final int mapHeight = 1000;
    private final int mapWidth = 1000;
    
    //Constructors
    public Projectile(){}
    
    public Projectile(String name, String type, boolean deadlyToAvatar, boolean deadlyToEnemy, String aDirection){
        super.setName(name);
        super.setType(type);
        this.isDeadlyToAvatar = deadlyToAvatar;
        this.isDeadlyToEnemy = deadlyToEnemy;
        this.isShot = false;
        this.direction = aDirection.toUpperCase();
    }
    
    public Projectile(Projectile projectileToCopy){
        super(projectileToCopy);
        this.isDeadlyToAvatar = projectileToCopy.getDeadlyToAvatar();
        this.isDeadlyToEnemy = projectileToCopy.getDeadlyToEnemy();
        this.isShot = projectileToCopy.getIsShot();
        this.direction = projectileToCopy.getDirection();
    }
    
    //Getter methods
    /**
    This method gets the isDeadlyToAvatar instance variable
    @return boolean
    */
    public boolean getDeadlyToAvatar(){
        return this.isDeadlyToAvatar;
    }
    
    /**
    This method gets the isDeadlyToEnemy instance variable
    @return boolean
    */
    public boolean getDeadlyToEnemy(){
        return this.isDeadlyToEnemy;
    }
    
    /**
    This method returns the isShot instance variable
    */
    public boolean getIsShot(){
        return this.isShot;
    }
    
    /**
    This method returns the direction that the projectile will be going
    @return String
    */
    public String getDirection(){
        return this.direction;
    }
    
    //Setter methods
    /**
    This sets wether or not the projectile is deadly to the avatar
    @param deadlyToAvatar : it is either deadly to the avatar (true) or not deadly (false)
    */
    public void setIsDeadlyToAvatar(boolean deadlyToAvatar){
        this.isDeadlyToAvatar = deadlyToAvatar;
    }
    
    /**
    This sets wether or not the porjectile is deadly to the enemy
    @param deadlyToEnemy : it is either deadly to the enemy (true) or not deadly (false)
    */
    public void setIsDeadlyToEnemy(boolean deadlyToEnemy){
        this.isDeadlyToEnemy = deadlyToEnemy;
    }
    
    /**
    This sets wether or not the projectile is shot 
    @param shot : it is either shot (true) or not shot (flase)
    */
    public void setIsShot(boolean shot){
        this.isShot = shot;
    }
    
    /**
    This method sets the directione of the projectile
    @param directionToShoot : this is the direction that we want to shoot the projectile to
    */
    public void setDirection(String directionToShoot) {
        directionToShoot.toUpperCase();
        this.direction = directionToShoot;
    }
    
    /**
    This method is the move method for the projectile.  It takes in a string input for the direction that the avatar/enemy is facing
    @param direction : this is the direction that we wish to shoot the projectile
    */
    
	public void move()                                                         // Projectile still bounces
	{
		this.direction = this.direction.toUpperCase();

		int xCoord = (int)(this.getLocation().getX());
		int yCoord = (int)(this.getLocation().getY());
		
		int xChange = 0;
		int yChange = 0;
		
        if (this.direction.contains("UP")){
			if (this.getLocation().getY() > 60){
                //if the proejectile is within the edge, then move up
				yChange = -10; 
			} else if (this.getLocation().getY() <= 60) {
                //Move the proejectile in a random direction once it has hit a boundary
                yChange = 10;
				this.direction = this.direction.replace("UP", "DOWN"); // Bounce
                
                
                //Change also the x position
                if (this.direction.contains("LEFT")) {
                    xChange = 10;
                    this.direction = this.direction.replace("LEFT", "RIGHT"); //Bounce 
                } else if (this.direction.contains("RIGHT")) {
                    xChange = -10;
                    this.direction = this.direction.replace("RIGHT", "LEFT");
                }
                

                
            }
		} else if(this.direction.contains("DOWN")){
			if (this.getLocation().getY() < 630){
                //if the projectile is within the edge, then move down
				yChange = 10;
            } else if (this.getLocation().getY() >= 630) {
                //Move the enemy in a random direction once it has hit a boundary
                yChange = -10;
                this.direction = this.direction.replace("DOWN", "UP"); // Bounce
                
                
                //Change also the x position
                if (this.direction.contains("LEFT")) {
                    xChange = 10;
                    this.direction = this.direction.replace("LEFT", "RIGHT"); //Bounce 
                } else if (this.direction.contains("RIGHT")) {
                    xChange = -10;
                    this.direction = this.direction.replace("RIGHT", "LEFT");
                }
                
                
            }
		} 
        if (this.direction.contains("LEFT")){
			if (this.getLocation().getX() > 90){
                //if the preojectile is within the edge, then move left
				xChange = -10;
            } else if (this.getLocation().getX() <= 90) {
                //Move the proejectile in a random direction once it has hit a boundary
                xChange = 10;
				this.direction = this.direction.replace("LEFT", "RIGHT"); // Bounce
                
                
                //Change also the y position
                if (this.direction.contains("UP")) {
                    yChange = 10;
                    this.direction = this.direction.replace("UP", "DOWN"); //Bounce 
                } else if (this.direction.contains("DOWN")) {
                    yChange = -10;
                    this.direction = this.direction.replace("DOWN", "UP");
                }
                
                
            }
		}else if(this.direction.contains("RIGHT")){
			if (this.getLocation().getX() < (872)){
				//if the projectile is within the egde, then move right
				xChange = 10;
            } else if (this.getLocation().getX() >= (872)) {
                //Move the projectile in a random direction once it has hit a boundary
                xChange = -10;
				this.direction = this.direction.replace("RIGHT", "LEFT"); // Bounce
                
                
                if (this.direction.contains("UP")) {
                    yChange = 10;
                    this.direction = this.direction.replace("UP", "DOWN"); //Bounce 
                } else if (this.direction.contains("DOWN")) {
                    yChange = -10;
                    this.direction = this.direction.replace("DOWN", "UP");
                }
                
            
            }
		}
		
		super.setLocation(xCoord + xChange, yCoord + yChange);	 
	}
    
    /**
    This is the toString method for the projectile clasee, it displays the name, position, and wether
    it is deadly to the avatar or deadly to the enemy
    */
    public String toString(){
        if (this.isShot == true){
            if(this.isDeadlyToAvatar == true){
                return super.toString() + " Is deadly to Avatar" + " and is Shot" + this.direction; 
            }else if (this.isDeadlyToEnemy == true){
                return super.toString() + " Is deadly to Enemy" + " and is Shot" + this.direction;
            }else {
                return super.toString() + " is Shot";
            }
        }else if (this.isShot == false){
            if(this.isDeadlyToAvatar == true){
                return super.toString() + " Is deadly to Avatar" + this.direction; 
            }else if (this.isDeadlyToEnemy == true){
                return super.toString() + " Is deadly to Enemy" + this.direction;
            }else {
                return super.toString();
            }
        }else {
            return super.toString();
        }
    }
    
    public static void main(String[] args){
		/*
        Projectile p = new Projectile();
        Enemy e = new Enemy();
        Avatar a = new Avatar();
        
        a.setName("Avatar");
        
        e.setName("Enemy");
        
        e.setLocation(0,0);
        
        p.setName("Projectile1");
        
        p.setIsDeadlyToEnemy(false);
        p.setIsDeadlyToAvatar(true);
        
        System.out.println(p);
        System.out.println(p.overlapsWith(a));
        System.out.println(p.overlapsWithObstacle(e));
        
        a.setHealth(3);
        System.out.println(a);
        
        if (p.overlapsWith(a) && p.getDeadlyToAvatar()){
            //Avatar take damage
            a.takeDamage(1);
        }
        System.out.println(a);
        
        e.setHealth(3);
        System.out.println(e);
        if (p.overlapsWithObstacle(e) && p.getDeadlyToEnemy()){
            //Enemy take damage
            e.takeDamage(1);
        }
        System.out.println(e);
        
        p.move();
        System.out.println(p);
        
        ArrayList<Obstacle> obstacleArray = new ArrayList<Obstacle>();
        obstacleArray.add(p);
        System.out.println(p);
        */
		
		// Diagonal Movement Test
		Projectile p = new Projectile("Projectile", "note",false, true, "UP LEFT");
		p.setLocation(100, 100);
		System.out.println(p);
		/*
		for (int i=0; i<10; i++)
		{
			p.move();
			System.out.println(p);
		}
		p.setDirection("UP RIGHT");
		p.move();
		System.out.println(p);
		
		p.setDirection("UP LEFT");
		p.move();
		System.out.println(p);
		*/
		p.move();
		System.out.println(p);
		
    }
    
}
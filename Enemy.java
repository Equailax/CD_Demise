import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.Point;
import java.lang.Math;

import javafx.scene.shape.ObservableFaceArray;

public class Enemy extends Obstacle
{
	private boolean isDeadly = true;
	private int health = 0;
    private Projectile note = new Projectile("Enemy's Note", true, false, "NONE");
    
    private final int mapHeight = 650;
    private final int mapWidth = 780;
	
	
	/**
	Constructor methods for obstacles which include both the environment and enemies
	
	@param name is the name of the object
	@param location is a rectangle of the object's location
	@param isDeadly determines whether the object will be deadly to the user or not
	*/
	public Enemy(Enemy inputEnemy){
		super(inputEnemy);
        
        //super.setName(inputEnemy.getName());
		this.isDeadly = inputEnemy.isDeadly;
		//super.setLocation(inputEnemy.getLocation());
		this.health = inputEnemy.health;
	}
	
	public Enemy(){
	}
	
	public Enemy(String name, Rectangle location)
	{
		super.setName(name);
		super.setLocation(location);
	}

	public Enemy(String name, int aHealth ,int x, int y){
		super.setName(name);
        super.setLocation(x, y);
        this.health = aHealth;
	}
    
    //Getter methods
	/**
	Get whether the object is deadly to the user or not
	
	@return isDeadly
	*/
	public boolean getIsDeadly()
	{
		return isDeadly;
	}
    
    /**
    Get the health of the enemy
    */
    public int getHealth(){
        return this.health;
    }
    
    /**
    Gets the projectile for the enemy
    */
    public Projectile getProjectile(){
        return new Projectile(this.note);
    }
    
    //Setter methdos
    /**
    This sets wether or not the enemy is deadly
    @param deadly : this is a boolean value
    */
    public void setIsDeadly(boolean deadly){
        this.isDeadly = deadly;
    }
    /**
    This method sets the health of the enemy
    @param health : the health that we wish to set the enemy to
    */
    public void setHealth(int health){
        this.health = health;
    }
    
	
	/**
	If the enemy got hit, reduce the health by the damge taken
    @param damageTaken : this is the damage taken by the enemy
	*/
	public void takeDamage(int damageTaken)
	{
		this.health -= damageTaken;
	}
    
    /**
    This is one of the movement methods that moves the location of the enemy a set amount, in the x-axis.  The parameter is a positive or negative integer value.
    The sign of the movement determines which direction the enemy will move.  It also checks if the movement is valid (ie withing bounds)
    @param movement : this is a negative or positive integer value.  If the value is negative, the enemy will move left, if its positive, the enemy
                      will move right.
    */
    public void moveX(int movement){
        this.setLocation((int)(this.getLocation().getX() + movement), (int)this.getLocation().getY());
    }
    
    /**
    This is one of the movement methods that moves the location of the enemy a set amount, in the y-axis.  The parameter is a positive or negative integer value.
    The sign of the movement determines which direction the enemy will move.  It also checks if the movement is valid (ie withing bounds)
    @param movement : this is a negative or positive integer value.  If the value is negative, the enemy will move up, if its positive, the enemy
                      will move down.
    */
    public void moveY(int movement){
        this.setLocation((int)this.getLocation().getX(), (int)(this.getLocation().getY() + movement));
    }
	
	/**
	Move the enemy in a defined direction
	@param direction is the direction to move the enemy in (up, down, left, right, otherwise the object won't move)
	*/
	public void move(String direction)
	{
		direction = direction.toLowerCase();
		System.out.println(direction);
		int xCoord = (int)(this.getLocation().getX());
		int yCoord = (int)(this.getLocation().getY());
		if(direction.equals("up")){
			if (this.getLocation().getY() > 0){
                //if the obstacle is within the edge, then move up
				super.setLocation(xCoord, yCoord - 1);	
			}else if(this.getLocation().getY() == 0 ){
                //If the obstacle is at the edge, have the obstacle bounce away from it
                super.setLocation(xCoord, yCoord + 1);
            }
		} else if(direction.equals("down")){
			if (this.getLocation().getY() < mapHeight){
                //if the obstcle is within the edge, then move down
				super.setLocation(xCoord, yCoord + 1);
			}else if(this.getLocation().getY() == mapHeight){
                //if the obstacle is at the edge, then move up
                super.setLocation(xCoord, yCoord - 1);
            }
		} else if(direction.equals("left")){
			if (this.getLocation().getX() > 0){
                //if the obstacle is within the edge, then move left
				super.setLocation(xCoord - 1, yCoord);
			}else if(this.getLocation().getX() == 0){
                //if the obstacle is at the edge, then move right
                super.setLocation(xCoord + 1, yCoord);
            }
		}else if(direction.equals("right")){
			if (this.getLocation().getX() < mapWidth){
				//if the obsatcle is within the egde, then move right
                super.setLocation(xCoord + 1, yCoord);
			}else if(this.getLocation().getX() == mapWidth){
                //if the obstacle is at the edge, then move left
                super.setLocation(xCoord - 1, yCoord);
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
		
		int xCoord = (int)(this.getLocation().getX());
		int yCoord = (int)(this.getLocation().getY());
		
		if(direction.equals("up")){
			if (this.getLocation().getY() > 0){
                //if the obstacle is within the edge, then move up
				super.setLocation(xCoord, yCoord - 1);	
			}else if(this.getLocation().getY() == 0 ){
                //If the obstacle is at the edge, have the obstacle bounce away from it
                super.setLocation(xCoord, yCoord + 1);
            }
		} else if(direction.equals("down")){
			if (this.getLocation().getY() < mapHeight){
                //if the obstcle is within the edge, then move down
				super.setLocation(xCoord, yCoord + 1);
			}else if(this.getLocation().getY() == mapHeight){
                //if the obstacle is at the edge, then move up
                super.setLocation(xCoord, yCoord - 1);
            }
		} else if(direction.equals("left")){
			if (this.getLocation().getX() > 0){
                //if the obstacle is within the edge, then move left
				super.setLocation(xCoord - 1, yCoord);
			}else if(this.getLocation().getX() == 0){
                //if the obstacle is at the edge, then move right
                super.setLocation(xCoord + 1, yCoord);
            }
		}else if(direction.equals("right")){
			if (this.getLocation().getX() < mapWidth){
				//if the obsatcle is within the egde, then move right
                super.setLocation(xCoord + 1, yCoord);
			}else if(this.getLocation().getX() == mapWidth){
                //if the obstacle is at the edge, then move left
                super.setLocation(xCoord - 1, yCoord);
            }
		}
	}
    
    public String toString(){
        return this.getName() + " Location: " + this.getLocation().getX() + " " + this.getLocation().getY() + " Health: " + this.health;
    }
    
    /**
    This mehod shoots a projectile in the direction that the enemy is facing
    */
    public void shootProjectile(){
        
    }
    
    public static void main(String[] args){
        Enemy e = new Enemy();
        Avatar a = new Avatar();
        
        System.out.println(e);
        
        ArrayList<Enemy> aE = new ArrayList<Enemy>();
        
        for (int i = 0; i < 3; i++){
            int x = (int)(Math.random() * 10 + 0);
            int y = (int)(Math.random() * 10 + 0);
            aE.add(new Enemy("Enemy" + i, 3, x, y));
        }
        
        System.out.println(aE);
        System.out.println(e.overlapsWith(a));
        
        for (Enemy e1 : aE){
            e1.randomMove();
        }
        System.out.println(aE);
        
        e.setName("Original Enemy");
        e.setLocation(0,0);
        
        Enemy copyOfEnemy = new Enemy(e);
        
        System.out.println(copyOfEnemy);
        System.out.println(copyOfEnemy.overlapsWith(a));
        
        ArrayList<Obstacle> obstacleArray = new ArrayList<Obstacle>();
        obstacleArray.add(e);
        System.out.println(e);
        
        obstacleArray.add(new Obstacle("Obstacle 1", 0, 0));
        obstacleArray.add(new Obstacle("Obstacle 2", 0, 0));
        obstacleArray.add(new Obstacle("Obstacle 3", 0, 0));
        obstacleArray.add(new Enemy("Enemy 2", 3, 0, 0));
        obstacleArray.add(new Projectile("Projectile 1", true, false, "NONE"));
        
        ArrayList<Obstacle> temp = new ArrayList<Obstacle>();
        for (Obstacle o : obstacleArray){
            if (o instanceof Enemy){
                temp.add(new Enemy((Enemy)o));
            }else if (o instanceof Projectile){
                temp.add(new Projectile((Projectile)o));
            }else if (o instanceof Obstacle){
                temp.add(new Obstacle(o));
            }
        }
        System.out.println(obstacleArray);
        System.out.println(temp);
        
        Enemy newEnemy = new Enemy((Enemy)temp.get(0));
        System.out.println(newEnemy);
    }
    
}
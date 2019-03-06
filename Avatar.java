import java.util.Scanner;
import java.awt.Rectangle;

    // i have not consider the privacy leaks in this file 
    // variables 
public class Avatar{
    private String name;
    private int health;
    private int lives;
    private int xposition;
    private int yposition;
    private final int width = 1;
    private final int height = 1;
    private int damage;
    private Rectangle location = new Rectangle(xposition, yposition, width, height);
    private Projectile note = new Projectile("Avatar's Note", false, true);

    // getter methods 
    /**
    This method gets the name for the avatar
    @return name
    */
    public String getName(){
        return name;
    }
    
    /**
    This method gets the health for the avatar
    @return health
    */
    public int getHealth(){
        return health;
    }
    
    /**
    This method gets the lives for the avatar
    @return lives
    */
    public int getLives(){
        return lives;
    }

    /**
    This method gets the damage for the avatar
    @return damage
    */
    public int getDamage(){
        return damage;
    }

    /**
    This method gets the location for the avatar
    @return location
    */
    public Rectangle getLocation(){
        return new Rectangle(this.location);
    }
    
    /**
    This method gets the projectile for the avatar
    @return projectile
    */
    public Projectile getProjectile(){
        return new Projectile(this.note);
    } 
    
    // setter 
    /**
    This sets the name for the avatar
    @param name : this is the name that we wish to change to
    */
    public void setName(String Name){
        this.name = Name;
    }
    
    /**
    This sets the health for the avatar
    @param characterHealth : this is the health that we wish to change to
    */
    public void setHealth(int characterHealth){
        this.health = characterHealth;

    }
    
    /**
    This sets the lives for the avatar
    @param characterLives : this is the lives that we wish to change to
    */
    public void setLives(int characterLives){
        this.lives = characterLives;
        
    }
    
    //public void setProjectile(){}

    public void setPosition(){
        this.location.x = 0;
        this.location.y = 0;
    }
    public void setDamage(int characterDamage){
        if (characterDamage > 0){
            this.damage =  characterDamage;
        }
    }
    // Methods 
    // movements for integer inputs
    /*
    Update these methods
    */
    public void moveUp(int movementUp){
        this.yposition -= movementUp;
    }
    public void moveDown(int movementDown){
        this.yposition += movementDown;
    }
    public void moveRight(int movementRight){
        this.xposition += movementRight;
    }
    public void moveLeft(int movementLeft){
        this.xposition -= movementLeft;
    }

    public void takeDamage(int damage){
        this.health -= damage;
        //print out 'taken damage'
        System.out.println("OUCH! I have taken damage");
    }

    public void gainHealth(int boost){
        this.health += boost;
        //print out 'i picked up health'
        System.out.println("I have picked up " + boost + " health!");
    }
    
    //Movment for a string inputs
    public void move(String direction){
        
        direction = direction.toLowerCase();
        
        int xCoord = (int)(this.location.getX());
		int yCoord = (int)(this.location.getY());
        
        if(direction.equals("up")){
			if (this.location.getY() > 0){
                //if the avatar is within the edge, then move up
				this.location.setLocation(xCoord, yCoord - 1);	
			}else if(this.location.getY() == 0 ){
                System.out.println("Cant go there, im at the edge");
            }
		} else if(direction.equals("down")){
			if (this.location.getY() < 10){
                //if the avatar is within the edge, then move down
				this.location.setLocation(xCoord, yCoord + 1);
			}else if(this.location.getY() == 10){
                System.out.println("Cant go there, im at the edge");
            }
		} else if(direction.equals("left")){
			if (this.location.getX() > 0){
                //if the avatar is within the edge, then move left
				this.location.setLocation(xCoord - 1, yCoord);
			}else if(this.location.getX() == 0){
                System.out.println("Cant go there, im at the edge");
            }
		}else if(direction.equals("right")){
			if (this.location.getX() < 10){
				//if the avatar is within the egde, then move right
                this.location.setLocation(xCoord + 1, yCoord);
			}else if(this.location.getX() == 10){
                System.out.println("Cant go there, im at the edge");
            }
		}
    }
    
    /**
    This method is the toString method for the avatar
    @return String
    */
    public String toString(){
        return this.name + " Position: " + this.location.getLocation().getX() + " " + this.location.getLocation().getY() + " Health: " + this.health + " Lives: " + this.lives;
    }
    
    /**
    This method shoots the projectile note
    */
    public void shootProjectile(){
    }
    
    /**
    This method checks if the health of the avatar.  It would do nothing if the health is above 0.  Once it is below 0
    the avatar would reset to it original health, and it would lose a life.  If the avatar ran out of lives, it would return true (end of game)
    */
    public boolean checkIfEndGame(int originalHealth){
        if (this.health > 0){
            //If the health is above 0, the end game hasnt reached yet
            return false;
        }else {
            //if the live is greater than 0, then the end game hasnt reached, only has lost a life and has reset the health
            if (this.lives > 0){
                System.out.println("O-Oh, I have ran out of health!");
                System.out.println("Lost 1 Life");
                this.lives -= 1;
                this.health = originalHealth;
                return false;
            }else {
                //If the lives is 0 or below, then we have reached the end game, so the health is not reset and the lives is not taken
                return true;
            }
        }
    }
    
    //health
    public void avatarHealth(int myhealth){
        this.health = 10;
        if ((myhealth - damage) > 0){ // need to tell when to subtract 1, this is incomplete
            this.health -= 1;
        }
    }
    // lives 
    public void avatarLives (int myLife){
        this.lives = 3;
        if (this.health == 0) {
            this.lives -= 1;
        }
    }

    // there is no method for damage in this file 

    // constructors 
    // default 
    public Avatar(){

    }
    public Avatar(String myName, int myLife, int myhealth, int myDamage, Rectangle location){
        this.name = myName;
        this.lives = myLife;
        this.health = myhealth;
        this.location = new Rectangle(location);
        this.damage = myDamage;
        
    }
    public Avatar(Avatar inputAvatar){
        this.name = inputAvatar.name;
        this.lives = inputAvatar.lives;
        this.health = inputAvatar.health;
        this.damage = inputAvatar.damage;
        this.location = new Rectangle(inputAvatar.location);
        
    }
         
}
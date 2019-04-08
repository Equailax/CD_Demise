import java.util.Scanner;
import java.awt.Rectangle;



    // i have not consider the privacy leaks in this file 
    // variables 
public class Avatar{
    private String name;
    private int health;
    private int lives;
    private int xposition = 100;
    private int yposition = 100;
    private final int width = 54;
    private final int height = 67;
    private int damage;
    private Rectangle location = new Rectangle(xposition, yposition, width, height);
    private Projectile note = new Projectile("Avatar's Note", "note",false, true, "NONE");
    
    private final int mapHeight = 1000;
    private final int mapWidth = 1000;


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
    
    /**
    This method sets the proejectile note for the avtar
    @param projecitleNote : this is the projectile that we wish to set the note to
    */
    public void setProjectile(Projectile projecitleNote){
        this.note = new Projectile(projecitleNote);
        this.note.setLocation(new Rectangle(this.location));
    }
    
    /**
    This method sets the location of the avatar to a specific place
    @param xcoord : this is the xcoordinate of the location that we want the avatar to move
    @param ycoord : this is the ycoordinate of the location that we want the avatar to move to
    */
    public void setLocation(int xcoord, int ycoord){
        this.location.setLocation(xcoord, ycoord);
    }
    
    public void setPosition(){
        this.location.x = 0;
        this.location.y = 0;
    }
    public void setDamage(int characterDamage){
        if (characterDamage > 0){
            this.damage =  characterDamage;
        }
    }
    
    /**
    This is one of the movement methods that moves the location of the avatar a set amount, in the x-axis.  The parameter is a positive or negative integer value.
    The sign of the movement determines which direction the avatar will move.  It also checks if the movement is valid (ie withing bounds)
    @param movement : this is a negative or positive integer value.  If the value is negative, the avatar will move left, if its positive, the avatar
                      will move right.
    */
    public void moveX(int movement){
        this.location.setLocation((int)(this.location.getX() + movement), (int)this.location.getY());
    }
    
    /**
    This is one of the movement methods that moves the location of the avatar a set amount, in the y-axis.  The parameter is a positive or negative integer value.
    The sign of the movement determines which direction the avatar will move.  It also checks if the movement is valid (ie withing bounds)
    @param movement : this is a negative or positive integer value.  If the value is negative, the avatar will move up, if its positive, the avatar
                      will move down.
    */
    public void moveY(int movement){
        this.location.setLocation((int)this.location.getX(), (int)(this.location.getY() + movement));
    }
    
    /**
    This is the take damage method where the avatar will take a specified amount of damage to their health
    @param damage : this is the damage that we want the avatar to take
    */
    public void takeDamage(int damage){
        this.health -= damage;
        //print out 'taken damage'
        System.out.println("OUCH! I have taken damage");
    }
    
    /**
    The gain health method adds a specified amount of health to the avatar
    @param boost : this is the amount of health that we want the avatar to gain
    */
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
			if (this.location.getY() > 100){
                //if the avatar is within the edge, then move up	
                this.moveY(-4);
			}else if(this.location.getY() == 100){
                System.out.println("Cant go there, im at the edge");
            }
		} else if(direction.equals("down")){
			if (this.location.getY() < 575){
                //if the avatar is within the edge, then move down
                this.moveY(4);
			}else if(this.location.getY() == 575){
                System.out.println("Cant go there, im at the edge");
            }
		} else if(direction.equals("left")){
			if (this.location.getX() > 100){
                //if the avatar is within the edge, then move left
                this.moveX(-4);
                
                //this.setBackward();
                
			}else if(this.location.getX() == 100){
                System.out.println("Cant go there, im at the edge");
            }
		}else if(direction.equals("right")){
			if (this.location.getX() < (852)){
				//if the avatar is within the egde, then move right
                //this.location.setLocation(xCoord + 1, yCoord);
                this.moveX(4);
                
                //this.setForward();
                
			}else if(this.location.getX() == (852)){
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
    This method shoots the projectile note in a specified direction (can be updated so that it shoots to wherever
    the mouse is pointing)
    @param directionToShoot : this is the direction that we want to shoot the projecitle
    */
    public void shootProjectile(String directionToShoot){
        this.setProjectile(new Projectile(this.getProjectile().getName(), "note",this.getProjectile().getDeadlyToAvatar(), this.getProjectile().getDeadlyToEnemy(), directionToShoot));
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
    
    /**
    This method checks if two avatars have equal position
    @return boolean
    */
    public boolean equals(Avatar a1){
        if (this.location.equals(a1.getLocation())){
            return true;
        }else {
            return false;
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
        
        this.note.setLocation(new Rectangle(this.location));
        
        
               
    }
    public Avatar(Avatar inputAvatar){
        this.name = inputAvatar.name;
        this.lives = inputAvatar.lives;
        this.health = inputAvatar.health;
        this.damage = inputAvatar.damage;
        this.location = new Rectangle(inputAvatar.location);
        this.note = new Projectile(inputAvatar.note);
    }
    
}
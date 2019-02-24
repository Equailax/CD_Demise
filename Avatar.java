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

    // getter methods 
    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public int getLives(){
        return lives;
    }

    public int getDamage(){
        return damage;
    }

    public Rectangle getLocation(){
        return new Rectangle(this.location);
    }
    
    // setter 
    public void setName(String Name){
        this.name = Name;
    }

    public void setHealth(int characterHealth){
        this.health = characterHealth;

    }
    public void setLives(int characterLives){
        this.lives = characterLives;
        
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
    // Methods 
    // movements for integer inputs
    
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
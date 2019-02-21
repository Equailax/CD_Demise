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

    public int getXPosition(){
        return xposition;
    }

    public int getYPosition(){
        return yposition;
    }

    public int getDamage(){
        return damage;
    }

    public Rectangle getLocation(){
        return location;
    }
    
    // setter 
    public void setName(String Name){
        this.name = Name;
    }

    public void setHealth(int characterHealth){
        if (characterHealth  > 0){
            this.health = characterHealth;
        }
    }
    public void setLives(int characterLives){
        if ( characterLives <= 0){
            this.lives = characterLives;
        }
    }

    public void setXPosition(int xaxis){
        if (xaxis > 0 ){
            this.xposition = xaxis;
        }
    }
    public void setYPosition(int yaxis){
        if (yaxis > 0){
            this.yposition = yaxis;
        }
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
    }

    public void gainHealth(int boost){
        this.health += boost;
    }
    
    //Movment for a string inputs
    public void move(String direction){
        if (direction.toLowerCase().equals("up")){
            this.yposition += 1;                    //***** check if its within bounds
        }else if (direction.toLowerCase().equals("down")){
            this.yposition -= 1;
        }else if (direction.toLowerCase().equals("left")){
            this.xposition -= 1;
        }else if (direction.toLowerCase().equals("right")){
            this.xposition -= 1;
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
        this.location = location;
        this.damage = myDamage;
        
    }
    public Avatar(Avatar a){
        this.name = a.name;
        this.lives = a.lives;
        this.health = a.health;
        this.damage = a.damage;
        this.location = a.location;
        
    }
         
}
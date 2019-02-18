import java.util.ArrayList;
import java.util.Scanner;


public class AnimationApp{
    //This is the animation app, where we will run our game.
    
    /*
    Interact with the human player to ask it for a move.
    Move the avatar as specified
    Check if any obstacles are hit.  If so react appropriately.
    Check if any collectibles have been reached.  If so, react appropriately.
    Move any collectibles that are movable.
    */
    /*
    Ostacle Class
    Variables
        -name: String           
        -isDeadly: boolean
        -location: Rectangle
        -health: int

    Methods
        +getLocation(): Rectangle - Return the location
        +getName(): String - Return the obstacle name
		+getIsDeadly(): Boolean - Return if the obstacle/deadly or not
        +enemyHit() - Reduce health by 1
        +move(direction:String) - Move in the direction
		+randomMove() - Move in a random direction or stay still
    */
    /*
    Avatar
    Variables:
        -String Name; - Name of the Avatar.
        -Image Skin; - What the Avatar will look like.
        -Int Health; - How many health points the Avatar can lose at a maximum in a life.
        -Int Lives; - How many times the Avatar can respawn without the game ending. 
        -Int x-position; - Within the Rectangle class, x-coordinate.
        -Int y-position; - Within the Rectangle class, y-coordinate. 
        -Int Damage; - How much damage the Avatar can output.

    Methods:
        -Move(String value): will take a String value as a parameter and will move in the direction given. Can either be Up, Down, Left or Right and will only work if that specific move if possible. (Can’t move past boundaries.)
        -updateHealth(Int value): will take an Int value as a parameter and will change the health of the Avatar to the value given. 
        -getLocation(Rectangle value): will take a Rectangle object from the Rectangle class as a parameter. This is a getter method so it will return the location of the avatar in the given Rectangle object. 
        -shoot(String value): The string value in the parameter will be the direction for where the shot will go. 
        -respawn(): This will allow the Avatar to respawn where they died, as long as they have one life left. 

    */
    
    //Instance variables
    private Avatar minidisc;
    private ArrayList<Collectible> collectibesArray;
    private ArrayList<Obstacle> obstacleArray;
    
    //Constructors
    /**
    The default constructor for the AnimationApp class has the instance variables set to their default values
    */
    public AnimationApp(){}
    
    /**
    This constructor allows to initialize and set the intance variables to a prefered value
    @param 
    */
    public AnimationApp(Avatar inputAvatar, ArrayList<Collectible> inputCollectiblesArray, ArrayList<Obstacle> inputObstaclesArray){
        
        //Copy the input avatar and set the newAvatar equal to the instance variable
        if (inputAvatar != null){
            this.Avatar = new Avatar(inputAvatar);
        }else {
            this.Avatar = null;
        }
        
        //Copy the inputCollectiblesArray and set it equal to the instance variable
        if (inputCollectiblesArray != null){
            ArrayList<Collectible> tempCollectiblesArrayList = new ArrayList<Collectible>();
            for (Collectible c : this.collectibesArray){
                if (c != null){
                    tempCollectiblesArrayList.add(new Collectible(c));
                }else {
                    tempCollectiblesArrayList.add(new Collectible());
                }
            }
            this.collectibesArray = tempCollectiblesArrayList;
        }
        
        //Copy the inputObstaclesArray and set it equal to the instance variable
        if (inputObstaclesArray != null){
            ArrayList<Obstacle> tempObstaclesArrayList = new ArrayList<Obstacle>();
            for (Obstacle o : this.obstacleArray){
                if (o != null){
                    tempObstaclesArrayList.add(new Obstacle(o));
                }else {
                    tempObstaclesArrayList.add(new Obstacle());
                }
            }
            this.obstacleArray = tempObstaclesArrayList;
        }
    }
    
    //Setter Method
    /**
    This method sets the avatar to some new avatar
    @param inputAvatar : this is the avatar we wish to set this.avatar to
    */
    public void setAvatar(Avatar inputAvatar){
        this.Avatar = new Avatar(inputAvatar);
    }
    
    /** 
    This method sets this.collectibesArray to a new array 
    @param inputCollectiblesArray : the collectibesArray that we wish to set this.collectibesArray to
    */
    public void setCollectiblesArray(ArrayList<Collectible> inputCollectiblesArray){
        ArrayList<Collectible> tempCollectiblesArrayList = new ArrayList<Collectible>();
        if (inputCollectiblesArray != null){
            ArrayList<Collectible> tempCollectiblesArrayList = new ArrayList<Collectible>();
            for (Collectible c : this.collectibesArray){
                if (c != null){
                    tempCollectiblesArrayList.add(new Collectible(c));
                }else {
                    tempCollectiblesArrayList.add(new Collectible());
                }
            }
            this.collectibesArray = tempCollectiblesArrayList;
        }
    }
    
    /**
    This method set this.obstacleArray to a new array
    @param inputObstaclesArray : the obstacleArray that we wish to set this.obstacleArray to
    */
    public void setObstacleArray(ArrayList<Collectible> inputObstaclesArray){
        if (inputObstaclesArray != null){
            ArrayList<Obstacle> tempObstaclesArrayList = new ArrayList<Obstacle>();
            for (Obstacle o : this.obstacleArray){
                if (o != null){
                    tempObstaclesArrayList.add(new Obstacle(o));
                }else {
                    tempObstaclesArrayList.add(new Obstacle());
                }
            }
            this.obstacleArray = tempObstaclesArrayList;
        }
    }
    
    /**
    This method will add an obstacle to the end of the obstacleArray
    @param obstacleToAdd : this is the obstacle we wish to add
    */
    public void addObstacle(Obstacle obstacleToAdd){
        this.obstacleArray.add(new Obstacle(obstacleToAdd));
    }
    
    /**
    This method allows to add an obstacle at a speicfic index
    @param index : the index (which is an integer) of the array in which we wish to add the obstacle
    @param obstacleToAdd : this is the obstacle we wish to add
    */
    public void addObstacle(int index, Obstacle obstacleToAdd){
        this.obstacleArray.add(index, new Obstacle(obstacleToAdd));
    }
    
    /**
    This method will add a collectible to the array at the end of the collectibesArray 
    @param collectibleToAdd : the collectible we wish to add to the array
    */
    public void addCollectible(Collectible collectibleToAdd){
        this.collectibesArray.add(new Collectible(collectibleToAdd));
    }
    
    /**
    This method allows to add a collectible at a speicfic index of the collectibesArray
    @param index : the index (which is an integer) of the array in which we wish to add the collectible
    @param collectibleToAdd : the collectible we wish to add to the array
    */
     public void addCollectible(int index, Collectible collectibleToAdd){
        this.collectibesArray.add(index, new Collectible(collectibleToAdd));
    }
    
    /**
    This will print the current state of the game.  This means avatar position/health, collectibes and obstacles
    */
    public void printCurrentState(){
        
    }
    
    public void drawCurrentState(){
        
    }
    
    public void processAvatarMove(){
    
    }
    
    public void initialize(){
    
    }
    
    //Main Run 
    public static void main(String[] args){
        
    }
}
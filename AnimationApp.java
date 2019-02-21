import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;


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
    private ArrayList<Collectible> collectiblesArray;
    private ArrayList<Obstacle> obstacleArray;
    
    //Constructors
    /**
    The default constructor for the AnimationApp class has the instance variables set to their default values
    */
    public AnimationApp(){
        this.minidisc = new Avatar();
        this.collectiblesArray = new ArrayList<Collectible>();
        this.obstacleArray = new ArrayList<Obstacle>();
    }
    
    /**
    This constructor allows to initialize and set the intance variables to a prefered value
    @param 
    */
    public AnimationApp(Avatar inputAvatar, ArrayList<Collectible> inputCollectiblesArray, ArrayList<Obstacle> inputObstaclesArray){
        
        //Copy the input avatar and set the newAvatar equal to the instance variable
        if (inputAvatar != null){
            this.minidisc = new Avatar(inputAvatar);
        }else {
            this.minidisc = null;
        }
        
        //Copy the inputCollectiblesArray and set it equal to the instance variable
        setCollectiblesArray(inputCollectiblesArray);

        //Copy the inputObstaclesArray and set it equal to the instance variable
        setObstacleArray(inputObstaclesArray);
    }
    
    //Setter Method
    /**
    This method sets the avatar to some new avatar
    @param inputAvatar : this is the avatar we wish to set this.avatar to
    */
    public void setAvatar(Avatar inputAvatar){
        this.minidisc = new Avatar(inputAvatar);
    }
    
    /** 
    This method sets this.collectiblesArray to a new array 
    @param inputCollectiblesArray : the collectiblesArray that we wish to set this.collectiblesArray to
    */
    public void setCollectiblesArray(ArrayList<Collectible> inputCollectiblesArray){
        if (inputCollectiblesArray != null){
            ArrayList<Collectible> tempCollectiblesArrayList = new ArrayList<Collectible>();
            
            //copy the elements of the inputCollectiblesArray to a temporary array list
            for (Collectible c : inputCollectiblesArray){
                if (c != null){
                    tempCollectiblesArrayList.add(new Collectible(c));
                }else {
                    tempCollectiblesArrayList.add(new Collectible());
                }
            }
            
            //set the temporary array list to this.collectiblesArray
            this.collectiblesArray = tempCollectiblesArrayList;
        }
    }
    
    /**
    This method copies the collecitbles array list to an input array list.
    @param inputCollectiblesArray : this is the array list that we wish to copy the elemnts of this.collectiblearraylist to. 
    */
    public void copyCollectiblesArrayTo(ArrayList<Collectible> inputCollectiblesArray){
        if (inputCollectiblesArray != null){
            ArrayList<Collectible> tempCollectiblesArrayList = new ArrayList<Collectible>();
            
            //copy the elements of this.collectiblesArray to a temporary array list
            for (Collectible c : this.collectiblesArray){
                if (c != null){
                    tempCollectiblesArrayList.add(new Collectible(c));
                }else {
                    tempCollectiblesArrayList.add(new Collectible());
                }
            }
            
            //set the temporary array list to the inputCollectiblesArray
            inputCollectiblesArray = tempCollectiblesArrayList;
        }
    }
    
    /**
    This method set this.obstacleArray to a new array
    @param inputObstaclesArray : the obstacleArray that we wish to set this.obstacleArray to
    */
    public void setObstacleArray(ArrayList<Collectible> inputObstaclesArray){
        if (inputObstaclesArray != null){
            ArrayList<Obstacle> tempObstaclesArrayList = new ArrayList<Obstacle>();
            
            //Copy the elements of the inputObstaclesArray to the temporary array list
            for (Obstacle o : inputObstaclesArray){
                if (o != null){
                    tempObstaclesArrayList.add(new Obstacle(o));
                }else {
                    tempObstaclesArrayList.add(new Obstacle());
                }
            }
            
            //set the temporary array list to the obstacleArray
            this.obstacleArray = tempObstaclesArrayList;
        }
    }
    
    /**
    This method copies the elements of the obstacles array list (this.obstacleArray)  to an input array list
    @param inputObstaclesArray : this is the array list that we wish to copy the elemnts of this.obstacleArray to.
    */
    public void copyObstacleArrayTo(ArrayList<Collectible> inputCollectiblesArray){
        if (inputCollectiblesArray != null){
            ArrayList<Obstacle> tempObstaclesArrayList = new ArrayList<Obstacle>();
            
            //copy the elements of this.obstacleArray to the temporary array list
            for (Obstacle o : this.obstacleArray){
                if (o != null){
                    tempObstaclesArrayList.add(new obstacle(o));
                }else {
                    tempObstaclesArrayList.add(new Obstacle());
                }
            }
            
            //set the temporary array list to the inputObstaclesArray
            inputObstaclesArray = tempObstaclesArrayList;
            
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
    This method will add a specified number of obstacles to the end of the obstacleArray
    @param numberOfObstaclesToAdd : this is the number of (new) obstacles we wish to add
    */
    public void addObstacle(int numberOfObstaclesToAdd){
        ArrayList tempObstaclesArrayList = new ArrayList<Obstacle>();
        
        //Copy the obsacle array list (this.obstacleArray)if it is not empty
        if (this.obstacleArray != null){
            copyObstacleArrayTo(tempObstaclesArrayList);
        }
        
        //Add the required obstacles to the temporary array list
        for (int i = 0; i < numberOfObstaclesToAdd; i++){
            
            //Generate a random number between 0 and 10 for the x coordinate
            int randomXCoordinate = (int)(Math.random() * 10 + 0);
            
            //Generate a random number between 0 and 10 for the Y coordinate
            int randomYCoordinate = (int)(Math.random() * 10 + 0);
            
            tempObstaclesArrayList.add(new Obstacle("Obstacle" + i, randomXCoordinate, randomYCoordinate));  ///When constructing an obstacle, it should take a random positon as an argument
        }
        this.obstacleArray = tempObstaclesArrayList;
    }
    
    /**
    This method will add a collectible to the array at the end of the collectiblesArray 
    @param collectibleToAdd : the collectible we wish to add to the array
    */
    public void addCollectible(Collectible collectibleToAdd){
        this.collectiblesArray.add(new Collectible(collectibleToAdd));
    }
    
    /**
    This method allows to add a collectible at a speicfic index of the collectiblesArray
    @param index : the index (which is an integer) of the array in which we wish to add the collectible
    @param collectibleToAdd : the collectible we wish to add to the array
    */
     public void addCollectible(int index, Collectible collectibleToAdd){
        this.collectiblesArray.add(index, new Collectible(collectibleToAdd));
    }
    
    /**
    This method will adda specified number of collectibles to the collectibles array list
    @param numberOfCollectiblesToAdd : this is the number of collectibles we wish to add to the array list
    */
    public void addCollectible(int numberOfCollectiblesToAdd){
        ArrayList<Collectible> tempCollectiblesArrayList = new ArrayList<Collectible>();
        
        //Copy the collectibles array list (this.collectiblesArray) elements to the temporary array list if it is not empty
        if (this.collectiblesArray != null){ 
            copyCollectiblesArrayTo(tempCollectiblesArrayList);
        }
        
        //Add the required number of collecitbles that one wished to add
        for (int i = 0; i < numberOfCollectiblesToAdd; i++){
            
            //Generate a random number between 0 and 10 for the x coordinate
            int randomXCoordinate = (int)(Math.random() * 10 + 0);
            
            //Generate a random number between 0 and 10 for the Y coordinate
            int randomYCoordinate = (int)(Math.random() * 10 + 0);
            
            tempCollectiblesArrayList.add(new Collectible("Collectible" + i, randomXCoordinate, randomYCoordinate));  ///When constructing a collectible, it should take a random positon as an argument
        }
        this.collectiblesArray = tempCollectiblesArrayList;
    }
    
    /**
    This method removes a collectible from the map once it has been picked up!
    @param indexToRemoveCollectible : this is the index of the collecitble that we wish to remove
    */
    public void removeCollectible(int indexToRemoveCollectible){
        this.collectiblesArray.remove(indexToRemoveCollectible);
        //can add some animation for removing things
    }
    
    //////////////////AVATAR METHODS
    /**
    This method checks if the avatar overlaps with any element in the collecitbles array.  If the avatar overlaps,
    it returns true.
    @param inputAvatar : this is the avatar (most likely a copy) that we wish to check if it oberlaps with anything
    @return boolean : this returns the true if the avatar overlaps with the collectible, false otherwise
    */
    public void overlapsWithAnyCollectibles(Avatar inputAvatar){
        //Check if the avatar overlaps with any collecitbles
        for (Collectible c : this.collectiblesArray){
            if (c.overlapsWith(inputAvatar)){
                return true;
            }
        }
        return false;
        
    }
    
    /**
    This method checks if the avatar overlaps with any obstacle in the obstacles array list.  If the avatar overlaps,
    it returns true
    @param inputAvatar : this is the avatar that we wish to check if ir overlaps with anything
    @return boolean : returns a true if an obstacles is in the way, false otherwise
    */
    public void overlapsWithAnyObstacles(Avatar inputAvatar){
        //check if the avatar overlaps with any obstacles
        for (Obstacle o : this.obstacleArray){
            if (o.overlapsWith(inputAvatar)){
                return true;
            }
        }
        return false;
    }
    
    /**
    This will print the current state of the game.  This means avatar position/health, collectibes and obstacles
    */
    public void printCurrentState(){
        
    }
    
    public void drawCurrentState(){
        
    }
    
    /**
    This method processess if hte avatar can move.  This means it would check if there are any obstacles and collectibles in the area to the place
    that the avatar move to.  It would then act accordingly if there are some present
    */
    
    public void processAvatarMove(String userMovementInput){
        //Create a copy avatar ---- so we can move it later
        Avatar copyOfAvatar = new Avatar(minidisc);
        
        //Move the copy avatar accordingly 
        copyOfAvatar.move(userMovementInput);
        
        //If its at the edge of the world, its an improper move and should be done nothing
        if ((copyOfAvatar.getLocation().getX > 10 || copyOfAvatar.getLocation().getX < 0) || (copyOfAvatar.getLocation().getY < 0 || copyOfAvatar.getLocation().getY > 10)){
            //do nothing, ie dont move the avatar
            System.out.println("Ooops, seems I can't reach there!");
        }else {
                
            //Check if the move is valid by checking the obstacle and collecitbles array
            
            ArrayList<Collectible> copyOfCollectibleArrayList = new ArrayList<Collectible>();
            copyCollectiblesArrayTo(copyOfCollectibleArrayList);
            
            ArrayList<Obstacle> copyOfObstacleArray = new ArrayList<Obstacle>();
            copyObstacleArrayTo(copyOfObstacleArray);
            
            //Check if there is a collectible and no obstacle
            if (overlapsWithAnyCollectibles() && !overlapsWithAnyObstacles){
                //If there is a collectible and no obstacles, move the real avatar and pick up the collecitble (remove it from the array)
                for (int i = 0; i < copyOfCollectibleArrayList.size(); i++){
                    if (copyOfCollectibleArrayList.get(i).overlapsWith(copyOfAvatar)){
                        //Collect collectible if its there
                        copyOfCollectibleArrayList.get(i).addToCollection();
                        
                        //Move the original avatar accordingly (processAvatarMove())
                        this.minidisc.move(userMovementInput);
                        System.out.println("I picked up a collecitble");
                        
                        //Remove the collectible from the map
                        removeCollectible(i);
                        copyOfCollectibleArrayList.remove(i);
                    }
                }
            }else if ((!overlapsWithAnyCollectibles() && overlapsWithAnyObstacles()) || (overlapsWithAnyCollectibles() && overlapsWithAnyObstacles())){
                //If there are collectibles or no collectibles in the area , but there is an obstacle, take damage and dont have the avatar move there yet
                for (Obstacle o : copyOfObstacleArray){
                    if (o.overlapsWith(copyOfAvatar)){
                       if (o.getIsDeadly()){
                           //Dont move the original avatar accoringly (processAvatarMove())
                           
                           //Take damage from the obstacle if its there
                           this.minidisc.updateHealth(); //||???||?|?|?|?|?|?|? this shoudl be updated to takeDamage
                           
                           //print out 'taken damage'
                           System.out.println("OUCH! I have taken damage");
                       }
                    }
                }
            }else if (!overlapsWithAnyCollectibles() && !overlapsWithAnyObstacles){
                //if it doesnt overlap with any obstacles or colectibles, thne just move without doing nothing
                this.minidisc.move(userMovementInput);
            }
        }        
    }
    
    /**
    This method initializes the game.  What that means is it creates the obstacles and collecitbles for the stage
    and places the avatar at the starting position. 
    */
    public void initialize(){
        //Initalize the avatar
        this.minidisc.setPosition(); ///\/\/\/\/\/\/\/\/\/\/ IMPORTANT we want to make sure tha the origianl position of  the avatar is at the starting points
        
        //Initialize Collectibles -- Add 5 collectibles -- make sure the positions of collectibles are correct
        addCollectible(5);
        
        //Initalize Obstacles -- Add 5 obstacles -- make sure the postions of the obstacles are correct
        addObstacle(5);  
    }
    
    /**This method initializes the game while the game runs.  This means keeping the positons of the 'original' objects that
    where created but also adding obstacles and collecitbles accordingly
    @param collecitblesToAdd : this is the number of new collecitbles that the game should add after completing a certain task
    @param obstaclesToAdd : this is the number of new obsatacles that the game shoudl add.
    */
    public void initialize(int collecitblesToAdd, int obstacleToAdd){
        
        //Add any collectibles if necessary
        addCollectible(collecitblesToAdd);
        
        //Add any obstacles if necessary
        addObstacle(obstacleToAdd);
    }
    
    
    //Main Run 
    public static void main(String[] args){
        int movements = 0;
        
        AnimationApp mainApp = new AnimationApp();
        
        //Initialize the game (obtacle, collectible, and avatar positions)
        mainApp.initialize();
        
        //While the number of allowed movements is less than the required ammount (10), play a turn of the game
            //Might add condition of 'winning' where they collect all 5 collectibles
        while (movements < 10){
        
        //Prompt the user for a movement
        System.out.print("Move UP, DOWN, LEFT, RIGHT:");
		Scanner movementInput = new Scanner(System.in);
        
        //Process if the avatar can move 
        mainApp.processAvatarMove(movementInput);
        
        //Move obstacles accordingly (make sure to not overlap with avatar)
            //Update positions of all obstacles in arraylist

        //Print the current state

        //Draw the current state

        //Check if end condition is met (number of turns lets say)
        }
        
    }
}

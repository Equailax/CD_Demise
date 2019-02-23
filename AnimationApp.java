import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import java.awt.Rectangle;


public class AnimationApp{
    //This is the animation app, where we will run our game.
    
    //Instance variables
    private Avatar minidisc = new Avatar();
    private ArrayList<Collectible> collectiblesArray = new ArrayList<Collectible>();
    private ArrayList<Obstacle> obstacleArray = new ArrayList<Obstacle>();
    
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
    This method set this.obstacleArray to a new array
    @param inputObstaclesArray : the obstacleArray that we wish to set this.obstacleArray to
    */
    public void setObstacleArray(ArrayList<Obstacle> inputObstaclesArray){
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
    This method will add a specified number of obstacles to the end of the obstacleArray
    @param numberOfObstaclesToAdd : this is the number of (new) obstacles we wish to add
    */
    public void addObstacle(int numberOfObstaclesToAdd){
        ArrayList<Obstacle> tempObstaclesArrayList = new ArrayList<Obstacle>();
        
        //Copy the obsacle array list (this.obstacleArray)if it is not empty
        if (this.obstacleArray != null){
            tempObstaclesArrayList = getObstacleArray();
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
    This method will adda specified number of collectibles to the collectibles array list
    @param numberOfCollectiblesToAdd : this is the number of collectibles we wish to add to the array list
    */
    public void addCollectible(int numberOfCollectiblesToAdd){
        ArrayList<Collectible> tempCollectiblesArrayList = new ArrayList<Collectible>();
        
        //Copy the collectibles array list (this.collectiblesArray) elements to the temporary array list if it is not empty
        if (this.collectiblesArray != null){ 
            tempCollectiblesArrayList = getCollectiblesArray();
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
    public boolean overlapsWithAnyCollectibles(Avatar inputAvatar){
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
    public boolean overlapsWithAnyObstacles(Avatar inputAvatar){
        //check if the avatar overlaps with any obstacles
        for (Obstacle o : this.obstacleArray){
            if (o.overlapsWith(inputAvatar)){
                return true;
            }
        }
        return false;
    }
    
    //Getter methods
    /**
    This method returns the collectible array list.
    @return temp : this is a copy of the this.collecitblesArray
    */
    public ArrayList<Collectible> getCollectiblesArray(){
        ArrayList<Collectible> temp = new ArrayList<Collectible>();
        for (Collectible c : this.collectiblesArray){
            temp.add(new Collectible(c));
        }
        return temp;
    }
    
    /**
    This method returns the obstacle array list
    @return temp : this is a copy of the this.obstacleArray
    */
    public ArrayList<Obstacle> getObstacleArray(){
        ArrayList<Obstacle> temp = new ArrayList<Obstacle>();
        for (Obstacle o : this.obstacleArray){
            temp.add(new Obstacle(o));
        }
        return temp;
    }
    
    /**
    This will print the current state of the game.  This means avatar position/health, collectibes and obstacles
    */
    public void printCurrentState(){
        //Print the curent state of the avatar
        System.out.println("Name: " + this.minidisc.getName());
		System.out.println("Health Level: " + this.minidisc. getHealth());
		System.out.println("Lives Remaining: " + this.minidisc.getLives());
		System.out.println("X Position: " + this.minidisc.getLocation().getX());
		System.out.println("Y Position: " + this.minidisc.getLocation().getY());
        
        //Print out the state of the obstacles
        
        for (Obstacle o : this.obstacleArray){
            System.out.println("------------------------------------------------------------");
            System.out.print("Obstacle Name: " + o.getName() + "|");
            System.out.print(" X Position: " + o.getLocation().getX() + "|");
            System.out.println(" Y Position: " + o.getLocation().getY() + " |");
            System.out.println("------------------------------------------------------------");
        }
        
        //Print out the state of the collectibles
        for (Collectible c : this.collectiblesArray){
            System.out.println("------------------------------------------------------------------");
            System.out.print("Collectible Name: " + c.getName() + " |");
            System.out.print(" X Position: " + c.getLocation().getX() + "|");
            System.out.println(" Y Position: " + c.getLocation().getY() + "|");
            System.out.println("------------------------------------------------------------------");
        }
        
    }
    
    public void drawCurrentState(){
        
    }
    
    /**
    This method processess if the avatar can move.  This means it would check if there are any obstacles and collectibles in the area to the place
    that the avatar move to.  It would then act accordingly if there are some present
    */
    
    public void processAvatarMove(String userMovementInput){
        //Create a copy avatar ---- so we can move it later
        Avatar copyOfAvatar = new Avatar(this.minidisc);
        
        //Move the copy avatar accordingly 
        copyOfAvatar.move(userMovementInput);
        
        //Check if the move is within bounds
        if((0 <= copyOfAvatar.getLocation().getX() && copyOfAvatar.getLocation().getX() <= 10) && ( 0 <= copyOfAvatar.getLocation().getY()) && copyOfAvatar.getLocation().getY() <= 10){
            //Check if the move is valid by checking the obstacle and collecitbles array
            
            ArrayList<Collectible> copyOfCollectibleArrayList = new ArrayList<Collectible>();
            copyOfCollectibleArrayList = getCollectiblesArray();
            
            
            ArrayList<Obstacle> copyOfObstacleArray = new ArrayList<Obstacle>();
            copyOfObstacleArray = getObstacleArray();
            
            
            //Check if there is a collectible and no obstacle
            if (overlapsWithAnyCollectibles(copyOfAvatar) && !overlapsWithAnyObstacles(copyOfAvatar)){
                //If there is a collectible and no obstacles, move the real avatar and pick up the collecitble (remove it from the array)
                for (int i = 0; i < copyOfCollectibleArrayList.size(); i++){
                    if (copyOfCollectibleArrayList.get(i).overlapsWith(copyOfAvatar)){
                        //Collect collectible if its there
                        this.collectiblesArray.get(i).addToCollection();
                        
                        //Move the original avatar accordingly (processAvatarMove())
                        this.minidisc.move(userMovementInput);
                        System.out.println("I picked up a collecitble");
                        
                        //Remove the collectible from the map
                        removeCollectible(i);
                        this.collectiblesArray.remove(i);
                        
                        //break once removed
                        break;
                    }
                }
            }else if (overlapsWithAnyObstacles(copyOfAvatar)){
                //If there are collectibles or no collectibles in the area , but there is an obstacle, take damage and dont have the avatar move there yet
                for (Obstacle o : copyOfObstacleArray){
                    if (o.overlapsWith(copyOfAvatar)){
                       System.out.println("Oh no, there is an obstacle");
                       //Take damage from the obstacle if its there
                       this.minidisc.takeDamage(1); //||???||?|?|?|?|?|?|? this shoudl be updated to takeDamage
                       
                       //print out 'taken damage'
                       System.out.println("OUCH! I have taken damage");
                       
                       //once detected one obstacle break
                       break;
                       
                       /*if (o.getIsDeadly()){
                           //Move the original avatar accoringly (processAvatarMove())
                           
                           //Take damage from the obstacle if its there
                           this.minidisc.takeDamage(1); //||???||?|?|?|?|?|?|? this shoudl be updated to takeDamage
                           
                           //print out 'taken damage'
                           System.out.println("OUCH! I have taken damage");
                       }*/
                    }
                }
            }else if (!overlapsWithAnyCollectibles(copyOfAvatar) && !overlapsWithAnyObstacles(copyOfAvatar)){
                //if it doesnt overlap with any obstacles or colectibles, thne just move without doing nothing
                this.minidisc.move(userMovementInput);
            }
        }else {
            //do nothing, ie dont move the avatar
            System.out.println("Ooops, seems I can't reach there!");
        }      
    }
	
	public void processObstacleMove()
	{   
        //Create new avatar
        Avatar inputAvatar = new Avatar(this.minidisc);
        
		// Create two obstacle array states
		ArrayList<Obstacle> dynamicObstacleArray = new ArrayList<Obstacle>();
        dynamicObstacleArray = getObstacleArray();
        
		ArrayList<Obstacle> staticObstacleArray = new ArrayList<Obstacle>();
        staticObstacleArray = getObstacleArray();
		
		// Go through the dynamic array and move an obstacle then check for overlaps
		for (Obstacle o1 : dynamicObstacleArray)
		{
			boolean occupied = false;
			Rectangle preMove = new Rectangle(o1.getLocation());
			o1.randomMove();
			// Check if the moving obstacle overlaps with the avatar
            if (o1.overlapsWith(inputAvatar))
			{
				occupied = true;
						// Code avatar getting hurt
			} else
			{
				// Check if the moving obstacle overlaps with an obstacle in the static array (even if the moving obstacle doesn't move, no changes will be made)
				for (Obstacle o2 : staticObstacleArray)
				{
					if (o1.overlapsWithObstacle(o2))
					{
						occupied = true;
						break;
					}
				}
            }
			// If moving obstacle overlaps with an avatar or obstacle, move it back
			if (occupied)
			{
				o1.getLocation().setLocation((int)preMove.getX(), (int)preMove.getY());
			}
        }
		// Change this.ObstacleArray to the dynamic array
		setObstacleArray(dynamicObstacleArray);

	}
    
    /**
    This method initializes the game.  What that means is it creates the obstacles and collecitbles for the stage
    and places the avatar at the starting position. 
    */
    public void initialize(){
        //Initalize the avatar
        this.minidisc.setName("Minidisc");
        this.minidisc.setPosition(); ///\/\/\/\/\/\/\/\/\/\/ IMPORTANT we want to make sure tha the origianl position of  the avatar is at the starting points
        
        //Initialize Collectibles -- Add 3 collectibles -- make sure the positions of collectibles are correct
        addCollectible(3);
        
        //Initalize Obstacles -- Add 3 obstacles -- make sure the postions of the obstacles are correct
        addObstacle(3);  
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
        while (movements < 20){
        
            //Prompt the user for a movement
            System.out.print("Move UP, DOWN, LEFT, RIGHT:");
            Scanner movementInput = new Scanner(System.in);
            
            String input = movementInput.nextLine();
            movements += 1;
            
            //Process if the avatar can move 
            mainApp.processAvatarMove(input);
            
            //Move obstacles accordingly (make sure to not overlap with avatar)
            mainApp.processObstacleMove();
                //Update positions of all obstacles in arraylist

            //Print the current state
            mainApp.printCurrentState();
            
            //Check if end condition is met (number of turns lets say)
        }
        
    }
}

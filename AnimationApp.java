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
    
    //Getter methods
    /**
    This method will return a copy of the avatar
    @return Avatar : this is a new avatar with the same values as this.minidisc
    */
    public Avatar getAvatar(){
        return new Avatar(this.minidisc);
    }
    
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
            System.out.println(" Collection: " + c.getCollection() + "|");
            
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
        
        ArrayList<Collectible> copyOfCollectibleArrayList = new ArrayList<Collectible>();
        copyOfCollectibleArrayList = getCollectiblesArray();
        
        
        ArrayList<Obstacle> copyOfObstacleArray = new ArrayList<Obstacle>();
        copyOfObstacleArray = getObstacleArray();
        
        boolean occupiedByObstacle = false;
        boolean occupiedByCollectible = false;
        
        //Check if the avatar overlaps with any obsatacles
        for(Obstacle o: copyOfObstacleArray){
            if(o.overlapsWith(copyOfAvatar)){
                occupiedByObstacle = true;
                break;
            }
        }
        
        //Check if the avatar overlaps with any collecitbles
        for(Collectible c: copyOfCollectibleArrayList){
            if(c.overlapsWith(copyOfAvatar)){
                occupiedByCollectible = true;
                break;
            }
        }
        
        if(occupiedByObstacle == true){
            //If there is an obstacle, take damage
            //Take damage from the obstacle if its there
            this.minidisc.takeDamage(1); 
            
        }else if(occupiedByCollectible == true){
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
                    
                    //break once removed
                    break;
                }
            }
        }else if(occupiedByObstacle == false && occupiedByCollectible == false){
            //if it doesnt overlap with any obstacles or colectibles, thne just move without doing nothing
            this.minidisc.move(userMovementInput);
            System.out.println("Theres nothing here");
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
                this.minidisc.takeDamage(1);        
                
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
        this.minidisc = new Avatar("Minidisc",3, 3, 1, new Rectangle(0,0,1,1));
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
        
        //The first argument sets the amount of lives
        Avatar inputAvatar = new Avatar();
        inputAvatar.setName("Minidisc");
        int livesCount = Integer.parseInt(args[0]);
        inputAvatar.setLives(livesCount);
        mainApp.setAvatar(inputAvatar);
        
        //The second argument sets the amount of health
        int healthCount = Integer.parseInt(args[1]);
        inputAvatar.setHealth(healthCount);
        mainApp.setAvatar(inputAvatar);
        
        
        //While the number of allowed movements is less than the required ammount (10), play a turn of the game
            //Might add condition of 'winning' where they collect all 5 collectibles
        while (movements < 30){
            
             //Print the current state
            mainApp.printCurrentState();
            
            //Prompt the user for a movement
            System.out.print("Move UP, DOWN, LEFT, RIGHT: ");
            Scanner movementInput = new Scanner(System.in);
            
            //Check if the input is valid
            boolean check = false;
            String input = "";
            
            while (!check){
                input = movementInput.nextLine();
                
                if(input.toLowerCase().equals("up") || input.toLowerCase().equals("down") || input.toLowerCase().equals("left") || input.toLowerCase().equals("right")){
                    check = true;
                    break;
                }else{
                    System.out.print("Invalid input, please type either UP, DOWN, LEFT, or RIGHT: ");
                }
            }
            
            movements += 1;
            
            //Process if the avatar can move 
            mainApp.processAvatarMove(input);
            
            //Move obstacles accordingly (make sure to not overlap with avatar)
            mainApp.processObstacleMove();
            
            //Check if the player has run out of health
            if(mainApp.getAvatar().getHealth() <= 0){
                System.out.println("O-Oh, I have ran out of health!");
                System.out.println("Lost 1 Life");
                
                Avatar checkLivesAvatar = new Avatar(mainApp.getAvatar());
                int newLife = mainApp.getAvatar().getLives() - 1;
                checkLivesAvatar.setLives(newLife);
                mainApp.setAvatar(checkLivesAvatar);
                
                if (mainApp.getAvatar().getLives() <= 0){
                    System.out.println("Womp-womp, game over :(");
                    break;
                }
                
            }
            
            //Check if end condition is met (number of turns lets say)
            //Or if they collected all of the collectibles
            if (mainApp.getCollectiblesArray().size() == 0){
                System.out.println("You collected all of the Collectibles!");
                
                break;
            }
            
        }
        
        if (movements == 30){
            System.out.println("Ran out of moves!");
        }
        
        System.out.println("End of Demo1");
        
    }
}

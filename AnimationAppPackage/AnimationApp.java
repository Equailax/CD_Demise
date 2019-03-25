import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import java.awt.Rectangle;

import ObstaclePackage.*;
import AvatarPackage.*;
import CollectiblePackage.*;

public class AnimationApp{
    //This is the animation app, where we will run our game.
    
    //Instance variables
    private Avatar minidisc = new Avatar();
    private ArrayList<Collectible> collectiblesArray = new ArrayList<Collectible>();
    private ArrayList<Obstacle> obstacleArray = new ArrayList<Obstacle>();
    
    //Map dimensions
    private final int mapHeight = 1000;
    private final int mapWidth = 1000;
    
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
                    if (o instanceof Enemy){
                        tempObstaclesArrayList.add(new Enemy((Enemy)o));
                    }else if (o instanceof Projectile){
                        tempObstaclesArrayList.add(new Projectile((Projectile)o));
                    }else if (o instanceof Obstacle){
                        tempObstaclesArrayList.add(new Obstacle(o));
                    }
                    //tempObstaclesArrayList.add(new Obstacle(o));
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
    public void addObstacle(int numberOfObstaclesToAdd, int numberOfEnemiesToAdd){
        ArrayList<Obstacle> tempObstaclesArrayList = new ArrayList<Obstacle>();
        
        //Copy the obsacle array list (this.obstacleArray)if it is not empty
        if (this.obstacleArray != null){
            tempObstaclesArrayList = getObstacleArray();
        }
        
        //Add the required obstacles to the temporary array list
        
        tempObstaclesArrayList.add(new Obstacle("Obstacle1", "puddle", 300, 110));
        tempObstaclesArrayList.add(new Obstacle("Obstacle2", "puddle", 700, 400));
        tempObstaclesArrayList.add(new Obstacle("Obstacle3", "puddle", 260, 565));
        
        /*for (int i = 0; i < numberOfObstaclesToAdd; i++){
            
            //Generate a random number between 0 and 10 for the x coordinate
            int randomXCoordinate = (int)(Math.random() * (mapWidth - 240) + 110);
            
            //Generate a random number between 0 and 10 for the Y coordinate
            int randomYCoordinate = (int)(Math.random() * (mapHeight - 485) + 75);
            
            tempObstaclesArrayList.add(new Obstacle("Obstacle" + i, "puddle",randomXCoordinate, randomYCoordinate));  ///When constructing an obstacle, it should take a random positon as an argument
        }
        */
        
        //Add specific enemies
        
        tempObstaclesArrayList.add(new Enemy("Enemy1", "dotify", 21, 500, 400, "UPRIGHT"));  //Sets the enemy health to 3
        tempObstaclesArrayList.add(new Enemy("Enemy2", "beatsbydro", 21, 700, 200, "DOWN"));  //Sets the enemy health to 3
        tempObstaclesArrayList.add(new Enemy("Enemy3", "pearmusic", 21, 200, 500, "UP"));  //Sets the enemy health to 3
        
        /*
        //Add the required enemies to the temporary array list
        for (int i = 0; i < numberOfEnemiesToAdd; i++){
            
            //Generate a random number between 0 and 10 for the x coordinate
            int randomXCoordinate = (int)(Math.random() * (mapWidth - 240) + 110);
            
            //Generate a random number between 0 and 10 for the Y coordinate
            int randomYCoordinate = (int)(Math.random() * (mapHeight - 485) + 75);
            
            tempObstaclesArrayList.add(new Enemy("Enemy" + i, "dotify", 1, randomXCoordinate, randomYCoordinate));  //Sets the enemy health to 3
        }
        */
        
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
        
        tempCollectiblesArrayList.add(new Collectible("Collectible1", 300, 300));
        tempCollectiblesArrayList.add(new Collectible("Collectible2", 800, 565));
        tempCollectiblesArrayList.add(new Collectible("Collectible3", 400, 200));
        
        //Add the required number of collecitbles that one wished to add
        /*
        for (int i = 0; i < numberOfCollectiblesToAdd; i++){
            
            //Generate a random number between 0 and 10 for the x coordinate
            int randomXCoordinate = (int)(Math.random() * (mapWidth - 240) + 110);
            
            //Generate a random number between 0 and 10 for the Y coordinate
            int randomYCoordinate = (int)(Math.random() * (mapHeight - 485) + 75);
            
            tempCollectiblesArrayList.add(new Collectible("Collectible" + i, randomXCoordinate, randomYCoordinate));  ///When constructing a collectible, it should take a random positon as an argument
        }
        */
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
            if (o instanceof Enemy){
                temp.add(new Enemy((Enemy)o));
            }else if (o instanceof Projectile){
                temp.add(new Projectile((Projectile)o));
            }else if (o instanceof Obstacle){
                temp.add(new Obstacle(o));
            }
        }
        return temp;
    }
    
    /**
    This will print the current state of the game.  This means avatar position/health, collectibes and obstacles
    */
    public void printCurrentState(){
        //Print the curent state of the avatar
        System.out.println(this.minidisc.toString());
        
        //Print out the state of the obstacles
        for (Obstacle o : this.obstacleArray) {
            if (o instanceof Enemy) {
                System.out.println(((Enemy)o).toString());
            } else if (o instanceof Projectile) {
                System.out.println(((Projectile)o).toString());
            } else {
                System.out.println(o.toString());
            }
        }
        
        //Print out the state of the collectibles
        for (Collectible c : this.collectiblesArray){
            if (c instanceof Health){
                System.out.println(((Health)c).toString());
            }else {
                System.out.println(c.toString());
            }
        }
        
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
        boolean occupiedByEnemy = false;
        boolean occupiedByProjectile = false;
        boolean occupiedByCollectible = false;
        
        //Check if the avatar overlaps with any obsatacles
        /*
        This block of code check if the isntance of the obstacle in the obstacle array is a projectile, enemy, or obstacle
        If the instance is a projectile then, the avatar would take damage, move in the desired direction, and the projectile would be removed from the obstacle array
        If the instance is an enemy, then the avatar would take damage and would not move in the desired direction.
        If the instance is an obstacle, then the avatar would just not move to the desired space, taking no damage.
        */
        for(Obstacle o: copyOfObstacleArray){
            if(o.overlapsWith(copyOfAvatar)){
                if (!(o instanceof Enemy || o instanceof Projectile)){      
                    //If the object is NOT an instance of either an enemy nor a porjetile,then it is an obstacle and we cant move through it
                    occupiedByObstacle = true;
                    break;
                }else if (o instanceof Enemy){
                    //If the obstalce is an instance of an enemy, then we cant move to the desired position so the spot is occupied by an enemy
                    occupiedByEnemy = true;
                }else if (o instanceof Projectile){
                    //If the obstacle is an instance of a projectile, then we can move through it and so the spot is occupied by a projectile
                    if (((Projectile)o).getDeadlyToAvatar()) {
                        occupiedByProjectile = true;
                    }
                }
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
            //just have the obstacle not move
            System.out.println("I cant move there!");
            
        }else if (occupiedByEnemy == true){
            //if the spot is occupied by an enemy (regadless if there is a projectile there too), then dont move to the desired location and take damage
            this.minidisc.takeDamage(1);
            System.out.println("I cant move there!");
            
        }else if (occupiedByProjectile == true && occupiedByEnemy == false && occupiedByObstacle == false){
            // if the spot is occupied by a projecile (and is not occupied by an enemy nor an obstacle), take damage and move to the desired location
            this.minidisc.takeDamage(1);
            this.minidisc.move(userMovementInput);
            
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
        }else if(occupiedByObstacle == false && occupiedByCollectible == false && occupiedByEnemy == false && occupiedByProjectile == false){
            //if it doesnt overlap with any obstacles or colectibles, thne just move without doing nothing
            this.minidisc.move(userMovementInput);
            //System.out.println("Theres nothing here");
        }
    }
	
    /**
    This method processes the obstacle movement.  It checks if the obstacle overlaps with any other obstacle and doesnt move if it does.
    It also checks if it overlaps with an avatar and damages the avatar accordingly.
    */
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
		for (Obstacle o1 : dynamicObstacleArray) {
			
            boolean occupied = false;
			Rectangle preMove = new Rectangle(o1.getLocation());
			
            
            if (o1 instanceof Projectile) {
                //If the instance of the obstacle is a projectile have it move in its specified direction, as long as its within bounds
                //Projectile projecitleBeforeMovement = new Projectile((Projectile)o1);
                //projecitleBeforeMovement.move();
                ((Projectile)o1).move();
            } else if (o1 instanceof Enemy){
                
                Obstacle o1BeforeMovement = new Enemy((Enemy)o1);
                
                //Currently has the enemy move in a random direction
                ((Enemy)o1).move();
                
                //Check if the enemy overlaps with any other enemy, obstacle, projectile
                boolean occupiedByProjectile = false;
                
                for(Obstacle o2: staticObstacleArray){
                    if (!(o1BeforeMovement.equals(o2))){
                        if(o1.overlapsWithObstacle(o2)){
                            if (o2 instanceof Enemy){
                                //If the instance of the obstacle is an enemy or an obstacle, then it cant move through
                                occupied = true;
                            }else if (o2 instanceof Projectile){
                                //If the isntance is a projectile that damages enemies, then it can move through but it takes damage
                                if (((Projectile)o2).getDeadlyToEnemy()){
                                    occupiedByProjectile = true;
                                }
                            } else if (o2 instanceof Obstacle) {
                                occupied = true;
                            }
                        }
                    }
                }
                
                // Check if the moving enemy overlaps with the avatar
                if (o1.overlapsWith(inputAvatar)){
                    //If the enemy  overlaps with an avatar, have the avatar take damage
                    occupied = true;
                    this.minidisc.takeDamage(1);        
                    
                }
                
                if (occupiedByProjectile) {
                    //If the spot is not occupied by an obstacle or an enemy, but it is occupied by a projectile that damages enemies, the enemy takes damage.
                    ((Enemy)o1).takeDamage(1);
                    //System.out.println("ENEMY SHOULD BE DEAD OMG");
                    
                } else if (occupied) {
                    // If moving obstacle overlaps with an avatar or obstacle, move it back
                    o1.getLocation().setLocation((int)preMove.getX(), (int)preMove.getY());
                    
                    if (((Enemy)o1).getDirection().contains("UP")) {
                        ((Enemy)o1).setDirection(((Enemy)o1).getDirection().replace("UP", "DOWN"));
                    } else if (((Enemy)o1).getDirection().contains("DOWN")) {
                        ((Enemy)o1).setDirection(((Enemy)o1).getDirection().replace("DOWN", "UP"));
                    }
                    if (((Enemy)o1).getDirection().contains("LEFT")) {
                        ((Enemy)o1).setDirection(((Enemy)o1).getDirection().replace("LEFT", "RIGHT"));
                    } else if (((Enemy)o1).getDirection().contains("RIGHT")) {
                        ((Enemy)o1).setDirection(((Enemy)o1).getDirection().replace("RIGHT", "LEFT"));
                    }
                }
                
                /*
                if (occupied){
                    // If moving obstacle overlaps with an avatar or obstacle, move it back
                    o1.getLocation().setLocation((int)preMove.getX(), (int)preMove.getY());
                } else if (!occupied && occupiedByProjectile){
                    //If the spot is not occupied by an obstacle or an enemy, but it is occupied by a projectile that damages enemies, the enemy takes damage.
                    ((Enemy)o1).takeDamage(1);
                }
                */
                
            }
        }
		// Change this.ObstacleArray to the dynamic array
		setObstacleArray(dynamicObstacleArray);

	}
    
    /**
    This method removes any obstacle that need to be removed
    */
    public void removeObstacles(){
        
        /*
        Remove the projecitles that have reached bound limits
        */
        int obstaclesThatHaveReachedBounds = 0;
        for (Obstacle o1 : this.obstacleArray){
            if (o1 instanceof Projectile) {
                //has the projectile reached the bounds of the map
                if ((o1.getLocation().getX() >= 870 || o1.getLocation().getX() <= 90) || (
                    o1.getLocation().getY() >= 630 || o1.getLocation().getY() <= 70)) {
                    
                    obstaclesThatHaveReachedBounds += 1;
                }
            }
        }
        
        for (int i = 0; i < obstaclesThatHaveReachedBounds; i++){
            for (Obstacle o1 : this.obstacleArray){
                if (o1 instanceof Projectile) {
                    //remove the obstacle once it has reached the edges of the map
                    if ((o1.getLocation().getX() >= 870 || o1.getLocation().getX() <= 90) || (
                    o1.getLocation().getY() >= 630 || o1.getLocation().getY() <= 70)) {
                        
                        this.obstacleArray.remove(o1);
                        break;
                    }
                }
            }
        }
        
        int lenghtOfObstacleArray = this.obstacleArray.size();
        
        ArrayList<Obstacle> staticObstacleArray = this.getObstacleArray();
       
        //Once we have the number of obstacles to remove, remove that number from this.obstacleArray
        for (int i = 0; i < lenghtOfObstacleArray; i++){
            for (Obstacle o1 : staticObstacleArray){
                for (Obstacle o2 : this.obstacleArray){
                    if (!(o1.equals(o2))){
                        //If the obstacle does not equal itself, check if it overlaps with obstacle 2
                        if (o1.overlapsWithObstacle(o2)){
                            /*
                            Now, if the obstacle is an instance of a projectile remove it if;
                            if the projectile overlaps with an enemy (if it damages it)
                            if the projecitle overlaps with the avatar (if it damages it)
                            if the projectile overlaps with an obstacle, remove only the projectile
                            */
                            if (o1 instanceof Projectile) {
                                if (o2 instanceof Enemy){
                                    //if object 1 is a projectile, check if it damages enemies, if it does remove it, other wise don't do anything. 
                                    if (((Projectile)o1).getDeadlyToEnemy()){
                                        
                                        ((Enemy)o2).takeDamage(1);
                                        
                                        for (Obstacle o3 : this.obstacleArray) {
                                            if (o1.equals(o3)) {
                                                this.obstacleArray.remove(o3);
                                                System.out.println("My note hit an Enemy!");
                                                break;
                                            }
                                        }    
                                    }
                                    break;
                                } else {
                                    //If the second obstacle is not an instance of enemy nor projectile, its a wall, so the projectile should be removed.
                                    
                                    for (Obstacle o3 : this.obstacleArray) {
                                        if (o1.equals(o3)) {
                                            this.obstacleArray.remove(o3);
                                            System.out.println("My note hit an Obstacle!");
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                //break;
            }
        }
        
        /*
        Remove any enemies that have run out of health
        */
        int enemiesToRemove = 0;
        for (Obstacle enemy : this.obstacleArray){
            if (enemy instanceof Enemy){
                if (((Enemy)enemy).getHealth() <= 0){
                    enemiesToRemove += 1;
                }
            }
        }
        
        for (int i = 0; i < enemiesToRemove; i++){
            for (Obstacle enemy : this.obstacleArray){
                if (enemy instanceof Enemy){
                    if (((Enemy)enemy).getHealth() <= 0){
                        this.obstacleArray.remove(enemy);
                        break;
                    }
                }
            }
        }
 
    }
    
    /**
    This method initializes the game.  What that means is it creates the obstacles and collecitbles for the stage
    and places the avatar at the starting position. 
    */
    public void initialize(){
        //Initalize the avatar
        this.minidisc = new Avatar("Minidisc",3, 3, 1, new Rectangle(100, 100, 54, 67));
        
        
        //Initialize Collectibles -- Add 3 collectibles -- make sure the positions of collectibles are correct
        addCollectible(3);
        
        //Initalize Obstacles
        addObstacle(3, 3);  
        
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
        //addObstacle(obstacleToAdd);
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
            System.out.print("Move UP, DOWN, LEFT, RIGHT, or SHOOT + DIRECTION (LEFT, RIGHT, DOWN, UP): ");
            Scanner movementInput = new Scanner(System.in);
            
            //Check if the input is valid
            boolean check = false;
            String input = "";
            
            while (!check){
                input = movementInput.nextLine();
                
                if(input.toLowerCase().equals("up") || input.toLowerCase().equals("down") || input.toLowerCase().equals("left") || input.toLowerCase().equals("right") || input.toLowerCase().equals("shoot")
                    || input.toLowerCase().equals("shootleft") || input.toLowerCase().equals("shootright") || input.toLowerCase().equals("shootdown") || input.toLowerCase().equals("shootup")){
                    check = true;
                    break;
                }else{
                    System.out.print("Invalid input, please type either UP, DOWN, LEFT, RIGHT, or SHOOTDIRECTION (LEFT, RIGHT, DOWN, UP): ");
                }
            }
            
            movements += 1;
            
            //Check if avatar shot
            
            //Process if the avatar can move 
            if (input.toLowerCase().equals("up") || input.toLowerCase().equals("down") || input.toLowerCase().equals("left") || input.toLowerCase().equals("right")){
                mainApp.processAvatarMove(input);
            } else if (input.toLowerCase().equals("shoot") || input.toLowerCase().equals("shootleft") || input.toLowerCase().equals("shootright") || 
                input.toLowerCase().equals("shootdown") || input.toLowerCase().equals("shootup")) {
                
                System.out.println("Projectile has shot");
                
                //have the avatar shoot the proejctile "in a direction"
                Avatar avatarHasShot = new Avatar(mainApp.getAvatar());
                
                if (input.toLowerCase().contains("left")) {
                    avatarHasShot.shootProjectile("left");
                } else if (input.toLowerCase().contains("right")) {
                    avatarHasShot.shootProjectile("right");
                } else if (input.toLowerCase().contains("up")) {
                    avatarHasShot.shootProjectile("up");
                } else if (input.toLowerCase().contains("down")) {
                    avatarHasShot.shootProjectile("down");
                }
                
                mainApp.setAvatar(avatarHasShot);
                
                // add the projectile to the obstacle array
                
                Projectile projectileToAdd = new Projectile(mainApp.getAvatar().getProjectile());
                
                ArrayList<Obstacle> arrayListToAdd = new ArrayList<Obstacle>();
                arrayListToAdd = mainApp.getObstacleArray();
                arrayListToAdd.add(projectileToAdd);
                mainApp.setObstacleArray(arrayListToAdd);
                
            }
            
            
            //Move obstacles accordingly (make sure to not overlap with avatar)
            mainApp.processObstacleMove();
            
            //Remove any projectiles that overlap with an obstacle, have hit their intended targets.  Remove enemies that have ran out of health
            mainApp.removeObstacles();
            
            //Check if the player has run out of health
            Avatar checkIfEndGameAvatar = new Avatar(mainApp.getAvatar());
            if (!checkIfEndGameAvatar.checkIfEndGame(healthCount)){
                //If the avatar still has lives (game hasnt ended), then update the main avatar accordingly
                mainApp.setAvatar(checkIfEndGameAvatar);
            }else if (checkIfEndGameAvatar.checkIfEndGame(healthCount)){
                //If the end game has been reached (avatar has lost all of their health and lives) then break from the loop and end the game
                System.out.println("Womp-womp, game over :(");
                break;
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

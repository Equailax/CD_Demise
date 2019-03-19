import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;

/**
 * GUI to display the main map, with spawns and animations of the avatar, enemies, obstacles, and collectibles, and projectiles.
 * The avatar moves using keys on the keyboard for up, down, right and left movements, and a combination of these.
 * The mouse calculates the angle between where the mouse clicked and the avatar to know what direction to shoot the projectile.
 * The enemies will currently be stationary until later demos.
 * The avatar will also throw projectiles at the enemies to deal damage to them, and collect collectible items to make progress and eventually win the game.
 * The health of the avatar will be hearts displayed in the top corner of the screen that will decrease/increase in numbers based on interactions in the map.
 * Some parts referenced from:https://gist.github.com/jewelsea/8321740
 */

public class GUIAnimationApp extends Application {
    // Instance variables for avatar movements
	private boolean right = true;
    private boolean left = true;
    private boolean up = true;
    private boolean down = true;
    
    // Creation of the life hearts and the image of the avatar for the GUI
    //private AvatarImage mini = new AvatarImage();
    private ArrayList<LifeHeart> lifeHearts = new ArrayList<LifeHeart>();
    
    
    // Display Setup for the GUI
    private Image map = new Image("Map 1000pixels.jpg");
    private Pane root = new Pane();
    private final Scene scene = new Scene(root, 1000, 1000, new ImagePattern(map));
    
    //Instance variables
    //This creades an animation app instance
    private AnimationApp demo2 = new AnimationApp();
    
    //These are the image arrays for enemies and collectibles
    private ArrayList<Obstacle> obstacleGUIArray = demo2.getObstacleArray();
    private ArrayList<Collectible> collectibleGUIArray = demo2.getCollectiblesArray();
    
    private Avatar mini = demo2.getAvatar();
    
    
    
    /**
    This is the initialize method for the gui animation application
    */
    public void initialize(){
        this.demo2.initialize();
        
        // Display positions of life hearts for health
        for(int i = 0; i <= demo2.getAvatar().getHealth(); i++){
            LifeHeart tempHealth = new LifeHeart(25, 20+(30*i));
            
            imageRectangles.add(tempHealth.getLocation());
            
            lifeHearts.add(tempHealth);
        }
        
        // Display of life hearts on GUI
        for(int i = 0; i < demo2.getAvatar().getHealth(); i++){
            root.getChildren().add(lifeHearts.get(i).getLocation());
        }
        
        //Distplay the obstacles
        for (Obstacle o : demo2.getObstacleArray()) {
            root.getChildren().add(o.getEnemyImageRectangle());
        }
        
        
        // Display Collectibles
        
        for(Collectible o : demo2.getCollectiblesArray()){
            o.setImage();
            root.getChildren().add(o.getCollectibleImageRectangle());
        }
        
    }
    
    /* //WORK IN PROGRESS
    public void updateScreen() {
        
        //Remove all rectangles
        
        for (Rectangle r : imageRectangles) {
            root.getChildren().remove(r);
        }
        
        imageRectangles = new ArrayList<Rectangle>();
        
        // Display positions of life hearts for health
        for(int i = 0; i <= demo2.getAvatar().getHealth(); i++){
            LifeHeart tempHealth = new LifeHeart(25, 20+(30*i));
            
            imageRectangles.add(tempHealth.getLocation());
            
            lifeHearts.add(tempHealth);
        }
        
        // Display of life hearts on GUI
        for(int i = 0; i < demo2.getAvatar().getHealth(); i++){
            root.getChildren().add(lifeHearts.get(i).getLocation());
        }
        
        /*
        // Display Obstacles
        for (Obstacle o : demo2.getObstacleArray()){
            int randomEnemy = new Random().nextInt(4);
            if (o instanceof Enemy){
                if (randomEnemy == 0){
                    EnemyImage temp = new EnemyImage("DOTIFY", (int)(o.getLocation().getX()), (int)(o.getLocation().getY()));
                    root.getChildren().add(temp.getLocation());
                }
                if (randomEnemy == 1) {
                    EnemyImage temp = new EnemyImage("BEATSBYDRO", (int)(o.getLocation().getX()),(int)(o.getLocation().getY()));
                    root.getChildren().add(temp.getLocation());
                }
                if (randomEnemy == 2) {
                    EnemyImage temp = new EnemyImage("PEARMUSIC", (int)(o.getLocation().getX()),(int)(o.getLocation().getY()));
                    root.getChildren().add(temp.getLocation());
                }
                if (randomEnemy == 3) {
                    EnemyImage temp = new EnemyImage("MYPHONE", (int)(o.getLocation().getX()),(int)(o.getLocation().getY()));
                    root.getChildren().add(temp.getLocation());
                }
            } else {
                Image puddle = new Image("Puddle.png");
                if (!(o instanceof Enemy || o instanceof Projectile)){
                    Rectangle puddleSpace = new Rectangle(o.getLocation().getX(), o.getLocation().getY(), 60 , 60);
                    puddleSpace.setFill(new ImagePattern(puddle));
                    root.getChildren().add(puddleSpace);
                }
            }
        }
        
        
        // Display Collectibles
        // Display Collectibles
        Image record = new Image("Record.png");
        for(Collectible o : demo2.getCollectiblesArray()){
            if (o instanceof Collectible){
                Rectangle recordSpace = new Rectangle(o.getLocation().getX(), o.getLocation().getY(), 60 , 60);
                recordSpace.setFill(new ImagePattern(record));
                
                imageRectangles.add(recordSpace);
                
                root.getChildren().add(recordSpace);
            }
        }
        
    }
    */

    public static void main(String[] args) {
        
        launch(args); // launches GUI application

    }

    public void start(Stage primaryStage) throws Exception {
        // Initialize the Animation App with 3 collectibles, 3 obstacles, and 3 enemies
        initialize();
          
        // Rectangle / hitbox
		Rectangle mouseHitbox = new Rectangle(0, 0, 1250, 1250);           // IMPORTANT: Make the rectangle fill the whole window
		mouseHitbox.setFill(Color.rgb(0,0,0,0));
        
        //root.getChildren().add(mini.getAvatarImage());
        
        root.getChildren().add(mini.getAvatarImage());
        
        root.getChildren().add(mouseHitbox);
		
		mouseHitbox.toFront();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
		
        

        //Animation of movements
        AnimationTimer moveTime = new AnimationTimer(){
            @Override
            public void handle(long now) {
                int moveX = 0;
                int moveY = 0;
                
                Avatar avatarBeforeMovement = new Avatar(demo2.getAvatar());
                
                //Avatar updatedAvatar = new Avatar(demo2.getAvatar());
                
                if (right) {
                    mini.setForward();
                    
                    //Check if moving right is valid by the ANIMATIONAPP LOGIC
                    demo2.processAvatarMove("right");
                    
                    //if the avatar's movement changed, set the moveX to + 3, if not, nothing has changed
                    if (avatarBeforeMovement.equals(demo2.getAvatar())){
                        moveX -= 0;
                    } else {
                        moveX += 5;
                    }
                    
                    //moveX += 3;
                }
                if (left) {
                    mini.setBackward();
                    
                    //Check if moving right is valid by the ANIMATIONAPP LOGIC
                    demo2.processAvatarMove("left");
                    
                    //if the avatar's movement changed, set the moveX to + 3, if not, nothing has changed
                    if (avatarBeforeMovement.equals(demo2.getAvatar())){
                        moveX -= 0;
                    } else {
                        moveX -= 5;
                    }
                    
                   // moveX -= 3;
                }
                if (up) {
                    //Check if moving right is valid by the ANIMATIONAPP LOGIC
                    demo2.processAvatarMove("up");
                    
                    //if the avatar's movement changed, set the moveX to + 3, if not, nothing has changed
                    if (avatarBeforeMovement.equals(demo2.getAvatar())){
                        moveY-= 0;
                    } else {
                        moveY -= 5;
                    }
                    
                    //moveY -= 3;
                }
                if (down) {
                    //Check if moving right is valid by the ANIMATIONAPP LOGIC
                    demo2.processAvatarMove("down");
                    
                    //if the avatar's movement changed, set the moveX to + 3, if not, nothing has changed
                    if (avatarBeforeMovement.equals(demo2.getAvatar())){
                        moveX -= 0;
                    } else {
                        moveY += 5;
                    }
                    //moveY += 3;
                }
<<<<<<< HEAD

                if (((mini.getXLocation() + moveX) <= 758) && ((mini.getXLocation() + moveX) >= 0)) {
                    if(((mini.getYLocation() + moveY) >= 0) && ((mini.getYLocation() + moveY) <= 805)) {
                        // Change the location of the avatar on the map
                        mini.moveAvatar(moveX, moveY);//Make sure to update the avatar
                        Avatar updatedAvatar = new Avatar(demo2.getAvatar());
                        updatedAvatar.setLocation((int)mini.getXLocation() + 100, (int)mini.getYLocation() + 100);
                        demo2.setAvatar(updatedAvatar);

                        
                        
                        /*
                        // Take the location of the actual avatar and make it match the one on the map
                        // Had to take the double value returned by the getX and getY methods into int
                        Double doubleNewX = avatarLocation.getX() + moveX;
                        Double doubleNewY = avatarLocation.getY() + moveY;
                        int newX = doubleNewX.intValue();
                        int newY = doubleNewY.intValue();
                        avatarLocation.setLocation(newX, newY);
                        */

=======
                
                if (((mini.getXImageLayout() + moveX) <= 758) && ((mini.getXImageLayout() + moveX) >= 0)) {
                    if(((mini.getYImageLayout() + moveY) >= 0) && ((mini.getYImageLayout() + moveY) <= 805)) {
                        
                        root.getChildren().remove(mini.getAvatarImage());
                        
                        mini.moveAvatarImage(moveX, moveY);
                        
                        //Avatar updatedAvatar = new Avatar(demo2.getAvatar());
>>>>>>> ed881553be50e34ed569d9688f37a81b6b4a93bf
                        
                        
                        
                        mini.setLocation((int)mini.getXImageLayout() + 100, (int)mini.getYImageLayout() + 100);
                        //demo2.setAvatar(updatedAvatar); 
                        
                        demo2.setAvatar(mini);
                        
                        root.getChildren().add(mini.getAvatarImage());
                    
                    }
                    
                }
                
<<<<<<< HEAD

               
=======
>>>>>>> ed881553be50e34ed569d9688f37a81b6b4a93bf
            }};


    

        

        // Movement Key Events
        scene.setOnKeyPressed(keyEvent -> {
                // Starts moving right when key is pressed
                if (keyEvent.getCode().toString() == "RIGHT")
                    right = true;
        
                // Starts moving left when key is pressed
                if (keyEvent.getCode().toString() == "LEFT")
                    left = true;
        
                // Starts moving up when key is pressed
                if (keyEvent.getCode().toString() == "UP")
                    up = true;
        
                // Starts moving down when key is pressed
                if (keyEvent.getCode().toString() == "DOWN")
                    down = true;
        });

        scene.setOnKeyReleased(keyEvent -> {
                // Stops moving right when key is released
                if (keyEvent.getCode().toString() == "RIGHT")
                    right = false;
        
                // Stops moving left when key is released
                if (keyEvent.getCode().toString() == "LEFT")
                    left = false;
        
                // Stops moving up when key is released
                if (keyEvent.getCode().toString() == "UP")
                    up = false;
        
                // Stops moving down when key is released
                if (keyEvent.getCode().toString() == "DOWN")
                    down = false;
        });
		
		mouseHitbox.setOnMouseClicked(mouseEvent ->
		{
			// Calculate the center of the avatar relative to the window
			double avatarXCenter = (demo2.getAvatar().getLocation().getX()+27);
			double avatarYCenter = (demo2.getAvatar().getLocation().getY()+33.5);
			System.out.println(demo2.getAvatar().getLocation()); // CAN BE DELETED
            
            System.out.println(mini.getXImageLayout() + " " + mini.getYImageLayout());
            
            System.out.println(mini.getAvatarImage().getX() + " " + mini.getAvatarImage().getY());
            
            demo2.printCurrentState();
            
			// Calculate the anglet between the avatar and the mouse

			double angle = Math.toDegrees(Math.atan2(mouseEvent.getX()-(avatarXCenter), mouseEvent.getY()-(avatarYCenter)))+180;
			System.out.println("Click (" + mouseEvent.getX() + ", " + mouseEvent.getY() + ")"); // CAN BE DELETED
			System.out.println(angle);// CAN BE DELETED
			
			// Print to console the direction that the mouse click is relative to the avatar's rectangle.
			// The angle is a circle with 0 starting at the top and increases as the mouse moves counter clockwise
			if (angle > 337.5)
			{
				System.out.println("North");
			} else if (angle > 292.5)
			{
				System.out.println("North East");
			} else if (angle > 247.5)
			{
				System.out.println("East");
			} else if (angle > 202.5)
			{
				System.out.println("South East");
			} else if (angle > 157.5)
			{
				System.out.println("South");
			} else if (angle > 112.5)
			{
				System.out.println("South West");
			} else if (angle > 67.5)
			{
				System.out.println("West");
			} else if (angle > 22.5)
			{
				System.out.println("North West");
			} else if (angle >= 0)
			{
				System.out.println("North");
			}
			
			// Projectile Image
			ProjectileImage projectile = new ProjectileImage((int)(avatarXCenter-11), (int)(avatarYCenter-18.5));
			root.getChildren().add(projectile.getImageLocation());
			mouseHitbox.toFront();
		});
		
        moveTime.start();
        
        demo2.printCurrentState();
    }
};


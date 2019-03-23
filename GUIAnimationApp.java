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
	private boolean right = false;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;
    
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
        
        obstacleGUIArray = demo2.getObstacleArray();
        collectibleGUIArray = demo2.getCollectiblesArray();
        mini = demo2.getAvatar();
        
        
        // Display positions of life hearts for health
        for(int i = 0; i <= demo2.getAvatar().getHealth(); i++){
            LifeHeart tempHealth = new LifeHeart(25, 20+(30*i));
            
            //imageRectangles.add(tempHealth.getLocation());
            
            lifeHearts.add(tempHealth);
        }
        
        // Display of life hearts on GUI
        for(int i = 0; i < demo2.getAvatar().getHealth(); i++){
            root.getChildren().add(lifeHearts.get(i).getLocation());
        }
        
        //Distplay the obstacles
        for (Obstacle o : this.obstacleGUIArray) {
            root.getChildren().add(o.getEnemyImageRectangle());
        }
        
        
        // Display Collectibles
        
        for(Collectible c : this.collectibleGUIArray){
            c.setImage();
            root.getChildren().add(c.getCollectibleImageRectangle());
        }
        
    }

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
		mini.setForward();
        
        root.getChildren().add(mouseHitbox);
		
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
		
        

        //Animation of movements
        AnimationTimer moveTime = new AnimationTimer(){
            @Override
            public void handle(long now) {
                int moveX = 0;
                int moveY = 0;
                
                
                
                //Avatar updatedAvatar = new Avatar(demo2.getAvatar());
                Avatar avatarBeforeMovement = new Avatar(demo2.getAvatar());
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
                }
				avatarBeforeMovement = new Avatar(demo2.getAvatar());
                if (up) {
                    //Check if moving right is valid by the ANIMATIONAPP LOGIC
                    demo2.processAvatarMove("up");
                    
                    //if the avatar's movement changed, set the moveX to + 3, if not, nothing has changed
                    if (avatarBeforeMovement.equals(demo2.getAvatar())){
                        moveY-= 0;
                    } else {
                        moveY -= 5;
                    }
                }
                if (down) {
                    //Check if moving right is valid by the ANIMATIONAPP LOGIC
                    demo2.processAvatarMove("down");
                    
                    //if the avatar's movement changed, set the moveX to + 3, if not, nothing has changed
                    if (avatarBeforeMovement.equals(demo2.getAvatar())){
                        moveY -= 0;
                    } else {
                        moveY += 5;
                    }
                }
                
                //Process the obstacle movement remove anything if necessary
                demo2.processObstacleMove();
                demo2.removeObstacles();
                
                for (Obstacle o : obstacleGUIArray) {
                    root.getChildren().remove(o.getEnemyImageRectangle());
                }
                
                obstacleGUIArray = demo2.getObstacleArray();
                
                for (Obstacle o : obstacleGUIArray) {
                    root.getChildren().add(o.getEnemyImageRectangle());
                }
                
                //Update collectibles
                for (Collectible c : collectibleGUIArray) {
                    root.getChildren().remove(c.getCollectibleImageRectangle());
                }
                
                collectibleGUIArray = demo2.getCollectiblesArray();
                
                for (Collectible c : collectibleGUIArray) {
                    c.setImage();
                    root.getChildren().add(c.getCollectibleImageRectangle());
                }
                
                if (((mini.getXImageLayout() + moveX) <= 772) && ((mini.getXImageLayout() + moveX) >= 0)) {
                    if(((mini.getYImageLayout() + moveY) >= 0) && ((mini.getYImageLayout() + moveY) <= 575)) {
                        
                    
                        
                        
                        root.getChildren().remove(mini.getAvatarImage());
                        
                        mini.moveAvatarImage(moveX, moveY);

                        mini.setLocation((int)mini.getXImageLayout() + 100, (int)mini.getYImageLayout() + 100);
                        
                        mini.setHealth(demo2.getAvatar().getHealth());
                        
                        demo2.setAvatar(mini);
                        
                        root.getChildren().add(mini.getAvatarImage());
                    
                    }
                }
				mouseHitbox.toFront();
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
                
                mini.shootProjectile("up");
                
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
                
                this.obstacleGUIArray.add(avatarProjectile);
                demo2.setObstacleArray(this.obstacleGUIArray);
                
                
			} else if (angle > 292.5)
			{
				System.out.println("North East");
                
                mini.shootProjectile("upright");
                
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
                
                this.obstacleGUIArray.add(avatarProjectile);
                demo2.setObstacleArray(this.obstacleGUIArray);
                
			} else if (angle > 247.5)
			{
				System.out.println("East");
                
                mini.shootProjectile("right");
                
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
                
                this.obstacleGUIArray.add(avatarProjectile);
                demo2.setObstacleArray(this.obstacleGUIArray);
                
			} else if (angle > 202.5)
			{
				System.out.println("South East");
                
                mini.shootProjectile("downright");
                
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
                
                this.obstacleGUIArray.add(avatarProjectile);
                demo2.setObstacleArray(this.obstacleGUIArray);
                
			} else if (angle > 157.5)
			{
				System.out.println("South");
                
                mini.shootProjectile("down");
                
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
                
                this.obstacleGUIArray.add(avatarProjectile);
                demo2.setObstacleArray(this.obstacleGUIArray);
                
			} else if (angle > 112.5)
			{
				System.out.println("South West");
                
                mini.shootProjectile("downleft");
                
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
                
                this.obstacleGUIArray.add(avatarProjectile);
                demo2.setObstacleArray(this.obstacleGUIArray);
                
			} else if (angle > 67.5)
			{
				System.out.println("West");
                
                mini.shootProjectile("left");
                
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
                
                this.obstacleGUIArray.add(avatarProjectile);
                demo2.setObstacleArray(this.obstacleGUIArray);
                
			} else if (angle > 22.5)
			{
				System.out.println("North West");
                
                mini.shootProjectile("upleft");
                
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
                
                this.obstacleGUIArray.add(avatarProjectile);
                demo2.setObstacleArray(this.obstacleGUIArray);
                
			} else if (angle >= 0)
			{
				System.out.println("North");
                
                mini.shootProjectile("up");
                
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
                
                this.obstacleGUIArray.add(avatarProjectile);
                demo2.setObstacleArray(this.obstacleGUIArray);
                
			}
			
		});
		
        moveTime.start();
        
        demo2.printCurrentState();
    }
};


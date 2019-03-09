import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
//import javafx.scene.shape.RectangleBuilder;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;
import java.util.Random;

/**
 * GUI to display the main map, with spawns and animations of the avatar, enemies, obstacles, and collectibles, and projectiles.
 *The avatar moves using keys on the keyboard for up,down,right, and left movements, and a combination of these.
 *The enemies will currently be stationary until later demos.
 *The avatar will also throw projectiles at the enemies to deal damage to them, and collect collectible items to make progress and eventually win the game.
 *The health of the avatar will be hearts displayed in the top corner of the screen that will decrease/increase in numbers based on interactions in the map.
 * Some parts referenced from:https://gist.github.com/jewelsea/8321740
 */
// FINAL DRAFT

public class GUIAnimationApp extends Application {
    // Instance variables for avatar movements
    String Right = "don't move";
    String Left = "don't move";
    String Up = "don't move";
    String Down = "don't move";
	
    //Creation of the life hearts and the image of the avatar for the GUI
    AvatarImage mini = new AvatarImage();
    ArrayList<LifeHeart> lifeHearts = new ArrayList<LifeHeart>();

    // Creation of ArrayList for enemies
    ArrayList<EnemyImage> enemyImages = new ArrayList<EnemyImage>();
    ArrayList<Obstacle> obstacleList = new ArrayList<Obstacle>();
    




    public static void main(String[] args) {
        
        launch(args); // launches GUI application

    }

    public void start(Stage primaryStage) throws Exception {
        // Initialize the Animation App with 3 collectibles, 3 obstacles, and 3 enemies
        AnimationApp demo2 = new AnimationApp();
        demo2.initialize();

       // Display Setup for the GUI
        Image map = new Image("Map 1000pixels.jpg");
        Pane root = new Pane();
        final Scene scene = new Scene(root, 1000, 1000, new ImagePattern(map));
	    
        // Display positions of life hearts for health
        for(int i = 0; i <= demo2.getAvatar().getHealth(); i++){
            LifeHeart temp = new LifeHeart(25, 20+(30*i));
            lifeHearts.add(temp);
        }
            
        // Display of life hearts on GUI
        for(int i = 0; i < demo2.getAvatar().getHealth(); i++){
            root.getChildren().add(lifeHearts.get(i).getLocation());
        }

        // Display Obstacles
        
        for (int i = 0; i < demo2.getObstacleArray().size(); i++){
            Obstacle o = demo2.getObstacleArray().get(i);
            int randomEnemy = new Random().nextInt(4);
            if (o instanceof Enemy){
                if (randomEnemy == 0){
                    EnemyImage temp = new EnemyImage("DOTIFY", (int) o.getLocation().getX(), (int) o.getLocation().getY());
                    root.getChildren().add(temp.getLocation());
                }
                if (randomEnemy == 1) {
                    EnemyImage temp = new EnemyImage("BEATSBYDRO", (int) o.getLocation().getX(),(int) o.getLocation().getY());
                    root.getChildren().add(temp.getLocation());
                }
                if (randomEnemy == 2) {
                    EnemyImage temp = new EnemyImage("PEARMUSIC", (int) o.getLocation().getX(),(int) o.getLocation().getY());
                    root.getChildren().add(temp.getLocation());
                }
                if (randomEnemy == 3) {
                    EnemyImage temp = new EnemyImage("MYPHONE", (int) o.getLocation().getX(),(int) o.getLocation().getY());
                    root.getChildren().add(temp.getLocation());}
            }  }
        
        for (int i = 0; i < demo2.getObstacleArray().size(); i++){
            Obstacle o = demo2.getObstacleArray().get(i);
            Image puddle = new Image("Puddle.png");
            if (!(o instanceof Enemy || o instanceof Projectile)){
                Rectangle puddleSpace = new Rectangle(o.getLocation().getX(), o.getLocation().getY(), 60 , 60);
                puddleSpace.setFill(new ImagePattern(puddle));
                root.getChildren().add(puddleSpace);}}
            
          
            
        
    
        
        root.getChildren().add(mini.getAvatarImage());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        
        
        //Animation of movements
        AnimationTimer moveTime = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int moveX = 0;
                int moveY = 0;
                
                Avatar avatarBeforeMovement = new Avatar(demo2.getAvatar());
                
                if (Right.equals("move")) {
                    mini.setForward();
                    
                    //Check if moving right is valid by the ANIMATIONAPP LOGIC
                    demo2.processAvatarMove("right");
                    
                    //if the avatar's movement changed, set the moveX to + 3, if not, nothing has changed
                    if (avatarBeforeMovement.equals(demo2.getAvatar())){
                        moveX -= 0;
                    } else {
                        moveX += 3;
                    }
                    
                    //moveX += 3;
                }
                if (Left.equals("move")) {
                    mini.setBackward();
                    
                    //Check if moving right is valid by the ANIMATIONAPP LOGIC
                    demo2.processAvatarMove("left");
                    
                    //if the avatar's movement changed, set the moveX to + 3, if not, nothing has changed
                    if (avatarBeforeMovement.equals(demo2.getAvatar())){
                        moveX -= 0;
                    } else {
                        moveX -= 3;
                    }
                    
                   // moveX -= 3;
                }
                if (Up.equals("move")) {
                    //Check if moving right is valid by the ANIMATIONAPP LOGIC
                    demo2.processAvatarMove("up");
                    
                    //if the avatar's movement changed, set the moveX to + 3, if not, nothing has changed
                    if (avatarBeforeMovement.equals(demo2.getAvatar())){
                        moveY-= 0;
                    } else {
                        moveY -= 3;
                    }
                    
                    //moveY -= 3;
                }
                if (Down.equals("move")) {
                    //Check if moving right is valid by the ANIMATIONAPP LOGIC
                    demo2.processAvatarMove("down");
                    
                    //if the avatar's movement changed, set the moveX to + 3, if not, nothing has changed
                    if (avatarBeforeMovement.equals(demo2.getAvatar())){
                        moveX -= 0;
                    } else {
                        moveY += 3;
                    }
                    //moveY += 3;
                }

                if ((mini.getXLocation(moveX) <= 758) && (mini.getXLocation(moveX) >= 0)) {
                    if((mini.getYLocation(moveY) >= 0) && ( mini.getYLocation(moveY) <= 742)) {
                        
                        
                        // Change the location of the avatar on the map
                        mini.moveAvatar(moveX, moveY);
                        /*
                        // Take the location of the actual avatar and make it match the one on the map
                        // Had to take the double value returned by the getX and getY methods into int
                        Double doubleNewX = avatarLocation.getX() + moveX;
                        Double doubleNewY = avatarLocation.getY() + moveY;
                        int newX = doubleNewX.intValue();
                        int newY = doubleNewY.intValue();
                        avatarLocation.setLocation(newX, newY);
                        */
                    }
                }
            }
        };
        // Movement Key Events
        scene.setOnKeyPressed(keyEvent -> {
                // Starts moving right when key is pressed
                if (keyEvent.getCode().toString() == "RIGHT")
                    Right = "move";
        
                // Starts moving left when key is pressed
                if (keyEvent.getCode().toString() == "LEFT")
                    Left = "move";
        
                // Starts moving up when key is pressed
                if (keyEvent.getCode().toString() == "UP")
                    Up = "move";
        
                // Starts moving down when key is pressed
                if (keyEvent.getCode().toString() == "DOWN")
                    Down = "move";
        });

        scene.setOnKeyReleased(keyEvent -> {
                // Stops moving right when key is released
                if (keyEvent.getCode().toString() == "RIGHT")
                    Right = "don't move";
        
                // Stops moving left when key is released
                if (keyEvent.getCode().toString() == "LEFT")
                    Left = "don't move";
        
                // Stops moving up when key is released
                if (keyEvent.getCode().toString() == "UP")
                    Up = "don't move";
        
                // Stops moving down when key is released
                if (keyEvent.getCode().toString() == "DOWN")
                    Down = "don't move";
        });
        moveTime.start();
    }
}

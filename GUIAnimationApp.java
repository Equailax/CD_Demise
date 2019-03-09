import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;

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

    //Instance variables for avatar
    String myName = "Minidisc";
    int myLife = 5;
    int myhealth = 5;
    int myDamage = 1;

    // Creation of the avatar, obstacles, and collectibles
   
    java.awt.Rectangle avatarLocation = new java.awt.Rectangle(72, 72, 100, 100);
    Avatar minidisc = new Avatar(myName, myLife, myhealth, myDamage, avatarLocation);
    private ArrayList<Collectible> collectiblesArray = new ArrayList<Collectible>();
    private ArrayList<Obstacle> obstacleArray = new ArrayList<Obstacle>();
    AnimationApp demo2 = new AnimationApp(minidisc, collectiblesArray, obstacleArray);

    public static void main(String[] args) {
        launch(args); // launches GUI application
    }

    public void start(Stage primaryStage) throws Exception {
       // Display Setup for the GUI
	Image map = new Image("Map 1000pixels.jpg");
        Pane root = new Pane();
        final Scene scene = new Scene(root, 1000, 1000, new ImagePattern(map));
	    
	// Display positions of life hearts for health
	for(int i = 0; i <= myhealth; i++)
	{
	    LifeHeart temp = new LifeHeart(25, 20+(30*i));
	    lifeHearts.add(temp);
	}
		
	// Display of life hearts on GUI
	for(int i = 0; i < myhealth; i++)
	{
	    root.getChildren().add(lifeHearts.get(i).getLocation());
	}
	
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
                if (Right.equals("move")) 
		{
                    mini.setForward();
                    moveX += 3;
                }
                if (Left.equals("move")) 
		{
                    mini.setBackward();
                    moveX -= 3;
                }
                if (Up.equals("move"))
                    moveY -= 3;
                if (Down.equals("move"))
                    moveY += 3;

                if ((mini.getXLocation(moveX) <= 758) && (mini.getXLocation(moveX) >= 0))
		{
		   if((mini.getYLocation(moveY) >= 0) && ( mini.getYLocation(moveY) <= 742))
		   {
                       	// Change the location of the avatar on the map
                        mini.moveAvatar(moveX, moveY);

                        // Take the location of the actual avatar and make it match the one on the map
                        // Had to take the double value returned by the getX and getY methods into int
                        Double doubleNewX = avatarLocation.getX() + moveX;
                        Double doubleNewY = avatarLocation.getY() + moveY;
                        int newX = doubleNewX.intValue();
                        int newY = doubleNewY.intValue();
                        avatarLocation.setLocation(newX, newY);
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

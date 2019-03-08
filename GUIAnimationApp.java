import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;

/**
 * GUI Display for the bank account of the user with deposit and withdraw
 * options, currently has no functions beyond the basic display
 */
// FINAL DRAFT

public class GUIAnimationApp extends Application {
    // Instance variables for avatar image
    boolean moveRight = false;
    boolean moveLeft = false;
    boolean moveUp = false;
    boolean moveDown = false;
    AvatarImage mini = new AvatarImage();

    //Instance variables for avatar
    String myName = "Minidisc";
    int myLife = 5;
    int myhealth = 5;
    int myDamage = 1;

    // Create the avatar, obstacls, and collectibles\
   
    java.awt.Rectangle avatarLocation = new java.awt.Rectangle(72, 72, 100, 100);
    Avatar minidisc = new Avatar(myName, myLife, myhealth, myDamage, avatarLocation);
    private ArrayList<Collectible> collectiblesArray = new ArrayList<Collectible>();
    private ArrayList<Obstacle> obstacleArray = new ArrayList<Obstacle>();
    AnimationApp demo2 = new AnimationApp(minidisc, collectiblesArray, obstacleArray);

    public static void main(String[] args) {
        launch(args); // launches GUI application
    }

    public void start(Stage primaryStage) throws Exception {
        Image map = new Image("Map 1000pixels.jpg");
    
        Pane root = new Pane();
        final Scene scene = new Scene(root, 1000, 1000, new ImagePattern(map));
        
        root.getChildren().add(mini.getAvatarImage());

        // Display Setup for the GUI
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        // Movement EvenHandlers
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                // Move right
                if (keyEvent.getCode().toString() == "RIGHT")
                    moveRight = true;

                // Move left
                if (keyEvent.getCode().toString() == "LEFT")
                    moveLeft = true;
                    
                // Move up
                if (keyEvent.getCode().toString() == "UP")
                    moveUp = true;

                // Move down
                if (keyEvent.getCode().toString() == "DOWN")
                    moveDown = true;
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                // Move right
                if (keyEvent.getCode().toString() == "RIGHT")
                    moveRight = false;

                // Move left
                if (keyEvent.getCode().toString() == "LEFT")
                    moveLeft = false;

                // Move up
                if (keyEvent.getCode().toString() == "UP")
                    moveUp = false;
                    
                // Move down
                if (keyEvent.getCode().toString() == "DOWN")
                    moveDown = false;

            }
        });

        // Creates animation movement
        AnimationTimer moveTime = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int moveX = 0;
                int moveY = 0;

                if (moveRight == true) {
                    mini.setForward();
                    moveX += 3;
                }
                if (moveLeft == true) {
                    mini.setBackward();
                    moveX -= 3;
                }
                if (moveUp == true)
                    moveY -= 3;
                if (moveDown == true)
                    moveY += 3;

                double avatarX = mini.getXLocation(moveX);
                double avatarY = mini.getYLocation(moveY);

                if ((avatarX <= 755) && (avatarX >= 0) && (avatarY >= 0) && (avatarY <= 640)) {
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
        };
        moveTime.start();

    }

}

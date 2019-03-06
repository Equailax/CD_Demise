import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;

/**
 * GUI Display for the bank account of the user with deposit and withdraw
 * options, currently has no functions beyond the basic display
 */
// FINAL DRAFT

public class GUIAnimationApp extends Application {
    boolean moveRight = false;
    boolean moveLeft = false;
    boolean moveUp = false;
    boolean moveDown = false;;
    

    // private Node character;

    public static void main(String[] args) {
        launch(args); // launches GUI application
    }

    public void start(Stage primaryStage) throws Exception {
        Image map = new Image("Map 1000pixels.jpg");

        Pane root = new Pane();
        final Scene scene = new Scene(root, 1000, 1000, new ImagePattern(map));

        Image avatarImage = new Image("Mini Test2.png");
        // Image avatarImageBackward = new Image("Mini Test2 Backward.png");

        Rectangle avatar = new Rectangle(72, 72, 100, 100);
        avatar.setFill(new ImagePattern(avatarImage));
        
                
        

        ImageView avatarForwards = new ImageView(avatarImage);
        // ImageView avatarBackwards = new ImageView(avatarImageBackward);

        root.getChildren().add(avatar);

        // Display Setup for the GUI
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        // Movement EvenHandlers
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                // Move right
                if (keyEvent.getCode().toString() == "RIGHT") {
                    moveRight = true;
                    return;
                }

                // Move left
                if (keyEvent.getCode().toString() == "LEFT") {
                    moveLeft = true;
                    return;
                }

                // Move up
                if (keyEvent.getCode().toString() == "UP") {

                    moveUp = true;
                    return;
                }

                // Move down
                if (keyEvent.getCode().toString() == "DOWN") {
                    moveDown = true;
                    return;
                }

            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                // Move right
                if (keyEvent.getCode().toString() == "RIGHT") {
                    moveRight = false;
                    return;
                }

                // Move left
                if (keyEvent.getCode().toString() == "LEFT") {
                    moveLeft = false;
                    return;
                }

                // Move up
                if (keyEvent.getCode().toString() == "UP") {
                    moveUp = false;
                    return;
                }

                // Move down
                if (keyEvent.getCode().toString() == "DOWN") {
                    moveDown = false;
                    return;
                }

            }
        });

        // Creates animation movement
        AnimationTimer moveTime = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int moveX = 0;
                int moveY = 0;

                if (moveRight == true) {
                    avatar.setFill(new ImagePattern(avatarImage));
                    moveX += 3;
                }
                if (moveLeft == true) {
                    // avatar.setFill(new ImagePattern(avatarImageBackward));
                    moveX -= 3;
                }
                if (moveUp == true)
                    moveY -= 3;
                if (moveDown == true)
                    moveY += 3;

                double avatarX = avatar.getLayoutX() + moveX;
                double avatarY = avatar.getLayoutY() + moveY;

                if ((avatarX <= 755) && (avatarX >= 0) && (avatarY >= 0) && (avatarY <= 640)) {
                    avatar.setLayoutX(avatar.getLayoutX() + moveX);
                    avatar.setLayoutY(avatar.getLayoutY() + moveY);
                }
            }
        };
        moveTime.start();

    }

}

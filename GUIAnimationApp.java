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
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.*;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;

import ObstaclePackage.*;
import AvatarPackage.*;
import CollectiblePackage.*;
import AnimationAppPackage.*;


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
    private boolean quit = false;
    private boolean restart = false;
    
    // Creation of the life hearts and the image of the avatar for the GUI
    //private AvatarImage mini = new AvatarImage();
    private ArrayList<LifeHeart> lifeHearts = new ArrayList<LifeHeart>();
    private ArrayList<Text> textList = new ArrayList<Text>();
    
    // Display Setup for the GUI
    private final Image map = new Image("Map 1000pixels.jpg");
    private final ImagePattern mapPattern = new ImagePattern(map);
    private Pane root = new Pane();
    private Pane startRoot = new Pane();

    private Scene scene = new Scene(root, 1000, 1000, mapPattern);
    private Scene startScene = new Scene(startRoot, 1000, 1000, mapPattern);
    
    // Instance variables
    // This creades an animation app instance
    private AnimationApp demo2 = new AnimationApp();
    
    // These are the image arrays for enemies and collectibles
    private ArrayList<Obstacle> obstacleGUIArray = demo2.getObstacleArray();
    private ArrayList<Collectible> collectibleGUIArray = demo2.getCollectiblesArray();
    
    private Avatar mini = demo2.getAvatar();
    
    boolean addedEndGame = false;

    /**
    This is the initialize method for the gui animation application
    */
    public void initialize(Pane root){
        this.demo2.initialize();
        
        obstacleGUIArray = demo2.getObstacleArray();
        collectibleGUIArray = demo2.getCollectiblesArray();
        mini = demo2.getAvatar();
        
        // Display positions of life hearts for health
        Text life = new Text(5, 90, "LIVES: " + demo2.getAvatar().getLives());
        life.setFont(new Font("Times New Roman", 15));
        life.setFill(Color.YELLOW);
        textList.add(life);
        root.getChildren().add(life);
        
        // Display Health Number
        Text health = new Text(5, 120, "HEALTH\n      " + demo2.getAvatar().getHealth());
        
        health.setFont(new Font("Times New Roman", 15));
        health.setFill(Color.RED);
        textList.add(health);
        root.getChildren().add(health);
        
        // Distplay Obstacles
        for (Obstacle o : this.obstacleGUIArray) {
            root.getChildren().add(o.getEnemyImageRectangle());
        }
        
        // Display Collectibles
        for(Collectible c : this.collectibleGUIArray){
            c.setImage();
            root.getChildren().add(c.getCollectibleImageRectangle());
        }
        
        Text collection = new Text(0, 160, "Collectibles \nRemaining: " + demo2.getCollectiblesArray().size());
        
        collection.setFont(new Font("Times New Roman", 15));
        collection.setFill(Color.YELLOW);
        textList.add(collection);
        root.getChildren().add(collection);
        
        scene.setFill(mapPattern);
    }
	
	// Launches GUI application
    public static void main(String[] args) { 
        launch(args); 
    }
    
    public void start(Stage primaryStage) throws Exception {
        // Initialize the Animation App with 3 collectibles, 3 obstacles, and 3 enemies
        initialize(root);
        
        /*
        This sets up the start game screen
        */
        // Rectangle / hitbox
		Rectangle mouseHitbox = new Rectangle(0, 0, 1250, 1250); // IMPORTANT: Make the rectangle fill the whole window
		mouseHitbox.setFill(Color.rgb(0,0,0,0));
		root.getChildren().add(mouseHitbox);
        root.getChildren().add(mini.getAvatarImage());
		mini.setForward();
		mouseHitbox.toFront();
        
        scene.setFill(new ImagePattern(map));
        
        primaryStage.setResizable(false);
        
		//primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        //primaryStage.show();
        
        
        // Animation of movements
        AnimationTimer moveTime = new AnimationTimer(){
            @Override
            public void handle(long now) {
                int moveX = 0;
                int moveY = 0;
                
                // Avatar updatedAvatar = new Avatar(demo2.getAvatar());
                Avatar avatarBeforeMovement = new Avatar(demo2.getAvatar());
                if (right) {
                    mini.setForward();
                    
                    // Check if moving right is valid by the ANIMATIONAPP LOGIC
                    demo2.processAvatarMove("right");
                    
                    // If the avatar's movement changed, set the moveX to +5, if not, nothing has changed
                    if (avatarBeforeMovement.equals(demo2.getAvatar())){
                        moveX -= 0;
                    } else {
                        moveX += 5;
                    }
                }
                if (left) {
                    mini.setBackward();
                    
                    // Check if moving left is valid by the ANIMATIONAPP LOGIC
                    demo2.processAvatarMove("left");
                    
                    // If the avatar's movement changed, set the moveX to -5, if not, nothing has changed
                    if (avatarBeforeMovement.equals(demo2.getAvatar())){
                        moveX -= 0;
                    } else {
                        moveX -= 5;
                    }
                }
				avatarBeforeMovement = new Avatar(demo2.getAvatar());
                if (up) {
                    // Check if moving up is valid by the ANIMATIONAPP LOGIC
                    demo2.processAvatarMove("up");
                    
                    // If the avatar's movement changed, set the moveY to -5, if not, nothing has changed
                    if (avatarBeforeMovement.equals(demo2.getAvatar())){
                        moveY-= 0;
                    } else {
                        moveY -= 5;
                    }
                }
                if (down) {
                    // Check if moving down is valid by the ANIMATIONAPP LOGIC
                    demo2.processAvatarMove("down");
                    
                    // If the avatar's movement changed, set the moveY to +5, if not, nothing has changed
                    if (avatarBeforeMovement.equals(demo2.getAvatar())){
                        moveY -= 0;
                    } else {
                        moveY += 5;
                    }
                }
                if (quit) {
                    Platform.exit();
                }
                if (restart) {
                    root.getChildren().removeAll(root.getChildren());
                    
                    demo2 = new AnimationApp();

                    initialize(root);
                    root.getChildren().add(mouseHitbox);
                    root.getChildren().add(mini.getAvatarImage());
                    mini.setForward();
                    mouseHitbox.toFront();
                }
                
                // Check if the player has run out of health
                Avatar checkIfEndGameAvatar = new Avatar(demo2.getAvatar());
                if ((demo2.getCollectiblesArray().size() == 0)) {
                    
                    demo2 = new AnimationApp();
                    root.getChildren().removeAll(root.getChildren());
                    
                    Rectangle endGameScreen = new Rectangle(0,0,1000,1000);
                    endGameScreen.setFill(Color.BLACK);
                    root.getChildren().add(endGameScreen);
                    
                    //End of Game Title
                    Text endGameTitle = new Text("VICTORY!");
                    Font endTitleFont = new Font("Callibri", 80);
                    //endGameTitle.setTextFill(Color.WHITE);
                    endGameTitle.setFill(Color.WHITE);
                    endGameTitle.setLayoutX(320);
                    endGameTitle.setLayoutY(80);
                    endGameTitle.setFont(endTitleFont.font("Berlin Sans FB", FontWeight.BOLD, 80));
                    endGameTitle.setStroke(Color.BLUE);
                    endGameTitle.setStrokeWidth(2);
                    root.getChildren().add(endGameTitle);
                    
                    //Collector Picture
                    Image collector = new Image("collector.jpg");
                    ImageView collectorImage = new ImageView(collector);
                    collectorImage.setLayoutX(300);
                    collectorImage.setLayoutY(100);
                    collectorImage.setFitWidth(400);
                    collectorImage.setPreserveRatio(true);
                    collectorImage.setSmooth(true);
                    root.getChildren().add(collectorImage);
                    
                    //Record Image
                    Image record = new Image("Record.png");
                    ImageView recordImage = new ImageView(record);
                    recordImage.setLayoutX(545);
                    recordImage.setLayoutY(100);
                    recordImage.setFitWidth(60);
                    recordImage.setPreserveRatio(true);
                    root.getChildren().add(recordImage);
                    
                    //End of game statement
                    Text endStatement = new Text("Congratulations! You have succeessfully prevented Dotify, PearMusic, BeatsbyDro,\nand MyPhone from finding and stealing the Collector's precious records. The Collector can\nnow relax knowing that you have retrieved the lost music records from his collection.");
                    Font statementFont = new Font("Callibri", 22);
                    endStatement.setTextAlignment(TextAlignment.CENTER);
                    //endStatement.setTextFill(Color.WHITE);
                    endStatement.setFill(Color.WHITE);
                    endStatement.setFont(statementFont);
                    endStatement.setLayoutX(63);
                    endStatement.setLayoutY(350);
                    root.getChildren().add(endStatement);
                    
                    //Instruction to Restart
                    Text endGameRestart = new Text("TO RESTART, PRESS 'R'");
                    Font endRestartFont = new Font("Callibri", 22);
                    endGameRestart.setFill(Color.WHITE);
                    endGameRestart.setLayoutX(140);
                    endGameRestart.setLayoutY(500);
                    endGameRestart.setFont(endRestartFont.font("Berlin Sans FB", FontWeight.BOLD, 22));
                    endGameRestart.setStroke(Color.BLUE);
                    endGameRestart.setStrokeWidth(1);
                    root.getChildren().add(endGameRestart);
                    
                    //Instruction to Restart
                    Text endGameQuit = new Text("TO QUIT, PRESS 'Q'");
                    Font endQuitFont = new Font("Callibri", 22);
                    endGameQuit.setFill(Color.WHITE);
                    endGameQuit.setLayoutX(640);
                    endGameQuit.setLayoutY(500);
                    endGameQuit.setFont(endQuitFont.font("Berlin Sans FB", FontWeight.BOLD, 22));
                    endGameQuit.setStroke(Color.BLUE);
                    endGameQuit.setStrokeWidth(1);
                    root.getChildren().add(endGameQuit);
                    /*
                    //Stats Board
                    Rectangle endBoard = new Rectangle(250,650,500,230);
                    LinearGradient boardColor = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,  new Stop(0.2, Color.LIGHTGREEN), new Stop(0.8, Color.MEDIUMSEAGREEN));
                    endBoard.setFill(boardColor);
                    endBoard.setStroke(Color.WHITESMOKE);
                    endBoard.setStrokeWidth(6);
                    root.getChildren().add(endBoard);
                    */

                    //Exit button
                    /*
                    Button exitButton = new Button("EXIT GAME");
                    Font buttonFont = new Font("Callibri", 25);
                    exitButton.setPrefHeight(90);
                    exitButton.setPrefWidth(260);
                    exitButton.setLayoutY(700);
                    exitButton.setLayoutX(150);
                    exitButton.setStyle("-fx-background-color: #FFDD7D");
                    exitButton.setFont(buttonFont.font("Berlin Sans FB", FontWeight.BOLD, 35));
                    exitButton.setTextFill(Color.BLACK);
                    exitButton.setOnMouseEntered(actionEvent -> exitButton.setStyle("-fx-background-color: #FFB34E"));
                    exitButton.setOnMouseExited(actionEvent -> exitButton.setStyle("-fx-background-color: #FFDD7D"));
                    exitButton.setOnAction(actionEvent -> Platform.exit()); // exits program when button is clicked
                    root.getChildren().add(exitButton);
                    */
                    /*
                    //Restart Button
                    Button startOver = new Button("START OVER");
                    Font buttonFont2 = new Font("Callibri", 25);
                    startOver.setPrefHeight(90);
                    startOver.setPrefWidth(260);
                    startOver.setLayoutY(700);
                    startOver.setLayoutX(500);
                    startOver.setStyle("-fx-background-color: #FFDD7D");
                    startOver.setFont(buttonFont2.font("Berlin Sans FB", FontWeight.BOLD, 35));
                    startOver.setTextFill(Color.BLACK);
                    startOver.setOnMouseEntered(actionEvent -> startOver.setStyle("-fx-background-color: #FFB34E"));
                    startOver.setOnMouseExited(actionEvent -> startOver.setStyle("-fx-background-color: #FFDD7D"));
                    startOver.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            root.getChildren().removeAll(root.getChildren());
                            initialize(root);
                            primaryStage.setScene(scene);
                            /*
                             * This sets up the start game screen
                             */
                            // Rectangle / hitbox
                            /*
                            Rectangle mouseHitbox = new Rectangle(0, 0, 1250, 1250); // IMPORTANT: Make the rectangle
                                                                                     // fill the whole window
                            mouseHitbox.setFill(Color.rgb(0, 0, 0, 0));
                            root.getChildren().add(mouseHitbox);
                            root.getChildren().add(mini.getAvatarImage());
                            mini.setForward();
                            mouseHitbox.toFront();
                            primaryStage.setResizable(false);

                        }

                    });
                    root.getChildren().add(startOver);
                    */
                    
                    
                
                    /*
                    Text endBoardTitle = new Text("END OF GAME REPORT");
                    Font boardTitleFont = new Font("Callibri", 30);
                    endBoardTitle.setLayoutX(340);
                    endBoardTitle.setLayoutY(570);
                    endBoardTitle.setFont(boardTitleFont.font("Berlin Sans FB", FontWeight.BOLD, 30));
                    //endBoardTitle.setPrefHeight(200);
                    //endBoardTitle.setPrefWidth(400);
                    endBoardTitle.setUnderline(true);
                    root.getChildren().add(endBoardTitle);
                    */
                    
                    
                    //scene.setFill(new ImagePattern(map));
                    /*
                    primaryStage.setScene(scene);
                    primaryStage.setResizable(false);
                    primaryStage.show();
                    */
                    // If all collectibles have reached 0, the game is over
                    //
                    //root.getChildren().add(new Label("YOU WIN!"));
                } else if (!checkIfEndGameAvatar.checkIfEndGame(3)){
                    // If the avatar still has lives (game hasn't ended), then update the main avatar accordingly
                    demo2.setAvatar(checkIfEndGameAvatar);
                    
                    // Clear collectible count and health count
                    for (Text t : textList) {
                        root.getChildren().remove(t);
                        
                        int updatedHealth = demo2.getAvatar().getHealth();
                        int updatedLife = demo2.getAvatar().getLives();
                        int updatedCollectibles = demo2.getCollectiblesArray().size();
                        
                        if (t.getText().toUpperCase().contains("HEALTH")) {
                            t.setText("HEALTH\n      " + updatedHealth);
                            root.getChildren().add(t);
                        } else if (t.getText().toUpperCase().contains("LIVES")) {
                            t.setText("LIVES: " + updatedLife);
                            root.getChildren().add(t);
                        } else if (t.getText().toUpperCase().contains("COLLECTIBLES")) {
                            t.setText("Collectibles \nRemaining: " + updatedCollectibles);
                            root.getChildren().add(t);
                        }
                    }
                    
                    // Process the obstacle movement remove anything if necessary
                    demo2.processObstacleMove();
                    demo2.removeObstacles();
                    // Enemies
                    for (Obstacle o : obstacleGUIArray) {
                        root.getChildren().remove(o.getEnemyImageRectangle());
                    }
                    // Obstacles
                    obstacleGUIArray = demo2.getObstacleArray();
                    for (Obstacle o : obstacleGUIArray) {
                        root.getChildren().add(o.getEnemyImageRectangle());
                    }
					
                    // Collectibles
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
                            mini.setLives(demo2.getAvatar().getLives());
                            demo2.setAvatar(mini);
							
                            root.getChildren().add(mini.getAvatarImage());
                        
                        }
                    }
                    mouseHitbox.toFront();
                    
                }else if (checkIfEndGameAvatar.checkIfEndGame(3)){
                    // If the end game has been reached (avatar has lost all of their health and lives) then break from the loop and end the game
                    //root.getChildren().clear();
                    //demo2 = new AnimationApp();
                    root.getChildren().removeAll(root.getChildren());

                    // Set up the end game screen a new stage
                    Rectangle endGameScreen = new Rectangle(0, 0, 1000, 1000);
                    endGameScreen.setFill(Color.BLACK);
                    root.getChildren().add(endGameScreen);

                    // End of Game Title
                    Text endGameTitle = new Text("You Failed!");
                    Font endTitleFont = new Font("Callibri", 80);
                    // endGameTitle.setTextFill(Color.WHITE);
                    endGameTitle.setFill(Color.BLACK);
                    endGameTitle.setLayoutX(300);
                    endGameTitle.setLayoutY(300);
                    endGameTitle.setFont(endTitleFont.font("Berlin Sans FB", FontWeight.BOLD, 80));
                    endGameTitle.setStroke(Color.RED);
                    endGameTitle.setStrokeWidth(3);
                    root.getChildren().add(endGameTitle);

                    // End of game statement
                    Text endStatement = new Text("Better Luck Next Time");
                    Font statementFont = new Font("Callibri", 22);
                    endStatement.setTextAlignment(TextAlignment.CENTER);
                    // endStatement.setTextFill(Color.WHITE);
                    endStatement.setFill(Color.BLACK);
                    endStatement.setFont(statementFont.font("Berlin Sans FB", FontWeight.BOLD, 40));
                    endStatement.setStroke(Color.RED);
                    endStatement.setStrokeWidth(2);
                    endStatement.setLayoutX(300);
                    endStatement.setLayoutY(400);
                    root.getChildren().add(endStatement);
                    
                    //Instruction to Restart
                    Text gameOverRestart = new Text("TO RESTART, PRESS 'R'");
                    Font gameOverRestartFont = new Font("Callibri", 22);
                    gameOverRestart.setFill(Color.BLACK);
                    gameOverRestart.setLayoutX(140);
                    gameOverRestart.setLayoutY(500);
                    gameOverRestart.setFont(gameOverRestartFont.font("Berlin Sans FB", FontWeight.BOLD, 22));
                    gameOverRestart.setStroke(Color.RED);
                    gameOverRestart.setStrokeWidth(1);
                    root.getChildren().add(gameOverRestart);
                    
                    //Instruction to Restart
                    Text gameOverQuit = new Text("TO QUIT, PRESS 'Q'");
                    Font gameOverQuitFont = new Font("Callibri", 22);
                    gameOverQuit.setFill(Color.BLACK);
                    gameOverQuit.setLayoutX(640);
                    gameOverQuit.setLayoutY(500);
                    gameOverQuit.setFont(gameOverQuitFont.font("Berlin Sans FB", FontWeight.BOLD, 22));
                    gameOverQuit.setStroke(Color.RED);
                    gameOverQuit.setStrokeWidth(1);
                    root.getChildren().add(gameOverQuit);
                    
                    /*
                     * //Stats Board Rectangle endBoard = new Rectangle(250,650,500,230);
                     * LinearGradient boardColor = new LinearGradient(0, 0, 0, 1, true,
                     * CycleMethod.NO_CYCLE, new Stop(0.2, Color.LIGHTGREEN), new Stop(0.8,
                     * Color.MEDIUMSEAGREEN)); endBoard.setFill(boardColor);
                     * endBoard.setStroke(Color.WHITESMOKE); endBoard.setStrokeWidth(6);
                     * root.getChildren().add(endBoard);
                     */

                    // Exit button
                    /*
                    Button exitButton = new Button("EXIT GAME");
                    Font buttonFont = new Font("Callibri", 25);
                    exitButton.setPrefHeight(90);
                    exitButton.setPrefWidth(260);
                    exitButton.setLayoutY(700);
                    exitButton.setLayoutX(150);
                    exitButton.setStyle("-fx-background-color: #FFDD7D");
                    exitButton.setFont(buttonFont.font("Berlin Sans FB", FontWeight.BOLD, 35));
                    exitButton.setTextFill(Color.BLACK);
                    exitButton.setOnMouseEntered(actionEvent -> exitButton.setStyle("-fx-background-color: #FFB34E"));
                    exitButton.setOnMouseExited(actionEvent -> exitButton.setStyle("-fx-background-color: #FFDD7D"));
                    exitButton.setOnAction(actionEvent -> Platform.exit()); // exits program when button is clicked
                    root.getChildren().add(exitButton);
                    */
                    /*
                    // Restart Button
                    Button startOver = new Button("START OVER");
                    Font buttonFont2 = new Font("Callibri", 25);
                    startOver.setPrefHeight(90);
                    startOver.setPrefWidth(260);
                    startOver.setLayoutY(700);
                    startOver.setLayoutX(500);
                    startOver.setStyle("-fx-background-color: #FFDD7D");
                    startOver.setFont(buttonFont2.font("Berlin Sans FB", FontWeight.BOLD, 35));
                    startOver.setTextFill(Color.BLACK);
                    startOver.setOnMouseEntered(actionEvent -> startOver.setStyle("-fx-background-color: #FFB34E"));
                    startOver.setOnMouseExited(actionEvent -> startOver.setStyle("-fx-background-color: #FFDD7D"));
                    startOver.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            root.getChildren().removeAll(root.getChildren());
                            initialize(root);
                            scene.setFill(mapPattern);
                            /*
                             * This sets up the start game screen
                             */
                            // Rectangle / hitbox
                            /*
                            Rectangle mouseHitbox = new Rectangle(0, 0, 1250, 1250); // IMPORTANT: Make the rectangle
                                                                                     // fill the whole window
                            mouseHitbox.setFill(Color.rgb(0, 0, 0, 0));
                            root.getChildren().add(mouseHitbox);
                            root.getChildren().add(mini.getAvatarImage());
                            mini.setForward();
                            mouseHitbox.toFront();
                            primaryStage.setScene(scene);
                            primaryStage.setResizable(false);

                        }

                    });
                    root.getChildren().add(startOver);
                    */

                }
                mouseHitbox.toFront();
            }};
            
        // Move when a key is pressed
        scene.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode().toString() == "D")
                    right = true;
                if (keyEvent.getCode().toString() == "A")
                    left = true;
                if (keyEvent.getCode().toString() == "W")
                    up = true;
                if (keyEvent.getCode().toString() == "S")
                    down = true;
                if (keyEvent.getCode().toString() == "Q")
                    quit = true;
                if (keyEvent.getCode().toString() == "R")
                    restart = true;
        });

		// Stop moving when the key is no longer pressed
        scene.setOnKeyReleased(keyEvent -> {
                if (keyEvent.getCode().toString() == "D")
                    right = false;
                if (keyEvent.getCode().toString() == "A")
                    left = false;
                if (keyEvent.getCode().toString() == "W")
                    up = false;
                if (keyEvent.getCode().toString() == "S")
                    down = false;
                if (keyEvent.getCode().toString() == "Q")
                    quit = false;
                if (keyEvent.getCode().toString() == "R")
                    restart = false;
        });
		
		// When clicking left mouse button
		mouseHitbox.setOnMouseClicked(mouseEvent ->
		{
			// Calculate the center of the avatar relative to the window
			double avatarXCenter = (demo2.getAvatar().getLocation().getX()+27);
			double avatarYCenter = (demo2.getAvatar().getLocation().getY()+33.5);
			
			// Print game state
			System.out.println(demo2.getAvatar().getLocation());
            System.out.println(mini.getXImageLayout() + " " + mini.getYImageLayout());
            System.out.println(mini.getAvatarImage().getX() + " " + mini.getAvatarImage().getY());
            demo2.printCurrentState();
            
			// Calculate the angle between the avatar and the mouse
			double angle = Math.toDegrees(Math.atan2(mouseEvent.getX()-(avatarXCenter), mouseEvent.getY()-(avatarYCenter)))+180;
			System.out.println("Click (" + mouseEvent.getX() + ", " + mouseEvent.getY() + ")");
			System.out.println(angle);
			
			// Print to console the direction that the mouse click is relative to the avatar's rectangle.
			// The angle is a circle with 0 starting at the top and increases as the mouse moves counter clockwise
			// Shoot a projectile in the direction clicked
			if (angle > 337.5)
			{
				System.out.println("North");
                mini.shootProjectile("up");
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
				this.obstacleGUIArray.add(avatarProjectile);
			} else if (angle > 292.5)
			{
				System.out.println("North East");
                mini.shootProjectile("upright");
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
				this.obstacleGUIArray.add(avatarProjectile);
			} else if (angle > 247.5)
			{
				System.out.println("East");
                mini.shootProjectile("right");
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
				this.obstacleGUIArray.add(avatarProjectile);
			} else if (angle > 202.5)
			{
				System.out.println("South East");
                mini.shootProjectile("downright");
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
				this.obstacleGUIArray.add(avatarProjectile);
			} else if (angle > 157.5)
			{
				System.out.println("South");
                mini.shootProjectile("down");
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
				this.obstacleGUIArray.add(avatarProjectile);
			} else if (angle > 112.5)
			{
				System.out.println("South West");
                mini.shootProjectile("downleft");
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
				this.obstacleGUIArray.add(avatarProjectile);
			} else if (angle > 67.5)
			{
				System.out.println("West");
                mini.shootProjectile("left");
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
				this.obstacleGUIArray.add(avatarProjectile);
			} else if (angle > 22.5)
			{
				System.out.println("North West");
                mini.shootProjectile("upleft");
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
				this.obstacleGUIArray.add(avatarProjectile);
			} else if (angle >= 0)
			{
				System.out.println("North");
                mini.shootProjectile("up");
                Projectile avatarProjectile = new Projectile(mini.getProjectile());
				this.obstacleGUIArray.add(avatarProjectile);
			}
            demo2.setObstacleArray(this.obstacleGUIArray);
			mouseHitbox.toFront();
		});
		
		// Enemy Attack Timer
		Timeline enemyTimer = new Timeline(new KeyFrame(Duration.seconds(2.5), ActionEvent ->
		{
			ArrayList<Obstacle> newProjectile = new ArrayList<Obstacle>();
			for (Obstacle o : this.obstacleGUIArray)
			{
				if (o instanceof Enemy)
				{
					((Enemy)o).shootProjectile("left");
					Projectile enemyProjectile = new Projectile(((Enemy)o).getProjectile());
					newProjectile.add(enemyProjectile);
				}
			}
			this.obstacleGUIArray.addAll(newProjectile);
			demo2.setObstacleArray(this.obstacleGUIArray);
		}));
        
        //Game Title
        Rectangle startGameScreen = new Rectangle(0,0,1100,1100);
        startGameScreen.setFill(Color.BLACK);
        startRoot.getChildren().add(startGameScreen);
        
        //Game Title
        Text startGameTitle = new Text("CD\nDEMISE");
        Font startTitleFont = new Font("Callibri", 100);
        startGameTitle.setFill(Color.WHITE);
        startGameTitle.setLayoutX(320);
        startGameTitle.setLayoutY(150);
        startGameTitle.setFont(startTitleFont.font("Berlin Sans FB", FontWeight.BOLD, 100));
        startGameTitle.setStroke(Color.DODGERBLUE);
        startGameTitle.setTextAlignment(TextAlignment.CENTER);
        startGameTitle.setStrokeWidth(3);
        startRoot.getChildren().add(startGameTitle);

        

        //  What to press to start gameText 
        Text startGameButton = new Text(" PRESS 'T' TO \nSTART GAME");
        Font startTitleButton = new Font("Callibri", 70);
        startGameButton.setFill(Color.WHITE);
        startGameButton.setLayoutX(270);
        startGameButton.setLayoutY(400);
        startGameButton.setFont(startTitleFont.font("Berlin Sans FB", FontWeight.BOLD, 70));
        startGameButton.setStroke(Color.RED);
        startGameButton.setTextAlignment(TextAlignment.CENTER);
        startGameButton.setStrokeWidth(3);
        startRoot.getChildren().add(startGameButton);


        //Start game button
        /*
        Button startGame = new Button("START GAME");
        Font buttonFont = new Font("Callibri", 25);
        startGame.setPrefHeight(100);
        startGame.setPrefWidth(310);
        startGame.setLayoutY(750);
        startGame.setLayoutX(345);
        startGame.setStyle("-fx-background-color: #7AFB7D");
        startGame.setFont(buttonFont.font("Berlin Sans FB", FontWeight.BOLD, 40));
        startGame.setTextFill(Color.BLACK);
        startGame.setOnMouseEntered(actionEvent -> startGame.setStyle("-fx-background-color: #4FFE79"));
        startGame.setOnMouseExited(actionEvent -> startGame.setStyle("-fx-background-color: #7AFB7D"));
        startGame.setOnAction(actionEvent -> Platform.exit()); //change this action to screen reset
        root.getChildren().add(startGame);
        */

        
        //Start game button
        /*
        Button startGame = new Button("START GAME");
        Font buttonFont = new Font("Callibri", 25);
        startGame.setPrefHeight(100);
        startGame.setPrefWidth(310);
        startGame.setLayoutY(750);
        startGame.setLayoutX(345);
        startGame.setStyle("-fx-background-color: #7AFB7D");
        startGame.setFont(buttonFont.font("Berlin Sans FB", FontWeight.BOLD, 40));
        startGame.setTextFill(Color.BLACK);
        startGame.setOnMouseEntered(actionEvent -> startGame.setStyle("-fx-background-color: #4FFE79"));
        startGame.setOnMouseExited(actionEvent -> startGame.setStyle("-fx-background-color: #7AFB7D"));
        startGame.setOnAction(actionEvent -> {
            
            startRoot.getChildren().remove(startGameScreen);
            startRoot.getChildren().remove(startGame);
            startRoot.getChildren().remove(startGameTitle);
            mouseHitbox.toFront();
        
            scene.setFill(new ImagePattern(map));

            // Start timers
            enemyTimer.setCycleCount(Timeline.INDEFINITE);
            enemyTimer.play();
            moveTime.start();
            
                        
            primaryStage.setScene(scene);
        
        }); //change this action to screen reset
        startRoot.getChildren().add(startGame);
    */
        startScene.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode().toString() == "T") {
                    startRoot.getChildren().clear();
                    
                    scene.setFill(new ImagePattern(map));
                    // Start timers
                    enemyTimer.setCycleCount(Timeline.INDEFINITE);
                    enemyTimer.play();
                    moveTime.start();    
                    primaryStage.setScene(scene);
                    
                    mouseHitbox.toFront();
                }
        });
        primaryStage.setScene(startScene);
        primaryStage.show();
        mouseHitbox.toFront();
        
        /*
        //Create a start screen timer
        AnimationTimer startScreenTime = new AnimationTimer(){
            @Override
            public void handle(long now) {
                
            }
        };
        */
        
		// Print game state
        demo2.printCurrentState();
    }
};


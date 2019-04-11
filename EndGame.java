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
import javafx.scene.text.Text;

public class EndGame extends Application
{

Pane root = new Pane();
Scene scene = new Scene(root,1000,1000);

public static void main(String[] args)
{
	launch(args);
}

public void start(Stage primaryStage) throws Exception{
	
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
	//Start over button
	Button startOver = new Button("START OVER");
	Font buttonFont = new Font("Callibri", 25);
	startOver.setPrefHeight(90);
	startOver.setPrefWidth(260);
	startOver.setLayoutY(900);
	startOver.setLayoutX(190);
	startOver.setStyle("-fx-background-color: #FFDD7D");
	startOver.setFont(buttonFont.font("Berlin Sans FB", FontWeight.BOLD, 35));
	startOver.setTextFill(Color.BLACK);
	startOver.setOnMouseEntered(actionEvent -> startOver.setStyle("-fx-background-color: #FFB34E"));
	startOver.setOnMouseExited(actionEvent -> startOver.setStyle("-fx-background-color: #FFDD7D"));
	startOver.setOnAction(actionEvent -> Platform.exit()); //change this action to screen reset
	root.getChildren().add(startOver);
	
	//Exit button
	Button exitButton = new Button("EXIT GAME");
	exitButton.setPrefHeight(90);
	exitButton.setPrefWidth(260);
	exitButton.setLayoutY(900);
	exitButton.setLayoutX(550);
	exitButton.setStyle("-fx-background-color: #FFDD7D");
	exitButton.setFont(buttonFont.font("Berlin Sans FB", FontWeight.BOLD, 35));
	exitButton.setTextFill(Color.BLACK);
	exitButton.setOnMouseEntered(actionEvent -> exitButton.setStyle("-fx-background-color: #FFB34E"));
	exitButton.setOnMouseExited(actionEvent -> exitButton.setStyle("-fx-background-color: #FFDD7D"));
    exitButton.setOnAction(actionEvent -> Platform.exit()); //exits program when button is clicked
	root.getChildren().add(exitButton);
	*/
	primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
    
	
}

}
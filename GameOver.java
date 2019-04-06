import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.*;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Text;

public class GameOver extends Application
{

Pane root = new Pane();
Scene scene = new Scene(root,1000,1000);

public static void main(String[] args)
{
	launch(args);
}

public void start(Stage primaryStage) throws Exception{
	
	Rectangle endGameScreen = new Rectangle(0,0,1100,1100);
	endGameScreen.setFill(Color.BLACK);
	root.getChildren().add(endGameScreen);
	
	//Game Title
	Text endGameTitle = new Text("GAME OVER");
	Font endTitleFont = new Font("Callibri", 120);
	endGameTitle.setFill(Color.RED);
	endGameTitle.setLayoutX(160);
	endGameTitle.setLayoutY(450);
	endGameTitle.setFont(endTitleFont.font("Berlin Sans FB", FontWeight.BOLD, 120));
	endGameTitle.setTextAlignment(TextAlignment.CENTER);
	root.getChildren().add(endGameTitle);


	//Start game button
	Button startOver = new Button("START OVER");
	Font buttonFont = new Font("Callibri", 25);
	startOver.setPrefHeight(100);
	startOver.setPrefWidth(310);
	startOver.setLayoutY(750);
	startOver.setLayoutX(345);
	startOver.setStyle("-fx-background-color: #7AFB7D");
	startOver.setFont(buttonFont.font("Berlin Sans FB", FontWeight.BOLD, 40));
	startOver.setTextFill(Color.BLACK);
	startOver.setOnMouseEntered(actionEvent -> startOver.setStyle("-fx-background-color: #4FFE79"));
	startOver.setOnMouseExited(actionEvent -> startOver.setStyle("-fx-background-color: #7AFB7D"));
	startOver.setOnAction(actionEvent -> Platform.exit()); //change this action to screen reset
	root.getChildren().add(startOver);
	
	
	primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
	
}

}
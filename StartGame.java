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

public class StartGame extends Application
{

Pane root = new Pane();
Scene scene = new Scene(root,1000,1000);

public static void main(String[] args)
{
	launch(args);
}

public void start(Stage primaryStage) throws Exception{
	
	Rectangle endGameScreen = new Rectangle(0,0,1100,1100);
	startGameScreen.setFill(Color.BLACK);
	root.getChildren().add(startGameScreen);
	
	//Game Title
	Text starGameTitle = new Text("CD\nDEMISE");
	Font endTitleFont = new Font("Callibri", 150);
	startGameTitle.setFill(Color.WHITE);
	startGameTitle.setLayoutX(180);
	startGameTitle.setLayoutY(320);
	startGameTitle.setFont(endTitleFont.font("Berlin Sans FB", FontWeight.BOLD, 180));
	startGameTitle.setStroke(Color.DODGERBLUE);
	startGameTitle.setTextAlignment(TextAlignment.CENTER);
	startGameTitle.setStrokeWidth(6);
	root.getChildren().add(startGameTitle);


	//Start game button
	Button startGame = new Button("START GAME");
	Font buttonFont = new Font("Callibri", 25);
	startGame.setPrefHeight(100);
	startGame.setPrefWidth(310);
	startGame.setLayoutY(750);
	startGame.setLayoutX(345);
	startGame.setStyle("-fx-background-color: #7AFB7D");
	startGame.setFont(buttonFont.font("Berlin Sans FB", FontWeight.BOLD, 40));
	startGame.setTextFill(Color.BLACK);
	startGame.setOnMouseEntered(actionEvent -> startOver.setStyle("-fx-background-color: #4FFE79"));
	startGame.setOnMouseExited(actionEvent -> startOver.setStyle("-fx-background-color: #7AFB7D"));
	startGame.setOnAction(actionEvent -> Platform.exit()); //change this action to screen reset
	root.getChildren().add(startGame);
	
	
	primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
	
}

}

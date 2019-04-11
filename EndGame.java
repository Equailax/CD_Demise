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

public class EndGame extends Application
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
	
	//End of Game Title
	Label endGameTitle = new Label("VICTORY!");
	Font endTitleFont = new Font("Callibri", 80);
	endGameTitle.setTextFill(Color.WHITE);
	endGameTitle.setLayoutX(320);
	endGameTitle.setLayoutY(0);
	endGameTitle.setFont(endTitleFont.font("Berlin Sans FB", FontWeight.BOLD, 80));
	endGameTitle.setPrefWidth(400);
	endGameTitle.setPrefHeight(80);
	root.getChildren().add(endGameTitle);
	
	//Collector Picture
	Image collector = new Image("collector.jpg");
	ImageView collectorImage = new ImageView(collector);
	collectorImage.setLayoutX(100);
	collectorImage.setLayoutY(100);
	collectorImage.setFitWidth(800);
	collectorImage.setPreserveRatio(true);
	collectorImage.setSmooth(true);
	root.getChildren().add(collectorImage);
	
	//Record Image
	Image record = new Image("Record.png");
	ImageView recordImage = new ImageView(record);
	recordImage.setLayoutX(590);
	recordImage.setLayoutY(95);
	recordImage.setFitWidth(120);
	recordImage.setPreserveRatio(true);
	root.getChildren().add(recordImage);
	
	//End of game statement
	Label endStatement = new Label("Congratulations! You have succeessfully prevented Dotify, PearMusic, BeatsbyDro,\nand MyPhone from finding and stealing the Collector's precious records. The Collector can\nnow relax knowing that you have retrieved the lost music records from his collection.");
	Font statementFont = new Font("Callibri", 22);
	endStatement.setTextAlignment(TextAlignment.CENTER);
	endStatement.setTextFill(Color.WHITE);
	endStatement.setFont(statementFont);
	endStatement.setLayoutX(63);
	endStatement.setLayoutY(700);
	root.getChildren().add(endStatement);
	
	//Stats Board
	Rectangle endBoard = new Rectangle(250,650,500,230);
	LinearGradient boardColor = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,  new Stop(0.2, Color.LIGHTGREEN), new Stop(0.8, Color.MEDIUMSEAGREEN));
	endBoard.setFill(boardColor);
	endBoard.setStroke(Color.WHITESMOKE);
	endBoard.setStrokeWidth(6);
	root.getChildren().add(endBoard);
	
	Label endBoardTitle = new Label("END OF GAME REPORT");
	Font boardTitleFont = new Font("Callibri", 30);
	endBoardTitle.setLayoutX(340);
	endBoardTitle.setLayoutY(570);
	endBoardTitle.setFont(boardTitleFont.font("Berlin Sans FB", FontWeight.BOLD, 30));
	endBoardTitle.setPrefHeight(200);
	endBoardTitle.setPrefWidth(400);
	endBoardTitle.setUnderline(true);
	root.getChildren().add(endBoardTitle);
	
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
	
	primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
	
}

}
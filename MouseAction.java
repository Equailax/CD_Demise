import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseAction extends Application
{
	public void start(Stage primaryStage) throws Exception
	{
		// Pane
		Pane root = new Pane();
		
		
		// Rectangle / hitbox
		Rectangle r = new Rectangle(50, 50, 400, 200);
		root.getChildren().add(r);
		// Mouse moves into rectangle
		r.setOnMouseEntered(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent event)
			{
				System.out.println("Hello");
			}
		}
		);
		// Mouse exits rectangle
		r.setOnMouseExited(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent event)
			{
				System.out.println("Goodbye");
			}
		}
		);
		// Mouse click inside rectangle and mouse x/y
		r.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent event)
			{
				System.out.println("Click (" + event.getX() + ", " + event.getY() + ")");
			}
		}
		);
		
		
		// Scene
		Scene scene = new Scene(root, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
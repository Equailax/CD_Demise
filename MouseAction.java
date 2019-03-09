import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.Math;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MouseAction extends Application
{
	public void start(Stage primaryStage) throws Exception
	{
		int winX = 500;
		int winY = 300;
		// Pane
		Pane root = new Pane();
		
		// Avatar / hitbox                                       This avatar rectangle can be replaced with the actual avatar
		Rectangle avatar = new Rectangle(300, 250, 10, 10);
		root.getChildren().add(avatar);
		// Rectangle / hitbox
		Rectangle r = new Rectangle(0, 0, winX, winY);           // IMPORTANT: Make the rectangle fill the whole window
		r.setFill(Color.rgb(0,0,0,0));                           // IMPORTANT: This makes the rectangle transparent
		root.getChildren().add(r);                               // IMPORTANT: Add the mouse rectangle to root last
		
		// Mouse moves into rectangle                               CAN BE DELETED
		r.setOnMouseEntered(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent event)
			{
				System.out.println("Hello");
			}
		}
		);
		// Mouse exits rectangle                                    CAN BE DELETED
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
				System.out.println("Click (" + event.getX() + ", " + event.getY() + ")"); // CAN BE DELETED
				double angle = Math.toDegrees(Math.atan2(event.getX()-(avatar.getX()+(avatar.getWidth()/2)), event.getY()-(avatar.getY()+(avatar.getHeight()/2))))+180;      // Make sure you use the avatar's rectangle or use the getters and add half the width/height so that x/y is the center and not the origin
				
				System.out.println(angle);// CAN BE DELETED
				
				// Print to console the direction that the mouse click is relative to the avatar's rectangle. The angle is a circle with 0 starting at the top and increases as the mouse moves counter clockwise
				if (angle > 337.5)
				{
					System.out.println("North");
				} else if (angle > 292.5)
				{
					System.out.println("North East");
				} else if (angle > 247.5)
				{
					System.out.println("East");
				} else if (angle > 202.5)
				{
					System.out.println("South East");
				} else if (angle > 157.5)
				{
					System.out.println("South");
				} else if (angle > 112.5)
				{
					System.out.println("South West");
				} else if (angle > 67.5)
				{
					System.out.println("West");
				} else if (angle > 22.5)
				{
					System.out.println("North West");
				} else if (angle >= 0)
				{
					System.out.println("North");
				}
			}
		}
		);
		
		
		// Scene
		Scene scene = new Scene(root, winX, winY);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
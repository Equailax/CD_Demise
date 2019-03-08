import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.ImagePattern;

public class LifeHeart
{
	private int numberofHearts;
	private Image heart = new Image("LifeHeart.png");
	private Rectangle location;
	private final int width = 55;
	private final int height = 50;

	public Rectangle getLocation()
	{
		return location;
	}

	public int getNumberOfHearts()
	{
		return numberofHearts;
	}

	public void setDisplay(int xcoord, int ycoord)
	{
		this.location.setX(xcoord);
		this.location.setY(ycoord);
	}

	public void setNumberOfHearts(int numberofHearts)
	{
		this.numberofHearts = numberofHearts;
	}

	public void displayHearts(int xcoord, int ycoord)
	{
		//To be determined
	}

	public LifeHeart()
	{	}

	public LifeHeart(int xcoord, int ycoord)
	{
		this.heart = new Image("LifeHeart.png");
		this.location = new Rectangle(xcoord, ycoord, 25, 20);
		this.location.setFill(new ImagePattern(heart));
	}
			

}
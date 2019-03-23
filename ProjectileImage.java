import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;

public class ProjectileImage
{
	private Image projectile;
	private Rectangle location = new Rectangle(0,0,0,0);
	private int xcoord;
	private int ycoord;
	private int moveX;
	private int moveY;

	public Rectangle getImageLocation()
	{
		return location;
	}

	public void setLocationX(int xcoord)
	{
		this.location.setX(xcoord);
	}
	
	public void setLocationY(int ycoord)
	{
		this.location.setY(ycoord);
	}

	public void setImage()
	{
		projectile = new Image("MusicNote.png");
		this.location = new Rectangle(xcoord, ycoord, 22, 37);
		this.location.setFill(new ImagePattern(projectile));
	}

	public void moveProjectile(int moveX, int moveY)
	{
		this.moveX = moveX;
		this.moveY = moveY;
		location.setLayoutX(location.getLayoutX() + moveX);
		location.setLayoutY(location.getLayoutY() + moveY);
	}

	public ProjectileImage()
	{	}

	public ProjectileImage(int xcoord, int ycoord)
	{
		projectile = new Image("MusicNote.png");
		this.location = new Rectangle(xcoord, ycoord, 22, 37);
		this.location.setFill(new ImagePattern(projectile));
	}

}
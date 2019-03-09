import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.ImagePattern;


public class EnemyImage
{
	private Image enemy;
	private Rectangle location = new Rectangle(0,0,0,0);
	private String type;
	private int xcoord; //*****remove
	private int ycoord; //***** remove
	
	public Rectangle getLocation()
	{
		return location;
	}

	public String getType()
	{
		return type;
	}
	
	public void setLocation(int xcoord, int ycoord)
	{
			this.xcoord = xcoord;
			this.ycoord = ycoord;
			this.location.setX(xcoord);
			this.location.setY(ycoord);
	}
	
	public void setImageType(String type)
	{
		this.type = type.toUpperCase();
	
		if(this.type.equals("DOTIFY"))
		{
			enemy = new Image("Dotify.png");
			this.location = new Rectangle(xcoord, ycoord, 54, 67);
			this.location.setFill(new ImagePattern(enemy));
		}
		if(this.type.equals("BEATSBYDRO"))
		{
			enemy = new Image("BeatsbyDro.png");
			this.location = new Rectangle(xcoord, ycoord, 37, 67);
			this.location.setFill(new ImagePattern(enemy));
		}
		if(this.type.equals("PEARMUSIC"))
		{
			enemy = new Image("PearMusic.png");
			this.location = new Rectangle(xcoord, ycoord, 40, 67);
			this.location.setFill(new ImagePattern(enemy));
		}
	}

	public void setImageForward()
	{
		if(this.type.equals("DOTIFY"))
		{
			enemy = new Image("Dotify.png");
			this.location.setFill(new ImagePattern(enemy));
		}
		if(this.type.equals("BEATSBYDRO"))
		{
			enemy = new Image("BeatsbyDro.png");
			this.location.setFill(new ImagePattern(enemy));
		}
		if(this.type.equals("PEARMUSIC"))
		{
			enemy = new Image("PearMusic.png");
			this.location.setFill(new ImagePattern(enemy));
		}
	}
	
	public void setImageBackward()
	{
		if(this.type.equals("DOTIFY"))
		{
			enemy = new Image("Dotify Backward.png");
			this.location.setFill(new ImagePattern(enemy));
		}
		if(this.type.equals("BEATSBYDRO"))
		{
			enemy = new Image("BeatsbyDro Backward.png");
			this.location.setFill(new ImagePattern(enemy));
		}
		if(this.type.equals("PEARMUSIC"))
		{
			enemy = new Image("PearMusic Backward.png");
			this.location.setFill(new ImagePattern(enemy));
		}
	}
	
	public EnemyImage()
	{	}
	
	public EnemyImage(String type, int xcoord, int ycoord)
	{
		this.type = type.toUpperCase();
		this.xcoord = xcoord;
		this.ycoord = ycoord;
	
		if(this.type.equals("DOTIFY"))
		{
			enemy = new Image("Dotify.png");
			this.location = new Rectangle(xcoord, ycoord, 54, 67);
			this.location.setFill(new ImagePattern(enemy));
		}
		if(this.type.equals("BEATSBYDRO"))
		{
			enemy = new Image("BeatsbyDro.png");
			this.location = new Rectangle(xcoord, ycoord, 37, 67);
			this.location.setFill(new ImagePattern(enemy));
		}
		if(this.type.equals("PEARMUSIC"))
		{
			enemy = new Image("PearMusic.png");
			this.location = new Rectangle(xcoord, ycoord, 40, 67);
			this.location.setFill(new ImagePattern(enemy));
		}
	}	

}

import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class AvatarImage
{
	    Image avatarImageForward;
        Image avatarImageBackward;
        Rectangle avatar;
		int avatarX;
		int avatarY;
		int moveX;
		int moveY;

		public void setForward()
		{
			this.avatar.setFill(new ImagePattern(avatarImageForward));
		}
		
		public void setBackward()
		{
			this.avatar.setFill(new ImagePattern(avatarImageBackward));
		}
		
		public Rectangle getAvatarImage()
		{
			return this.avatar;
		}
		
		public double getXLocation(int moveX)
		{
			this.moveX = moveX;
			return avatar.getLayoutX() + moveX;
		}
		
		public double getYLocation(int moveY)
		{
			this.moveY = moveY;
			return avatar.getLayoutY() + moveY;
		}
		
		public void moveAvatar(int moveX, int moveY)
		{
					this.moveX = moveX;
					this.moveY = moveY;
			        avatar.setLayoutX(avatar.getLayoutX() + moveX);
                    avatar.setLayoutY(avatar.getLayoutY() + moveY);
		}
		
		public AvatarImage()
		{
			this.avatarImageForward = new Image("Mini Test2.png");
			this.avatarImageBackward = new Image("Mini Test2 Backward.png");
			this.avatar = new Rectangle(78, 85, 100, 100);
			this.avatar.setFill(new ImagePattern(avatarImageForward));
			
		}




}
import static org.junit.Assert.*;
import java.beans.Transient;
import org.junit.Test;
import java.awt.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;


public class AvatarTest {

    public class MockAvatar extends Avatar{
        public MockAvatar(){super();};
        public MockAvatar(String myName, int myLife, int myhealth, int myDamage, Rectangle location){
            super(myName, myLife, myhealth, myDamage, location);
        }
        public MockAvatar(Avatar avatarToCopy){
            super(avatarToCopy);
        }

    }

    @Test
    public void test_Instance_Variables(){
        Rectangle location = new Rectangle(100, 100, 54, 67);
        Avatar avatar = new MockAvatar("Avatar", 4, 4, 1, location);
        assertEquals("Expected name 'Avatar'.", "Avatar", avatar.getName());
        assertEquals("Expected 4 health.", 4, avatar.getHealth(), 0.00001);
        assertEquals("Expected 4 lives.", 4, avatar.getLives(), 0.00001);
        assertEquals("Expected 1 damage.", 1, avatar.getDamage(), 0.00001);
        assertEquals("Expected Xposition to be 100.", 100, avatar.getLocation().getX(), 0.00001);
        assertEquals("Expected Yposition to be 100.", 100, avatar.getLocation().getY(), 0.00001);
        assertEquals("Expected width to be 100.", 54, avatar.getLocation().getWidth(), 0.00001);
        assertEquals("Expected height to be 100.", 67, avatar.getLocation().getHeight(), 0.00001);
    }

    
    @Test
    public void test_copy_constructor(){
        Rectangle location = new Rectangle(100, 100, 54, 67);
        Avatar toCopy = new Avatar("Avatar", 4, 4, 1, location);
        Avatar avatar = new MockAvatar(toCopy);
        assertEquals("Expected name to be Avatar.", toCopy.getName(), avatar.getName());
        assertEquals("Expected health to be 4.", toCopy.getHealth(), avatar.getHealth(), 0.00001);
        assertEquals("Expected lives to be 4.", toCopy.getLives(), avatar.getLives(), 0.00001);
        assertEquals("Expected damage to be 1.", toCopy.getDamage(), avatar.getDamage(), 0.00001);
        assertEquals("Expected Xposition to be 100.", toCopy.getLocation().getX(), avatar.getLocation().getX(), 0.00001);
        assertEquals("Expected Yposition to be 100.", toCopy.getLocation().getY(), avatar.getLocation().getY(), 0.00001);
        assertEquals("Expected width to be 100.", toCopy.getLocation().getWidth(), avatar.getLocation().getWidth(), 0.00001);
        assertEquals("Expected height to be 100.", toCopy.getLocation().getHeight(), avatar.getLocation().getHeight(), 0.00001);
    }

    @Test 
    public void test_take_damage(){
        Rectangle location = new Rectangle(100, 100, 54, 67);
        Avatar avatar = new MockAvatar("Avatar", 4, 4, 1, location);
        avatar.takeDamage(2);
        assertEquals("Expected health to be 2.", 2, avatar.getHealth(), 0.00001);
    }

    @Test 
    public void test_gain_health(){
        Rectangle location = new Rectangle(100, 100, 54, 67);
        Avatar avatar = new MockAvatar("Avatar", 4, 4, 1, location);
        avatar.gainHealth(2);
        assertEquals("Expected health to be 2.", 6, avatar.getHealth(), 0.00001);
    }

    @Test
    public void test_movement() {
        Rectangle location = new Rectangle(0, 0, 54, 67);
        Avatar avatar = new MockAvatar("Avatar", 4, 4, 1, location);
        avatar.move("Down");
        assertEquals("Expected YPosition to be 4.", 4, avatar.getLocation().getY(), 0.00001);
        avatar.move("UP");
        assertEquals("Expected YPosition to be 0.", 4, avatar.getLocation().getY(), 0.00001);
        avatar.move("RIGHT");
        assertEquals("Expected XPosition to be 4.", 4, avatar.getLocation().getX(), 0.00001);
        avatar.move("LEFT");
        assertEquals("Expected XPosition to be 0.", 4, avatar.getLocation().getX(), 0.00001);
    }

    @Test 
    public void test_toString(){
        Rectangle location = new Rectangle(100, 100, 54, 67);
        Avatar avatar = new MockAvatar("Avatar", 4, 4, 1, location);
        assertEquals("Excpeted toString to gives same string", "Avatar Position: 100.0 100.0 Health: 4 Lives: 4", avatar.toString());
    }

    @Test
    public void test_endgame(){
        Rectangle location = new Rectangle(100, 100, 54, 67);
        Avatar avatar = new MockAvatar("Avatar", 0, 0, 1, location);
        avatar.checkIfEndGame(0);
        assertEquals("Excpeted to return true if 0 lives and 0 health", true, avatar.checkIfEndGame(0));
        }
    

    @Test 
    public void test_locations_when_copied(){
        Rectangle location = new Rectangle(100, 100, 54, 67);
        Avatar toCopy = new Avatar("Avatar", 4, 4, 1, location);
        Avatar avatar = new MockAvatar(toCopy);
        assertEquals("Excpeted to return true if location are the same", true, avatar.equals(toCopy));
    }

    @Test 
    public void test_setter_methods(){
        Avatar avatar = new MockAvatar();
        avatar.setName("Avatar");
        avatar.setHealth(4);
        avatar.setLives(4);
        avatar.setLocation(100, 100);
        avatar.setDamage(1);
        assertEquals("Expected name 'Avatar'.", "Avatar", avatar.getName());
        assertEquals("Expected 4 health.", 4, avatar.getHealth(), 0.00001);
        assertEquals("Expected 4 lives.", 4, avatar.getLives(), 0.00001);
        assertEquals("Expected 1 damage.", 1, avatar.getDamage(), 0.00001);
        assertEquals("Expected Xposition to be 100.", 100, avatar.getLocation().getX(), 0.00001);
        assertEquals("Expected Yposition to be 100.", 100, avatar.getLocation().getY(), 0.00001);
        assertEquals("Expected width to be 100.", 54, avatar.getLocation().getWidth(), 0.00001);
        assertEquals("Expected height to be 100.", 67, avatar.getLocation().getHeight(), 0.00001);
    }
}

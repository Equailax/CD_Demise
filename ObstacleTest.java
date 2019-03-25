import static org.junit.Assert.*;
import java.beans.Transient;
import org.junit.Test;
import java.awt.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public class ObstacleTest{

    public class MockObstacle extends Obstacle {
        public MockObstacle() {
            super();
        }

        public MockObstacle(Obstacle toCopy) {
            super(toCopy);
        }

        public MockObstacle(String name, String typeString, int xcoord, int ycoord){super(name,typeString, xcoord, ycoord);}
    }


    @Test 
    public void test_creation(){
        Obstacle a = new MockObstacle("Obstacle","Dotify", 100, 100);
        assertEquals("Excpected name to be 'Obstacle'", "Obstacle", a.getName());
        assertEquals("Excpected type to be 'Dotify'", "Dotify", a.getType());
        assertEquals("Excpected Xcoord to be 100", 100, a.getLocation().getX());
        assertEquals("Excpected Ycoord to be 100", 100, a.getLocation().getY());
    }

    @Test
    public void test_copy_constructor(){
        Obstacle toCopyObstacle = new MockObstacle("Obstacle", "Dotify", 100, 100);
        Obstacle a = new MockObstacle(toCopyObstacle);
        assertEquals("Excpected name to be 'Obstacle'", "Obstacle", a.getName());
        assertEquals("Excpected type to be 'Dotify'", "Dotify", a.getType());
        assertEquals("Excpected Xcoord to be 100", 100, a.getLocation().getX());
        assertEquals("Excpected Ycoord to be 100", 100, a.getLocation().getY());
    }

    @Test
    public void test_setter_methods(){
        Obstacle a = new MockObstacle();
        a.setName("Obstacle");
        a.setType("Dotify");
        a.setLocation(100, 100);
        assertEquals("Excpected name to be 'Obstacle'", "Obstacle", a.getName());
        assertEquals("Excpected type to be 'Dotify'", "Dotify", a.getType());
        assertEquals("Excpected Xcoord to be 100", 100, a.getLocation().getX());
        assertEquals("Excpected Ycoord to be 100", 100, a.getLocation().getY());
    }

    @Test 
    public void test_overlaps_avatar(){
        Rectangle locRectangle = new Rectangle(100, 100, 100, 100);
        Obstacle a = new MockObstacle("Obstacle","Dotify", 100, 100);
        Avatar b = new Avatar("avatar", 4, 4, 1, locRectangle);
        assertEquals("expected true", true, a.overlapsWith(b));
	}
    
    @Test 
    public void test_overlaps_obstacle(){
        Obstacle a = new MockObstacle("Obstacle","Dotify", 100, 100);
        Obstacle b = new MockObstacle("Obstacle","Dotify", 100, 100);
        assertEquals("expected true", true, a.overlapsWithObstacle(b));
    }

    


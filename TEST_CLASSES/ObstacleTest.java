import static org.junit.Assert.*;
import java.beans.Transient;
import org.junit.Test;
import java.awt.Rectangle;


public class ObstacleTest{

    
    @Test 
    public void test_creation(){
        Obstacle a = new Obstacle("Obstacle","Dotify", 100, 100);
        assertEquals("Excpected name to be 'Obstacle'", "Obstacle", a.getName());
        assertEquals("Excpected type to be 'Dotify'", "DOTIFY", a.getType());
        assertEquals("Excpected Xcoord to be 100", 100, a.getLocation().getX(), 0.00001);
        assertEquals("Excpected Ycoord to be 100", 100, a.getLocation().getY(), 0.00001);
    }

    @Test
    public void test_copy_constructor(){
        Obstacle toCopyObstacle = new Obstacle("Obstacle", "Dotify", 100, 100);
        Obstacle a = new Obstacle(toCopyObstacle);
        assertEquals("Excpected name to be 'Obstacle'", "Obstacle", a.getName());
        assertEquals("Excpected type to be 'Dotify'", "DOTIFY", a.getType());
        assertEquals("Excpected Xcoord to be 100", 100, a.getLocation().getX(), 0.00001);
        assertEquals("Excpected Ycoord to be 100", 100, a.getLocation().getY(), 0.00001);
    }

    @Test
    public void test_setter_methods(){
        Obstacle a = new Obstacle();
        a.setName("Obstacle");
        a.setType("Dotify");
        a.setLocation(100, 100);
        assertEquals("Excpected name to be 'Obstacle'", "Obstacle", a.getName());
        assertEquals("Excpected type to be 'Dotify'", "DOTIFY", a.getType());
        assertEquals("Excpected Xcoord to be 100", 100, a.getLocation().getX(), 0.00001);
        assertEquals("Excpected Ycoord to be 100", 100, a.getLocation().getY(), 0.00001);
    }

    @Test 
    public void test_overlaps_avatar(){
        Rectangle locRectangle = new Rectangle(100, 100, 100, 100);
        Obstacle a = new Obstacle("Obstacle","Dotify", 100, 100);
        Avatar b = new Avatar("avatar", 4, 4, 1, locRectangle);
        assertEquals("expected true", true, a.overlapsWith(b));
	}
    
    @Test 
    public void test_overlaps_obstacle(){
        Obstacle a = new Obstacle("Obstacle","Dotify", 100, 100);
        Obstacle b = new Obstacle("Obstacle","Dotify", 100, 100);
        assertEquals("expected true", true, a.overlapsWithObstacle(b));
    }

}


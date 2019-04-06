import static org.junit.Assert.*;
import java.beans.Transient;
import org.junit.Test;
import java.awt.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public class CollectibleTest{
    public class MockCollectible extends Collectible{
        public MockCollectible(){super();}
        public MockCollectible(Collectible toCopy){super(toCopy);}
        public MockCollectible(String name, int xcoord, int ycoord){super(name, xcoord, ycoord);}
    }

    @Test 
    public void test_creation(){
        Collectible a = new MockCollectible("Collectible", 100, 100);
        assertEquals("Excpected name to be 'Collectible'", "Collectible", a.getName());
        assertEquals("Excpected Xcoord to be 100", 100, (int)a.getLocation().getX());
        assertEquals("Excpected Ycoord to be 100", 100, (int)a.getLocation().getY());
    }

    @Test 
    public void test_copy_constructor(){
        Collectible toCopy = new MockCollectible("Collectible", 100, 100);
        Collectible collectible = new MockCollectible(toCopy);
        assertEquals("Excpected name to be 'Collectible'", toCopy.getName(), collectible.getName());
        assertEquals("Excpected Xcoord to be 100", (int)toCopy.getLocation().getX(), (int)collectible.getLocation().getX());
        assertEquals("Excpected Ycoord to be 100", (int)toCopy.getLocation().getY(), (int)collectible.getLocation().getY());
    }

    @Test 
    public void test_setter_methods(){
        Collectible collectible = new MockCollectible();
        collectible.setName("New Name");
        collectible.setLocation(100, 100);
        assertEquals("Excpected name to be 'New Name'", "New Name", collectible.getName());
        assertEquals("Excpected Xcoord to be 100", 100, (int)collectible.getLocation().getX());
        assertEquals("Excpected Ycoord to be 100", 100, (int)collectible.getLocation().getY());
    }

    @Test 
    public void test_overlaps(){
        Avatar a = new Avatar();
        a.setLocation(100, 100);
        Collectible collectible = new MockCollectible("Collectible", 100, 100);
        assertEquals("Expected to return true if overlapping", true, collectible.overlapsWith(a));
    }

    @Test 
    public void test_toString(){
        Collectible collectible = new MockCollectible("Collectible", 100, 100);
        assertEquals("Expected right toString()", "Collectible 100.0 100.0", collectible.toString());
    }

    @Test 
    public void test_add_to_collection(){
        Collectible collectible = new MockCollectible("Collectible", 100, 100);
        collectible.addToCollection();
        collectible.addToCollection();
        assertEquals("Excpected Collectiong to be 2", 2, collectible.getCollection());
    }

    
}
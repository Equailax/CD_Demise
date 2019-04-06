import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import java.awt.Rectangle;


public class EnemyTest{
	
// test constructor 
@Test
public void test_constructors(){
Enemy c = new Enemy("villan","TYPE",40,100,100,"RIGHT");	
assertEquals("testing for name to be villan","villan",c.getName());
assertEquals("testing for TYPE to be TYPE","TYPE",c.getType());
assertEquals("testing for health to be 100",100,(int)c.getLocation().getX());
assertEquals("testing for y-axis to be 100",100,(int)c.getLocation().getY());
assertEquals("testing for health to be 40",40,c.getHealth());
assertEquals("testing for direction to be RIGHT","RIGHT",c.getDirection());
}
// default constructor

@Test 
public void test_default_constructor(){
	Enemy c = new Enemy();
	assertEquals("testing for default constructor",null,c.getName());
	assertEquals("testing for default constructor","NOTSET",c.getType());
	assertEquals("testing for default constructor",0,c.getHealth());
	assertEquals("testing for default constructor",0,(int)c.getLocation().getX());
	assertEquals("testing for default constructor",0,(int)c.getLocation().getY());
	assertEquals("testing for default constructor","NONE",c.getDirection());
}
	//copy constructor
@Test
public void test_copy_constructor (){
Enemy c = new Enemy("villan","TYPE",40,100,100,"RIGHT");
Enemy c1 = new Enemy(c);	
assertEquals("testing for name to be villan","villan",c1.getName());
assertEquals("testing for TYPE to be TYPE","TYPE",c1.getType());
assertEquals("testing for health to be 100",100,(int)c1.getLocation().getX());
assertEquals("testing for y-axis to be 100",100,(int)c1.getLocation().getY());
assertEquals("testing for health to be 40",40,c1.getHealth());
assertEquals("testing for direction to be RIGHT","RIGHT",c1.getDirection());
}
	
//test getter 
@Test
public void test_getHealth(){
	Enemy c = new Enemy();
	c.setHealth(100);
assertEquals("testing for the health to be 100",100,c.getHealth());
}
@Test 
public void test_getIsdeadly(){
	Enemy c = new Enemy();
	c.setIsDeadly(true);
	assertEquals("testing for getIsdeadly, return true",true,c.getIsDeadly());
}
@Test
public void test_getDirection(){
	Enemy c = new Enemy();
	c.setDirection("RIGHT");
	assertEquals("testing for getDirection, RIGHT", "RIGHT",c.getDirection());
}
// take damage
@Test 
public void test_takedamage(){
Enemy c = new Enemy();
c.getHealth();
c.setHealth(100);
c.takeDamage(50);
assertEquals("testing for damagetaken,50" ,50,c.getHealth());
}	
// movex
@Test 
public void test_moveX(){
	Enemy c = new Enemy();
	c.setLocation(new Rectangle(10, 10, 1, 1));
	c.moveX(3);
	assertEquals("testing for moveX, when movement is 3", 13,(int)c.getLocation().getX());
	assertEquals("testing for moveX, when movement is 3", 10,(int)c.getLocation().getY());
}
//movey
@Test
public void test_moveY(){
	Enemy c = new Enemy();
	c.setLocation(new Rectangle(10, 10, 1, 1));
	c.moveY(3);
	assertEquals("testing for moveY, when movement is 3", 10,(int)c.getLocation().getX());
	assertEquals("testing for moveY, when movement is 3", 13,(int)c.getLocation().getY());
	}
	// tostring
	@Test
	public void test_toString()
	{
		Enemy c = new Enemy("enemy", "villan", 40,100,100,"RIGHT");
		assertEquals("Testing toString method", "enemy Location: 100.0 100.0 Health: 40 Direction: RIGHT", c.toString());
    
	}
	
	
}
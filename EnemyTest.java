import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;


public class EnemyTest{
	
// test constructor 
@Test
public void test_constructors(){
Enemy c = new Enemy("villan","type",100,100,40,"Right");	
assertEquals("testing for name to be villan","villan",c.getName());
assertEquals("testing for type to be type","type",c.getType());
assertEquals("testing for health to be 100",100,c.getLocation().getX());
assertEquals("testing for y-axis to be 100",100,c.getLocation().getY());
assertEquals("testing for health to be 40",40,c.getHealth());
assertEquals("testing for direction to be Right","Right",c.getDirection());
}
// default constructor

@Test 
public void test_default_constructor(){
	Enemy c = new Enemy(" ");
	assertEquals("testing for default constructor"," ",c.getName());
	assertEquals("testing for default constructor"," ",c.getType());
	assertEquals("testing for default constructor"," ",c.getHealth());
	assertEquals("testing for default constructor"," ",c.getLocation().getX());
	assertEquals("testing for default constructor"," ",c.getLocation().getY());
	assertEquals("testing for default constructor"," ",c.getDirection());
}
	//copy constructor
@Test
public void test_copy_constructor (){
Enemy c = new Enemy("villan","type",100,100,40,"Right");
Enemy c1 = new Enemy(c);	
assertEquals("testing for name to be villan","villan",c1.getName());
assertEquals("testing for type to be type","type",c1.getType());
assertEquals("testing for health to be 100",100,c1.getLocation().getX());
assertEquals("testing for y-axis to be 100",100,c1.getLocation().getY());
assertEquals("testing for health to be 40",40,c1.getHealth());
assertEquals("testing for direction to be Right","Right",c1.getDirection());
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
	c.setIsdeadly(true);
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
	c.setLocation(10);
	c.moveX(3);
	assertEquals("testing for moveX, when movement is 3", 13,c.getLocation().getX());
	assertEquals("testing for moveX, when movement is 3", 10,c.getLocation().getY());
}
//movey
@Test
public void test_moveY(){
	Enemy c = new Enemy();
	c.setLocation(10);
	c.moveY(3);
	assertEquals("testing for moveY, when movement is 3", 10,c.getLocation().getX());
	assertEquals("testing for moveY, when movement is 3", 13,c.getLocation().getY());
	}
	// tostring
	@Test
	public void test_toString()
	{
		Enemy c = new Enemy("villan", 100,100,40,"Right");
		assertEquals("villan, 100 on x-axis,100 on y-axis, 40 is the health and Right is the direction", c.toString());
    
	}
	
	
}
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;

public class HealthTest{
	
	//test constructors 
	
	@Test 
	public void Health_test(){
	Health c = new Health("villan",10,100,100);
 assertEquals("Testing for the name, villan","villan",c.getName());
 assertEquals("Testing for the healthboost,10", 10,c.getHealthBoost());
assertEquals("Testing for the Xcood,100",100,c.getLocation.getX());
assertEquals("Testing for the Ycood,100",100,c.getLocation.getY());
}
//test for default constructor 

@Test
public void Health_default_test(){
	Health c = new Health("");
	assertEquals("testing for default constructor,name"," ",c.getName());
	assertEquals("testing for default constructor,healthboost"," ",c.getHealthBoost());
	assertEquals("testing for default constructor,xcood"," ",c.getLocation().getX());
	assertEquals("testing for default constructor,ycood"," ",c.getLocation().getY());
}
// copy constructor 
@Test 
public void Health_test(){
Health c = new Health("villan",10,100,100);
Health c1 = new Health(c);
assertEquals("Testing for the name, villan","villan",c1.getName());
assertEquals("Testing for the healthboost,10", 10,c1.getHealthBoost());
assertEquals("Testing for the Xcood,100",100,c1.getLocation.getX());
assertEquals("Testing for the Ycood,100",100,c1.getLocation.getY());
}
// test getter ans setter
@Test
public void test_getHealthBoost(){
	Health c = new Health();
	c.setHealthBoost(10);
	assertEquals("testing for the healthboost,10",10,c.getHealthBoost());	
}
// test for overlaps with method 
@Test
public void test_overlapsWith(){
	Avatar a = new Avatar();
	a.setLocation(100,100);
	Health c = new Health();
	boolean r = c.overlapsWith(a);
		assertEquals("testing for over when is true",true,r);
}
// tostring
	@Test
	public void test_toString()
	{
		Enemy c = new Enemy("villan", 10,100,100);
		assertEquals("villan, 10 healthBoost,100 xcood,100 ycood", c.toString());
    
	}
	
	
	}

	

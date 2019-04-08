import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;



public class HealthTest{
	
	//test constructors 
	
	@Test 
	public void test_constructor(){
	Health c = new Health("villan",10,100,100);
 assertEquals("Testing for the name, villan","villan",c.getName());
 assertEquals("Testing for the healthboost,10", 10,c.getHealthBoost());
assertEquals("Testing for the Xcood,100",100,(int)c.getLocation().getX());
assertEquals("Testing for the Ycood,100",100,(int)c.getLocation().getY());
}
//test for default constructor 

@Test
public void test_defaultConstructor(){
	Health c = new Health();
	c.setName("Health");
	assertEquals("testing for default constructor,name","Health",c.getName());
	assertEquals("testing for default constructor,healthboost",1,c.getHealthBoost());
	assertEquals("testing for default constructor,xcood",0,(int)c.getLocation().getX());
	assertEquals("testing for default constructor,ycood",0,(int)c.getLocation().getY());
}
// copy constructor 
@Test 
public void test_copyConstructor(){
Health c = new Health("villan",10,100,100);
Health c1 = new Health(c);
assertEquals("Testing for the name, villan","villan",c1.getName());
assertEquals("Testing for the healthboost,10", 10,c1.getHealthBoost());
assertEquals("Testing for the Xcood,100",100,(int)c1.getLocation().getX());
assertEquals("Testing for the Ycood,100",100,(int)c1.getLocation().getY());
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
	c.setLocation(100, 100);
		assertEquals("testing for over when is true",true, c.overlapsWith(a));
}
// tostring
	@Test
	public void test_toString()
	{
		Health c = new Health("villan", 10,100,100);
		assertEquals("Testing toString method", "villan 100.0 100.0 Health Boost: 10", c.toString());
    
	}
	
	
	}

	

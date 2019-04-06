import static org.junit.Assert.*;
import org.junit.Test;


public class ProjectileTest
{
	//constructor tests
	@Test
	public void test_defaultContructor()
	{
		Projectile test = new Projectile();
		assertEquals("Projectile should not be deadly to avatar.", false, test.getDeadlyToAvatar());
		assertEquals("Projectile should not be deadly to enemies.", false, test.getDeadlyToEnemy());
		assertEquals("Projectile should not be shot.", false, test.getIsShot());
		assertEquals("Projectile direction should be none." , "NONE", test.getDirection());
	}
		
	@Test
	public void test_constructor()
	{
		Projectile test = new Projectile("MusicNote", "Tester", true, false, "Right");
		assertEquals("Projectile should be named MusicNote.", "MusicNote", test.getName());
		assertEquals("Projectile should be type Tester.", "TESTER", test.getType());
		assertEquals("Projectile should be deadly to the avatar.", true, test.getDeadlyToAvatar());
		assertEquals("Projectile should not be deadly to enemies.", false, test.getDeadlyToEnemy());
		assertEquals("Projectile direction should be set to right.", "RIGHT", test.getDirection());
	}
	
	@Test
	public void test_copyConstructor()
	{
		Projectile c = new Projectile("MusicNote", "Tester", true, false, "Right");
		Projectile test = new Projectile(c);
		assertEquals("Projectile should be named MusicNote.", "MusicNote", test.getName());
		assertEquals("Projectile should be type Tester.", "TESTER", test.getType());
		assertEquals("Projectile should be deadly to the avatar.", true, test.getDeadlyToAvatar());
		assertEquals("Projectile should not be deadly to enemies.", false, test.getDeadlyToEnemy());
		assertEquals("Projectile direction should be set to right.", "RIGHT", test.getDirection());
	}
	
	//setter tests
	@Test
	public void test_setIsDeadlyToAvatar_changesToDeadly()
	{
		Projectile test = new Projectile();
		test.setIsDeadlyToAvatar(true);
		
		boolean testSetter = true;
		
		assertEquals("Projectile's deadliness on the avatar does not change.", testSetter, test.getDeadlyToAvatar());
	}
	
	@Test
	public void test_setIsDeadlyToEnemy_changesToDeadly()
	{
		Projectile test = new Projectile();
		test.setIsDeadlyToEnemy(true);
		
		boolean testSetter = true;
		
		assertEquals("Projectile's deadliness on enemies does not change.", testSetter, test.getDeadlyToEnemy());
	}
	
	@Test
	public void test_setIsShot_changesStatusToBeingShot()
	{
		Projectile test = new Projectile();
		test.setIsShot(true);
		
		boolean testSetter = true;
		
		assertEquals("Projectile's status for being shot or not does not change.", testSetter, test.getIsShot());
	}
	
	@Test
	public void test_setDirection_changesDirection()
	{
		Projectile test = new Projectile();
		test.setDirection("LEFT");
		
		String testSetter = "LEFT";
		
		assertEquals("The direction of the projectile has not changed", testSetter, test.getDirection());
	}	
	
	//movement method tests
	@Test
	public void test_move_changeInXCoordinateOnly()
	{
		Projectile test = new Projectile();
		test.setDirection("RIGHT");
		
		test.move();
		
		assertEquals("Projectiles new x coordinate should be 10.", 10, test.getLocation().getX(), 0.0001);
		assertEquals("Projectiles y coordinate should remain 0.", 0, test.getLocation().getY(), 0.0001);
	}
	
	@Test
	public void test_move_changeInYCoordinateOnly()
	{
		Projectile test = new Projectile();
		test.setDirection("DOWN");
		
		test.move();
		
		assertEquals("Projectiles new y coordinate should be 10.", 10, test.getLocation().getY(), 0.0001);
		assertEquals("Projectiles x coordinate should remain 0.", 0, test.getLocation().getX(), 0.0001);
	}
	
	@Test
	public void test_move_changeInBothCoordinates()
	{
		Projectile test = new Projectile();
		test.setDirection("DOWNRIGHT");
		
		test.move();
		
		assertEquals("Projectiles new y coordinate should be 10.", 10, test.getLocation().getY(), 0.0001);
		assertEquals("Projectiles new x coordinate should be 10.", 10, test.getLocation().getX(), 0.0001);
	}
	
	//toString test
	@Test
	public void test_toString()
	{
		Projectile test = new Projectile("MusicNote", "Tester", true, false, "RIGHT");
			
		assertEquals("MusicNote 0.0 0.0 Is deadly to AvatarRIGHT", test.toString());	
	}
	
}
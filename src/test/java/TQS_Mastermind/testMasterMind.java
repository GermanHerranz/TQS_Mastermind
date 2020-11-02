package TQS_Mastermind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testMasterMind {
	
	@Before 
    public void setUp() throws Exception {
    }
	
	@Test
	public void testRead_Parameters() {
		MasterMind res= new MasterMind();
		MockReadParameters mockReadParameters = new MockReadParameters();
		Player p1 = new Player(0);
		Player p2 = new Player(1);
		
		mockReadParameters.colors[0] = "red";
		mockReadParameters.colors[1] = "yellow";
		mockReadParameters.colors[2] = "black";
		mockReadParameters.colors[3] = " ";
		mockReadParameters.colors[4] = "orange!";
		mockReadParameters.read_parameters(p1);
		
		boolean value0=res.check_parameters(p1.get_usercolorPosition(0));
		assertTrue(value0);
		
		boolean value1=res.check_parameters(p1.get_usercolorPosition(1));
		assertTrue(value1);
		
		boolean value2=MasterMind.check_parameters(p1.get_usercolorPosition(2));
		assertFalse(value2);
		
		boolean value3=MasterMind.check_parameters(p1.get_usercolorPosition(3));
		assertFalse(value3);
		
		boolean value4=MasterMind.check_parameters(p1.get_usercolorPosition(2));
		assertFalse(value4);
		
		boolean value5=MasterMind.check_parameters(p1.get_usercolorPosition(-5));
		assertEquals(value5, "-1");
		
		boolean value6=MasterMind.check_parameters(p1.get_usercolorPosition(6));
		assertEquals(value6, "-1");
		
		boolean value7=MasterMind.check_parameters(p1.get_usercolorPosition(-1));
		assertEquals(value7, "-1");
		
		boolean value8=MasterMind.check_parameters(p1.get_usercolorPosition(5));
		assertEquals(value8, "-1");
		
		boolean value9=MasterMind.check_parameters(p2.get_usercolorPosition(3));
		assertEquals(value9, "-1");
		
	}
	
	@Test
	public void testCheck_Parameters() {
		MasterMind res= new MasterMind();
		
		boolean value0=res.check_parameters("yellow ");
		assertFalse(value0);
		
		boolean value=MasterMind.check_parameters("red");
		assertFalse(value);
		
		boolean value2=MasterMind.check_parameters("black");
		assertTrue(value2);
		
		boolean value3=MasterMind.check_parameters("1");
		assertTrue(value3);
		
		boolean value4=MasterMind.check_parameters("RED");
		assertTrue(value4);
		
		boolean value5=MasterMind.check_parameters("Red");
		assertTrue(value5);
		
		boolean value6=MasterMind.check_parameters(" ");
		assertTrue(value6);
		
		boolean value7=MasterMind.check_parameters("!");
		assertTrue(value7);
		
		boolean value8=MasterMind.check_parameters("red!");
		assertTrue(value8);
		
		boolean value9=MasterMind.check_parameters("red yellow");
		assertTrue(value9);
		
		boolean value10=MasterMind.check_parameters("red, yellow");
		assertTrue(value10);
	}
	
	
	
}
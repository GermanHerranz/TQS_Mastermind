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
		
		mockReadParameters.read_parameters(p1, res);
		
		boolean value0=res.check_parameters("yellow ");
		assertFalse(value0);
		
		boolean value=res.check_parameters("red");
		assertFalse(value);
		
		boolean value2=res.check_parameters("black");
		assertTrue(value2);
		
		boolean value3=res.check_parameters("1");
		assertTrue(value3);
		
		boolean value4=res.check_parameters("RED");
		assertTrue(value4);
		
		boolean value5=res.check_parameters("Red");
		assertTrue(value5);
		
		boolean value6=res.check_parameters(" ");
		assertTrue(value6);
		
		boolean value7=res.check_parameters("!");
		assertTrue(value7);
		
		boolean value8=res.check_parameters("red!");
		assertTrue(value8);
		
		boolean value9=res.check_parameters("red yellow");
		assertTrue(value9);
		
		boolean value10=res.check_parameters("red, yellow");
		assertTrue(value10);
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
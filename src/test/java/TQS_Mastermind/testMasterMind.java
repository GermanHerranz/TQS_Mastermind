package TQS_Mastermind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testMasterMind {
	
	@Before 
    public void setUp() throws Exception {
    }


	@Test
	public void testCheck_Parameters() {
		MasterMind res = new MasterMind();
		boolean value=MasterMind.check_parameters("red");
		assertTrue(value);
		
		boolean value2=MasterMind.check_parameters("black");
		assertFalse(value2);
		
		boolean value3=MasterMind.check_parameters("1");
		assertFalse(value3);
		
		boolean value4=MasterMind.check_parameters("RED");
		assertFalse(value4);
		
		boolean value5=MasterMind.check_parameters("Red");
		assertFalse(value5);
		
		boolean value6=MasterMind.check_parameters(" ");
		assertFalse(value6);
		
		boolean value7=MasterMind.check_parameters("!");
		assertFalse(value7);
		
		boolean value8=MasterMind.check_parameters("red!");
		assertFalse(value8);
		
		boolean value9=MasterMind.check_parameters("red yellow");
		assertFalse(value9);
		
		boolean value10=MasterMind.check_parameters("red, yellow");
		assertFalse(value10);
	}
}
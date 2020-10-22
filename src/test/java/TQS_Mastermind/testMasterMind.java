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
		MasterMind res= new MasterMind();
		boolean value=res.check_parameters("!");
		assertFalse(value);
	}
	
	
	
}
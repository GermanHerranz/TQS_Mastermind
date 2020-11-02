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
		
		MockReadParameters mockReadParameters = new MockReadParameters();
		Player p1 = new Player(0);
		Player p2 = new Player(1);
		mockReadParameters.colors = new String[5];
		mockReadParameters.colors[0] = "red";
		mockReadParameters.colors[1] = "yellow";
		mockReadParameters.colors[2] = "black";
		mockReadParameters.colors[3] = " ";
		mockReadParameters.colors[4] = "orange!";
		mockReadParameters.read_parameters(p1);
		
		boolean value0=MasterMind.check_parameters(p1.get_usercolorPosition(0));
		assertTrue(value0);
		
		boolean value1=MasterMind.check_parameters(p1.get_usercolorPosition(1));
		assertTrue(value1);
		
		boolean value2=MasterMind.check_parameters(p1.get_usercolorPosition(2));
		assertFalse(value2);
		
		boolean value3=MasterMind.check_parameters(p1.get_usercolorPosition(3));
		assertFalse(value3);
		
		boolean value4=MasterMind.check_parameters(p1.get_usercolorPosition(2));
		assertFalse(value4);
		
		boolean value5=MasterMind.check_parameters(p1.get_usercolorPosition(-5));
		assertFalse(value5);
		
		boolean value6=MasterMind.check_parameters(p1.get_usercolorPosition(6));
		assertFalse(value6);
		
		boolean value7=MasterMind.check_parameters(p1.get_usercolorPosition(-1));
		assertFalse(value7);
		
		boolean value8=MasterMind.check_parameters(p1.get_usercolorPosition(5));
		assertFalse(value8);
		
		boolean value9=MasterMind.check_parameters(p2.get_usercolorPosition(3));
		assertFalse(value9);
		
	}
	
	@Test
	public void testCheck_Parameters() {
		
		
		boolean value0=MasterMind.check_parameters("yellow ");
		assertFalse(value0);
		
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
		
		boolean value11=MasterMind.check_parameters("purple");
		assertTrue(value11);
		
		boolean value12=MasterMind.check_parameters("yellow");
		assertTrue(value12);
		
		boolean value13=MasterMind.check_parameters("orange");
		assertTrue(value13);
		
		boolean value14=MasterMind.check_parameters("blue");
		assertTrue(value14);
		
		boolean value15=MasterMind.check_parameters("green");
		assertTrue(value15);
	}
	
	@Test
	public void testSetAndGetPlayer() {
		Player p= new Player(0);
		p.set_usercolorPosition(0, "red");
		assertEquals(p.get_usercolorPosition(0), "red");
		
		p.set_usercolorPosition(4, "yellow");
		assertEquals(p.get_usercolorPosition(4), "yellow");
		
		p.set_usercolorPosition(5, "yellow");
		assertEquals(p.get_usercolorPosition(5), "-1");
		
		p.set_usercolorPosition(-1, "purple");
		assertEquals(p.get_usercolorPosition(-1), "-1");
		
		
	}
	
	@Test
	public void testTurn() {
		int res=MasterMind.turn(0);
		assertEquals(res, 1);
		
		int res1=MasterMind.turn(1);
		assertEquals(res1, 0);
		
		int res2=MasterMind.turn(-1);
		assertEquals(res2, 0);
		
		int res3=MasterMind.turn(2);
		assertEquals(res3, 0);
		
		
		
	}
	
	@Test
	public void testNumPlays() {
		int res=MasterMind.numPlays();
		assertEquals(res, 11);
		
		int res1=MasterMind.numPlays();
		assertEquals(res1, 10);
		
		int res2=MasterMind.numPlays();
		assertEquals(res2, 9);
			
		
	}
	
	@Test
	public void testPlay() {
		MockReadParameters mockReadParameters = new MockReadParameters();
		Player p1 = new Player(0);
		Player p2 = new Player(1);
		mockReadParameters.colors = new String[5];
		mockReadParameters.colors[0] = "red";
		mockReadParameters.colors[1] = "yellow";
		mockReadParameters.colors[2] = "black";
		mockReadParameters.colors[3] = " ";
		mockReadParameters.colors[4] = "orange!";
		mockReadParameters.read_parameters(p1);
		
		boolean res=MasterMind.Play(p1,p2);
		assertFalse(res);
		
		
		mockReadParameters.colors = new String[5];
		mockReadParameters.colors[0] = "red";
		mockReadParameters.colors[1] = "yellow";
		mockReadParameters.colors[2] = "purple";
		mockReadParameters.colors[3] = "red";
		mockReadParameters.colors[4] = "orange";
		mockReadParameters.read_parameters(p1);
		
		boolean res1=MasterMind.Play(p1, p2);
		assertTrue(res1);
		
		
		
	}
	
	
	
}
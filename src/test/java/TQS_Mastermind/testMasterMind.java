package TQS_Mastermind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testMasterMind {
	
	@Before 
    public void setUp() throws Exception {
    }
	
	@Test
	public void test_Read_Parameters() {
		MasterMind m= new MasterMind();
		MockReadParameters mockReadParameters = new MockReadParameters();
		Player p1 = new Player(0);
		Player p2 = new Player(1);
		mockReadParameters.colors = new int[5];
		mockReadParameters.colors[0] = 0;
		mockReadParameters.colors[1] = 3;
		mockReadParameters.colors[2] = 5;
		mockReadParameters.colors[3] = -1;
		mockReadParameters.colors[4] = 6;
		mockReadParameters.read_parameters(p1);
		
		boolean value0=m.check_parameters(p1.get_userColorPosition(0));
		assertTrue(value0);
		
		boolean value1=m.check_parameters(p1.get_userColorPosition(1));
		assertTrue(value1);
		
		boolean value2=m.check_parameters(p1.get_userColorPosition(2));
		assertTrue(value2);
		
		boolean value3=m.check_parameters(p1.get_userColorPosition(3));
		assertFalse(value3);
		
		boolean value4=m.check_parameters(p1.get_userColorPosition(4));
		assertFalse(value4);
		
		boolean value5=m.check_parameters(p1.get_userColorPosition(-5));
		assertFalse(value5);
		
		boolean value6=m.check_parameters(p1.get_userColorPosition(6));
		assertFalse(value6);
		
		boolean value7=m.check_parameters(p1.get_userColorPosition(-1));
		assertFalse(value7);
		
		boolean value8=m.check_parameters(p1.get_userColorPosition(5));
		assertFalse(value8);
	}
	
	@Test
	public void test_GenerateCode() {
		MasterMind m= new MasterMind();
		int array_code[]=m.generate_code();
		assertEquals(array_code.length,5);
		
		for(int i=0; i<array_code.length; i++) {
			boolean value=m.check_parameters(array_code[i]);
			assertTrue(value);
		}
	}
	
	@Test
	public void test_Random_Numbers() {
		MockRandomNumbers mockrandomnumbers= new MockRandomNumbers();
		MasterMind m= new MasterMind();
		Player p= new Player(0);
		
		mockrandomnumbers.array = new int[5];
		mockrandomnumbers.array[0] = 0;
		mockrandomnumbers.array[1] = 3;
		mockrandomnumbers.array[2] = 5;
		mockrandomnumbers.array[3] = -1;
		mockrandomnumbers.array[4] = 6;
		
		boolean res = mockrandomnumbers.random_numbers(p, m);
		assertTrue(res);
		
		for(int i=0; i<mockrandomnumbers.array.length; i++) {
			boolean value1=m.check_parameters(mockrandomnumbers.array[i]);
			if (i==3 || i==4)
				assertFalse(value1);
			else
				assertTrue(value1);
		}
		
		mockrandomnumbers.array[0] = 0;
		mockrandomnumbers.array[1] = 3;
		mockrandomnumbers.array[2] = 5;
		mockrandomnumbers.array[3] = 4;
		mockrandomnumbers.array[4] = 2;
		
		boolean res1 = mockrandomnumbers.random_numbers(p, m);
		assertTrue(res1);
		
		for(int i=0; i<mockrandomnumbers.array.length; i++) {
			boolean value2=m.check_parameters(mockrandomnumbers.array[i]);
			assertTrue(value2);
		}	
	}
	
	@Test
	public void test_Check_Parameters() {
		MasterMind m= new MasterMind();
		
		boolean value0=m.check_parameters(0);
		assertTrue(value0);
		
		boolean value1=m.check_parameters(1);
		assertTrue(value1);
		
		boolean value2=m.check_parameters(2);
		assertTrue(value2);
		
		boolean value3=m.check_parameters(3);
		assertTrue(value3);
		
		boolean value4=m.check_parameters(4);
		assertTrue(value4);
		
		boolean value5=m.check_parameters(5);
		assertTrue(value5);
		
		boolean value6=m.check_parameters(-1);
		assertFalse(value6);
		
		boolean value7=m.check_parameters(6);
		assertFalse(value7);
		
		boolean value8=m.check_parameters(-5);
		assertFalse(value8);
		
		boolean value9=m.check_parameters(-4);
		assertFalse(value9);
		
		boolean value10=m.check_parameters(7);
		assertFalse(value10);
		
		boolean value11=m.check_parameters(20);
		assertFalse(value11);
	}
	
	@Test
	public void test_SetAndGetPlayer() {
		Player p= new Player(0);
		p.set_userColorPosition(0, 0);
		assertEquals(p.get_userColorPosition(0), 0);
		
		p.set_userColorPosition(4, 3);
		assertEquals(p.get_userColorPosition(4), 3);
		
		p.set_userColorPosition(5, 3);
		assertEquals(p.get_userColorPosition(5), -1);
		
		p.set_userColorPosition(-1, 5);
		assertEquals(p.get_userColorPosition(-1), -1);
	}
	
	@Test
	public void test_Turn() {
		MasterMind m= new MasterMind();
		int res=m.turn(0);
		assertEquals(res, 1);
		
		int res1=m.turn(1);
		assertEquals(res1, 0);
		
		int res2=m.turn(-1);
		assertEquals(res2, 0);
		
		int res3=m.turn(2);
		assertEquals(res3, 0);
	}
	
	@Test
	public void test_NumPlays() {
		MasterMind m= new MasterMind();
		int res=m.numPlays();
		assertEquals(res, 11);
		
		int res1=m.numPlays();
		assertEquals(res1, 10);
		
		int res2=m.numPlays();
		assertEquals(res2, 9);
	}
	
	@Test
	public void test_check_positions() {
		 MasterMind m = new MasterMind();
	        MockReadParameters mockReadParameters = new MockReadParameters();
	        Player p1 = new Player(0);
	        Player p2 = new Player(1);
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p1);
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p2);
	        
	        boolean res1=m.check_positions(p1, p2);
	        assertTrue(res1);
	        
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p1);
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 3;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p2);
	        
	        boolean res2=m.check_positions(p1, p2);
	        assertFalse(res2);
	        
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p1);
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 0;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p2);
	        
	        boolean res3=m.check_positions(p1, p2);
	        assertFalse(res3);
	        
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p1);
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 0;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p2);
	        
	        boolean res4=m.check_positions(p1, p2);
	        assertFalse(res4);
	        
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p1);
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 0;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p2);
	        
	        boolean res5=m.check_positions(p1, p2);
	        assertFalse(res5);
	        
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p1);
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 4;
	        mockReadParameters.read_parameters(p2);
	        
	        boolean res6=m.check_positions(p1, p2);
	        assertFalse(res6);
	        
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p1);
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 1;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 0;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p2);
	        
	        boolean res7=m.check_positions(p1, p2);
	        assertFalse(res7);
	}
	
	@Test
	public void test_Player1() {
		MasterMind m= new MasterMind();
		
		MockReadParameters mockReadParameters = new MockReadParameters();
		Player p1 = new Player(0);
		mockReadParameters.colors = new int[5];
		mockReadParameters.colors[0] = 0;
		mockReadParameters.colors[1] = 3;
		mockReadParameters.colors[2] = 7;
		mockReadParameters.colors[3] = -1;
		mockReadParameters.colors[4] = 6;
		mockReadParameters.read_parameters(p1);
		
		boolean res=m.Player1(p1);
		assertFalse(res);
		
		
		mockReadParameters.colors = new int[5];
		mockReadParameters.colors[0] = 0;
		mockReadParameters.colors[1] = 3;
		mockReadParameters.colors[2] = 5;
		mockReadParameters.colors[3] = 0;
		mockReadParameters.colors[4] = 4;
		mockReadParameters.read_parameters(p1);
		
		boolean res1=m.Player1(p1);
		assertTrue(res1);	
	}
	
	@Test
	public void test_Player2() {
		MasterMind m= new MasterMind();
		
		MockReadParameters mockReadParameters = new MockReadParameters();
		Player p2 = new Player(1);
		mockReadParameters.colors = new int[5];
		mockReadParameters.colors[0] = 0;
		mockReadParameters.colors[1] = 3;
		mockReadParameters.colors[2] = 7;
		mockReadParameters.colors[3] = -1;
		mockReadParameters.colors[4] = 6;
		mockReadParameters.read_parameters(p2);
		
		boolean res=m.Player2(p2);
		assertFalse(res);
		
		
		mockReadParameters.colors = new int[5];
		mockReadParameters.colors[0] = 0;
		mockReadParameters.colors[1] = 3;
		mockReadParameters.colors[2] = 5;
		mockReadParameters.colors[3] = 0;
		mockReadParameters.colors[4] = 4;
		mockReadParameters.read_parameters(p2);
		
		boolean res1=m.Player2(p2);
		assertTrue(res1);
		
		assertEquals(m.numPlays,11);
		
		m.Player2(p2);
		assertEquals(m.numPlays,10);
		
		m.Player2(p2);
		assertEquals(m.numPlays,9);
		
		m.Player2(p2);
		assertEquals(m.numPlays,8);
		
		m.Player2(p2);
		assertEquals(m.numPlays,7);
		
		m.Player2(p2);
		assertEquals(m.numPlays,6);
		
		m.Player2(p2);
		assertEquals(m.numPlays,5);
		
		m.Player2(p2);
		assertEquals(m.numPlays,4);
		
		m.Player2(p2);
		assertEquals(m.numPlays,3);
		
		m.Player2(p2);
		assertEquals(m.numPlays,2);
		
		m.Player2(p2);
		assertEquals(m.numPlays,1);
		
		m.Player2(p2);
		assertEquals(m.numPlays,0); //incorrect values like -1 are checked in other tests, like test_Play
	}
	
	/*@Test
	public void test_Play() {
		MasterMind m= new MasterMind();
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
		
		boolean res=m.Play(p1,p2);
		assertTrue(res);
		
		
		mockReadParameters.colors = new String[5];
		mockReadParameters.colors[0] = "red";
		mockReadParameters.colors[1] = "yellow";
		mockReadParameters.colors[2] = "purple";
		mockReadParameters.colors[3] = "red";
		mockReadParameters.colors[4] = "orange";
		mockReadParameters.read_parameters(p1);
		
		boolean res1=m.Play(p1, p2);
		assertFalse(res1);
		
		mockReadParameters.colors = new String[5];
		mockReadParameters.colors[0] = "red";
		mockReadParameters.colors[1] = "yellow";
		mockReadParameters.colors[2] = "black";
		mockReadParameters.colors[3] = " ";
		mockReadParameters.colors[4] = "orange!";
		mockReadParameters.read_parameters(p2);
		
		boolean res2=m.Play(p1,p2);
		assertTrue(res2);
		
		
		mockReadParameters.colors = new String[5];
		mockReadParameters.colors[0] = "red";
		mockReadParameters.colors[1] = "yellow";
		mockReadParameters.colors[2] = "purple";
		mockReadParameters.colors[3] = "red";
		mockReadParameters.colors[4] = "orange";
		mockReadParameters.read_parameters(p2);
		
		boolean res3=m.Play(p1, p2);
		assertFalse(res3);
	}*/
	
	@Test
	public void test_Save_and_GetSaved_Play() { //Save the correct plays and get them
		Player p1= new Player(0);				
		MockRandomNumbers mockrandomnumbers= new MockRandomNumbers();
		
		mockrandomnumbers.array = new int[5];
		mockrandomnumbers.array[0] = 0;
		mockrandomnumbers.array[1] = 3;
		mockrandomnumbers.array[2] = 5;
		mockrandomnumbers.array[3] = 4;
		mockrandomnumbers.array[4] = 2;
		
		boolean saved=p1.Save_Play(mockrandomnumbers.array, 0);
		assertTrue(saved);
		int res[]=p1.get_saved_play(0);
		assertEquals(res.length, mockrandomnumbers.array.length);
		for(int i=0; i<5; i++) {
			assertEquals(res[i], mockrandomnumbers.array[i]);
		}
		
		mockrandomnumbers.array = new int[5];
		mockrandomnumbers.array[0] = 2;
		mockrandomnumbers.array[1] = 3;
		mockrandomnumbers.array[2] = 1;
		mockrandomnumbers.array[3] = 4;
		mockrandomnumbers.array[4] = 3;
		boolean saved2=p1.Save_Play(mockrandomnumbers.array, 11);
		assertTrue(saved2);
		int res2[]=p1.get_saved_play(11);
		assertEquals(res.length, mockrandomnumbers.array.length);
		for(int i=0; i<5; i++) {
			assertEquals(res2[i], mockrandomnumbers.array[i]);
		}
		
		mockrandomnumbers.array = new int[5];
		mockrandomnumbers.array[0] = 3;
		mockrandomnumbers.array[1] = 3;
		mockrandomnumbers.array[2] = 1;
		mockrandomnumbers.array[3] = 4;
		mockrandomnumbers.array[4] = 2;
		boolean saved3=p1.Save_Play(mockrandomnumbers.array, 12);
		assertFalse(saved3);
		int res3[]=p1.get_saved_play(12);
		assertEquals(res3.length, 0);
		
		
		mockrandomnumbers.array = new int[5];
		mockrandomnumbers.array[0] = 3;
		mockrandomnumbers.array[1] = 3;
		mockrandomnumbers.array[2] = 2;
		mockrandomnumbers.array[3] = 2;
		mockrandomnumbers.array[4] = 2;
		boolean saved4=p1.Save_Play(mockrandomnumbers.array, -1);
		assertFalse(saved4);
		int res4[]=p1.get_saved_play(-1);
		assertEquals(res4.length, 0);
		
	}
	
	@Test
	public void test_SetandGet_play() { //save ONLY the current play and latter check it
		Play play = new Play();
		MockRandomNumbers mockrandomnumbers= new MockRandomNumbers();
		int new_a[] = new int[5];
		
		mockrandomnumbers.array = new int[5];
		mockrandomnumbers.array[0] = 0;
		mockrandomnumbers.array[1] = 3;
		mockrandomnumbers.array[2] = 5;
		mockrandomnumbers.array[3] = 4;
		mockrandomnumbers.array[4] = 2;
		
		play.set_play(mockrandomnumbers.array);
		new_a = play.get_play();
		
		for (int i=0; i<mockrandomnumbers.array.length; i++)
			assertEquals(new_a[i], mockrandomnumbers.array[i]);
	}
	
}
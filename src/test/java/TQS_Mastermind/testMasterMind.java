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
		//Player p2 = new Player(1);
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
	        Player p2 = new Player(1);
	        m.code[0] = 0;
	        m.code[1] = 2;
	        m.code[2] = 5;
	        m.code[3] = 1;
	        m.code[4] = 0;
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p2);
	        
	        boolean res1=m.check_positions(p2);
	        assertTrue(res1);
	        int value1[] = new int[5];
	        value1[0]=1;
	        value1[1]=1;
	        value1[2]=1;
	        value1[3]=1;
	        value1[4]=1;
	        for(int i=0; i<mockReadParameters.colors.length; i++) {
				assertEquals(value1[i], m.comparison[i]);
			}
	        
	        m.code[0] = 0;
	        m.code[1] = 2;
	        m.code[2] = 5;
	        m.code[3] = 1;
	        m.code[4] = 0;
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 3;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p2);
	        
	        boolean res2=m.check_positions(p2);
	        assertFalse(res2);
	        int value2[] = new int[5];
	        value2[0]=-1;
	        value2[1]=1;
	        value2[2]=1;
	        value2[3]=1;
	        value2[4]=1;
	        for(int i=0; i<mockReadParameters.colors.length; i++) {
				assertEquals(value2[i], m.comparison[i]);
			}
	        
	        
	        m.code[0] = 0;
	        m.code[1] = 2;
	        m.code[2] = 5;
	        m.code[3] = 1;
	        m.code[4] = 0;
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 0;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p2);
	        
	        boolean res3=m.check_positions(p2);
	        assertFalse(res3);
	        int value3[] = new int[5];
	        value3[0]=1;
	        value3[1]=0;
	        value3[2]=1;
	        value3[3]=1;
	        value3[4]=1;
	        for(int i=0; i<mockReadParameters.colors.length; i++) {
				assertEquals(value3[i], m.comparison[i]);
			}
	        
	        
	        m.code[0] = 0;
	        m.code[1] = 2;
	        m.code[2] = 5;
	        m.code[3] = 1;
	        m.code[4] = 0;
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 0;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p2);
	        
	        boolean res4=m.check_positions(p2);
	        assertFalse(res4);
	        int value4[] = new int[5];
	        value4[0]=1;
	        value4[1]=1;
	        value4[2]=0;
	        value4[3]=1;
	        value4[4]=1;
	        for(int i=0; i<mockReadParameters.colors.length; i++) {
				assertEquals(value4[i], m.comparison[i]);
			}
	        
	        m.code[0] = 0;
	        m.code[1] = 2;
	        m.code[2] = 5;
	        m.code[3] = 1;
	        m.code[4] = 0;
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 4;
	        mockReadParameters.colors[3] = 5;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p2);
	        
	        boolean res5=m.check_positions(p2);
	        assertFalse(res5);
	        int value5[] = new int[5];
	        value5[0]=1;
	        value5[1]=1;
	        value5[2]=-1;
	        value5[3]=0;
	        value5[4]=1;
	        for(int i=0; i<mockReadParameters.colors.length; i++) {
				assertEquals(value5[i], m.comparison[i]);
			}
	        
	        m.code[0] = 0;
	        m.code[1] = 2;
	        m.code[2] = 5;
	        m.code[3] = 1;
	        m.code[4] = 0;
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 2;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 1;
	        mockReadParameters.colors[4] = 4;
	        mockReadParameters.read_parameters(p2);
	        
	        boolean res6=m.check_positions(p2);
	        assertFalse(res6);
	        
	        
	        m.code[0] = 0;
	        m.code[1] = 2;
	        m.code[2] = 5;
	        m.code[3] = 1;
	        m.code[4] = 0;
	        
	        mockReadParameters.colors = new int[5];
	        mockReadParameters.colors[0] = 0;
	        mockReadParameters.colors[1] = 1;
	        mockReadParameters.colors[2] = 5;
	        mockReadParameters.colors[3] = 0;
	        mockReadParameters.colors[4] = 0;
	        mockReadParameters.read_parameters(p2);
	        
	        boolean res7=m.check_positions(p2);
	        assertFalse(res7);
	}
	
	@Test
	public void test_Player1() {
		MasterMind m= new MasterMind();
		
		Player p1 = new Player(0);
		Player p2=new Player(1);
		m.code = new int[5];
		m.code[0] = 0;
		m.code[1] = 3;
		m.code[2] = 7;
		m.code[3] = -1;
		m.code[4] = 6;
		
		boolean res=m.Player1(p1,p2);
		assertFalse(res);
	
		m.code[0] = 0;
		m.code[1] = 3;
		m.code[2] = 5;
		m.code[3] = 0;
		m.code[4] = 4;
		
		boolean res1=m.Player1(p1,p2);
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
	
	@Test
	public void test_Play() {
		MasterMind m= new MasterMind();
		MockReadParameters mockReadParameters = new MockReadParameters();
		
		
		Player p1 = new Player(0);
		Player p2 = new Player(1);
		
		//**************************************** PLAY 1 - check the game finish properly and all the data is saved properly ************************************************************
		
		//set the code 
		m.code = new int[5];
		m.code[0] = 0;
		m.code[1] = 1;
		m.code[2] = 2;
		m.code[3] = 2;
		m.code[4] = 3;
		
		
		boolean res=m.Play(p1,p2);
		assertTrue(res);          //first play of p1
		assertEquals(m.turn, 1);
		
		//p2 play
		mockReadParameters.colors = new int[5];
		mockReadParameters.colors[0] = 1;
		mockReadParameters.colors[1] = 7;
		mockReadParameters.colors[2] = 4;
		mockReadParameters.colors[3] = 1;
		mockReadParameters.colors[4] = 3;
		
		mockReadParameters.read_parameters(p2);
		
		boolean res1=m.Play(p1, p2);
		assertFalse(res1);           //first play of p2
		
		//numPlays should be 12 'cause the play was incorrect
		assertEquals(m.numPlays, 12);
		assertEquals(m.turn, 1); //turn shouldn't have changed
		
		//correct play of p2
		mockReadParameters.colors = new int[5];
		mockReadParameters.colors[0] = 1;
		mockReadParameters.colors[1] = 2;
		mockReadParameters.colors[2] = 4;
		mockReadParameters.colors[3] = 1;
		mockReadParameters.colors[4] = 3;
		
		mockReadParameters.read_parameters(p2);
		
		boolean res2=m.Play(p1, p2);
		assertTrue(res2);      
		
		assertEquals(m.numPlays, 11);
		assertEquals(m.turn, 0); 
		
		//p1 play
		boolean res3=m.Play(p1, p2);
		assertFalse(res3); //player2 didn't win
		assertEquals(m.turn, 1); 
		
		
		//check than the comparison was correct and saved
		int value1[] = new int[5];
        value1[0]=0;
        value1[1]=0;
        value1[2]=-1;
        value1[3]=0;
        value1[4]=1;
        
        for(int i=0; i<m.code.length; i++) {
			assertEquals(value1[i], m.comparison[i]);
		}
        
        //incorrect play of p2
        mockReadParameters.colors = new int[5];
		mockReadParameters.colors[0] = -11;
		mockReadParameters.colors[1] = 2;
		mockReadParameters.colors[2] = -1;
		mockReadParameters.colors[3] = 1;
		mockReadParameters.colors[4] = 6;
		
		mockReadParameters.read_parameters(p2);
		
		boolean res4=m.Play(p1, p2);
		assertFalse(res4);          
		
		//numPlays should be 11 'cause the play was incorrect
		assertEquals(m.numPlays, 11);
		assertEquals(m.turn, 1); //turn shouldn't have changed
		
		//correct play of p2
		mockReadParameters.colors = new int[5];
		mockReadParameters.colors[0] = 1;
		mockReadParameters.colors[1] = 2;
		mockReadParameters.colors[2] = 1;
		mockReadParameters.colors[3] = 1;
		mockReadParameters.colors[4] = 1;
		
		mockReadParameters.read_parameters(p2);
		
		boolean res5=m.Play(p1, p2);
		assertTrue(res5);          
		
		assertEquals(m.numPlays, 10);
		assertEquals(m.turn, 0); 
		
		//p1 play
		boolean res6=m.Play(p1, p2);
		assertFalse(res6); //player2 didn't win
		
		assertEquals(m.turn, 1); 
		
		//check the comparison
		value1[0]=0;
        value1[1]=0;
        value1[2]=0;
        value1[3]=0;
        value1[4]=0;
        
        for(int i=0; i<m.code.length; i++) {
			assertEquals(value1[i], m.comparison[i]);
		}
        
        //p2 play
        mockReadParameters.colors = new int[5];
		mockReadParameters.colors[0] = 1;
		mockReadParameters.colors[1] = 2;
		mockReadParameters.colors[2] = 1;
		mockReadParameters.colors[3] = 1;
		mockReadParameters.colors[4] = 1;
		
		mockReadParameters.read_parameters(p2);
		
		boolean res7=m.Play(p1, p2);
		assertTrue(res7);          
		
		assertEquals(m.numPlays, 9);
		assertEquals(m.turn, 0);
		
		//p1 play
		boolean res8=m.Play(p1, p2);
		assertFalse(res8); //player2 didn't win
		
		assertEquals(m.turn, 1); 
		
		//check the comparison
		value1[0]=0;
        value1[1]=0;
        value1[2]=0;
        value1[3]=0;
        value1[4]=0;
        
        for(int i=0; i<m.code.length; i++) {
			assertEquals(value1[i], m.comparison[i]);
		}
        
        //p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res9=m.Play(p1, p2);
		assertTrue(res9);          
		
		assertEquals(m.numPlays, 8);
		assertEquals(m.turn, 0);
		
		//p1 play
		
		//we use the data generated before
		
		boolean res10=m.Play(p1, p2);
		assertFalse(res10); //player2 didn't win
		
		assertEquals(m.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m.code.length; i++) {
			assertEquals(value1[i], m.comparison[i]);
		}
        
        //p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res11=m.Play(p1, p2);
		assertTrue(res11);          
		
		assertEquals(m.numPlays, 7);
		assertEquals(m.turn, 0);
		
		//p1 play
		
		//we use the data generated before
		
		boolean res12=m.Play(p1, p2);
		assertFalse(res12); //player2 didn't win
		
		assertEquals(m.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m.code.length; i++) {
			assertEquals(value1[i], m.comparison[i]);
		}
        
		//p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res13=m.Play(p1, p2);
		assertTrue(res13);          
		
		assertEquals(m.numPlays, 6);
		assertEquals(m.turn, 0);
		
		//p1 play
		
		//we use the data generated before
		
		boolean res14=m.Play(p1, p2);
		assertFalse(res14); //player2 didn't win
		
		assertEquals(m.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m.code.length; i++) {
			assertEquals(value1[i], m.comparison[i]);
		}
		
		//p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res15=m.Play(p1, p2);
		assertTrue(res15);          
		
		assertEquals(m.numPlays, 5);
		assertEquals(m.turn, 0);
		
		//p1 play
		
		//we use the data generated before
		
		boolean res16=m.Play(p1, p2);
		assertFalse(res16); //player2 didn't win
		
		assertEquals(m.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m.code.length; i++) {
			assertEquals(value1[i], m.comparison[i]);
		}
		
		//p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res17=m.Play(p1, p2);
		assertTrue(res17);          
		
		assertEquals(m.numPlays, 4);
		assertEquals(m.turn, 0);
		
		
		//p1 play
		
		//we use the data generated before
		
		boolean res18=m.Play(p1, p2);
		assertFalse(res18); //player2 didn't win
		
		assertEquals(m.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m.code.length; i++) {
			assertEquals(value1[i], m.comparison[i]);
		}
		
		//p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res19=m.Play(p1, p2);
		assertTrue(res19);          
		
		assertEquals(m.numPlays, 3);
		assertEquals(m.turn, 0);
		
		
		//p1 play
		
		//we use the data generated before
		
		boolean res20=m.Play(p1, p2);
		assertFalse(res20); //player2 didn't win
		
		assertEquals(m.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m.code.length; i++) {
			assertEquals(value1[i], m.comparison[i]);
		}
		
		//p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res21=m.Play(p1, p2);
		assertTrue(res21);          
		
		assertEquals(m.numPlays, 2);
		assertEquals(m.turn, 0);
		
		
		//p1 play
		
		//we use the data generated before
		
		boolean res22=m.Play(p1, p2);
		assertFalse(res22); //player2 didn't win
		
		assertEquals(m.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m.code.length; i++) {
			assertEquals(value1[i], m.comparison[i]);
		}
		
		//p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res23=m.Play(p1, p2);
		assertTrue(res23);          
		
		assertEquals(m.numPlays, 1);
		assertEquals(m.turn, 0);
		
		
		//p1 play
		
		//we use the data generated before
		
		boolean res24=m.Play(p1, p2);
		assertFalse(res24); //player2 didn't win
		
		assertEquals(m.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m.code.length; i++) {
			assertEquals(value1[i], m.comparison[i]);
		}
		
		//p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res25=m.Play(p1, p2);
		assertTrue(res25);          
		
		assertEquals(m.numPlays, 0);
		assertEquals(m.turn, 0);
		
		//p1 play
		
		//we use the data generated before
		
		boolean res26=m.Play(p1, p2);
		assertFalse(res26); //player2 didn't win
		
		assertEquals(m.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m.code.length; i++) {
			assertEquals(value1[i], m.comparison[i]);
		}
        
        
        //check that the game finished correctly
        boolean res27=m.Play(p1, p2);
		assertFalse(res27);          
		
		assertEquals(m.numPlays, 0);
		assertEquals(m.turn, 1);
		
		boolean res28=m.Play(p1, p2);
		assertFalse(res28);          
		
		assertEquals(m.numPlays, 0);
		assertEquals(m.turn, 1);
        
        
		
	}
	
}

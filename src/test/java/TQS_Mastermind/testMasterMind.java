package TQS_Mastermind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import models.MasterMind;
import models.Player;

public class testMasterMind {
	
	@Before 
    public void setUp() throws Exception {
    }
	
	@Test
	public void test_Check_Parameters() {
		MasterMind m= new MasterMind();
		
		//Check the boundary value (boundary=frontera)
		boolean value0=m.check_parameters(0); 
		assertTrue(value0);
		
		boolean value5=m.check_parameters(5);
		assertTrue(value5);
		
		//Check correct values euivalent partition
		boolean value3=m.check_parameters(3);
		assertTrue(value3);
		
		 //Check the limit value
		boolean value6=m.check_parameters(-1);
		assertFalse(value6);
		
		boolean value7=m.check_parameters(6);
		assertFalse(value7);
		
		//Check incorrect values equivalent partition
		boolean value8=m.check_parameters(-35);
		assertFalse(value8);
		
		boolean value9=m.check_parameters(20);
		assertFalse(value9);
	}
	
	
	@Test
	public void test_Read_Parameters() {
		MasterMind m= new MasterMind();
		MockReadParameters mockReadParameters = new MockReadParameters();
		Player p1 = new Player(0);
		
		mockReadParameters.colors ="0 3 5 0 6" ;
		
		mockReadParameters.read_parameters(p1, m); //Read the correct input (only positive numbers)
		
		//Check the value of the boundary position
		boolean value0=m.check_parameters(p1.get_userColorPosition(0));
		assertTrue(value0);
		
		boolean value4=m.check_parameters(p1.get_userColorPosition(4));
		assertFalse(value4);
		
		//Check the value of correct position. Equivalent partition
		boolean value2=m.check_parameters(p1.get_userColorPosition(2));
		assertTrue(value2);
		
		//Check the value of the limit position
		boolean value6=m.check_parameters(p1.get_userColorPosition(5));
		assertFalse(value6);
		
		boolean value7=m.check_parameters(p1.get_userColorPosition(-1));
		assertFalse(value7);
		
		//Check the value of incorrect position. Equivalent partition
		boolean value5=m.check_parameters(p1.get_userColorPosition(-5));
		assertFalse(value5);
		
		boolean value8=m.check_parameters(p1.get_userColorPosition(7));
		assertFalse(value8);
		
		//Check limit value
		mockReadParameters.colors ="";
		mockReadParameters.read_parameters(p1, m);
		assertTrue(m.wrong_numbers);
		m.wrong_numbers=false;
		
		/*Check incorrect values. Equivalent partitions (number and letters (without space),
		number and letters (with space), numbers separated by symbols, negative number*/
		mockReadParameters.colors ="32u8";
		mockReadParameters.read_parameters(p1, m);
		assertTrue(m.wrong_numbers);
		m.wrong_numbers=false;
		
		mockReadParameters.colors ="m m m 2 1";
		mockReadParameters.read_parameters(p1, m);
		assertTrue(m.wrong_numbers);
		m.wrong_numbers=false;
		
		mockReadParameters.colors ="1,3,5,2,0";
		mockReadParameters.read_parameters(p1, m);
		assertTrue(m.wrong_numbers);
		m.wrong_numbers=false;
		
		mockReadParameters.colors ="-1 3 5 2 0";
		mockReadParameters.read_parameters(p1, m);
		assertTrue(m.wrong_numbers);
		m.wrong_numbers=false;
	}
	
	
	@Test
	public void test_GenerateCode() {
		MasterMind m= new MasterMind();
		int array_code[]=m.generate_code();
		assertEquals(array_code.length,5);
		
		//Check that the random values generated are in the range (0-5)
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
		Player p2= new Player(1);
		
		mockrandomnumbers.array = new int[5];
		mockrandomnumbers.array[0] = 0; //Check boundary value
		mockrandomnumbers.array[1] = 3; //Equivalent partition
		mockrandomnumbers.array[2] = 5; //Check boundary value
		mockrandomnumbers.array[3] = -1; //Check limit value
		mockrandomnumbers.array[4] = 6; //Check limit value
		
		boolean res = mockrandomnumbers.random_numbers(p, m);
		assertTrue(res);
		
		for(int i=0; i<mockrandomnumbers.array.length; i++) {
			boolean value1=m.check_parameters(mockrandomnumbers.array[i]);
			if (i==3 || i==4)
				assertFalse(value1);
			else
				assertTrue(value1);
		}
		
		//Condition and decision coverage
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
	
		mockrandomnumbers.array[0] = 0;
		mockrandomnumbers.array[1] = 3;
		mockrandomnumbers.array[2] = 5;
		mockrandomnumbers.array[3] = 4;
		mockrandomnumbers.array[4] = 2;
		boolean res2 = mockrandomnumbers.random_numbers(p2, m);
		assertFalse(res2);
		
		mockrandomnumbers.array[0] = 0;
		mockrandomnumbers.array[1] = 3;
		mockrandomnumbers.array[2] = 5;
		mockrandomnumbers.array[3] = 4;
		mockrandomnumbers.array[4] = 2;
		m.numPlays();
		boolean res3 = mockrandomnumbers.random_numbers(p, m);
		assertFalse(res3);
		
		mockrandomnumbers.array[0] = 0;
		mockrandomnumbers.array[1] = 3;
		mockrandomnumbers.array[2] = 5;
		mockrandomnumbers.array[3] = 4;
		mockrandomnumbers.array[4] = 2;
		m.numPlays();
		boolean res4 = mockrandomnumbers.random_numbers(p2, m);
		assertFalse(res4);
	}
	
	
	@Test
	public void test_Turn() {
		MasterMind m= new MasterMind();
		
		//Check boundary value (turn)
		int res=m.turn(0);
		assertEquals(res, 1);
		
		int res1=m.turn(1);
		assertEquals(res1, 0);
		
		//Check limit value (turn). Equivalent partition
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
        
        //There's no limit value because it's impossible. comparison[i] will only be 0, 1 or 2.
        //Check boundary value (comparison[i]=2 && comparison[i]=0)
        m.code[0] = 0;
        m.code[1] = 2;
        m.code[2] = 5;
        m.code[3] = 1;
        m.code[4] = 0;
        
        mockReadParameters.colors = "0 2 5 1 0";
       
        mockReadParameters.read_parameters(p2, m);
        
        boolean res1=m.check_positions(p2);
        assertTrue(res1);
        int value1[] = new int[5];
        value1[0]=2;
        value1[1]=2;
        value1[2]=2;
        value1[3]=2;
        value1[4]=2;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value1[i], m.comparison[i]);
		}
        
        m.code[0] = 0;
        m.code[1] = 2;
        m.code[2] = 5;
        m.code[3] = 1;
        m.code[4] = 0;
        
        mockReadParameters.colors = "4 4 4 4 4";
        
        mockReadParameters.read_parameters(p2, m);
        
        boolean res2=m.check_positions(p2);
        assertFalse(res2);
        int value5[] = new int[5];
        value5[0]=0;
        value5[1]=0;
        value5[2]=0;
        value5[3]=0;
        value5[4]=0;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
        
        //Pairwise test
        m.code[0]=1;
        m.code[1]=2;
        m.code[2]=3;
        m.code[3]=4;
        m.code[4]=5;
        mockReadParameters.colors ="0 0 0 0 0";
        mockReadParameters.read_parameters(p2, m);
        boolean res10=m.check_positions(p2);
        assertFalse(res10);
        value5[0]=0;
        value5[1]=0;
        value5[2]=0;
        value5[3]=0;
        value5[4]=0;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
        
        mockReadParameters.colors ="4 3 2 1 0";
        mockReadParameters.read_parameters(p2, m);
        boolean res11=m.check_positions(p2);
        assertFalse(res11);
        value5[0]=1;
        value5[1]=1;
        value5[2]=1;
        value5[3]=1;
        value5[4]=0;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
        
        mockReadParameters.colors ="1 2 3 4 0";
        mockReadParameters.read_parameters(p2, m);
        boolean res12=m.check_positions(p2);
        assertFalse(res12);
        value5[0]=2;
        value5[1]=2;
        value5[2]=2;
        value5[3]=2;
        value5[4]=0;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
        
        mockReadParameters.colors ="1 3 0 4 2";
        mockReadParameters.read_parameters(p2, m);
        boolean res13=m.check_positions(p2);
        assertFalse(res13);
        value5[0]=2;
        value5[1]=1;
        value5[2]=0;
        value5[3]=2;
        value5[4]=1;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
        
        mockReadParameters.colors ="4 0 3 1 2";
        mockReadParameters.read_parameters(p2, m);
        boolean res14=m.check_positions(p2);
        assertFalse(res14);
        value5[0]=1;
        value5[1]=0;
        value5[2]=2;
        value5[3]=1;
        value5[4]=1;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
        
        mockReadParameters.colors ="0 2 2 0 2";
        mockReadParameters.read_parameters(p2, m);
        boolean res15=m.check_positions(p2);
        assertFalse(res15);
        value5[0]=0;
        value5[1]=2;
        value5[2]=1;
        value5[3]=0;
        value5[4]=1;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
        
        mockReadParameters.colors ="0 3 3 0 5";
        mockReadParameters.read_parameters(p2, m);
        boolean res16=m.check_positions(p2);
        assertFalse(res16);
        value5[0]=0;
        value5[1]=1;
        value5[2]=2;
        value5[3]=0;
        value5[4]=2;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
        
        mockReadParameters.colors ="4 2 0 1 5";
        mockReadParameters.read_parameters(p2, m);
        boolean res17=m.check_positions(p2);
        assertFalse(res17);
        value5[0]=1;
        value5[1]=2;
        value5[2]=0;
        value5[3]=1;
        value5[4]=2;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
        
        mockReadParameters.colors ="1 0 2 4 5";
        mockReadParameters.read_parameters(p2, m);
        boolean res18=m.check_positions(p2);
        assertFalse(res18);
        value5[0]=2;
        value5[1]=0;
        value5[2]=1;
        value5[3]=2;
        value5[4]=2;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
        
        mockReadParameters.colors ="1 0 2 2 5";
        mockReadParameters.read_parameters(p2, m);
        boolean res19=m.check_positions(p2);
        assertFalse(res19);
        value5[0]=2;
        value5[1]=0;
        value5[2]=1;
        value5[3]=1;
        value5[4]=2;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
        
        mockReadParameters.colors ="4 0 2 0 5";
        mockReadParameters.read_parameters(p2, m);
        boolean res20=m.check_positions(p2);
        assertFalse(res20);
        value5[0]=1;
        value5[1]=0;
        value5[2]=1;
        value5[3]=0;
        value5[4]=2;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
        
        mockReadParameters.colors ="0 0 2 2 5";
        mockReadParameters.read_parameters(p2, m);
        boolean res21=m.check_positions(p2);
        assertFalse(res21);
        value5[0]=0;
        value5[1]=0;
        value5[2]=1;
        value5[3]=1;
        value5[4]=2;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
        
        mockReadParameters.colors ="0 0 2 4 5";
        mockReadParameters.read_parameters(p2, m);
        boolean res22=m.check_positions(p2);
        assertFalse(res22);
        value5[0]=0;
        value5[1]=0;
        value5[2]=1;
        value5[3]=2;
        value5[4]=2;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
        
        mockReadParameters.colors ="4 0 2 4 5";
        mockReadParameters.read_parameters(p2, m);
        boolean res23=m.check_positions(p2);
        assertFalse(res23);
        value5[0]=1;
        value5[1]=0;
        value5[2]=1;
        value5[3]=2;
        value5[4]=2;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
        
        mockReadParameters.colors ="1 0 2 0 5";
        mockReadParameters.read_parameters(p2, m);
        boolean res24=m.check_positions(p2);
        assertFalse(res24);
        value5[0]=2;
        value5[1]=0;
        value5[2]=1;
        value5[3]=0;
        value5[4]=2;
        for(int i=0; i<mockReadParameters.color.length; i++) {
			assertEquals(value5[i], m.comparison[i]);
		}
	}
	
	
	@Test
	public void test_Player1() {
		MasterMind m= new MasterMind();
		MockRandomNumbers mockRandomNumbers = new MockRandomNumbers();
		
		Player p1 = new Player(0);
		Player p2 = new Player(1);
		
		mockRandomNumbers.array[0] = 0;
		mockRandomNumbers.array[1] = 3;
		mockRandomNumbers.array[2] = 5;
		mockRandomNumbers.array[3] = 0;
		mockRandomNumbers.array[4] = 4;
		
		mockRandomNumbers.random_numbers(p1, m);
		boolean res6=m.Player1(p1,p2);
		assertTrue(res6);
		
		m.numPlays=11;
		p2.user_color = new int [5];
		p2.user_color[0]=1;
		p2.user_color[1]=1;
		p2.user_color[2]=1;
		p2.user_color[3]=1;
		p2.user_color[4]=1;
		boolean res=m.Player1(p1,p2);
		assertFalse(res);
		
		p2.user_color = new int [5];
		p2.user_color[0]=0;
		p2.user_color[1]=3;
		p2.user_color[2]=5;
		p2.user_color[3]=0;
		p2.user_color[4]=4;
		boolean res1=m.Player1(p1,p2);
		assertTrue(res1);
	}
	
	@Test
	public void test_Player2() {
		MasterMind m= new MasterMind();
		
		MockReadParameters mockReadParameters = new MockReadParameters();
		Player p2 = new Player(1);
		
		//Check loop testing
		mockReadParameters.colors = "8 3 4 1 2";
		
		mockReadParameters.read_parameters(p2, m);
		
		boolean res1=m.Player2(p2);
		assertTrue(m.wrong_numbers);
		assertFalse(m.wrong_size);
		m.wrong_numbers=false;
		assertFalse(res1);
		
		mockReadParameters.colors = "3 8 4 1 2";
		
		mockReadParameters.read_parameters(p2, m);
		
		boolean res2=m.Player2(p2);
		assertTrue(m.wrong_numbers);
		assertFalse(m.wrong_size);
		m.wrong_numbers=false;
		assertFalse(res2);
		
		mockReadParameters.colors ="3 4 8 1 2";
		
		mockReadParameters.read_parameters(p2, m);
		
		boolean res3=m.Player2(p2);
		assertTrue(m.wrong_numbers);
		assertFalse(m.wrong_size);
		m.wrong_numbers=false;
		assertFalse(res3);
		
		mockReadParameters.colors ="3 4 1 8 2";
		
		mockReadParameters.read_parameters(p2, m);
		
		boolean res4=m.Player2(p2);
		assertTrue(m.wrong_numbers);
		assertFalse(m.wrong_size);
		m.wrong_numbers=false;
		assertFalse(res4);
		
		mockReadParameters.colors ="3 4 2 1 8";
		
		mockReadParameters.read_parameters(p2, m);
		
		boolean res5=m.Player2(p2);
		assertTrue(m.wrong_numbers);
		assertFalse(m.wrong_size);
		m.wrong_numbers=false;
		assertFalse(res5);
		
		
		//Check limit values (4 and 6 inputs). Equivalent partition
		mockReadParameters.colors = "3 2 1 4";
		mockReadParameters.read_parameters(p2, m);
		
		boolean res6=m.Player2(p2);
		assertFalse(m.wrong_numbers);
		assertTrue(m.wrong_size);
		m.wrong_size=false;
		assertFalse(res6);
		
	
		mockReadParameters.colors = "3 4 2 1 3 3";
		mockReadParameters.read_parameters(p2, m);
			
		boolean res7=m.Player2(p2);
		assertFalse(m.wrong_numbers);
		assertTrue(m.wrong_size);
		m.wrong_size=false;
		assertFalse(res7);
		
		
		//Check boundary values (5 inputs) & Condition and decision coverage
		mockReadParameters.colors = "0 3 5 0 4";
		
		mockReadParameters.read_parameters(p2, m);
		
		boolean res8=m.Player2(p2);
		assertFalse(m.wrong_numbers);
		assertFalse(m.wrong_size);
		m.wrong_numbers=false;
		assertTrue(res8);
		assertEquals(m.numPlays,11); //incorrect values like -1 are checked in other tests, like test_Play
	}
	
	
	@Test
	public void test_Play() {
		
		//**************************************** PLAY 1 - check the game finish properly and all the data is saved properly ************************************************************

		MasterMind m= new MasterMind();
		MockReadParameters mockReadParameters = new MockReadParameters();
		Player p1 = new Player(0);
		Player p2 = new Player(1);
	
		//set the code 
		m.code = new int[5];
		m.code[0] = 0;
		m.code[1] = 1;
		m.code[2] = 2;
		m.code[3] = 2;
		m.code[4] = 3;
		
		boolean res=m.Play(p1,p2); //first play of p1
		assertTrue(res);
		assertEquals(m.turn, 1); //Check boundary value (turn)
		
		//p2 turn
		mockReadParameters.colors = "1 7 4 1 3";
		mockReadParameters.read_parameters(p2, m);
		
		boolean res1=m.Play(p1, p2); //first play of p2
		assertFalse(res1);           
	
		assertEquals(m.numPlays, 12); //Boundary value, numPlays should be 12 'cause the play was incorrect
		assertEquals(m.turn, 1); //turn shouldn't have changed
		
		//correct play of p2
		mockReadParameters.colors = "1 2 4 1 3";
		mockReadParameters.read_parameters(p2, m);
		
		boolean res2=m.Play(p1, p2);
		assertTrue(res2);      
		
		assertEquals(m.numPlays, 11);
		assertEquals(m.turn, 0);  //Check boundary value (turn)
		
		//p1 play
		boolean res3=m.Play(p1, p2);
		assertFalse(res3); //player2 didn't win
		assertEquals(m.turn, 1); 
		
		
		//check that the comparison was correct and saved
		int value1[] = new int[5];
        value1[0]=1;
        value1[1]=1;
        value1[2]=0;
        value1[3]=1;
        value1[4]=2;
        
        for(int i=0; i<m.code.length; i++) {
			assertEquals(value1[i], m.comparison[i]);
		}
        
        //incorrect play of p2
        mockReadParameters.colors ="8 2 1 1 6";
		mockReadParameters.read_parameters(p2, m);
		
		boolean res4=m.Play(p1, p2);
		assertFalse(res4);          
		
		assertEquals(m.numPlays, 11); //numPlays should be 11 'cause the play was incorrect
		assertEquals(m.turn, 1); //turn shouldn't have changed
		
		//correct play of p2
		mockReadParameters.colors ="1 2 1 1 1";
		mockReadParameters.read_parameters(p2, m);
		
		boolean res5=m.Play(p1, p2);
		assertTrue(res5);          
		
		assertEquals(m.numPlays, 10);
		assertEquals(m.turn, 0); 
		
		//p1 play
		boolean res6=m.Play(p1, p2);
		assertFalse(res6); //player2 didn't win
		assertEquals(m.turn, 1); 
		
		//check the comparison
		value1[0]=1;
        value1[1]=1;
        value1[2]=1;
        value1[3]=1;
        value1[4]=1;
        
        for(int i=0; i<m.code.length; i++) {
			assertEquals(value1[i], m.comparison[i]);
		}
        
        //p2 play
        mockReadParameters.colors = "1 2 1 1 1";
		mockReadParameters.read_parameters(p2, m);
		
		boolean res7=m.Play(p1, p2);
		assertTrue(res7);          
		
		assertEquals(m.numPlays, 9);
		assertEquals(m.turn, 0);
		
		//p1 play
		boolean res8=m.Play(p1, p2);
		assertFalse(res8); //player2 didn't win
		
		assertEquals(m.turn, 1); 
		
		//check the comparison
		value1[0]=1;
        value1[1]=1;
        value1[2]=1;
        value1[3]=1;
        value1[4]=1;
        
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
		
		assertEquals(m.numPlays, 0); //Check boundary value
		assertEquals(m.turn, 1);
		
		boolean res28=m.Play(p1, p2);
		assertFalse(res28);          
		
		assertEquals(m.numPlays, 0);
		assertEquals(m.turn, 1);
		
		
		
		
		//**************************************** PLAY 2 - check the game finish properly and all the data is saved properly ************************************************************
		
		MasterMind m1= new MasterMind();
		MockReadParameters mockReadParameters1 = new MockReadParameters();
		
		
		Player p11 = new Player(0);
		Player p22 = new Player(1);
		
		//set the code 
		m1.code = new int[5];
		m1.code[0] = 0;
		m1.code[1] = 1;
		m1.code[2] = 2;
		m1.code[3] = 2;
		m1.code[4] = 3;
		
		
		boolean res01=m1.Play(p11,p22);
		assertEquals(m1.numPlays,12);
		assertTrue(res01);          //first play of p1
		assertEquals(m1.turn, 1);
		
		//p2 play
		mockReadParameters1.colors = "0 1 2 2 3";
		
		
		mockReadParameters1.read_parameters(p22, m);
		
		m1.Play(p11, p22);
		
		assertTrue(m1.Play(p11, p22)); // the game finishes 'cause the player2 won
		
		
		
		
		//**************************************** PLAY 3 - check the game finish properly and all the data is saved properly ************************************************************
		//check values limits
		
		MasterMind m2= new MasterMind();
		MockReadParameters mockReadParameters2 = new MockReadParameters();
		
		
		Player p111 = new Player(0);
		Player p222 = new Player(1);
		
		//set the code 
		m2.code = new int[5];
		m2.code[0] = 0;
		m2.code[1] = 1;
		m2.code[2] = 2;
		m2.code[3] = 2;
		m2.code[4] = 3;
		
		
		boolean res31=m2.Play(p111,p222);
		assertTrue(res31);          //first play of p1
		assertEquals(m2.turn, 1);
		
		//p2 play
		mockReadParameters2.colors = "1 2 4 1 3";
		
		
		mockReadParameters2.read_parameters(p222, m);
		
		
		
		//correct play of p2
	
		
		boolean res32=m2.Play(p111, p222);
		assertTrue(res32);      
		
		assertEquals(m2.numPlays, 11);
		assertEquals(m2.turn, 0); 
		
		//p1 play
		boolean res33=m2.Play(p111, p222);
		assertFalse(res33); //player2 didn't win
		assertEquals(m2.turn, 1); 
		
		
		//check than the comparison was correct and saved
		int value11[] = new int[5];
        value11[0]=1;
        value11[1]=1;
        value11[2]=0;
        value11[3]=1;
        value11[4]=2;
        
        for(int i=0; i<m2.code.length; i++) {
			assertEquals(value11[i], m2.comparison[i]);
		}
        
        //play of p2
        
		boolean res34=m2.Play(p111, p222);
		assertTrue(res34);          
		
		
		assertEquals(m2.numPlays, 10);
		assertEquals(m2.turn, 0); 
		
		
		//p1 play
		boolean res36=m2.Play(p111, p222);
		assertFalse(res36); //player2 didn't win
		
		assertEquals(m2.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m2.code.length; i++) {
			assertEquals(value11[i], m2.comparison[i]);
		}
        
        //p2 play
       
		boolean res37=m2.Play(p111, p222);
		assertTrue(res37);          
		
		assertEquals(m2.numPlays, 9);
		assertEquals(m2.turn, 0);
		
		//p1 play
		boolean res38=m2.Play(p111, p222);
		assertFalse(res38); //player2 didn't win
		
		assertEquals(m2.turn, 1); 
		
		//check the comparison
		
        
        for(int i=0; i<m2.code.length; i++) {
			assertEquals(value11[i], m2.comparison[i]);
		}
        
        //p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res39=m2.Play(p111, p222);
		assertTrue(res39);          
		
		assertEquals(m2.numPlays, 8);
		assertEquals(m2.turn, 0);
		
		//p1 play
		
		//we use the data generated before
		
		boolean res310=m2.Play(p111, p222);
		assertFalse(res310); //player2 didn't win
		
		assertEquals(m2.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m2.code.length; i++) {
			assertEquals(value11[i], m2.comparison[i]);
		}
        
        //p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res311=m2.Play(p111, p222);
		assertTrue(res311);          
		
		assertEquals(m2.numPlays, 7);
		assertEquals(m2.turn, 0);
		
		//p1 play
		
		//we use the data generated before
		
		boolean res312=m2.Play(p111, p222);
		assertFalse(res312); //player2 didn't win
		
		assertEquals(m2.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m2.code.length; i++) {
			assertEquals(value11[i], m2.comparison[i]);
		}
        
		//p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res313=m2.Play(p111, p222);
		assertTrue(res313);          
		
		assertEquals(m2.numPlays, 6);
		assertEquals(m2.turn, 0);
		
		//p1 play
		
		//we use the data generated before
		
		boolean res314=m2.Play(p111, p222);
		assertFalse(res314); //player2 didn't win
		
		assertEquals(m2.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m2.code.length; i++) {
			assertEquals(value11[i], m2.comparison[i]);
		}
		
		//p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res315=m2.Play(p111, p222);
		assertTrue(res315);          
		
		assertEquals(m2.numPlays, 5);
		assertEquals(m2.turn, 0);
		
		//p1 play
		
		//we use the data generated before
		
		boolean res316=m2.Play(p111, p222);
		assertFalse(res316); //player2 didn't win
		
		assertEquals(m2.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m2.code.length; i++) {
			assertEquals(value11[i], m2.comparison[i]);
		}
		
		//p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res317=m2.Play(p111, p222);
		assertTrue(res317);          
		
		assertEquals(m2.numPlays, 4);
		assertEquals(m2.turn, 0);
		
		
		//p1 play
		
		//we use the data generated before
		
		boolean res318=m2.Play(p111, p222);
		assertFalse(res318); //player2 didn't win
		
		assertEquals(m2.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m2.code.length; i++) {
			assertEquals(value11[i], m2.comparison[i]);
		}
		
		//p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res319=m2.Play(p111, p222);
		assertTrue(res319);          
		
		assertEquals(m2.numPlays, 3);
		assertEquals(m2.turn, 0);
		
		
		//p1 play
		
		//we use the data generated before
		
		boolean res320=m2.Play(p111, p222);
		assertFalse(res320); //player2 didn't win
		
		assertEquals(m2.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m2.code.length; i++) {
			assertEquals(value11[i], m2.comparison[i]);
		}
		
		//p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res321=m2.Play(p111, p222);
		assertTrue(res321);          
		
		assertEquals(m2.numPlays, 2);
		assertEquals(m2.turn, 0);
		
		
		//p1 play
		
		//we use the data generated before
		
		boolean res322=m2.Play(p111, p222);
		assertFalse(res322); //player2 didn't win
		
		assertEquals(m2.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m2.code.length; i++) {
			assertEquals(value11[i], m2.comparison[i]);
		}
		
		//p2 play
        
        //we use the data generated before with mockReadParameters.read_parameters(p2);
		
		boolean res323=m2.Play(p111, p222);
		assertTrue(res323);          
		
		assertEquals(m2.numPlays, 1);
		assertEquals(m2.turn, 0);
		
		
		//p1 play
		
		//we use the data generated before
		
		boolean res324=m2.Play(p111, p222);
		assertFalse(res324); //player2 didn't win
		
		assertEquals(m2.turn, 1); 
		
		//check the comparison
        
        for(int i=0; i<m2.code.length; i++) {
			assertEquals(value11[i], m2.comparison[i]);
		}
		
		//p2 play
        
        mockReadParameters2.colors = "0 1 2 2 3";
	
		
		mockReadParameters2.read_parameters(p222, m);
		
		boolean res325=m2.Play(p111, p222);
		assertTrue(res325);          
		
		assertEquals(m2.numPlays, 0);
		assertEquals(m2.turn, 0);
		
		//p1 play
		
		//we use the data generated before
		
		boolean res326=m2.Play(p111, p222);
		assertTrue(res326); //player2 didn't win
		
		assertEquals(m2.turn, 1); 
		
		//check the comparison
		value11[0]=2;
		value11[1]=2;
		value11[2]=2;
		value11[3]=2;
		value11[4]=2;
				
        for(int i=0; i<m2.code.length; i++) {
			assertEquals(value11[i], m2.comparison[i]);
		}
        
        //Check limit value (numPlays and turn). Equivalent partitions
        m2.turn = 0;
        m2.numPlays=13;
        boolean res327=m2.Play(p111, p222);
        assertFalse(res327);
        assertEquals(m2.numPlays, 13);
		assertEquals(m2.turn, 0);
        
        m2.numPlays=-1;
        boolean res328=m2.Play(p111, p222);
        assertFalse(res328);
        assertEquals(m2.numPlays, -1);
		assertEquals(m2.turn, 0);
		
		m2.turn = 0;
		m2.numPlays=0;
		boolean res338=m2.Play(p111, p222);
        assertTrue(res338);
        assertEquals(m2.numPlays, 0);
		assertEquals(m2.turn, 1);
		
		m2.numPlays=0;
		boolean res339=m2.Play(p111, p222);
        assertFalse(res339);
        assertEquals(m2.numPlays, 0);
		assertEquals(m2.turn, 1);
		
		m2.numPlays=5;
        m2.turn = 2;
        boolean res329=m2.Play(p111, p222);
        assertFalse(res329);
        assertEquals(m2.numPlays, 5);
		assertEquals(m2.turn, 2);
        
        m2.turn = -1;
        boolean res330=m2.Play(p111, p222);
        assertFalse(res330);
        assertEquals(m2.numPlays, 5);
		assertEquals(m2.turn, -1);
		
	}
	
	
	@Test
	public void test_Game() {
		MockTestGame mT= new MockTestGame();
		MasterMind  m= new MasterMind();
		Player p1= new Player(0);
		Player p2= new Player(1);
		
		boolean res=mT.Game(m, p1, p2);
		assertTrue(res);
		
		//Loop testing
		mT.find = false;
		m.numPlays=-1;
		boolean res1=mT.Game(m, p1, p2);
		assertFalse(res1);
		
		mT.find = true;
		boolean res2=mT.Game(m, p1, p2);
		assertTrue(res2);
		
	}
	
}

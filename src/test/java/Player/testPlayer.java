package Player;

import static org.junit.Assert.*;
import org.junit.Test;

import TQS_Mastermind.MockRandomNumbers;
import models.Player;

public class testPlayer {
	
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
}

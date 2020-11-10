package Play;

import static org.junit.Assert.*;
import org.junit.Test;

import TQS_Mastermind.MockRandomNumbers;
import TQS_Mastermind.Play;

public class testPlay {
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

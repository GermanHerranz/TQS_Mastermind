package TQS_Mastermind;

import java.util.Random;

public class MockRandomNumbers {
	
	int array[] = new int[5];
	
	boolean random_numbers(Player player, MasterMind md) {
		boolean find=false;
		
		if (player.id_player == 0 && md.numPlays==12)
		{
			for(int i=0; i<5; i++) {
				player.set_userColorPosition (i, array[i]);
				find = true;
			}	
		}
		return find;
	}
}

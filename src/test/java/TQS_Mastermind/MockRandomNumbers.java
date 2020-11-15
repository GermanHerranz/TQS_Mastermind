package TQS_Mastermind;

import models.MasterMind;
import models.Player;

public class MockRandomNumbers {
	
	public int array[] = new int[5];
	
	boolean random_numbers(Player player, MasterMind md) {
		boolean find=false;
		
		if (player.id_player == 0 && md.numPlays==12)
		{
			for(int i=0; i<5; i++) {
				if(array[i]<=5 && array[i]>=0) {
				md.code[i] = array[i];
				find = true;
				}
			}	
		}
		return find;
	}
}

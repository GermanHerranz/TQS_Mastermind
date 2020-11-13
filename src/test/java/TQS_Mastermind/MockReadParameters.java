package TQS_Mastermind;

import models.Player;

public class MockReadParameters {
	
	public int colors[];
	
	public void read_parameters(Player player){
	
		player.user_color = new int [5];
		for(int i=0; i<5; i++) {
			player.set_userColorPosition (i, colors[i]);
			
		}		
	}
	

}

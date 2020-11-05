package TQS_Mastermind;

import java.util.Scanner;

public class MockReadParameters {
	
	int colors[];
	
	void read_parameters(Player player){
	
		for(int i=0; i<5; i++) {
			player.set_userColorPosition (i, colors[i]);
			
		}		
	}
	

}

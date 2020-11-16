package TQS_Mastermind;

import java.util.Random;

import models.MasterMind;
import models.Player;

public class MockTestGame {
	MockRandomNumbers mRandom;
	MockReadParameters mRead;
	int test_array[];
	boolean find = false;
	
	MockTestGame(){
		mRandom = new MockRandomNumbers();
		mRead = new MockReadParameters();
		
		mRead.colors = "";
		mRandom.array = new int[5];
	}
	
	public boolean Game(MasterMind m, Player p1, Player p2) {
		Random r = new Random();
		int results[] = new int [m.comparison.length];
		while(!find && m.numPlays>=0) { //while there's plays left and the player 2 hasn't win
			if(m.numPlays==12 && m.turn==0) { //set the combination of player 1
				m.code[0]=1;
				m.code[1]=0;
				m.code[2]=4;
				m.code[3]=5;
				m.code[4]=3;
			}
			else {
				if(m.turn==1) { //random generation of the player 2 code
					for (int i=0; i<m.comparison.length; i++) {
						if (m.comparison[i] == 2) { //if the number is correct we keep the value
							results[i]=p2.user_color[i];
						}
						else { //if not, we generate random numbers between 0 and 5
							results[i] = r.nextInt(6);
						}
					}
					mRead.colors = ""+results[0]+" "+results[1]+" "+results[2]+" "+results[3]+" "+results[4]+"";
					mRead.read_parameters(p2, m);
				}
				
			}
			boolean play=m.Play(p1, p2);
			if(m.turn==1 && play && m.numPlays!=12 ) { //Player 2 has win
				find=true;
			}
			if(m.turn==1 && m.numPlays==0 && !play) { //Player 2 has lost
				find= true;
			}
			
		}
		
		return find;
	}
}

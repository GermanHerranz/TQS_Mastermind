package TQS_Mastermind;

import java.util.Random;

import models.MasterMind;
import models.Player;

public class MockTestGame {
	MockRandomNumbers mRandom;
	MockReadParameters mRead;
	
	MockTestGame(){
		mRandom=new MockRandomNumbers();
		mRead=new MockReadParameters();
		
		mRead.colors = "";
		mRandom.array = new int[5];
	}
	public boolean Game(MasterMind m, Player p1, Player p2) {
		boolean find= false;
		Random r= new Random();
		while(!find && m.numPlays>=0) {
			if(m.numPlays==12 && m.turn==0) {
				m.code[0]=1;
				m.code[1]=0;
				m.code[2]=4;
				m.code[3]=5;
				m.code[4]=3;
			}
			else {
				if(m.turn==1) {
					mRead.colors= ""+r.nextInt(6)+" "+r.nextInt(6)+" "+r.nextInt(6)+" "+r.nextInt(6)+" "+r.nextInt(6)+"";
					
					mRead.read_parameters(p2, m);
				}
				
			}
			boolean play=m.Play(p1, p2);
			if(m.turn==1 && play && m.numPlays!=12 ) {
				find=true;
			}
			if(m.turn==1 && m.numPlays==0 && !play) {
				find= true;
			}
			
		}
		
		
		return find;
	}
}

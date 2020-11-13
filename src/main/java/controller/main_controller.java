package controller;


import java.io.IOException;

import models.MasterMind;
import models.Player;

public class main_controller {
	MasterMind m;
	Player p1;
	Player p2;
	
	public void controller() throws IOException {
		boolean find= false;
		m = new MasterMind();
		p1 = new Player(0);
		p2 = new Player(1);
		
		while(!find && m.numPlays>=0) {
			if(m.numPlays==12 && m.turn==0) {
				m.generate_code();
			}
			else {
				if(m.turn==1) {
					System.out.println("ESCRIU");
					m.read_parameters(p2);
				}
				
			}
			boolean play=m.Play(p1, p2);
			if(m.turn==1 && play && m.numPlays!=12 ) {
				find=true;
			}
			if(m.turn==1 && m.numPlays==0 && !play) {
				find=true;
			}
			
		}
	}
}
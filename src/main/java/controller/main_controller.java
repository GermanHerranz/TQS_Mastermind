package controller;


import java.io.IOException;

import models.MasterMind;
import models.Player;
import view.view;

public class main_controller {
	MasterMind m;
	Player p1;
	Player p2;
	view v;
	public void controller() throws IOException {
		boolean find= false;
		m = new MasterMind();
		p1 = new Player(0);
		p2 = new Player(1);
		v =new view();
		
		while(!find && m.numPlays>=0) {
			boolean play;
			if(m.numPlays==12 && m.turn==0) {
				m.generate_code();
			}
			else {
				if(m.turn==1) {
					
					v.print_message_insert();
					m.read_parameters(p2);
				}
				
			}
			play=m.Play(p1, p2);
			
			if(m.wrong_numbers) {
				v.print_message_wrong_combination();
				m.wrong_numbers=false;
			}
			else if(m.wrong_size){
				v.print_message_wrong_size();
				m.wrong_size=false;
			}
			
			if(m.turn==1 && play && m.numPlays!=12 ) {
				find=true;
			}
			if(m.turn==1 && m.numPlays==0 && !play) {
				find=true;
			}
			
		}
	}
}
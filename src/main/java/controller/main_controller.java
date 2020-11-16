package controller;


import java.io.IOException;

import main.main;
import models.MasterMind;
import models.Player;
import view.view;

public class main_controller {
	MasterMind m;
	Player p1;
	Player p2;
	view v;
	
	public void controller() throws IOException {
		boolean find = false;
		m = new MasterMind();
		p1 = new Player(0);
		p2 = new Player(1);
		v = new view();
		v.print_info();
		
		while(!find) { //while there's plays left and the player 2 hasn't win
			boolean play;
			
			if(m.numPlays==12 && m.turn==0) { //generation of the player 1 code, if it is player 1 turn and its first play
				m.generate_code();
			}
			else {
				if(m.turn==1) { //read inputs if it's player 2 turn
					v.print_message_insert();
					m.read_parameters(p2);
				}
			}
			
			play = m.Play(p1, p2);
			
			if(m.wrong_numbers) { //print message of error if the input values were wrong
				v.print_message_wrong_combination();
				m.wrong_numbers=false; //set the value to false
			}
			else if(m.wrong_size){ //print message of error if the input size was wrong
				v.print_message_wrong_size();
				m.wrong_size=false; //set the value to false
			}
			else {
				if(m.turn==1 && m.numPlays!=12) { //prints the board
					v.show_board(p1, p2, m);
				}
			}
			
			if(m.turn==1 && play && m.numPlays!=12 ) { //the player 2 wins
				find=true;
				v.print_win();
			}
			
			else if(m.turn==1 && m.numPlays==0 && !play) { //the player 2 loses
				find=true;
				v.print_lost();
			}
		}
	}
	
}
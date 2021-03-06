package TQS_Mastermind;


import java.io.IOException;

import TQS_Mastermind.mockCode1;
import TQS_Mastermind.mockCode2;
import TQS_Mastermind.mockCode3;
import TQS_Mastermind.mockCode4;
import TQS_Mastermind.mockKeyboard;
import main.main;
import models.InterfaceCode;
import models.MasterMind;
import models.Player;
import models.interfaceKeyboard;
import view.view;

public class mockMainController3 {
	InterfaceCode m;
	Player p1;
	Player p2; 
	view v;
	interfaceKeyboard k = new mockKeyboard();
	
	public mockMainController3() { 
		k.addValue("0 0 0 0 0"); // Entradas del keyboard
		k.addValue("1 2 3 4 5");
		k.addValue("2 2 5 3 2");
		k.addValue("0 0 0 0 0"); // Entradas del keyboard
		k.addValue("1 2 3 4 5");
		k.addValue("2 2 5 3 2");
		k.addValue("0 0 0 0 0"); // Entradas del keyboard
		k.addValue("1 2 3 4 5");
		k.addValue("2 2 5 3 2");
		k.addValue("5 4 3 2 1");
		k.addValue("5 4 3 2 1");
		k.addValue("2 2 5 3 3");
		
		
	}
	
		public void controller() throws IOException {
		boolean find = false;
		m = new mockCode3(); // Cambiar mock para diferentes partidas
		p1 = new Player(0);
		p2 = new Player(1);
		v = new view();
		v.print_info();
		
		while(!find) { //while there's plays left and the player 2 hasn't win
			boolean play;
			
			if(m.getNumPlays()==12 && m.getTurn()==0) { //generation of the player 1 code, if it is player 1 turn and its first play
				m.generate_code();
			}
			else {
				if(m.getTurn()==1) { //read inputs if it's player 2 turn
					v.print_message_insert();
					m.read_parameters(p2, k);
				}
			}
			
			play = m.Play(p1, p2);
			
			if(m.getWrongNumbers()) { //print message of error if the input values were wrong
				v.print_message_wrong_combination();
				m.setWrongNumbers(false); //set the value to false
			}
			else if(m.getWrongSize()){ //print message of error if the input size was wrong
				v.print_message_wrong_size();
				m.setWrongSize(false); //set the value to false
			}
			else {
				if(m.getTurn()==1 && m.getNumPlays()!=12) { //prints the board
					v.show_board(p1, p2, m);
				}
			}
			
			if(m.getTurn()==1 && play && m.getNumPlays()!=12 ) { //the player 2 wins and game finishes
				find=true; //game finishes
				v.print_win();
			}
			
			else if(m.getTurn()==1 && m.getNumPlays()==0 && !play) { //the player 2 loses and game finishes
				find=true; //game finishes
				v.print_lost();
			}
		}
	}
	
}
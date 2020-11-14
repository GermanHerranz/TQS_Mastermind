package view;

import models.MasterMind;
import models.Player;

public class view {
	String board= "--------------------------------------------";
	
	public void show_board(Player p1, Player p2, MasterMind m) {
		System.out.println(board);
		for(int i=0; i<=m.num; i++) {
			int p1_play[]=p1.get_saved_play(i);
			int p2_play[]=p2.get_saved_play(i);
			for(int j=0; j<p2_play.length; j++) {
				System.out.print(p2_play[j]);
				
			}
			System.out.print(" -> ");
			for(int j=0; j<p1_play.length; j++) {
				System.out.print(p1_play[j]);
				
			}
			System.out.println(" ");
			
		}
		System.out.println(board);
		
	}
	public void print_message_insert() {
		System.out.println("Write below the code separated by spaces: ");
	}
	public void print_message_wrong_size() {
		System.out.println("The size was wrong, write 5 numbers. ");
	}
	public void print_message_wrong_combination(){
		System.out.println("The numbers were wrong, write numbers between 0 and 5.  ");
	}
	
	public void print_win() {
		System.out.println("You win! :D");
	}
	
	public void print_lost() {
		System.out.println("You lost :( ");
	}
	
	public void print_info() {
		System.out.println("Hi! Welcome to MasterMind.");
		System.out.println("Legend->");
		System.out.println("	2 -> you guess the position and the number!");
		System.out.println("	1 -> you guess the number but not the position");
		System.out.println("	0 -> you didn't guess anything... F");
	}
}

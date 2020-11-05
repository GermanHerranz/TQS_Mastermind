package TQS_Mastermind;

import java.util.Arrays;
import java.util.Scanner;

public class MasterMind {
	static String colors []= {"red","blue","green","yellow","orange","purple"};
	static String user_color[]= {"0","0","0","0","0"};
	
	static int turn=0;
	static int numPlays;
	MasterMind(){
		
		numPlays=12;
	}
	static void read_parameters(Player player){
		Scanner in = new Scanner(System.in);
		String color;
		for(int i=0; i<5; i++) {
			
			color = in.nextLine();
			
			player.set_usercolorPosition (i, color); 
		}
		
		in.close();
		
	}
	
	static boolean Player1(Player p) {
		boolean find=false;
		int i=0;
		
		if(numPlays==12) {
			if(p.user_color.length == 5) {
				while(!find && i<5) {
					find=!(check_parameters(p.get_usercolorPosition(i))); //if the color is correct return true
					i=i+1;
				}
				if(!find) {
					turn(turn);
				}
				else {
					System.out.println("Player1: Upps the sequence was wrong! Enter a new one with the accepted colors: red, blue, orange, green, yellow or purple");
				}
			}
			else {
				System.out.println("Player1: Upps!! Enter 5 colors please!!");
			}
		}
		
		return find;
	}
	
	static boolean Player2(Player p) {
		boolean find=false;
		int i=0;
		if(p.user_color.length == 5) {
			while(!find && i<5) {
				find=!check_parameters(p.get_usercolorPosition(i));
				i=i+1;
			}
			if(!find) {
				turn(turn);
				numPlays();
			}
			else {
				System.out.println("Player2: Upps the sequence was wrong! Enter a new one with the accepted colors: red, blue, orange, green, yellow or purple");
			}
			
		}
		
		else {
			System.out.println("Player2: Upps!! Enter 5 colors please!!");
		}
		
		return find;
	}
	
	static boolean Play(Player p1, Player p2) {
		boolean find=false; //check if the turn has been completly succesfull
		if(turn==0) {
			find=Player1(p1);
		}
		else if(turn==1) {
			find=Player2(p2);
		}
		return find;
		
	}
	static int turn(int t) {
		if(t==0) {
			turn=1;
		}
		else if(t==1){
			turn=0;
		}
		return turn;
	}
	
	static int numPlays() {
		numPlays=numPlays-1;
		return numPlays;
	}
	
	static boolean check_parameters(String color) {
		
		boolean find=false;

		if(Arrays.asList(colors).contains(color)) {
			find=true;
		}
		return find;
	}

	public static void main(String[] args) {
		
		//read_parameters();
		//Play(player1,player2);
		
	  }
}

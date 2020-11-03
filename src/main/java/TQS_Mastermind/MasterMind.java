package TQS_Mastermind;

import java.util.Arrays;
import java.util.Scanner;

public class MasterMind {
	static String colors []= {"red","blue","green","yellow","orange","purple"};
	static String user_color[]= {"0","0","0","0","0"};
	static Player player1;
	static Player player2;
	static int turn=0;
	static int numPlays;
	MasterMind(){
		player1= new Player(0);
		player2=new Player(1);
		numPlays=12;
	}
	static void read_parameters(){
		Scanner in = new Scanner(System.in);
		String color;
		for(int i=0; i<5; i++) {
			
			color = in.nextLine();
			
			player1.set_usercolorPosition (i, color); 
		}
		
		in.close();
		
	}
	
	static boolean Player1(Player p) {
		return true;
	}
	
	static boolean Play(Player p1, Player p2) {
		boolean find=true;
		int i=0;
		if(turn==0) {
			if(numPlays==12) {
				if(p1.user_color.length == 5) {
					while(find && i<5) {
						find=check_parameters(p1.get_usercolorPosition(i));
						i=i+1;
					}
					if(find) {
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
		}
		else if(turn==1) {
			if(p2.user_color.length == 5) {
				while(find && i<5) {
					find=check_parameters(p2.get_usercolorPosition(i));
					i=i+1;
				}
				if(find) {
					turn(turn);
				}
				else {
					System.out.println("Player2: Upps the sequence was wrong! Enter a new one with the accepted colors: red, blue, orange, green, yellow or purple");
				}
				
			}
			
			else {
				System.out.println("Player2: Upps!! Enter 5 colors please!!");
			}
			
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
		read_parameters();
		Play(player1,player2);
		
	  }
}

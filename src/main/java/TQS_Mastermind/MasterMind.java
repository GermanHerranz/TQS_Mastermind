package TQS_Mastermind;

import java.util.Arrays;
import java.util.Scanner;

public class MasterMind {
	static String colors []= {"red","blue","green","yellow","orange","purple"};
	static String user_color[]= {"0","0","0","0","0"};
	static Player player1= new Player(0);
	static Player player2=new Player(1);
	static int turn=0;
	static int numPlays=12;
	
	static void read_parameters(){
		Scanner in = new Scanner(System.in);
		String color;
		for(int i=0; i<5; i++) {
			
			color = in.nextLine();
			
			player1.set_usercolorPosition (i, color); 
		}
		
		in.close();
		
	}
	
	static boolean Play(Player p1, Player p2) {
		boolean find=true;
		int i=0;
		if(p1.user_color.length == 5) {
			while(find && i<5) {
				find=check_parameters(p1.get_usercolorPosition(i));
				i=i+1;
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
		turn(0);
	  }
}

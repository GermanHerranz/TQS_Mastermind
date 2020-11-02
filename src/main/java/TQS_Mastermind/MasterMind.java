package TQS_Mastermind;

import java.util.Arrays;
import java.util.Scanner;

public class MasterMind {
	static String colors []= {"red","blue","green","yellow","orange","purple"};
	static String user_color[]= {"0","0","0","0","0"};
	static Player p1= new Player(0);
	static Player p2=new Player(1);
	
	static void read_parameters(){
		Scanner in = new Scanner(System.in);
		String color;
		for(int i=0; i<5; i++) {
			
			color = in.nextLine();
			
			p1.set_usercolorPosition (i, color); 
		}
		
		in.close();
		
	}
	
	static void Play() {
		
		
	}
	static int turn(int id) {
		return 0;
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

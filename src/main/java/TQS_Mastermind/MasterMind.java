package TQS_Mastermind;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MasterMind {
    String colors []= {"red","blue","green","yellow","orange","purple"};
    String user_color[]= {"0","0","0","0","0"};
	
	int turn=0;
	int numPlays;
	MasterMind(){
		
		numPlays=12;
	}
	void read_parameters(Player player){
		Scanner in = new Scanner(System.in);
		String color;
		for(int i=0; i<5; i++) {
			
			color = in.nextLine();
			
			player.set_usercolorPosition (i, color); 
		}
		
		in.close();
		
	}
	int[] generate_code() {
		int code[]= new int[6];;
		for(int i=0; i<6; i++) {
			Random r= new Random();
			code[i]=r.nextInt(6);
		}
		return code;
	}
	boolean Player1(Player p) {
		boolean find=false;
		int i=0;
		
		if(numPlays==12) {
			if(p.user_color.length == 5) {
				while(!find && i<5) {
					//find=!(check_parameters(p.get_usercolorPosition(i))); //if the color is correct return true
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
		else {
			
		}
			
		
		return find;
	}
	
	boolean Player2(Player p) {
		boolean find=false;
		int i=0;
		if(p.user_color.length == 5) {
			while(!find && i<5) {
				//find=!check_parameters(p.get_usercolorPosition(i));
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
	
	boolean Play(Player p1, Player p2) {
		boolean find=false; //check if the turn has been completly succesfull
		if(turn==0) {
			find=Player1(p1);
		}
		else if(turn==1) {
			find=Player2(p2);
		}
		return find;
		
	}
	int turn(int t) {
		if(t==0) {
			turn=1;
		}
		else if(t==1){
			turn=0;
		}
		return turn;
	}
	
	int numPlays() {
		numPlays=numPlays-1;
		return numPlays;
	}
	
	boolean check_parameters(int color) {
		
		boolean find=false;

		if(color <=5 && color>=0) {
			find=true;
		}
		return find;
	}

}

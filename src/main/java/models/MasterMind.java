package models;

import java.util.*;

import com.google.common.primitives.Ints;



public class MasterMind {
    int colors []= {0, 1, 2, 3, 4, 5};
	public int turn=0;
	public int numPlays;
	public int comparison[]= {};
	public int code[];
	
	
	public MasterMind(){
		numPlays=12;
		code = new int[5];
		
		comparison = new int[5];
		comparison[0] = 0;
		comparison[1] = 0;
		comparison[2] = 0;
		comparison[3] = 0;
		comparison[4] = 0;
	}
	public void read_parameters(Player player){
		Scanner in = new Scanner(System.in);
		int color;
		for(int i=0; i<5; i++) {
			
			color = in.nextInt();
			
			player.set_userColorPosition (i, color); 
		}
		
		in.close();
		
	}
	public int[] generate_code() {
		for(int i=0; i<5; i++) {
			Random r= new Random();
			code[i]=r.nextInt(6);
		}
		return code;
	}
	public boolean Player1(Player p, Player p2) {
		boolean find=true;
		int i=0;
		
		if(numPlays==12) {
			while(find && i<5) {
				find=(check_parameters(code[i])); //if the color is correct return true
				i=i+1;
			}
			if(find) {
				turn(turn);
			}
		}
		else {
			find=check_positions(p2); //return false if the player2 didn't win
			
			turn(turn);
			p.Save_Play(p.user_color, numPlays+1);
		}
			
		
		return find;
	}
	
	public boolean Player2(Player p) {
		boolean find=true;
		int i=0;
		while(find && i<5) {
			find=check_parameters(p.get_userColorPosition(i));
			i=i+1;
		}
		if(find) {
			turn(turn);
			numPlays();
		}
		else {
			System.out.println("Player2: Upps the sequence was wrong! Enter a new one with the accepted colors: red, blue, orange, green, yellow or purple");
			//read_parameters(p);
			//Player2(p);
		}
	
		
		return find;
	}
	
	public boolean Play(Player p1, Player p2) {
		boolean find=false; //check if the turn has been completly succesfull
		if(numPlays>0) {
			if(turn==0) {
				find=Player1(p1, p2);
			}
			else if(turn==1) {
				find=Player2(p2);
			}
		}
		else {
			if(turn==0) {
				find=Player1(p1, p2);
				
			}
		}
		return find;
		 
	}
	public int turn(int t) {
		if(t==0) {
			turn=1;
		}
		else if(t==1){
			turn=0;
		}
		return turn;
	}
	
	public int numPlays() {
		numPlays=numPlays-1;
		return numPlays;
	}
	
	public boolean check_parameters(int color) {
		
		boolean find=false;

		if(color <=5 && color>=0) {
			find=true;
		}
		return find;
	}
	
	public boolean check_positions(Player p2) {
		boolean same=true;
        int length = code.length;
        int i=0;
        while (i<length) {
			if (code[i] == p2.user_color[i]) {
            	comparison[i]=1;
            }
            else {
            	same=false;
            	if(Ints.contains(code, p2.user_color[i])) {
                	comparison[i]=0;
            	}
            	else {
                	comparison[i]=-1;
            	}
            }
            i++;
        }
        
        return same;
	}
}

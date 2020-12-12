package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import com.google.common.primitives.Ints;



public class MasterMind implements InterfaceCode{
    int colors []= {0, 1, 2, 3, 4, 5}; //set the possible colors
	public int turn=0; //in the first play the turn if for player1
	public int numPlays; //this variable has the number of plays that are left
	public int comparison[]= {}; //this array contains the comparison between player1 code and player2 play
	public int code[]; //we save here the code generated by player1
	
	public boolean wrong_numbers =false; //if the data input was not accepted then wrong_numbers=true
	public boolean wrong_size= false; //if the length of data input was not accepted then wrong_sixe=true
	public int num; 
	
	
	public MasterMind(){ //constructor
		numPlays=12; //maxPlays =12
		code = new int[5];
		
		comparison = new int[5];
		comparison[0] = 0;
		comparison[1] = 0;
		comparison[2] = 0;
		comparison[3] = 0;
		comparison[4] = 0;
	}
	
	public int getNum() {return this.num;}
	
	public void read_parameters(Player player, interfaceKeyboard k) throws IOException { //read the data input written by player2
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s_color = br.readLine(); //we read only one line
		String[] a_scolor = s_color.split(" "); 
		String regex="[0-9]+";
		int color[]=new int[a_scolor.length];
		player.user_color=new int[a_scolor.length];  //set user_color length
		for(int i =0 ;i < a_scolor.length;i++){ //for every character written
			if(a_scolor[i].matches(regex) ) { //if the number is accepted
			    color[i]= Integer.parseInt(a_scolor[i]);
			    player.set_userColorPosition (i, color[i]);
			}
			else {
				player.set_userColorPosition (i, 8); //save an incorrect value
				wrong_numbers=true; //if data input is not accepted
			}
		}
		
	}

	public int[] generate_code() { //generate the random code for player1
		for(int i=0; i<5; i++) {
			Random r= new Random();
			code[i]=i; 
		}
		return code;
	}
	public boolean Player1(Player p, Player p2) {
		boolean find=true;
		
		if(numPlays==12) { //when it is the first play
			turn(turn); //change turn
		}
		else {
			find=check_positions(p2); //return false if the player2 didn't win
			
			turn(turn);
			p.Save_Play(comparison, num); //save the comparison array
		}
			
		
		return find;
	}
	
	public boolean Player2(Player p) {
		boolean find=true;
		int i=0;
		if (p.user_color.length == 5) { //if the length of the data written by player 2 is correct
			while(find && i<5) {
				find=check_parameters(p.get_userColorPosition(i));
				i=i+1;
			}
			if(find) { //if all the values were correct, in the range of 0-5
				turn(turn);
				num=12-numPlays; //calculate the number of play
				numPlays(); 
				p.Save_Play(p.user_color, num); //save the play
			}
			else {
				wrong_numbers=true; //if some value was not in the range 0-5
			}
		}
		else {
			wrong_size=true; //if the size of the data input was wrong
			find=false;
		}
		
	
		return find;
	}
	
	public boolean Play(Player p1, Player p2) {
		boolean find=false; //check if the turn has been completly succesfull
		if(numPlays>0 && numPlays<13) { //if numPlays are in the range
			if(turn==0) {
				find=Player1(p1, p2); 
			}
			else if(turn==1) {
				find=Player2(p2);
			}
		}
		else {
			if(turn==0 && numPlays==0) { //if it is the last play
				find=Player1(p1, p2);
				
			}
		}
		return find;
		 
	}
	public int turn(int t) { //change turn
		if(t==0) {
			turn=1;
		}
		else if(t==1){
			turn=0;
		}
		return turn;
	}
	
	public int numPlays() { //subtract numPlays
		numPlays=numPlays-1;
		return numPlays;
	}
	
	public boolean check_parameters(int color) { //check if the numbers written by player2 are in the range 0-5
		
		boolean find=false;

		if(color <=5 && color>=0) {
			find=true; //if they are in the range return true
		}
		return find;
	}
	
	public boolean check_positions(Player p2) { //check if player2 guessed the code
		boolean same=true;
        int length = code.length; 
        int i=0;
        while (i<length) {
			if (code[i] == p2.user_color[i]) { //check if the position and number are correct
            	comparison[i]=2;
            }
            else {
            	same=false; //player2 didn't guessed
            	if(Ints.contains(code, p2.user_color[i])) { //check if the number is on the code
                	comparison[i]=1;
            	}
            	else {
                	comparison[i]=0; //the number is not in the code
            	}
            }
            i++;
        }
        
        return same; //if player2 guessed the code then same is true
	}
	

	@Override
	public int[] getColors() {
		return this.colors;
	}

	@Override
	public int getTurn() {
		return this.turn;
	}

	@Override
	public int getNumPlays() {
		return this.numPlays;
	}

	@Override
	public int[] getComparison() {
		return this.comparison;
	}

	@Override
	public int[] getCode() {
		return this.code;
	}

	@Override
	public boolean getWrongNumbers() {
		return this.wrong_numbers;
	}

	@Override
	public boolean getWrongSize() {
		return this.wrong_size;
	}

	@Override
	public void setWrongNumbers(boolean b) {
		this.wrong_numbers = b;
	}

	@Override
	public void setWrongSize(boolean b) {
		this.wrong_size = b;
		
	}
}

package models;


public class Player {
	public int id_player;
	public int user_color[]= {};
	Play save_play[]= {};
	
	
	public Player(int id) { //constructor 
		id_player = id;
		
		save_play = new Play[12];  //sets the number of save_play to 12 'cause numPlays=12
		for(int i=0; i<12; i++) {
        	save_play[i] = new Play(); //initialize the positions of save_play
        }
		
	}
	
	public int get_userColorPosition (int position) {
		if (position >= 0 && position < user_color.length) //checks if the position is correct
			return user_color[position];  //return the number saved in that position
		else
			return -1;   //returns -1 if the position was incorrect
	}
	
	public void set_userColorPosition (int position, int color) {
		if (position >= 0 && position < user_color.length) //checks if the position is correct
			user_color[position] = color;
	}
	
	public boolean Save_Play(int[] array, int pos) {
    	boolean saved=false;
    	if(pos<12 && pos>=0) { //checks if the position is correct, the max numPlays is 12 and the min numPlays is 0
    		save_play[pos].set_play(array); //save the play in the position
    		saved=true; //return true, so the position was saved
    	}
    	return saved; 
    }
    
    public int[] get_saved_play(int pos) {
    	if(pos<12 && pos>=0) { //checks if the position is correct, the max numPlays is 12 and the min numPlays is 0
    		return save_play[pos].get_play(); //returns the play saved in that position
    	}
    	int array[]= {}; //if the position was incorrect, set an empty array
    	return array; //return the empty array so the position was incorrect
    }
	
}

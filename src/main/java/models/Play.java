package models;

public class Play {
	
	int play []= {};
	
    
	public Play() { //constructor
        play = new int[5];  //set the number of position to 5, cause there are 5 numbers in every play
        
        play[0] = 0; //initialize to 0 the positions
        play[1] = 0;
        play[2] = 0;
        play[3] = 0;
        play[4] = 0;
        
        
    }
    
    public void set_play(int[] array) { //save a play
        for (int i=0; i<play.length; i++)
            play[i]=array[i];
    }
    
    public int[] get_play() {  //returns a play
        return play;
    }
    
    
}

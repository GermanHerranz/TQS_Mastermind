package models;

public class Play {
	
	int play []= {};
	
    
	public Play() {
        play = new int[5];
        
        play[0] = 0;
        play[1] = 0;
        play[2] = 0;
        play[3] = 0;
        play[4] = 0;
        
        
    }
    
    public void set_play(int[] array) {
        for (int i=0; i<play.length; i++)
            play[i]=array[i];
    }
    
    public int[] get_play() {
        return play;
    }
    
    
}

package models;


public class Player {
	public int id_player;
	public int user_color[]= {};
	Play save_play[]= {};
	
	
	public Player(int id) {
		id_player = id;
		
		save_play = new Play[12];
		for(int i=0; i<12; i++) {
        	save_play[i] = new Play();
        }
		
	}
	
	public int get_userColorPosition (int position) {
		if (position >= 0 && position < user_color.length)
			return user_color[position];
		else
			return -1;
	}
	
	public void set_userColorPosition (int position, int color) {
		if (position >= 0 && position < user_color.length)
			user_color[position] = color;
	}
	
	public boolean Save_Play(int[] array, int pos) {
    	boolean saved=false;
    	if(pos<12 && pos>=0) {
    		save_play[pos].set_play(array);
    		saved=true;
    	}
    	return saved;
    }
    
    public int[] get_saved_play(int pos) {
    	if(pos<12 && pos>=0) {
    		return save_play[pos].get_play();
    	}
    	int array[]= {};
    	return array;
    }
	
}

package TQS_Mastermind;


public class Player {
	int id_player;
	int user_color[]= {};
	Play save_play[]= {};
	
	
	public Player(int id) {
		id_player = id;

		user_color = new int[5];
		user_color[0] = 0;
		user_color[1] = 0;
		user_color[2] = 0;
		user_color[3] = 0;
		user_color[4] = 0;
		
		save_play = new Play[12];
		for(int i=0; i<12; i++) {
        	save_play[i] = new Play();
        }
		
	}
	
	public int get_userColorPosition (int position) {
		if (position >= 0 && position < user_color.length && (id_player==0 || id_player==1))
			return user_color[position];
		else
			return -1;
	}
	
	public void set_userColorPosition (int position, int color) {
		if ((id_player == 0 || id_player==1) && position >= 0 && position < user_color.length)
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

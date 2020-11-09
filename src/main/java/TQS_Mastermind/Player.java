package TQS_Mastermind;


public class Player {
	int id_player;
	int user_color[]= {};
	Play save_play[]= {};
	
	
	Player(int id) {
		id_player = id;

		user_color = new int[5];
		user_color[0] = 0;
		user_color[1] = 0;
		user_color[2] = 0;
		user_color[3] = 0;
		user_color[4] = 0;
		
		for(int i=0; i<12; i++) {
        	save_play[i] = new Play();
        }
		
	}
	
	int get_userColorPosition (int position) {
		if (position >= 0 && position < user_color.length && (id_player==0 || id_player==1))
			return user_color[position];
		else
			return -1;
	}
	
	void set_userColorPosition (int position, int color) {
		if ((id_player == 0 || id_player==1) && position >= 0 && position < user_color.length)
			user_color[position] = color;
	}
	
	void Save_Play(int[] array, int pos) {
    	
    	save_play[pos].set_play(array);
    }
    
    int[] get_saved_play(int pos) {
    	return save_play[pos].get_play(); 
    }
	
}

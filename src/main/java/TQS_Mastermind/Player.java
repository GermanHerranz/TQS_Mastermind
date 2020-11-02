package TQS_Mastermind;


public class Player {
	int id_player;
	String user_color[]= {};
	
	Player(int id) {
		id_player = id;
		

		user_color = new String[5];
		user_color[0] = "0";
		user_color[1] = "0";
		user_color[2] = "0";
		user_color[3] = "0";
		user_color[4] = "0";
		
	}
	
	String get_usercolorPosition (int position) {
		if (position >= 0 && position < user_color.length && (id_player==0 || id_player==1))
			return user_color[position];
		else
			return "-1";
	}
	
	void set_usercolorPosition (int position, String color) {
		if ((id_player == 0 || id_player==1) && position >= 0 && position < user_color.length)
			user_color[position] = color;
	}
}

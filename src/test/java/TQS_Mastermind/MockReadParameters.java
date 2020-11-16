package TQS_Mastermind;



import models.MasterMind;
import models.Player;

public class MockReadParameters {
	public String colors;
	public int color[];
	
	public void read_parameters(Player player, MasterMind m){
		String regex = "[0-9]+";
		String[] a_scolor = colors.split(" ");
		
		color = new int[a_scolor.length];
		player.user_color = new int [a_scolor.length];
		
		for(int i=0; i<a_scolor.length; i++) {
			if(a_scolor[i].matches(regex)) { //if the value is a positive number
				color[i] = Integer.parseInt(a_scolor[i]); //conversion of the value from string to int
				player.set_userColorPosition(i, color[i]); //save the value
			}
			else { //if the value is not a number or it's a negative number
				player.set_userColorPosition(i, 8); //save an incorrect value
				m.wrong_numbers=true;
			}
		}		
	}

}



	
	    
	
	

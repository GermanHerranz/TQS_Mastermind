package TQS_Mastermind;



import models.MasterMind;
import models.Player;

public class MockReadParameters {
	
	public String colors;
	public int color[];
	public void read_parameters(Player player, MasterMind m){
		String regex="[0-9]+";
		String[] a_scolor = colors.split(" ");
		color=new int[a_scolor.length];
		player.user_color = new int [a_scolor.length];
		for(int i=0; i<a_scolor.length; i++) {
			if(a_scolor[i].matches(regex) ) {
				color[i]= Integer.parseInt(a_scolor[i]);
				player.set_userColorPosition (i, color[i]);
			}
			else {
				m.wrong_numbers=true;
			}
			
		}		
	}
	

}



	
	    
	
	

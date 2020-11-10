package TQS_Mastermind;

public class MockReadParameters {
	
	public int colors[];
	
	public void read_parameters(Player player){
	
		for(int i=0; i<5; i++) {
			player.set_userColorPosition (i, colors[i]);
			
		}		
	}
	

}

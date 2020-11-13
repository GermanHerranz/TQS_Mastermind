package TQS_Mastermind;

public class MockRandomNumbers {
	
	public int array[] = new int[5];
	
	boolean random_numbers(Player player, MasterMind md) {
		boolean find=false;
		
		if (player.id_player == 0 && md.numPlays==12)
		{
			for(int i=0; i<5; i++) {
				md.code[i] = array[i];
				find = true;
			}	
		}
		return find;
	}
}

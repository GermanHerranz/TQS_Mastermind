package TQS_Mastermind;

import java.util.Arrays;
import java.util.Scanner;

public class MasterMind {
	static String colors []= {"red","blue","green","yellow","orange","purple"};
	static String user_color[]= {"0","0","0","0","0"};
	
	static void read_parameters(){
		Scanner in = new Scanner(System.in);
		String color;
		boolean find=false;
		int j=0;
		for(int i=0; i<5; i++) {
			
			color = in.nextLine();
			user_color[i] =color; 
		}
		
		in.close();
		while(j<5 &&  !find) {
		  
		  find=check_parameters(user_color[j]);
		  
		  j++;
		}
	}
	
	static boolean check_parameters(String color) {
		
		boolean find=false;

		if(Arrays.asList(colors).contains(color)) {
			find=true;
		}
		return find;
	}

	public static void main(String[] args) {
		read_parameters();
	  }
}

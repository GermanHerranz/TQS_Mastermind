package TQS_Mastermind;

import java.util.ArrayList;
import java.util.Scanner;

import models.interfaceKeyboard;

public class mockKeyboard implements interfaceKeyboard{
	ArrayList<String> array = new ArrayList<String>(); //añado datos
	
	public String keyboardIn() {
		return array.remove(0);
	}
	
	public void addValue(String val) {
		array.add(val);
	}
	
	public String readLine() {
		return array.remove(0);
	}

	@Override
	public Scanner getIn() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

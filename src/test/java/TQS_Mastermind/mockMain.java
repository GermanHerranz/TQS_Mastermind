package TQS_Mastermind;

import java.io.IOException;

import controller.main_controller;

public class mockMain {
	public static void main(String[] args) throws IOException {
		// Each mockMainController represent a different game.
		mockMainController c = new mockMainController();
		//mockMainController2 c = new mockMainController2();
		//mockMainController3 c = new mockMainController3();
		//mockMainController4 c = new mockMainController4();
		c.controller(); //calls controller
	}
}

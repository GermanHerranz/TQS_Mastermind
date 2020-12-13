package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import com.google.common.primitives.Ints;

public interface InterfaceCode {
	public void read_parameters(Player player, interfaceKeyboard k) throws IOException;
	public int[] generate_code();
	public boolean Player1(Player p, Player p2);
	public boolean Player2(Player p);
	public boolean Play(Player p1, Player p2);
	public int turn(int t);
	public boolean check_parameters(int color);
	public boolean check_positions(Player p2);
	public int getNum();
	public int[] getColors();
	public int getTurn();
	public int getNumPlays();
	public int[] getComparison();
	public int[] getCode();
	public boolean getWrongNumbers();
	public boolean getWrongSize();
	
	public void setWrongNumbers(boolean b);
	public void setWrongSize(boolean b);
}

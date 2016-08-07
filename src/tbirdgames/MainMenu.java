package tbirdgames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Poker5CardStud start = new Poker5CardStud();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter your name: ");
		String name = null;
		try {
			name = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		start.game(name.isEmpty() ? "PLAYER" : name, 3);
	}

}

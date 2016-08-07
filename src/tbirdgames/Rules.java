//By James Fadeley.
package tbirdgames;

public interface Rules {
	
	public void game(String name, int numBots);
	public void scoring(Player player);
	public void winner(Player[] players);
	public void results(Player player);

}

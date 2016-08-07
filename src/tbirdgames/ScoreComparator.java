//By James Fadeley.
package tbirdgames;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Player>{
	
	@Override 
	public int compare(Player o1, Player o2){
		if(o1.getHandScore() > o2.getHandScore()) return -1;
		else if (o1.getHandScore() < o2.getHandScore()) return 1;
		else if (o1.getHighestCard().getValue() > o2.getHighestCard().getValue()) return -1;
		else if (o1.getHighestCard().getValue() < o2.getHighestCard().getValue()) return 1;
		else if (o1.getHighestCard().getSuit() > o2.getHighestCard().getSuit()) return -1;
		return 1;		
	}

}

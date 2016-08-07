package tbirdgames;

import java.util.Comparator;

public class CardComparator implements Comparator<Card>{

	@Override
	public int compare(Card o1, Card o2) {
		// TODO Auto-generated method stub
		if(o1.getValue() > o2.getValue()) return -1;
		else if (o1.getValue() < o2.getValue()) return 1;
		else if(o1.getSuit() > o2.getSuit()) return -1;
		return 1;
	}

}

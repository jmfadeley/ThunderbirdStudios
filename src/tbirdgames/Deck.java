//By James Fadeley.
package tbirdgames;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {
	private LinkedList<Card> deck = new LinkedList<Card>();
	
	public void shuffle(){
		for(int i=0; i<4; i++){ //Creates the initial, unsorted deck.
			for(int j=0; j<13; j++){
				deck.add(new Card(j,i));
			}
		}
		Collections.shuffle(deck);
	}
	
	public Card[] deal(){
		Card[] hand = new Card[5];
		for (int i=0; i<5; i++)
			hand[i]=deck.pop();
		return hand;
	}
	
}

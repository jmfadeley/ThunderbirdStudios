//By James Fadeley.
package tbirdgames;

import java.util.HashMap;
import java.util.Map;

public class Card {//implements Comparable<Card> {

	static final Map<Integer, String> valueMap = createValueMap();
	static final Map<Integer, String> suitMap = createSuitMap();
	private int value;	
	private int suit;
	
	private static final Map<Integer, String> createValueMap(){
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "Two");
		map.put(1, "Three");
		map.put(2, "Four");
		map.put(3, "Five");
		map.put(4, "Six");
		map.put(5, "Seven");
		map.put(6, "Eight");
		map.put(7, "Nine");
		map.put(8, "Ten");
		map.put(9, "Jack");
		map.put(10, "Queen");
		map.put(11, "King");
		map.put(12, "Ace");
		return map;
	}
	
	private static final Map<Integer, String> createSuitMap(){
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0,"Clubs");
		map.put(1, "Diamonds");
		map.put(2, "Hearts");
		map.put(3, "Spades");
		return map;
	}
	
	public Card(int value, int Suit){
		this.value = value;
		this.suit = Suit;
	}
	
	public String cardName(){
		return valueMap.get(value) + " of " + suitMap.get(suit);
	}
	
	public int getValue(){
		return value;
	}
	
	public int getSuit(){
		return suit;
	}
	
}

package tbirdgames;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import tbirdgames.Deck;
import tbirdgames.Player;

public class Poker5CardStud implements Rules{

	static final Map<Integer, String> scoreMap = createScoreMap();
	static String[] playerNames = {"", "Martin", "Jeff", "Steve"};
	
	public void game(String name, int numBots){
		Deck deck = new Deck();
		deck.shuffle();
		Player[] players = new Player[numBots+1];
		playerNames[0] = name;
		System.out.println("The players are:");
		for(int i=0; i<=numBots;i++) {
			players[i] = new Player(playerNames[i]);
			players[i].setHand(deck.deal());
			scoring(players[i]);
			results(players[i]);
		}
		winner(players);
	}

	public void scoring(Player player){
		StringBuilder sb = new StringBuilder(player.getName());
		sb.append(" with... ");
		System.out.println(sb.toString());
		
		Arrays.sort(player.getHand(), new CardComparator());
		for(Card i : player.getHand()) System.out.println(i.cardName());
		boolean straightPossible = true;
		boolean flushPossible = true;
		int matches = 0;
		int matches2 = 0;
		
		for(int i=0; i<player.getHand().length-1; i++){
			if(straightPossible && player.getHand()[i].getValue()-1!=player.getHand()[i+1].getValue()) 
				straightPossible=false;
			if(!straightPossible && player.getHand()[i].getValue()==player.getHand()[i+1].getValue()) {
				matches++;
				if(matches == 1){
					if(matches2 == 0){
						player.setHighestCard(player.getHand()[i]);
					} else if(player.getHighestCard().getValue() < player.getHand()[i].getValue()){
						player.setHighestCard(player.getHand()[i]);
					}
				}
			} else if(matches>0) {
				matches2 = matches;
				matches = 0;
			}
			if(player.getHand()[i].getSuit()!=player.getHand()[i+1].getSuit())				
				flushPossible=false;
		}
		if(straightPossible){
			if(flushPossible && player.getHand()[0].getValue()==12){
				player.setHandScore(9, player.getHand()[0]);
				return;
			} else if(flushPossible){
				player.setHandScore(8, player.getHand()[0]);
				return;
			} else {
				player.setHandScore(4, player.getHand()[0]); 
				return;
			}
		}
		if(flushPossible){ //You don't return on a flush yet because you can still get a full house, which is better.
			player.setHandScore(5, player.getHand()[0]);
		}
		if(matches2>matches){
			int temp=matches2;
			matches2=matches;
			matches=temp;
		}
		if(matches==3){
			player.setHandScore(7);
			return;
		} else if(matches==2 && matches2==1){
			player.setHandScore(6); //Full house boys!
			return;
		} else if(flushPossible){ //You don't return on a flush yet because you can still get a full house, which is better.
			player.setHandScore(5, player.getHand()[0]);
			return;
		} else if(matches==1 && matches2==1){ //Two pair. 
			player.setHandScore(2);
		} else {
			switch(matches){
				case 2: player.setHandScore(3);
						break;
				case 1: player.setHandScore(1);
						break;
				case 0: player.setHandScore(0);
						player.setHighestCard(player.getHand()[0]);
						break;
			}
		}
	}

	public void results(Player player){
		StringBuilder sb = new StringBuilder();
		sb.append(player.getName());
		sb.append(" has ");
		sb.append(scoreMap.get(player.getHandScore()));
		if(player.getHandScore()!=0){
			sb.append(" High card of ");
		}
		sb.append(player.getHighestCard().cardName());
		sb.append(".\n");
		System.out.println(sb.toString());
	}
	
	public void winner(Player[] players){
		Arrays.sort(players, new ScoreComparator());
		System.out.println("The winner is: " + players[0].getName());	
	}
	
	private static final Map<Integer, String> createScoreMap(){
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "a high card of ");
		map.put(1, "a pair.");
		map.put(2, "two pair!");
		map.put(3, "three of a kind.");
		map.put(4, "a straight!");
		map.put(5, "a flush!");
		map.put(6, "a full house!");
		map.put(7, "four of a kind!");
		map.put(8, "straight flush!");
		map.put(9, "a royal flush!");
		return map;
	}
}

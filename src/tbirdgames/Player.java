package tbirdgames;

public class Player {

	private String name;
	private int handScore; //Determines value of hand.
	private Card[] hand;//	private ArrayList<Card> hand = new ArrayList<Card>();
	private Card highestCard;
	
	public Player(String name){
		this.name = (name != null && !name.isEmpty()) ? name : "Default";
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setHandScore(int handScore, Card highestCard){
		this.handScore = handScore;
		this.highestCard = highestCard;
	}
	
	public void setHandScore(int handScore){
		this.handScore = handScore;
	}
	
	public int getHandScore(){
		return handScore;
	}
	
	public void setHighestCard(Card highestCard){
		this.highestCard = highestCard;
	}
	
	public Card getHighestCard(){
		return highestCard;
	}
	
	public void setHand(Card[] hand){
		this.hand = hand;
	}
	
	public Card[] getHand(){
		return hand;
	}
	
	public void retireHand(){
		hand = null;
		highestCard = null;
	}
	
}

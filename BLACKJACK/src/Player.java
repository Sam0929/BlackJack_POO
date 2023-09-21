import java.util.ArrayList;


public class Player {
	
	private String name;
	ArrayList<Card> cards = new ArrayList<Card>();
	
	public Player(String name, DeckOfCards myDeck)
	{
		this.name = name;
		cards.add(myDeck.dealCard());
		cards.add(myDeck.dealCard());
	}
	
	public void addCard (DeckOfCards myDeck)
	{
		cards.add(myDeck.dealCard());
	}
	
	public void getCards()
	{
		System.out.println("\n\nCartas do " + this.getName());
		for(int i = 0; i<cards.size(); i++)
		{
			System.out.println(cards.get(i));
	}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}

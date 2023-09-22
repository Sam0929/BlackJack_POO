import java.util.ArrayList;


public class Player {
	
    /**
     * Class that represent a player in the game.
     */
	
	private String name;
	ArrayList<Card> cards = new ArrayList<Card>();
	
    /**
     * Constructor of the player.
     */
	public Player(String name, DeckOfCards myDeck)
	{
		this.name = name;
		cards.add(myDeck.dealCard());
		cards.add(myDeck.dealCard());
		this.hasAce();
	}
	
    /**
     * Deal a card of the deck and add into the hand of the player.
     */
	public void addCard (DeckOfCards myDeck)
	{
		cards.add(myDeck.dealCard());
		this.hasAce();
	}
	
    /**
     * Print the card that the player has in his hand.
     */
	public void getCards()
	{
		System.out.println("\n=========================================");
		System.out.println("Cartas do " + this.getName()+":\n");
		for(int i = 0; i<cards.size(); i++)
		{
			System.out.println(cards.get(i));
		}
	}
	
    /**
     * Return the name of the player.
     * 
     * @return Returns the name of the player
     */
	public String getName()
	{
		return name;
	}
	
    /**
     * Set the name of the player.
     */
	public void setName(String name)
	{
		this.name = name;
	}
	
    /**
     * Sum the values of the card in the hand of the player.
     *
     * @return Returns the sum of the cards.
     */
	public int getTotal()
    {  
        int total = 0;
        
        for (Card eachCard : this.cards)
        {
            total += eachCard.getValue();
            
        }
        
        return total;
    }
    
    /**
     * Checks whether card hand is bust or not.
     *
     * @return Returns true if the hand is bust.
     */
    public boolean isBust()
    {
        return (getTotal() > 21) ? true : false;
    }
    
    /**
     * Check to see if hand has Blackjack - that being equal to 21 and 
     * only two cards.
     * 
     * @return Returns true if the player has Blackjack.
     */
    public boolean hasBlackjack()
    {
        return (getTotal() == 21 && cards.size() == 2) ? true : false;
    }
    
    /**
     * Checks whether card hand is bust and if has an Ace, change the value to 1.
     */
    public void hasAce()
    {
        if(isBust())
        {
        	for (Card eachCard : this.cards)
        	{
        		if(eachCard.getValue() == 11 && isBust())
        		{
        			eachCard.setValueAce();
        		}
        	}
        }
    }
   
}

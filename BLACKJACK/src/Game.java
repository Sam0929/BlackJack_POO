import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to represent the game.
 */
public class Game {

	/**
	 * Attributes of the class Game.
	 */
	DeckOfCards Deck;
	private boolean stands = true;
	private int blackJackCount = 0;
	ArrayList<Player> Players;
	private Scanner s;
	
	/**
	 * Constructor of the class Game.
	 * @param numPlayers Number of players.
	 * @param s Scanner.
	 */
	public Game(int numPlayers, Scanner s) {
		Deck = new DeckOfCards();
		Players = new ArrayList <Player>();
	  	Deck.shuffle();
	  	this.s = s;
        
        for (int i = 0; i < numPlayers; i++) 
        {
        	System.out.print("Digite o nome do jogador:");
  	      	String name = s.nextLine();
            Player player = new Player (name, Deck);
            Players.add(player);
            if(player.hasBlackjack())
  	      {
  	    	  System.out.println("Parabéns, " + player.getName() + ", você fez um BlackJack!");
  	    	  player.getCards();
  	    	  System.out.println("Soma das cartas: " + player.getTotal());
  	    	  blackJackCount ++;
  	      }
        }
    }

	/**
	 * Method to start the game.
	 */
	public void startGame() 
	{
		Deck.shuffle();

		if (blackJackCount == 0)
		{
			for (Player player : Players)
			{
				stands = true;
				  while (stands)
		    	  {
			    	  player.getCards();
			    	  System.out.println("\nSoma das cartas: " + player.getTotal());
			    	  
			    	  if(player.isBust())
		    		  {
		    			  System.out.println("Você estorou!");
		    			  sleep(4000);
		    			  stands = false;
					  }else
		    		  {
						System.out.println("\n1 - Hit" + "		2 - Pass");
		
				    	if(s.nextInt() == 2)
				    	{ 
				    	  stands = false;
				    	}else
				    	  player.addCard(Deck);
		    		  }
		    	  }
				
				
			}
		}

		int maxScore = 0;
		int indexOfMax = 0;
		
		if(blackJackCount == 0 ){
			for (Player eachPlayer : Players) {
				if (eachPlayer.getTotal() > maxScore) {
					maxScore = eachPlayer.getTotal();
					indexOfMax = Players.indexOf(eachPlayer);
				}
			}	
			blackJackCount = 1;
			System.out.println("\n\n================================================");
			System.out.println("Jogador " + Players.get(indexOfMax).getName() + " venceu com " + Players.get(indexOfMax).getTotal() + " pontos!");
		}
		
		gameWinners();
		
		
	}
	
	/**
	 * Method to print the winners of the game.
	 */
	public void gameWinners () {
		for (Player player : Players)
		{
			if(player.isBust())
			{
				System.out.println("\n\n================================================");
				System.out.println("Jogador " + player.getName() + " estourou!");
			}
			else
			{
				System.out.println("\n\n================================================");
				System.out.println("Jogador " + player.getName() + " fez " + player.getTotal() + " pontos!");
			}
		}
		
		if(blackJackCount == 1) {
			System.out.println("\n\n================================================");
	    	System.out.println("\nJogo encerrado, 1 vencedor");
	     } else {
			System.out.println("\n\n================================================");
	    	System.out.println("\nJogo empatado, " + blackJackCount + " vencedores!");
	     }
	}
	
	
	/**
	* Static method to spend time, before any other code.
	*/
	public static void sleep (int time)
	{
		try {
			Thread.sleep(time);
		} catch (Exception e) {}
			
	}
}

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	DeckOfCards Deck;
	private boolean stands = true;
	private int blackJackCount = 0;
	ArrayList<Player> Players;
	private Scanner s;
	
	
	public Game(int numPlayers, Scanner s) {
		Deck = new DeckOfCards();
		Players = new ArrayList <Player>();
	  	Deck.shuffle();
	  	this.s = s;
        
        for (int i = 0; i < numPlayers; i++) 
        {
        	System.out.print("Digite o nome do jogador:");
  	      	String nome = s.nextLine();
            Player jogador = new Player (nome, Deck);
            Players.add(jogador);
            if(jogador.hasBlackjack())
  	      {
  	    	  System.out.println("Parabéns, " + jogador.getName() + ", você fez um BlackJack!");
  	    	  jogador.getCards();
  	    	  System.out.println("Soma das cartas: " + jogador.getTotal());
  	    	  blackJackCount ++;
  	      }
        }
    }
	
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
		    		  }else {
		    			  
				    	  System.out.println("\n1 - Hit" + "		2 - Pass");
		
				    	  if(s.nextInt() == 2)
				    	  { 
				    		  stands = false;
				    	  }
				    	  else
				    		  player.addCard(Deck);
		    		  }
		    	  }
				
				
			}
		}
		
		gameWinners();
		
		
	}
	
	public void gameWinners () {
		
		if(blackJackCount == 1) {
	    	 System.out.println("Jogo encerrado, 1 vencedor");
	     } else {
	    	 System.out.println("Jogo empatado, " + blackJackCount + " vencedores!");
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

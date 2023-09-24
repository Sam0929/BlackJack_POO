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
	private static Scanner s = new Scanner(System.in);
	private int numPlayers = 0;
	
	/**
	 * Constructor of the class Game.
	 * @param nP Number of players.
	 */
	public Game(int nP) 
	
	{
		Deck = new DeckOfCards();
		Players = new ArrayList <Player>();
	  	Deck.shuffle();
        String name;
        numPlayers = nP;
        for (int i = 0; i < nP; i++) 
        {
        	System.out.print("Digite o nome do jogador:");
  	      	name = readS();
            Player player = new Player (name, Deck);
            Players.add(player);
            if(player.hasBlackjack())
  	      {
              System.out.println("\n\n================================================");
  	    	  System.out.println("\nParabéns, " + player.getName() + ", você fez um BlackJack!");
  	    	  System.out.println("\n================================================");
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
		    			  System.out.println("\nQue pena! Você estorou! Mais sorte da próxima vez!");
		    			  sleep(4000);
		    			  stands = false;
					  }else
		    		  {
						System.out.println("\n1 - Hit" + "		2 - Pass");
		
				    	if(readNumber() == 2)
				    	{ 
				    	  stands = false;
				    	}else
				    	  player.addCard(Deck);
		    		  }
		    	  }
				
				
			}
		}
		setWinners();
		
		gameWinners();
	}
	
	/**
	 * Method to print the winner, if he exists. And see if there is a draw or not.
	 */
	private void setWinners () 
	
	{
		
		int maxScore = 0;
		int indexOfMax = 0;
		int hasWinner = 0;
		ArrayList<Player> tiePlayers = new ArrayList<>();
		
		if(blackJackCount == 0 )
		{
			
			
			for (Player eachPlayer : Players) {
				
				int total = eachPlayer.getTotal();
				if (total > maxScore && total <= 21) {
					
					maxScore = total;
					indexOfMax = Players.indexOf(eachPlayer);
					tiePlayers.clear();
	                tiePlayers.add(eachPlayer);
	                hasWinner ++;
				}
				else if (total == maxScore)
				{
                    tiePlayers.add(eachPlayer);
                }
			}
			
			if(hasWinner>0 && tiePlayers.size() < 2)
			{
				blackJackCount = 1;
				System.out.println("\n\n================================================");
				System.out.println("Jogador " + Players.get(indexOfMax).getName() + " venceu com " + Players.get(indexOfMax).getTotal() + " pontos!");
			}
		}
	}
	
	/**
	 * Method to print the winners of the game.
	 */
	public void gameWinners () 
	
	{
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
			System.out.println("\n================================================");
	    	System.out.println("\nJogo empatado, " + blackJackCount + " vencedores!");
	     }
		
		System.out.println("\n==============================================");
		System.out.println("Deseja jogar novamente?\n\n" + "1 - Sim 		2 - Não");
		
			if (readNumber() == 1) restartGame(numPlayers);
			
			else finishGame();
			
	}
	

	/**
	 * Method to restart the game.
	 */
	private void restartGame(int numPlayers) 
	
	{
        
        Deck = new DeckOfCards();
        Players.clear();
        blackJackCount = 0;
        String nome;
        Deck.shuffle();
        
        for (int i = 0; i < numPlayers; i++) 
        {
        	
            System.out.print("Digite o nome do jogador:");
            nome = readS();
            Player jogador = new Player(nome, Deck);
            Players.add(jogador);
            
            if (jogador.hasBlackjack()) {
                System.out.println("Parabéns, " + jogador.getName() + ", você fez um BlackJack!");
                jogador.getCards();
                System.out.println("Soma das cartas: " + jogador.getTotal());
                blackJackCount++;
            }
        }
        startGame();
    }
	
	
	private void finishGame() {
		
		s.close();
		
		System.out.println("\n\n================================================");
		
		System.out.println("\n\nObrigado por jogar BlackJack!");
		
		System.out.println("\n\n================================================");
		
		System.exit(0);
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
	
	/**
	* Static method to read a number.
	*/
	public static int readNumber()
	{
		int number=0;
		String str;
		str = s.nextLine();
		 try{
			 number = Integer.parseInt(str);
			 
	      }
	      catch (NumberFormatException ex){
	          ex.printStackTrace();
	      }
		 return number;
	}
	
	/**
	* Static method to read a String.
	*/
	public static String readS()
	{
		String str;
		str = s.nextLine();
		return str;
	}
}

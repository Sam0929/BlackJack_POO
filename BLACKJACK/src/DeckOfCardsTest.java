import java.util.Scanner;
public class DeckOfCardsTest
{
   // execute application
   public static void main(String[] args)
   {
	   
	  Scanner s = new Scanner (System.in);
	  int x = 0;
	  int blackJackCount = 0;
	  boolean stands = true;
	  
	  System.out.print("Quantos players irão jogar BlackJack? \n \nDigite o número de jogadores:");
	  String str = s.nextLine();      

	  try{
           x = Integer.parseInt(str);
      }
      catch (NumberFormatException ex){
          ex.printStackTrace();
      }
	  
	  
	  	Player p[] = new Player [x];
		
	  	DeckOfCards Deck = new DeckOfCards ();
		
	  	Deck.shuffle(); // place Cards in random order
		  
	  for (int i =0; i<p.length; i++)
	  {	  
	      System.out.print("Digite o nome do jogador:");
	      String nome = s.nextLine();
	      p[i] = new Player(nome, Deck);
	      if(p[i].hasBlackjack())
	      {
	    	  System.out.println("Parabéns, " + p[i].getName() + ", você fez um BlackJack!");
	    	  p[i].getCards();
	    	  System.out.println("Soma das cartas: " + p[i].getTotal());
	    	  blackJackCount ++;
	      }
	      
	  }
      
     
    
     if(blackJackCount == 0)
     {
	      for (int i =0; i<p.length; i++)
	      {
	    	  stands = true;
	    	  while (stands)
	    	  {
		    	  p[i].getCards();
		    	  System.out.println("\nSoma das cartas: " + p[i].getTotal());
		    	  
		    	  if(p[i].isBust())
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
			    		  p[i].addCard(Deck);
	    		  }
	    	  }
	    	  
	      }     
     } else if(blackJackCount == 1) {
    	 System.out.println("Jogo encerrado, 1 vencedor");
     } else {
    	 System.out.println("Jogo empatado, " + blackJackCount + " vencedores!");
     }
 
      
      s.close();
   } 
 // end class DeckOfCardsTest

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
import java.util.Scanner;
public class DeckOfCardsTest
{
   // execute application
   public static void main(String[] args)
   {
	   
	  Scanner s = new Scanner (System.in);
	  System.out.println("Quantos players irão jogar BlackJack? \n \n Digite o número de jogadores:");
	  int x = s.nextInt();
	  Player p[] = new Player [x];
	  DeckOfCards Deck = new DeckOfCards ();
	  Deck.shuffle(); // place Cards in random order
	  s.nextLine();
	  for (int i =0; i<x; i++)
	  {	  
	      System.out.println("Digite o nome do jogador:");
	      String nome = s.nextLine();
	      p[i] = new Player(nome, Deck);
	      
	  }
      
      
      // print all 52 Cards in the order in which they are dealt
     
      for (int i =0; i<p.length; i++)
      {
    	  p[i].getCards();
      }
      s.close();
   } 
} // end class DeckOfCardsTest
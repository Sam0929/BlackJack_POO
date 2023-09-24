public class DeckOfCardsTest
{
   // execute application
   public static void main(String[] args)
   {

	  System.out.print("Quantos players irão jogar BlackJack? \n \nDigite o número de jogadores:");
	  
	  int qJogadores = Game.readNumber();
	  
	  Game novo = new Game (qJogadores);
	  novo.startGame();
	  
   } 
 // end class DeckOfCardsTest

   
}
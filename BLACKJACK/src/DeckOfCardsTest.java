import java.util.Scanner;
public class DeckOfCardsTest
{
   // execute application
   public static void main(String[] args)
   {
	   
	  Scanner s1 = new Scanner (System.in);
	  int numberPlayers = 0;
	  
	  System.out.print("Quantos players irão jogar BlackJack? \n \nDigite o número de jogadores:");
	  String str = s1.nextLine();      

	  try{
           numberPlayers = Integer.parseInt(str);
      }
      catch (NumberFormatException ex){
          ex.printStackTrace();
      }
	  
	  
	  Game newGame = new Game (numberPlayers, s1);
	  newGame.startGame();
      s1.close();
	  
   } 
 // end class DeckOfCardsTest

   
}
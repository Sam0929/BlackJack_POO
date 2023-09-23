import java.util.Scanner;
public class DeckOfCardsTest
{
   // execute application
   public static void main(String[] args)
   {
	   
	  Scanner s1 = new Scanner (System.in);
	  int qJogadores = 0;
	  
	  System.out.print("Quantos players irão jogar BlackJack? \n \nDigite o número de jogadores:");
	  String str = s1.nextLine();      

	  try{
           qJogadores = Integer.parseInt(str);
      }
      catch (NumberFormatException ex){
          ex.printStackTrace();
      }
	  
	  
	  Game novo = new Game (qJogadores, s1);
	  novo.startGame();
      s1.close();
	  
   } 
 // end class DeckOfCardsTest

   
}
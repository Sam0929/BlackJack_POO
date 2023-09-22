import java.util.HashMap;
import java.util.Map;

public class Card 
{
   private final String face; // face of card ("Ace", "Deuce", ...)
   private final String suit; // suit of card ("Hearts", "Diamonds", ...)
   private final int value; // value of card

   // two-argument constructor initializes card's face and suit
   public Card(String face, String suit)
   {
      this.face = face;
      this.suit = suit;
      switch(face) {
      case "Ace": this.value = 11; break;
      case "Jack": this.value = 10; break;
      case "Queen": this.value = 10; break;
      case "King": this.value = 10; break;
      default: this.value = convert(face); break;
      }
      
   } 

   // return String representation of Card
   public String toString() 
   { 
      return face + " of " + suit + "(value: " + value + ")" ;
   } 
   
   private static final Map<String, Integer> wordToNumber = new HashMap<>();
   
   static {
       wordToNumber.put("One", 1);
       wordToNumber.put("Deuce", 2);
       wordToNumber.put("Three", 3);
       wordToNumber.put("Four", 4);
       wordToNumber.put("Five", 5);
       wordToNumber.put("Six", 6);
       wordToNumber.put("Seven", 7);
       wordToNumber.put("Eight", 8);
       wordToNumber.put("Nine", 9);
       wordToNumber.put("Ten", 10);
   }

   private static int convert(String input) {
      
       if (wordToNumber.containsKey(input)) {
           return wordToNumber.get(input);
       } else {
           throw new IllegalArgumentException("Palavra não reconhecida: " + input);
       }
   }
   
   public int getValue() {
	   return this.value;
   }
} // end class Card
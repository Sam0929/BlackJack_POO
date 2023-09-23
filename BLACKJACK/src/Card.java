import java.util.HashMap;
import java.util.Map;

/**
 * Class that represent a card.
 */
public class Card 
{
    /**
     * Attributes of the class Card.
     */
   private final String face; // face of card ("Ace", "Deuce", ...)
   private final String suit; // suit of card ("Hearts", "Diamonds", ...)
   private int value; // value of card

   /**
    * Constructor of the class Card.
    * @param face Face of the card.
    * @param suit Suit of the card.
    */
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

   /**
    * Method to return the face of the card.
    * @return Face of the card.
    */
   public String toString() 
   { 
      return face + " of " + suit + "(value: " + value + ")" ;
   } 
   
   /**
    * Method to return the value of the card.
    * @return Value of the card.
    */
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

   /**
    * Method to convert the face of the card to a number.
    * @param input Face of the card.
    * @return Value of the card.
    */
   private static int convert(String input) {
      
       if (wordToNumber.containsKey(input)) {
           return wordToNumber.get(input);
       } else {
           throw new IllegalArgumentException("Palavra não reconhecida: " + input);
       }
   }
   
   /**
    * Method to return the value of the card.
    * @return Value of the card.
    */
   public int getValue() {
	   return this.value;
   }
   
    /**
     * Method to set the value of the card Ace to 1.
     */
   void setValueAce() {
	   this.value = 1;
   }
} // end class Card
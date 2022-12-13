import java.util.*;
import javax.swing.*;

public class WordForm {
   
   // Declaring stuff
   int num; // Input number
   
   // Constructor
   public WordForm() {
      // num = (int)(Math.random() * 999) + 1;
   }
   
   public static int getNum() {
   
      String value = JOptionPane.showInputDialog("Enter the number you would like to convert into word form.");
      
      int num = Integer.parseInt(value);
      
      return num;
   
   }
   
   // Getting the expanded form of a number
   @SuppressWarnings("all")
   public ArrayList getExpandedForm(int num) {
      ArrayList<Integer> expandedForm = new ArrayList<Integer>(); // ArrayList containing expanded form
      int currentDigit = 0; // Number containing a digit of num
      while (!(num % 10 == 0)) { // Checking for ones place
         num--;
         currentDigit++;
      }
      expandedForm.add(currentDigit); // Adding ones place to expandedForm
      currentDigit = 0; // Resetting digit container
      while (!(num % 100 == 0)) { // Checking for tens place
         num -= 10;
         currentDigit += 10;
      }
      expandedForm.add(currentDigit);
      currentDigit = 0;
      while (!(num % 1000 == 0)) { // Checking for hundreds place
         num -= 100;
         currentDigit += 100;
      }
      expandedForm.add(currentDigit);
      
      return expandedForm; // Returns list with expanded form
   }
   
   // Getting the word form of a number using the expanded form
   public String getWordForm(int num) {
      
      // ArrayList referencing expanded form (user input)
      @SuppressWarnings("all")
      ArrayList<Integer> expandedForm = getExpandedForm(num);
      
      // ArrayList containing word form
      ArrayList<String> wordForm = new ArrayList<String>();
      
      // Declaring each place
      String onesPlace = "";
      String tensPlace = "";
      String hundredsPlace = "";
      
      // Declaring full converted form
      String numberInWordForm = "";
      
      // Edge Cases
      boolean isTeenCase = false;
      boolean endsWithZero = false;
      boolean secondDigitIsZero = false;
      
      switch (expandedForm.get(0)) { // Regular case ones place
         case 1: {onesPlace = "One"; break;}
         case 2: {onesPlace = "Two"; break;}
         case 3: {onesPlace = "Three"; break;}
         case 4: {onesPlace = "Four"; break;}
         case 5: {onesPlace = "Five"; break;}
         case 6: {onesPlace = "Six"; break;}
         case 7: {onesPlace = "Seven"; break;}
         case 8: {onesPlace = "Eight"; break;}
         case 9: {onesPlace = "Nine"; break;}
         case 0: {onesPlace = ""; endsWithZero = true; break;}
      }
      
      if (expandedForm.get(1) == 10) { // Special case combined tens and ones place
         switch (expandedForm.get(0)) {
            case 1: {onesPlace = "Eleven"; break;}
            case 2: {onesPlace = "Twelve"; break;}
            case 3: {onesPlace = "Thirteen"; break;}
            case 4: {onesPlace = "Fourteen"; break;}
            case 5: {onesPlace = "Fifteen"; break;}
            case 6: {onesPlace = "Sixteen"; break;}
            case 7: {onesPlace = "Seventeen"; break;}
            case 8: {onesPlace = "Eighteen"; break;}
            case 9: {onesPlace = "Nineteen"; break;}
            case 0: {onesPlace = "Ten"; break;}
         }
         
         isTeenCase = true;
      }
      
      wordForm.add(onesPlace); // Adding the ones place
      
      switch (expandedForm.get(1)) { // Regular case ones place
         case 10: {tensPlace = ""; break;}
         case 20: {tensPlace = "Twenty"; break;}
         case 30: {tensPlace = "Thirty"; break;}
         case 40: {tensPlace = "Forty"; break;}
         case 50: {tensPlace = "Fifty"; break;}
         case 60: {tensPlace = "Sixty"; break;}
         case 70: {tensPlace = "Seventy"; break;}
         case 80: {tensPlace = "Eighty"; break;}
         case 90: {tensPlace = "Ninety"; break;}
         case 0: {tensPlace = ""; secondDigitIsZero = true; break;}
      }
      
      wordForm.add(tensPlace);
      
      switch (expandedForm.get(2)) {
         case 100: {hundredsPlace = "One Hundred"; break;}
         case 200: {hundredsPlace = "Two Hundred"; break;}
         case 300: {hundredsPlace = "Three Hundred"; break;}
         case 400: {hundredsPlace = "Four Hundred"; break;}
         case 500: {hundredsPlace = "Five Hundred"; break;}
         case 600: {hundredsPlace = "Six Hundred"; break;}
         case 700: {hundredsPlace = "Seven Hundred"; break;}
         case 800: {hundredsPlace = "Eight Hundred"; break;}
         case 900: {hundredsPlace = "Nine Hundred"; break;}
         case 0: {hundredsPlace = ""; break;}
      }
      
      wordForm.add(hundredsPlace);
      
      if (isTeenCase == true) {
         numberInWordForm = wordForm.get(2) + " " + wordForm.get(0);
      } else if (endsWithZero == true) {
         numberInWordForm = wordForm.get(2) + " " + wordForm.get(1);
      } else if (secondDigitIsZero == true) {
         numberInWordForm = wordForm.get(2) + " " + wordForm.get(0);
      } else {
         numberInWordForm = wordForm.get(2) + " " + wordForm.get(1) + "-" + wordForm.get(0);
      }
      
      return (numberInWordForm.trim());
   }
   
   public static void main(String[] args) {
      WordForm converter = new WordForm();
      for (int i = 1; i <= 999; i++) {
         System.out.println(converter.getWordForm(i));
      }
   }

}
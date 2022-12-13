import edu.fcps.karel2.*;
import javax.swing.*;
import java.util.*;

public class CleverShift {
   public static void main(String[] args) {
   
      String filename = JOptionPane.showInputDialog("What robot world?");
      Display.openWorld("maps/" + filename + ".map");
      Display.setSize(10, 10);
      Display.setSpeed(10);
      
      Athlete a = new Athlete(1, 1, Display.EAST, 0);
      Athlete b = new Athlete(1, 2, Display.EAST, 0);
      
      shiftBeepers(a);
      shiftAgain(b);
      
      System.out.println("Infinite loop check successful.");
     
   }
   
   
   
   public static void shiftBeepers(Athlete temp) {
      
      // create an arraylist to record the number of beepers in each pile
      ArrayList<Integer> beeps = new ArrayList<Integer>();
      
      // create a variable to record the individual amount of beepers in each pile each iteration of the loop
      int eachBeeps = 0;
      
      // pick up an amount of beepers, record that as a number in the arraylist
      for (int i = 0; i < 7; i++) {
         eachBeeps = 0; // number of beepers in each pile, recorded each iteration of the loop
         
         while (temp.nextToABeeper()) {
            temp.pickBeeper();
            eachBeeps++; // for every time temp picks up a beeper, tell the program to remember that
         }
         
         beeps.add(eachBeeps); // add the number of beepers in a pile to the arraylist
         temp.move();
         System.out.println(beeps); // printing the number of beepers in each pile for testing
         
      }

      // turn around
      temp.turn180();
      
      // put down beepers equal to each item in the arraylist, but offset:
      for (int i = 7; i > 0; i--) { // loop moving back to the start
         for (int b = 0; b < beeps.get(i - 1); b++) { // put down a number of beepers equal to each number in the list backwards
            temp.putBeeper();
         }
         temp.move();
      }
      
      // turn around
      temp.turn180();
      
   }
   
   public static void shiftAgain(Athlete temp) {
      // go to the other side
      for (int i = 0; i < 7; i++) {
         temp.move();
      }
      temp.turn180();
      temp.move();
      
      // create an arraylist to record the number of beepers in each pile
      ArrayList<Integer> beeps = new ArrayList<Integer>();
      
      // create a variable to record the individual amount of beepers in each pile each iteration of the loop
      int eachBeeps = 0;
      
      // pick up an amount of beepers, record that as a number in the arraylist
      for (int i = 0; i < 8; i++) {
         eachBeeps = 0; // number of beepers in each pile, recorded each iteration of the loop
         
         while (temp.nextToABeeper()) {
            temp.pickBeeper();
            eachBeeps++; // for every time temp picks up a beeper, tell the program to remember that
         }
         
         beeps.add(eachBeeps); // add the number of beepers in a pile to the arraylist
         if (temp.frontIsClear()) {
            temp.move();
         }
         System.out.println(beeps); // printing the number of beepers in each pile for testing
         
      }

      // turn around
      temp.turn180();
      temp.move();
      
      // put down beepers equal to each item in the arraylist, but offset:
      for (int i = 7; i > 0; i--) { // loop moving back to the start
         for (int b = 0; b < beeps.get(i - 1); b++) { // put down a number of beepers equal to each number in the list backwards
            temp.putBeeper();
         }
         temp.move();
      }
      
      // turn around
      temp.turn180();

   }
}
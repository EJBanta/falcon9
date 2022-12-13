// MakePyramid3.java        ITCS
//
// Create a pyramid using class methods

import edu.fcps.karel2.*;
import javax.swing.*;

public class MakePyramid3 {
   public static void goUp(int numBeepers, Multitasker worker) { // assembles column
      for(int i = 0; i < numBeepers; i++) {
         worker.dropAndMove();
      }
   }
   
   public static void goDown(int height, Multitasker worker) { // returns robot to ground when column is assembled
      for(int i = 0; i < height; i++) {
         worker.move();
      }
   }
   
   public static void moveOver(Multitasker worker) { // moves robot to the side when it reaches the ground and prepares it for another column
      worker.turnLeft();
      worker.move();
      worker.turnLeft();
   }
   
   public static void main(String[] args) {
   
      // setup
      Display.setSize(8, 8);
      Display.setSpeed(10);
      
      // instantiating new robot
      Multitasker worker = new Multitasker(1, 1, Display.NORTH, Display.INFINITY);     
 
      // column 1
      worker.goUp(1);
      worker.turn180();
      worker.goDown(1);
      worker.moveOver();
      
      //column 2
      worker.goUp(2);
      worker.turn180();
      worker.goDown(2);
      worker.moveOver();
      
      // column 3
      worker.goUp(3);
      worker.turn180();
      worker.goDown(3);
      worker.moveOver();
      
      // column 4
      worker.goUp(4);
      worker.turn180();
      worker.goDown(4);
      worker.moveOver();
      
      // column 5
      worker.goUp(3);
      worker.turn180();
      worker.goDown(3);
      worker.moveOver();
      
      // column 6
      worker.goUp(2);
      worker.turn180();
      worker.goDown(2);
      worker.moveOver();
      
      // column 7
      worker.goUp(1);
      worker.turn180();
      worker.goDown(1);
      worker.moveOver();
      
      // prints a message of finishing
      printFinishMessage("Pyramid complete.");
   
      
   }
   
   
   
   // Prints the given message in the dialog box  
   public static void printFinishMessage(String message) { 
      
      JOptionPane.showMessageDialog(null, message);
   }
   
}
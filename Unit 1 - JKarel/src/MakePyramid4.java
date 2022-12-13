// MakePyramid4.java        ITCS
//
// Creates a pyramid N columns high

import edu.fcps.karel2.*;
import javax.swing.JOptionPane;

// importing math for use in createPyramid method
import static java.lang.Math.*;



public class MakePyramid4 {
   
   // the main method
   public static void main (String[] args) {
   
      // finds the number of columns using a JOptionPane method
      int numColumns = getNumColumns();
      
      // setup
      Display.openWorld("");
      Display.setSize(numColumns, numColumns);
      Display.setSpeed(10);
      
      // instantiates new Multitasker
      Multitasker worker = new Multitasker(1, 1, Display.NORTH, Display.INFINITY);      
      
      // runs overarching create function to create the pyramid
      // passes worker and numColumns                   
      createPyramid(worker, numColumns);
      
      // prints a message to convey that the program is complete
      printFinishMessage("Pyramid complete.");
   }
   
   
   
   // Prompts and returns the number of columns to build
   public static int getNumColumns() {
   
      String value = JOptionPane.showInputDialog("Enter the number of columns for the pyramid.");
      
      int numColumns = Integer.parseInt(value);
      
      return numColumns;
   
   }
   
   
   
   // Creates a pyramid with a Multitasker robot that has as many columns as numColumns
   public static void createPyramid(Multitasker temp, int numColumns) {
      
      // instantiates currentColumn (indicator for the column the loop is currently on)
      int currentColumn = 1;
      
      // instantiates currentHeight (indicator for the height of the column the loop is currently on)
      int currentHeight = 1;
      
      // instantiates isSecondColumn (indicator for if there has been a second top column in an evenly columned pyramid)
      boolean finishedSecondColumn = false;
      
      // calculates the height of the pyramid according to the input of numColumns
      int pyramidHeight = (numColumns + 1) / 2;
      
      
      // large, complicated loop runs once for every column, making the right sized column each time
      for(int i = 0; i < numColumns; i++) {
      
         // calculates the current height of the column each repeat of the loop using an absolute value equation
         currentHeight = (-1 * abs(currentColumn - (pyramidHeight)) + (pyramidHeight));
         
         // creates a column of the currentHeight
         column(temp, currentHeight);
         
         // large, complicated if statement that increases the currentColumn 
         // by 1 each repeat...
         if(numColumns % 2 != 0) { // if numColumns is odd...
         
            currentColumn = currentColumn + 1;
            
         } else { // but if it's not odd...
         
            if(pyramidHeight == currentHeight) { // and it's at the peak..
            
               if(finishedSecondColumn == false) { // and it hasn't repeated any columns yet...
               
                  finishedSecondColumn = true; // then repeat a column and tell it not to do it again.
                  
               } else { // don't repeat it again...
               
                  currentColumn = currentColumn + 1;
                  
               }
            } else { // and if it's not at it's peak, don't repeat it either.
            
               currentColumn = currentColumn + 1;
               
            }
            
         } // end of the large, complicated if statement
         
         
      } // end of the large, complicated loop
   }
   
   
   
   // Method to create a single column of the pyramid
   public static void column(Multitasker temp, int height) {
      // places beepers while rising
      goUp(height, temp);
      
      // turns around
      temp.turn180();
      
      // moves back to the ground
      goDown(height, temp);
      
      // moves over to make the next column
      moveOver(temp);
   }
   
   
   
   // method to place beepers to one column
   public static void goUp(int numBeepers, Multitasker temp) {
      for(int i = 0; i < numBeepers; i++) {
         temp.dropAndMove();
      }
   }
   
   
   
   // method to return robot to ground after placing beepers in one column
   public static void goDown(int height, Multitasker temp) {
      for(int i = 0; i < height; i++) {
         temp.move();
      }
   }
   
   
   
   // method to move robot over when it reaches the ground to prepare for another column
   public static void moveOver(Multitasker temp) {
      temp.turnLeft();
      temp.move();
      temp.turnLeft();
   }

   
   
   // method to effectively print the finish message
   public static void printFinishMessage(String message) { 
      
      JOptionPane.showMessageDialog(null, message);
   }

}
// MakePyramid2.java        ITCS    Shell Code

import edu.fcps.karel2.*;
import javax.swing.JOptionPane;

public class MakePyramid2 {

   public static void main (String[] args) {
   
      Display.setSize(8, 8);
      Display.setSpeed(10);
      
      // Create a Multitasker
      Multitasker m = new Multitasker(1, 1, Display.NORTH, Display.INFINITY);
      
      // Code to make the pyramid goes here
      
      m.turnRight(); //COLUMN 1
      m.dropAndMove();
      
      m.turnLeft();
      
      
      for(int i = 0; i < 2; i++) { //COLUMN 2
         m.dropAndMove();
      }
      
      m.turn180();
      
      for(int i = 0; i < 2; i++) {
         m.move();
      }
      
      m.turnLeft();
      m.move();
      m.turnLeft();
      
      
      for(int i = 0; i < 3; i++) { //COLUMN 3
         m.dropAndMove();
      }
      
      m.turn180();
      
      for(int i = 0; i < 3; i++) {
         m.move();
      }
      
      m.turnLeft();
      m.move();
      m.turnLeft();
      
      
      for(int i = 0; i < 4; i++) { //COLUMN 4
         m.dropAndMove();
      }
      
      m.turn180();
      
      for(int i = 0; i < 4; i++) {
         m.move();
      }
      
      m.turnLeft();
      m.move();
      m.turnLeft();
      
      
      for(int i = 0; i < 3; i++) { //COLUMN 5
         m.dropAndMove();
      }
      
      m.turn180();
      
      for(int i = 0; i < 3; i++) {
         m.move();
      }
      
      m.turnLeft();
      m.move();
      m.turnLeft();
      
      
      for(int i = 0; i < 2; i++) { //COLUMN 6
         m.dropAndMove();
      }
      
      m.turn180();
      
      for(int i = 0; i < 2; i++) {
         m.move();
      }
      
      m.turnLeft();
      m.move();
      m.turnLeft();
      
      
      m.dropAndMove(); //COLUMN 7
      
         
      printFinishMessage("King Tuthankhamen's tomb was discoverd by archaeologist Howard Carter!");
   
   }

   // Prints the message to a dialog box
   public static void printFinishMessage(String message) {     
      JOptionPane.showMessageDialog(null, message);
   }
     
     
     
      
}
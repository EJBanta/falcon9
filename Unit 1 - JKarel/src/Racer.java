// Racer.java				
import edu.fcps.karel2.*;
	
public class Racer extends Athlete {

  	// A Racer can be at any y-coordinate (1, y), face East, 
	// and have an Infinite amount of beepers    
   public Racer() {
      super(1, 1, Display.EAST, Display.INFINITY);
   }
   
   public Racer(int x, int y, int d, int b) {
      super(x, y, d, b);
   }

   public Racer(int y) {
      super(1, y, Display.EAST, 0);
   }
					
	// Begins facing East, jumps over a hurdle, and finishes facing East
   public void jumpRight() {
      turnLeft();
      move();
      turnRight();
      move();
      turnRight();
      move();
      turnLeft();
   }
		
	// Begins facing West, jumps over a hurdle, and finishes facing West.
   public void jumpLeft() {
      turnRight();
      move();
      turnLeft();
      move();
      turnLeft();
      move();
      turnRight();
   }
   
	// Moves forward numSpaces spaces.
   public void sprint(int numSpaces) {
      for(int i = 0; i < numSpaces; i++) {
         move();
      }
   }
   	
	// Put down numBeepers beepers.
   public void put(int numBeepers) {
      for(int i = 0; i < numBeepers; i++) {
         putBeeper();
      }
   }	
   
	// Pick up numBeepers beepers.
   public void pick(int numBeepers) {
      for(int i = 0; i < numBeepers; i++) {
         pickBeeper();
      }
   }
   
	   
}
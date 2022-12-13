// Lab03: Climb Every Mountain
// Climber.java		
	
import edu.fcps.karel2.*;

// A Climber Robot can climb up and down mountain
public class Climber extends Athlete {
  		
   // The default constructor starts at (1,1), faces North, and has
	// 1 beeper	
   public Climber() {
      super(1, 1, Display.NORTH, 1);
   }    
		
		
	// The 1 parameter constructor starts at (x, 1), faces North, and has
   // 1 beeper
   public Climber(int x) {
      super(x, 1, Display.NORTH, 1);
   }
      
   // Climber is facing right and moves up one level and finishes facing right 
   public void climbUpRight() { 
      turnLeft();
      for(int i = 0; i < 2; i++) {
         move();
      }
      turnRight();
      move();
   }
      
   	
   // Climber is facing left and moves up one level and finishes facing left
   public void climbUpLeft() {	     
      turnRight();
      for(int i = 0; i < 2; i++) {
         move();
      }
      turnLeft();
      move();
   }
      
   	
   // Climber is facing right and moves down one level and finishes facing right
   public void climbDownRight() {
      move();
      turnRight();
      for(int i = 0; i < 2; i++) {
         move();
      }
      turnLeft();
   }
      
   // Climber is facing left and moves down one level and finishes facing left
   public void climbDownLeft() { 
      move();
      turnLeft();
      for(int i = 0; i < 2; i++) {
         move();
      }
      turnRight();  
   }
}
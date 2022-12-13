// Lab03: Climb Every Mountain
// ClimbEveryMountain.java

import edu.fcps.karel2.*;

public class ClimbEveryMountain {
   
   // Static class method for retrieving treasure
   public static void getTreasure(Climber temp) {
   
      // Move to climbing starting position
      temp.turnRight();
      temp.move();
      
      // Begin the climb up with a loop and the climbUpRight method
      for(int i = 0; i < 4; i++) {
         temp.climbUpRight();
      }
      
      // Continue by climbing down to the treasure with a loop
      // and the climbDownRight method
      for(int i = 0; i < 3; i++) {
         temp.climbDownRight();
      }
      
      // Grab 5 pieces of the treasure
      for(int i = 0; i < 5; i++) {
         temp.pickBeeper();
      }
      
      // Turn Around
      temp.turn180();
      
      // Climb back up using a loop and the climbUpLeft method
      for(int i = 0; i < 3; i++) {
         temp.climbUpLeft();
      }
      
      // Finish the climb by climbing back down using a loop and the 
      // climbDownLeft method
      for(int i = 0; i < 4; i++) {
         temp.climbDownLeft();
      }
      
      // Return to base camp
      temp.move();
      
      // Drop treasure in pile of beepers
      for(int i = 0; i < 5; i++) {
         temp.putBeeper();
      }
      
      // Their serivce is no longer needed
      temp.explode();

   }


   // Main program loop
   public static void main(String[] args) {
   
      // Setup (map file, map size, robot speed)
      Display.openWorld("maps/mountain.map");
      Display.setSize(17, 17);
      Display.setSpeed(10);
      
      // New climber basemarker at (8, 1), facing North, with 1 beeper
      Climber basemarker = new Climber(8);
      
      // Establish base camp w/ beeper
      basemarker.putBeeper();
      
      // basemarker is no longer needed
      basemarker.explode();
      
      // New bots abc lineup instantiation
      Climber a = new Climber(8);
      Climber b = new Climber(8);
      Climber c = new Climber(8);
      
      // Bots abc get treasure
      getTreasure(a);
      getTreasure(b);
      getTreasure(c);
      
   }
}
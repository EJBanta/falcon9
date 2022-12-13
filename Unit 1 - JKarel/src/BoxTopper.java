import edu.fcps.karel2.*;

public class BoxTopper extends Racer {
   public BoxTopper() {
      super(1, 1, Display.EAST, Display.INFINITY);
   }
   
   public void jumpRight() {
      turnLeft();
      while (!rightIsClear()) {
         move();
      }
      turnRight();
      move();
      while (!rightIsClear()) {
         move();
      }
      turnRight();
      while (frontIsClear()) {
         move();
      }
      turnLeft();
   }
}
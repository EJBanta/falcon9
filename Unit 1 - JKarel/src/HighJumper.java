import edu.fcps.karel2.*;

public class HighJumper extends Racer {
   public HighJumper() {
      super(1, 1, Display.EAST, Display.INFINITY);
   }
   
   public void jumpRight() {
      turnLeft();
      while (!rightIsClear()) {
         move();
      }
      turnRight();
      move();
      turnRight();
      while (frontIsClear()) {
         move();
      }
      turnLeft();
   }
}
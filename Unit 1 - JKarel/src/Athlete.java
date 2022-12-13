import edu.fcps.karel2.Display; 
import edu.fcps.karel2.Robot;

public class Athlete extends Robot {

   public Athlete() {
      super(1, 1, Display.NORTH, Display.INFINITY);
   }
   
   public Athlete(int x, int y, int direction, int beepers) {
      super(x, y, direction, beepers);
   }
   
   public void turnRight() {
      for(int i = 0; i < 3; i++) {
         turnLeft();
      }
   }
   
   public void turn180() {
      for(int i = 0; i < 2; i++) {
         turnLeft();
      }
   }

}
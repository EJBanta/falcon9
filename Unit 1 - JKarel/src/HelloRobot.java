import edu.fcps.karel2.Display; 
import edu.fcps.karel2.Robot;

public class HelloRobot {

   public static void main(String[] args) {
      Display.openWorld("maps/goldmine.map");
      Display.setSize(10, 10);
      
      Robot r = new Robot();
      
      r.move();
      r.turnLeft(); 
      
   }
}
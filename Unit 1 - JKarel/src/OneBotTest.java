import edu.fcps.karel2.*;

public class OneBotTest {
   public static void main(String[] args) {
   
      Display.openWorld("maps/maze1.map");
      Display.setSpeed(10);
      
      Robot endmarker = new Robot(8, 5, Display.WEST, 2);
      
      endmarker.move();
      endmarker.pickBeeper();
      endmarker.turnLeft();
      endmarker.turnLeft();
      endmarker.move();
      endmarker.putBeeper();
      endmarker.putBeeper();
      endmarker.explode();
      
   }
}
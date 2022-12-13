import edu.fcps.karel2.*;

public class HopperBotTest {
   public static void main(String[] args) {
   
      Display.openWorld("maps/boxtop2.map");
      Display.setSpeed(10);
      
      HopperBot a = new HopperBot(1, 1, Display.EAST);
      
      a.solveBoxTop();
   }
}
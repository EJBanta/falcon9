import edu.fcps.karel2.*;

public class LoopChallenge {
   public static void main(String[] args) {
      
      Display.openWorld("maps/loopChallenge.map");
      Display.setSpeed(10);
      
      EasyBot b = new EasyBot(1, 1, Display.EAST);
      
      for(int i = 0; i < 4; i++) {
         b.beep(3);
      }
      
   }
}
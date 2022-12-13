import edu.fcps.karel2.*;

public class IfPractice {
   public static void main(String[] args) {
      Display.openWorld("maps/ifpractice.map");
      Display.setSize(10, 10);
      Display.setSpeed(10);
      
      Athlete a = new Athlete(1, 1, Display.EAST, 0);
      
      for(int i = 0; i < 50; i++) {
         if (a.frontIsClear()) {
            a.move();
         } else {
            a.turn180();
         }
      }
   
   
   }
}
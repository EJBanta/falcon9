import edu.fcps.karel2.*;

public class AthleteTester {
   public static void main(String[] args) {
   
      Display.openWorld("");
      Display.setSize(10, 10);
      Display.setSpeed(2);
   
      Athlete kobe = new Athlete();
      Athlete tom = new Athlete(3, 2, Display.NORTH, 0);
      
      for(int i = 0; i < 3; i++) {
         kobe.move();
      }
      kobe.turnRight();
      
      for(int i = 0; i < 2; i++) {
         tom.move();
      }
      tom.turn180();
      
   
   }
}
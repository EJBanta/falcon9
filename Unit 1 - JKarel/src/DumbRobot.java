import edu.fcps.karel2.*;

public class DumbRobot {
   public static void main(String[] args) {
      
      Display.setSpeed(10);
      
      EasyBot a = new EasyBot();
            
      //a.tp(5, 5);
      a.tp(3, 4);
      a.tp(8, 9);
      a.beep(34);
      a.m(2);
   }
}
import edu.fcps.karel2.Display; 
import edu.fcps.karel2.Robot;

public class MapTester {
   public static void main(String[] args) {
      Display.openWorld("maps/trapperMapper.map");
      
      Robot gerald = new Robot(1, 1, Display.EAST, Display.INFINITY);
      
      while(true) {
         gerald.putBeeper();
         System.out.println("HELLOTHEREGENERALKENOBI");
      }      
   }
}
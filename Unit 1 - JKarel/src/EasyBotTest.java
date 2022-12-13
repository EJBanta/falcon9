import edu.fcps.karel2.*;

public class EasyBotTest {
   public static void main(String[] args) {
   
      Display.openWorld("");
      Display.setSize(20, 20);
      Display.setSpeed(10);
      
      EasyBot a = new EasyBot();
      
      int teleY = 0;
      int teleX = 0;
      int XorY = 0;
      
      for (int i = 0; i < 400; i++) {
         XorY = (int)(Math.random() * 2);
         if (XorY == 0) {
            teleX += 1;
         } else {
            teleY += 1;
         }
         a.tp(teleX, teleY);
      }
      
   }
}
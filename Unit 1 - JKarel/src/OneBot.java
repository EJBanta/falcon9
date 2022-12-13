import edu.fcps.karel2.*;

public class OneBot extends Robot {
   
   public OneBot() {
      super(1, 1, Display.NORTH, Display.INFINITY);
   }
   
   public OneBot(int x, int y, int dir) {
      super(x, y, dir, Display.INFINITY);
   }
   
   // BaseBot Methods
   public void m(int x) {
      for(int i = 0; i < x; i++) {
         move();
      }
   }
   
   public void beep(int beepnum) {
      for(int i = 0; i < beepnum; i++) {
         putBeeper();
      }
   }
   
   public void unbeep(int beepnum) {
      for(int i = 0; i < beepnum; i++) {
         pickBeeper();
      }
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
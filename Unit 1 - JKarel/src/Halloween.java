import edu.fcps.karel2.*;

public class Halloween {
   public static void main(String[] args) {
      Display.openWorld("maps/halloween.map");
      Display.setSpeed(10);
   
      TrickRTreaterLeft child1 = new TrickRTreaterLeft();
      TrickRTreaterRight child2 = new TrickRTreaterRight();
      
      Thread t1 = new Thread(child1);
      Thread t2 = new Thread(child2);
   
      t1.start();
      t2.start();
   }
}
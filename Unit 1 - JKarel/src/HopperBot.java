import edu.fcps.karel2.*;

public class HopperBot extends EasyBot {
   
   boolean isEnd = false;
   boolean isObstacle = false;

   public HopperBot() {
      super(1, 1, Display.NORTH);
      System.out.print("\n");
      System.out.println("Derivative: HopperBot");

   }
   
   public HopperBot(int x, int y, int dir) {
      super(x, y, dir);
      System.out.print("\n");
      System.out.println("Derivative: HopperBot");
   }
   
   public void run() {
      
      while (frontIsClear() && !nextToABeeper()) {
         move();
      }
      if (!frontIsClear()) {
         isObstacle = true;
         System.out.print("\n");
         System.out.println("HopperBot ran until it found an obstacle.");
         
      } else if (nextToABeeper()) {
         isEnd = true;
      }
   }
   
   public void jump() {
      if (isObstacle == true) {
         turnLeft();
         while (!rightIsClear()) {
            move();
         }
         turnRight();
         move();
         while (!rightIsClear()) {
            move();
         }
         turnRight();
         while (frontIsClear()) {
            move();
         }
         turnLeft();
         isObstacle = false;
         System.out.print("\n");
         System.out.println("HopperBot jumped over an obstacle.");
      } else {
         System.out.print("\n");
         System.out.println("Jumping doesn't work here! Try running instead!");
      }
   }
   
   public void solveBoxTop() {
      while (!nextToABeeper()) {
         run();
         if (isEnd == false) {
            jump();
         }
      }
      pickBeeper();
      System.out.print("\n");
      System.out.println("HopperBot ran and jumped over the top of a box.");
   }
   
}
import edu.fcps.karel2.*;

public class MazeBot extends Athlete {
   public MazeBot() {
      super(1, 1, Display.NORTH, Display.INFINITY);
   }
   
   public MazeBot(int x, int y, int dir) {
      super(x, y, dir, Display.INFINITY);
   }
   
   public void solveMaze1() {
      while (!nextToABeeper()) {
         if (frontIsClear() && !leftIsClear()) {
            move();
         } else if (leftIsClear()) {
            turnLeft();
            move();
         } else if (rightIsClear()) {
            turnRight();
            move();
         } else {
            turn180();
         }
      } 
      System.out.print("\n");
      System.out.println("Solved maze by keeping MazeBot's hand on the left wall.");

   }
   
   public void solveMaze2() {
      boolean run = true;
      
      while (run) {
         if (nextToABeeper()) {
            pickBeeper();
            run = false;
         } else if (frontIsClear() && !rightIsClear()) {
            move();
         } else if (rightIsClear()) {
            turnRight();
            move();
         } else if (leftIsClear()) {
            turnLeft();
            move();
         } else {
            turn180();
         }
      } 
      System.out.print("\n");
      System.out.println("Solved maze by keeping MazeBot's hand on the right wall.");
   }
}
import edu.fcps.karel2.*;

public class TrickRTreaterLeft extends TrickRTreater implements Runnable {
   // Declaring myCandy for public use between two methods
   int myCandy = 0;

   public TrickRTreaterLeft() {
      super(1, 1, Display.NORTH, 0);
   }
   
   public void goToHouse() {
      while (frontIsClear()) {
         move();
      }
   }
   
   public void trick() {
      while (!nextToARobot()) {
         if (frontIsClear() && !leftIsClear()) {
            while (nextToABeeper()) {
               pickBeeper();
               myCandy++;
            }
            move();
         } else if (leftIsClear()) {
            while (nextToABeeper()) {
               pickBeeper();
               myCandy++;
            }
            turnLeft();
            move();
         } else if (rightIsClear()) {
            while (nextToABeeper()) {
               pickBeeper();
               myCandy++;
            }
            turnRight();
            move();
         } else {
            while (nextToABeeper()) {
               pickBeeper();
               myCandy++;
            }
            turn180();
         }
      }
   }
   
   public void goBack() {
      while (!facingSouth()) {
         turnLeft();
      }
      while (frontIsClear()) {
         move();
      }
      turnRight();
      while (frontIsClear()) {
         move();
      }
   }
   
   public void share() {
      int theirCandy = 0;
      int allCandy = 0;
      int sharedCandy = 0;
   
      // Go to spot to place all beepers
      while (!facingNorth()) { 
         turnLeft();
      }
      move();
      // Place all beepers
      while (hasBeepers()) {
         putBeeper();
      }
      // Go to spot other robot has placed all beepers
      for (int i = 0; i < 2; i++) {
         turnRight();
         move();
      }
      // Collect and count all beepers
      while (nextToABeeper() && !nextToARobot()) {
         pickBeeper();
         theirCandy++;
      }
      // Calculations
      allCandy = myCandy + theirCandy;
      sharedCandy = allCandy / 2;
      // Returning to own pile
      for (int i = 0; i < 2; i++) {
        turnRight();
         move();
      }
      // Picking up own candy
      while (nextToABeeper()) {
         pickBeeper();
      }
      // Giving TrickRTreaterRight half of candy
      for (int i = 0; i < sharedCandy; i++) {
         putBeeper();
      }
      // Returning to original position with half of candy
      turn180();
      move();
      turnLeft();
   }
   
   public void flex() {
      for (int i = 0; i < 2; i++) {
         move();
      }
      while (hasBeepers()) {
         putBeeper();
      }
      turnLeft();
      move();
   }

   public void run() {
      goToHouse();
      trick();
      goBack();
      share();
      flex();
   }
}
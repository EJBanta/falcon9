import edu.fcps.karel2.*;

public class TrickRTreaterRight extends TrickRTreater implements Runnable {
   public TrickRTreaterRight() {
      super(1, 1, Display.EAST, 0);
   }
   
   public void goToHouse() {
      while (frontIsClear()) {
         move();
      }
   }
   
   public void trick() {
      @SuppressWarnings("unused")
      int myCandy = 0;
      
      while (!nextToARobot()) {
         if (frontIsClear() && !rightIsClear()) {
            while (nextToABeeper()) {
               pickBeeper();
               myCandy++;
            }
            move();
         } else if (rightIsClear()) {
            while (nextToABeeper()) {
               pickBeeper();
               myCandy++;
            }
            turnRight();
            move();
         } else if (leftIsClear()) {
            while (nextToABeeper()) {
               pickBeeper();
               myCandy++;
            }
            turnLeft();
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
      // Go to spot to place all beepers
      while (!facingEast()) { 
         turnLeft();
      }
      move();
      // Place all beepers
      while (hasBeepers()) {
         putBeeper();
      }
      // Move away from pile to let TrickRTreaterLeft count
      turn180();
      move();
      // Move to new pile's position to wait for candy
      turnRight();
      move();
      // Wait for TrickRTreaterLeft to put down, reclaim, and share candy
      for (int i = 0; i < 2; i++) {
         while (!nextToARobot()) {
            // Note: the best method I found to wait for something to occur without skipping over the while statement was spinning.
            // Assume that TrickRTreaterRight is TrickRTreaterLeft's obnoxious little brother and won't stop spinning while waiting for his candy.
            turnLeft();
         }
         while (nextToARobot()) {
            turnLeft();
         }
      }
      // Collect shared candy
      while (nextToABeeper()) {
         pickBeeper();
      }
      // Go to ending position with shared candy
      while (!facingEast()) {
         turnLeft();
      }
      for (int i = 0; i < 2; i++) {
         move();
         turnRight();
      }
   }
   
   public void flex() {
      move();
      while (hasBeepers()) {
         putBeeper();
      }
      turnRight();
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
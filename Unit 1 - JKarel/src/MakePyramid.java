import edu.fcps.karel2.*;

public class MakePyramid {
   public static void main(String[] args) {
   
      Display.openWorld("");
      Display.setSize(10, 10);
      Display.setSpeed(10);
      
      Athlete a = new Athlete();
      
      //COLUMN 1
      a.putBeeper();
      a.turnRight();
      a.move();
      a.turnLeft();
      
      
      //COLUMN 2
      for(int i = 0; i < 2; i++) {
         a.putBeeper();
         a.move();
      }
      
      a.turn180();
      
      //Return to Ground
      for(int i = 0; i < 2; i++) {
         a.move();
      }
      a.turnLeft();
      a.move();
      a.turnLeft();
      
      
      //COLUMN 3
      for(int i = 0; i < 3; i++) {
         a.putBeeper();
         a.move();
      }
      
      a.turn180();
      
      //Return to Ground
      for(int i = 0; i < 3; i++) {
         a.move();
      }
      a.turnLeft();
      a.move();
      a.turnLeft();
      
      //COLUMN 4
      for(int i = 0; i < 2; i++) {
         a.putBeeper();
         a.move();
      }
      
      a.turn180();
      
      //Return to Ground
      for(int i = 0; i < 2; i++) {
         a.move();
      }
      a.turnLeft();
      a.move();
      a.turnLeft();
      
      //COLUMN 5
      a.putBeeper();
      a.move();
   }
}
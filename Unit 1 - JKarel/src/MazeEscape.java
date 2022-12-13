import edu.fcps.karel2.*;

public class MazeEscape {
   public static void main(String[] args) {
      Display.openWorld("maps/maze4.map");
      Display.setSpeed(10);
   
      Athlete a = new Athlete();
      
      solveMaze(a);
   }
   
   public static void solveMaze(Athlete temp) {
   
      while (!temp.nextToABeeper()) {
               
         // movement starts here
         if (temp.frontIsClear() && !temp.leftIsClear()) {
            temp.move();
         } else if (temp.leftIsClear()) {
            temp.turnLeft();
            temp.move();
         } else if (temp.rightIsClear()) {
            temp.turnRight();
            temp.move();
         } else {
            temp.turn180();
         }
      }
   }
   
}
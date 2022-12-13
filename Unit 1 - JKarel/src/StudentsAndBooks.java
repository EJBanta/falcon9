import edu.fcps.karel2.Display; 
import edu.fcps.karel2.Robot;

public class StudentsAndBooks {
   
   public static void main(String[] args) {
      Display.openWorld("maps/ACL.map"); 
      Display.setSize(10, 10);
      Display.setSpeed(10);
      
      Robot lisa = new Robot();
      Robot pete = new Robot(4,5,3,0);
      Robot librarian = new Robot(6, 9, 2, 0);
      
      lisa.move();
      lisa.move();
      lisa.turnLeft();
      lisa.move();
      lisa.turnLeft();
      lisa.move();
      
      lisa.pickBeeper();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.move();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.move();
      lisa.turnLeft();
      lisa.move();
      lisa.move();
      lisa.move();
      lisa.turnLeft();
      lisa.move();
      lisa.move();
      lisa.move();
      lisa.move();
      lisa.move();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.move();
      lisa.move();
      
      lisa.pickBeeper();
      lisa.turnLeft();
      lisa.move();
      lisa.turnLeft();
      lisa.move();
      lisa.move();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.move();
      lisa.move();
      lisa.turnLeft();
      lisa.move();
      
      lisa.putBeeper();
      lisa.putBeeper();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.move();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.move();
      
      pete.move();
      pete.turnLeft();
      pete.turnLeft();
      pete.turnLeft();
      pete.move();
      
      pete.pickBeeper();
      pete.pickBeeper();
      pete.turnLeft();
      pete.turnLeft();
      pete.move();
      pete.move();
      pete.move();
      pete.turnLeft();
      pete.move();
      pete.move();
      pete.turnLeft();
      pete.turnLeft();
      pete.turnLeft();
      pete.move();
      pete.move();
      pete.turnLeft();
      pete.move();
      pete.turnLeft();
      pete.move();
      pete.move();
      pete.turnLeft();
      pete.turnLeft();
      pete.turnLeft();
      pete.move();
      pete.move();
      pete.putBeeper();
      pete.putBeeper();
      pete.turnLeft();
      pete.turnLeft();
      pete.move();
      
      for (int i = 0; i < 3; i++) {
         for (int t = 0; t < 2; t++) {
            librarian.pickBeeper();
         }
         
         librarian.move();
      }
      
      
      for (int i = 0; i < 3; i++) {
         librarian.pickBeeper();
      }
      
      librarian.move();
      
      for (int i = 0; i < 3; i++) {
         librarian.pickBeeper();
      }
      
      librarian.turnLeft();
      librarian.turnLeft();
      
      for (int i = 0; i < 4; i++) {
         librarian.move();
      }
      
      for (int i = 0; i < 2; i++) {
         librarian.move();
         for (int t = 0; t < 3; t++) {
            librarian.pickBeeper();
         }

      }
      
      for (int i = 0; i < 18; i++) {
         librarian.putBeeper();
      }
      
      librarian.turnLeft();
      librarian.turnLeft();
      librarian.move();
      librarian.move();
      librarian.turnLeft();
      librarian.move();

      
   }

}
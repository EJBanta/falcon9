import edu.fcps.karel2.Display; 
import edu.fcps.karel2.Robot;

public class EasyBot extends Robot {

   static int Botx = 0;
   static int Boty = 0;

   public EasyBot() {
      super(1, 1, Display.NORTH, Display.INFINITY);
      System.out.print("\n");
      System.out.println("Instantiated an EasyBot or one of its derivatives with default constructor. If no derivative named, derivative is EasyBot.");
      Botx = 1;
      Boty = 1;
   }
   
   public EasyBot(int x, int y, int dir) {
      super(x, y, dir, Display.INFINITY);
      System.out.print("\n");
      System.out.println("Instantiated an EasyBot or one of its derivatives with 3-argument constructor. If no derivative named, derivative is EasyBot.");
      Botx = x;
      Boty = y;
   }
   
   public int getXPos() {
      return x;
   }
   
   public int getYPos() {
      return y;
   }
   
   public void tp(int telex, int teley) {
      x = telex; // sets x
      y = teley; // sets y
      for (int i = 0; i < 4; i++) { // reset
         turnLeft();
      }
   }
   
   public void m(int x) {
      int steps = 0;
      String dir = "";
      if (facingNorth()) {
         dir = "north";
      } else if (facingEast()) {
         dir = "east";
      } else if (facingWest()) {
         dir = "west";
      } else if (facingSouth()) {
         dir = "south";
      }

      for(int i = 0; i < x; i++) {
         move();
         steps++;
      }
      System.out.print("\n");
      System.out.println("Moved " + steps + " spaces to the " + dir + ".");
      
      if (dir == "north") {
         Boty = Boty + steps;
      } else if (dir == "south") {
         Boty = Boty - steps;
      } else if (dir == "east") {
         Botx = Botx + steps;
      } else if (dir == "west") {
         Botx = Botx - steps;
      }
      
      System.out.print("\n");
      System.out.println(Botx + ", " + Boty);
   }
   
   public void beep(int beepnum) {
      int beeps = 0;
      for(int i = 0; i < beepnum; i++) {
         putBeeper();
         beeps++;
      }
      System.out.print("\n");
      System.out.println("Placed " + beeps + " beepers.");
   }
      
   public void unbeep(int beepnum) {
      int unbeeps = 0;
      for(int i = 0; i < beepnum; i++) {
         pickBeeper();
         unbeeps++;
      }
      System.out.print("\n");
      System.out.println("Took " + unbeeps + " beepers.");
   }
   
   public void turnRight() {
      for(int i = 0; i < 3; i++) {
         turnLeft();
      }
      System.out.print("\n");
      System.out.println("Turned right.");
   }
   
   public void turn180() {
      for(int i = 0; i < 2; i++) {
         turnLeft();
      }
      System.out.print("\n");
      System.out.println("Turned around.");
   }
   
}
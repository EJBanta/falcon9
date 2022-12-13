import edu.fcps.karel2.*;

public class MazeBotTest {
   public static void main(String[] args) {
   
      Display.openWorld("maps/customMaze2.map");
      Display.setSize(20, 20);
      Display.setSpeed(10);
      
      @SuppressWarnings("unused")
      MazeBot endmarker = new MazeBot(7, 5, Display.EAST);
      MazeBot a = new MazeBot();
      MazeBot b = new MazeBot();
      
      a.solveMaze1();
      b.solveMaze2();
   }
}
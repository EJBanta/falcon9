public class Multitasker extends Athlete {
   
   public Multitasker(int x, int y, int direction, int beepers) {
      super(x, y, direction, beepers);
   }
   
   public void dropAndMove() {
      putBeeper();
      move();
   }
   
   public void moveAndDrop() {
      move();
      putBeeper();
   }
   
   public void goUp(int height) {
      for(int i = 0; i < height; i++) {
         dropAndMove();
      }
   }

   public void goDown(int height) {
      for(int i = 0; i < height; i++) {
         move();
      }
   }
   
   public void moveOver() {
      turnLeft();
      move();
      turnLeft();
   }

}
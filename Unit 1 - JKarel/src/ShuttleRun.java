import edu.fcps.karel2.*;

public class ShuttleRun {
   public static void runTheRace(Racer temp) {
      shuttle(3, 5, temp); // collect first pile
      shuttle(5, 2, temp); // collect second pile
      shuttle(6, 3, temp); // collect third pile
      shuttle(9, 7, temp); // collect fourth pile
      temp.turnLeft(); // turn left to...
      temp.move(); // move away from the pile and show 17 beepers

   }

   public static void shuttle(int moveNum, int beepNum, Racer temp) {
      temp.move(); // move to the hurdle
      temp.jumpRight(); // jump over the hurdle to the right
      temp.sprint(moveNum); // move to the beeper pile
      temp.pick(beepNum); // pick up all the beepers in the pile
      temp.turn180(); // turn around
      temp.sprint(moveNum); // move back to the hurdle
      temp.jumpLeft(); // jump over the hurdle to the left
      temp.move(); // move back to the start
      temp.put(beepNum); // put down the beepers in a pile
      temp.turn180(); // prepare to repeat by turning around
   }

   public static void main(String[] args) {
      // setup
      Display.openWorld("maps/shuttleRun.map");
      Display.setSize(13, 10);
      Display.setSpeed(10);
      
      // instantiate racers
      Racer a = new Racer(1);
      Racer b = new Racer(4);
      Racer c = new Racer(7);
      
      // run the race
      runTheRace(a);
      runTheRace(b);
      runTheRace(c);
      
   }
}
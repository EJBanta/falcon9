import edu.fcps.karel2.*;
import java.util.*;

public class SnakeBotSolved {
   public static void main(String[] args) {
      
      // World setup
      Display.openWorld("maps/snake30.map");
      Display.setSize(30, 30);
      Display.setSpeed(10);
      
      // Variable setup
      ArrayList<EasyBot> bots = new ArrayList<EasyBot>(); /* keeps track of all the robots on screen */
      int headY = 1; /* note: actually the y value of the point above the head of the robot */
      int headX = 1;
      
      int length = 5;   
      createSnake(length, bots, headY);
      
      placeRandomBeeper();
      
      headY = (length + 1);
      
      headX = 10;
      
      playSnake(bots, headY, headX);
            
   }
   
   
   public static void createSnake(int x, ArrayList<EasyBot> bots, int headY) {
      
      for (int y = 1; y <= x /* x = length of snake */; y++) {
         EasyBot a = new EasyBot(10, y, Display.NORTH);
         bots.add(a);
         headY++;
      }
   }
   
   
   public static void placeBeeper(int x, int y) {
   
      // places a beeper in a place
      EasyBot beeper = new EasyBot(x, y, Display.NORTH);
      beeper.putBeeper();
      beeper.explode();
      
   }
   
   public static void placeRandomBeeper() {
   
      // places a beeper in a place
      EasyBot beeper = new EasyBot((int)(Math.random() * 20) + 1, (int)(Math.random() * 20) + 1, Display.NORTH);
      beeper.putBeeper();
      beeper.explode();
      
   }
   
   public static void playSnake(ArrayList<EasyBot> bots, int headY, int headX) {
      boolean run = true;
      
      @SuppressWarnings("unused")
      ArrowKeys keys = new ArrowKeys();
      
      int snakedir = 1;
      /* 
      1 = up/north,
      2 = right/east,
      3 = down/south,
      4 = left/west
      */
      
      while (run) {
         
         // defines key bots
         EasyBot lastBot = bots.get(0);
         EasyBot firstBot = bots.get(bots.size() - 1);
         EasyBot secondBot = bots.get(bots.size() - 2);
         EasyBot testBot;
         boolean turnedAlready = false;
         
         if (snakedir == 1) {
            testBot = new EasyBot((firstBot.getXPos()), (firstBot.getYPos() + 1), Display.NORTH);
         } else if (snakedir == 2) {
            testBot = new EasyBot((firstBot.getXPos() + 1), (firstBot.getYPos()), Display.EAST);
         } else if (snakedir == 3) {
            testBot = new EasyBot((firstBot.getXPos()), (firstBot.getYPos() - 1), Display.SOUTH);
         } else if (snakedir == 4) {
            testBot = new EasyBot((firstBot.getXPos() - 1), (firstBot.getYPos()), Display.WEST);
         } else {
            testBot = new EasyBot((firstBot.getXPos()), (firstBot.getYPos() + 1), Display.NORTH);
         }
         
         // determines bot direction
         if (snakedir == 4 && turnedAlready == true) {
            snakedir = 1;
            turnedAlready = false;
         } else if (snakedir == 1 && !testBot.frontIsClear()) {
            snakedir = 2;
            turnedAlready = true;
         } else if (snakedir == 2 && turnedAlready == true) {
            snakedir = 3;
            turnedAlready = false;
         } else if (snakedir == 3 && !testBot.frontIsClear()) {
            snakedir = 4;
            turnedAlready = true;
         }
         testBot.explode();
         
         // new bot
         if (snakedir == 1) {
            EasyBot a = new EasyBot(headX, headY, Display.NORTH);
            bots.add(a);
            headY++;
         } else if (snakedir == 2) {
            EasyBot a = new EasyBot(headX, headY, Display.EAST);
            bots.add(a);
            headX++;
         } else if (snakedir == 3) {
            EasyBot a = new EasyBot(headX, headY, Display.SOUTH);
            bots.add(a);
            headY--;
         } else if (snakedir == 4) {
            EasyBot a = new EasyBot(headX, headY, Display.WEST);
            bots.add(a);
            headX--;
         }
            
         // remove last bot
         lastBot.explode();
         bots.remove(lastBot);
         
         
         // check for beeper
         if (firstBot.nextToABeeper()) {
            
            // picks up beeper
            firstBot.pickBeeper();
            
            // extends snake length by creating an additional robot
            if (snakedir == 1) {
               EasyBot a = new EasyBot(headX, headY, Display.NORTH);
               bots.add(a);
               headY++;
               snakedir = 1;
            } else if (snakedir == 2) {
               EasyBot a = new EasyBot(headX, headY, Display.EAST);
               bots.add(a);
               headX++;
               snakedir = 2;
            } else if (snakedir == 3) {
               EasyBot a = new EasyBot(headX, headY, Display.SOUTH);
               bots.add(a);
               headY--;
               snakedir = 3;
            } else if (snakedir == 4) {
               EasyBot a = new EasyBot(headX, headY, Display.WEST);
               bots.add(a);
               headX--;
               snakedir = 4;
            }
            
            // puts a new beeper somewhere
            placeRandomBeeper();
         }
         
         if (secondBot.nextToARobot()) {
            System.out.print("\n");
            System.out.println("You ran into yourself and lost!");
            System.out.print("\n");
            System.out.println("You scored " + (bots.size()) + " points!");
            System.exit(0);
         }
         
         if (!secondBot.frontIsClear()) {
            System.out.print("\n");
            System.out.println("You ran into a wall and lost!");
            System.out.print("\n");
            System.out.println("You scored " + (bots.size()) + " points!");
            System.exit(0);
         }
         
      }

   }
}
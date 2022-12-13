package AngryRobots;
//ITCS and Physics - Integrated Projectile Project

import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import javax.swing.JOptionPane;

public class AngryRobotsPt1 {

   // global variables
   // These can be used in any method in this program without having to pass the variable as a parameter
   // Note that Ay and Ax are declared final, they cannot be changed   
   public static final double Ay = -9.8;
   public static final double Ax = 0;
   public static double v0 = 0; 
   public static double angleDegrees = 0;
   public static double y = 0.0;
   public static double x = 0.0;
   public static double v0x = 0.0;
   public static double v0y = 0.0;
   public static double t = 0.0;
   public static double dt = 0.2;
   public static double maxY = 0;  
   
   public static void main(String[] args){
      // Open default map and set speed
      Display.setSize(100, 100);
      Display.setSpeed(8);
       
      // User input to define initial velocity and launch angle
      // the parseDouble method converts the string input to a double
      v0 = Double.parseDouble(JOptionPane.showInputDialog("Please enter an initial velocity in m/s"));
      angleDegrees = Double.parseDouble(JOptionPane.showInputDialog("Please enter an initial angle in degrees"));
   
      v0x = Math.cos(Math.toRadians(angleDegrees)) * v0;
      System.out.println(Math.cos(Math.toRadians(angleDegrees)));
      v0y = v0 * Math.sin(Math.toRadians(angleDegrees));
      
      
      for (t = 0.0; y >= 0.0; t += dt) {
    	  x = v0x * t;
    	  y = (v0y * t) + (-4.9 * Math.pow(t, 2));
    	  if (y > maxY) {
    		  maxY = y;
    	  }
    	  System.out.println("For time value " + t + " x is equal to " + x + ".");
    	  System.out.println("For time value " + t + " y is equal to " + y + ".");
    	  Robot john = new Robot((int)x, (int)y, Display.NORTH, 0);
        john.getClass();
      }
      
      Display.setSize((int)x, (int)maxY);
      
   }

}
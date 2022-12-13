//Calculator2.java
//ITCS
import javax.swing.JOptionPane;
import edu.fcps.karel2.*;

public class Calculator2 {
   public static void main(String[] args) {
      double value1 = Double.parseDouble(JOptionPane.showInputDialog("Enter vector angle in degrees."));
      double value2 = Double.parseDouble(JOptionPane.showInputDialog("Enter vector magnitude."));
      System.out.println("The x component of this vector is " + getXComponent(value1, value2) + ".");
      System.out.println("The y component of this vector is " + getYComponent(value1, value2) + ".");
      
      System.out.print("\n");
      
      int value3 = Integer.parseInt(JOptionPane.showInputDialog("Enter rise value."));
      int value4 = Integer.parseInt(JOptionPane.showInputDialog("Enter run value."));
      plotLine(value3, value4);
      
      System.out.print("\n");
      
      int value5 = Integer.parseInt(JOptionPane.showInputDialog("Enter quadratic equation coefficient a."));
      int value6 = Integer.parseInt(JOptionPane.showInputDialog("Enter quadratic equation coefficient b."));
      int value7 = Integer.parseInt(JOptionPane.showInputDialog("Enter quadratic equation coefficient c."));
      System.out.println("For the quadratic equation: " + value5 + "x^2" + " + " + value6 + "x" + " + " + value7 + " = 0, the roots are: " + getQuadraticMinus(value5, value6, value7) + " and " + getQuadraticPlus(value5, value6, value7) + ".");
      
      System.out.print("\n");
      
      double value8 = Double.parseDouble(JOptionPane.showInputDialog("Enter initial projectile velocity in meters per second."));
      double value9 = Double.parseDouble(JOptionPane.showInputDialog("Enter projectile launch angle in degrees."));
      System.out.println("If a projectile is launched with an initial velocity of " + value8 + " m/s ");
      System.out.println("and a launch angle of " + value9 + " degrees then the x-component of ");
      System.out.println("the initial velocity is " + getInitXComponent(value8, value9));
      System.out.println("and the y-component of the initial velocity is " + getInitYComponent(value8, value9) + ".");
      System.out.println("The projectile will be in the air for " + getHangTime(value8, value9));
      System.out.println("and will travel a horizontal distance of " + getXRange(value8, value9) + ".");
      
      // Sorry about the messy printing for the projectile calculator
      // I tried my best to make it fit
   }
   
   public static double getXComponent(double angleDegrees, double hypotenuse) {
      return Math.cos(Math.toRadians(angleDegrees)) * hypotenuse;
   }
   
   public static double getYComponent(double angleDegrees, double hypotenuse) {
      return Math.sin(Math.toRadians(angleDegrees)) * hypotenuse;
   }
   
   public static void plotLine(int rise, int run) {
      System.out.println("First Five Points");
      for (int i = 1; i <= 5; i++) {
         System.out.println("(" + rise * i + ", " + run * i + ")");
      }
      
      Display.openWorld("");
      Display.setSize(20, 20);
      
      for (int i = 1; i <= 5; i++) {
         @SuppressWarnings("unused")
         Robot a = new Robot(rise * i, run * i, Display.NORTH, 0);
      }
   }
   
   public static double getQuadraticPlus(double a, double b, double c) {
      return ((-1 * b) + Math.sqrt((Math.pow(b, 2) - 4 * a * c)))/(2 * a);
   }
   
   public static double getQuadraticMinus(double a, double b, double c) {
      return ((-1 * b) - Math.sqrt((Math.pow(b, 2) - 4 * a * c)))/(2 * a);
   }
   
   public static double getInitXComponent(double v, double angle) {
      return v * Math.cos(Math.toRadians(angle));
   }
   
   public static double getInitYComponent(double v, double angle) {
      return v * Math.sin(Math.toRadians(angle));
   }
   
   public static double getHangTime(double v, double angle) {
      return getQuadraticMinus(-4.9, getInitYComponent(v, angle), 0);
   }
   
   public static double getXRange(double v, double angle) {
      return getInitXComponent(v, angle) * getHangTime(v, angle);
   }

}
//Calculator.java
//ITCS
//The purpose of this class is to practice writing class methods that return calculated values using the java Math class.  
import javax.swing.JOptionPane;

public class Calculator {
  
   public static void main(String[] args) {
		// Dialogue box allows user input for the values to be calculated and parses them to doubles	
      double value1 = Double.parseDouble(JOptionPane.showInputDialog("Please enter first value"));
      double value2 = Double.parseDouble(JOptionPane.showInputDialog("Please enter second value"));
		
      System.out.println("Addition: "+ value1+" + "+value2+" = "+add(value1,value2));
      System.out.println("Subtraction: "+ value1+" - "+value2+" = "+subtract(value1,value2));
      System.out.println("Multiplication: "+ value1+" * "+value2+" = "+multiply(value1,value2));
      System.out.println("Division: "+ value1+" / "+value2+" = "+divide(value1,value2));
      System.out.println("Maximum value: "+ findMax(value1,value2));
      System.out.println("Minimum value: "+ findMin(value1,value2));
      System.out.println("Square root of "+ value1+":"+ " = "+ squareRoot(value1));
      System.out.println("Power: "+ value1+"^"+value2+" = "+ power(value1,value2));
      System.out.println("Pythagorean: for c = " + value1 + " and a = " + value2 + " then b = " + pythagorean(value1, value2));
    
  }
  
   // Example method: add method returns the sum of two doubles
   public static double add(double input1, double input2){
      return input1 + input2;
   }
  
   // Find the difference of input1 and input2
   public static double subtract(double input1, double input2) {
      return input1 - input2;
   }
   
   public static double multiply(double input1, double input2) {
      return input1 * input2;
   }
   
   public static double divide(double input1, double input2) {
      return input1 / input2;
   }

   public static double findMax(double input1, double input2) {
      return Math.max(input1, input2);
   }
   
   public static double findMin(double input1, double input2) {
      return Math.min(input1, input2);
   }
   
   public static double squareRoot(double input1) {
      return Math.sqrt(input1);
   }
   
   public static double power(double input1, double input2) {
      return Math.pow(input1, input2);
   }

   public static double pythagorean(double input1, double input2) {
      return Math.sqrt(Math.pow(input1, 2) - Math.pow(input2, 2));
   }
   
}
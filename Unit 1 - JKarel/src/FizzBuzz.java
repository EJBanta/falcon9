public class FizzBuzz {
   public static void main(String[] args) {
      for (int i = 1; i <= 1000; i++) {
         String output = "";
         
         if (i % 3 == 0) {
            output += "Fizz";
         } 
         if (i % 5 == 0) {
            output += "Buzz";
         }
         if (i % 8 == 0) {
            output += "Fuzz";
         }
         if (i % 9 == 0) {
            output += "Biff";
         }
         if (i % 12 == 0) {
            output += "Fazz";
         }
         if (i % 3 != 0 && i % 5 != 0 && i % 8 != 0 && i % 9 != 0 && i % 12 != 0) {
            output = String.valueOf(i);
         }
         
         System.out.println(output);
      }
   }
}
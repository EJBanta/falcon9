import java.util.Scanner;

public class ScannerPractice {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter two numbers.");
        
        int num1 = s.nextInt();
        int num2 = s.nextInt();

        int sum = num1 + num2;
        System.out.println("The sum of those two numbers is " + sum + ".");

        Scanner s2 = new Scanner(System.in);
        System.out.println("Please enter your name.");

        String name = s2.nextLine();
        System.out.println("Hello, " + name + ".");

        s.close();
        s2.close();
    }
}

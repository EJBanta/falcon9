import javax.swing.JOptionPane;
public class ConvertToDMY {
   public static void main(String[] args) {
      int days = Integer.parseInt(JOptionPane.showInputDialog("Enter number of days."));
      
      int years = days / 365;
      
      int months = (days % 365) / 30;
      
      int daysRemaining = days % 365 - months * 30;
            
      System.out.println(days + " days is " + years + " years " + months + " months, and " + daysRemaining + " days.");
   }
}
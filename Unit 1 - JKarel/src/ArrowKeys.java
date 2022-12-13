import javax.swing.*;
import java.awt.event.*;

public class ArrowKeys {
   
   // Key press counter variables
   private int upCount = 1;
   private int downCount = 1;
   private int leftCount = 1;
   private int rightCount = 1;
   
   // Currently pressing key? variables
   private boolean upIsPressed = false;
   private boolean downIsPressed = false;
   private boolean leftIsPressed = false;
   private boolean rightIsPressed = false;
   
   // Returns number of times the up key has been pressed
   public int getUpCount() {
      return upCount;
   }
   public int getDownCount() {
      return downCount;
   }
   public int getLeftCount() {
      return leftCount;
   }
   public int getRightCount() {
      return rightCount;
   }
   
   // Returns if the key is pressed
   public boolean getUpIsPressed() {
      return upIsPressed;
   }
   public boolean getDownIsPressed() {
      return downIsPressed;
   }
   public boolean getLeftIsPressed() {
      return leftIsPressed;
   }
   public boolean getRightIsPressed() {
      return rightIsPressed;
   }
   
   public ArrowKeys() {
      
      // Creates window
      JFrame frame = new JFrame();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 400);
      frame.setLocation(0, 0);
      frame.setFocusable(true);
      frame.toFront();
      frame.requestFocus();
      
      // Creates panel and labels
      JPanel panel = new JPanel();
      JLabel up = new JLabel();
      JLabel down = new JLabel();
      JLabel left = new JLabel();
      JLabel right = new JLabel();
      
      // Puts labels on panel
      panel.add(up);
      panel.add(down);
      panel.add(left);
      panel.add(right);
      
      // Adding text to the labels
      up.setText("UP: 0");
      down.setText("DOWN: 0");
      left.setText("LEFT: 0");
      right.setText("RIGHT: 0");
      
      // Creates key listener
      frame.addKeyListener(new KeyListener() {
         
         @Override
         public void keyTyped(KeyEvent e) {
            // nothing
         }
         
         // Detects when a key is pressed with switch and modifies both the
         // __Count variable and the label itself
         @Override
         public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch(keyCode) {
               case KeyEvent.VK_UP:
                  up.setText("UP: " + Integer.toString(upCount++));
                  upIsPressed = true;
                  break;
               case KeyEvent.VK_DOWN:
                  down.setText("DOWN: " + Integer.toString(downCount++));
                  downIsPressed = true;
                  break;
               case KeyEvent.VK_LEFT:
                  left.setText("LEFT: " + Integer.toString(leftCount++));
                  leftIsPressed = true;
                  break;
               case KeyEvent.VK_RIGHT:
                  right.setText("RIGHT: " + Integer.toString(rightCount++));
                  rightIsPressed = true;
                  break;
            }
         }
         
         @Override
         public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch(keyCode) {
               case KeyEvent.VK_UP:
                  upIsPressed = false;
                  break;
               case KeyEvent.VK_DOWN:
                  downIsPressed = false;
                  break;
               case KeyEvent.VK_LEFT:
                  leftIsPressed = false;
                  break;
               case KeyEvent.VK_RIGHT:
                  rightIsPressed = false;
                  break;
            }

         }
      });
    
      
      // Puts panel on window
      frame.add(panel);
      
   }
}
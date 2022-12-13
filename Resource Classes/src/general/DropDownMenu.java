package general;

import javax.swing.*;

public class DropDownMenu {
    private String title;
    private String message;
    private String[] options;
    private int startingoption;

    public DropDownMenu(String t, String m, String[] o, int s) {
        title = t;
        message = m;
        options = o;
        startingoption = s;
    }

    public String showMenu() {
        //i solved my problem adding the following 2 lines of code...
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        //...and passing `frame` instead of `null` as first parameter
        Object selectionObject = JOptionPane.showInputDialog(frame, message, title, JOptionPane.PLAIN_MESSAGE, null, options, options[startingoption - 1]);
        String selectionString = selectionObject.toString();
        return selectionString;
    }
}

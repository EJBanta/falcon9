package WinterWonderland;

import java.awt.geom.AffineTransform;
import java.awt.*;
import javax.swing.*;

public class SmallSign extends JPanel { 
    private int xPos;
    private int yPos;
    private Color color1;
    private Color color2;
    private Color textColor;


    public SmallSign(int x, int y, Color c1, Color c2, Color t, Graphics g) {
        xPos = x;
        yPos = y;
        color1 = c1;
        color2 = c2;
        textColor = t;

        draw(g);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        //int xPos2 = xPos - 23;
        //int yPos2 = yPos - 39;

        // Sign post
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(15), xPos, yPos);
        g.setColor(color2);
        g.fillRect(xPos, yPos, 8, 28);
        g2d.setTransform(old);

        // Sign Body
        old = g2d.getTransform();
        g2d.rotate(Math.toRadians(15), ((xPos) + (xPos - 23)) / 2, ((yPos) + (yPos - 39)) / 2);
        g.setColor(color1);
        g.fillRect(xPos - 23, yPos - 39, 68, 43);
        g2d.setTransform(old);

        // Sign Text
        old = g2d.getTransform();
        g2d.rotate(Math.toRadians(15), ((xPos) + (xPos - 23)) / 2, ((yPos) + (yPos - 39)) / 2);
        g.setColor(textColor);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        g.drawString("1 = 2", xPos - 11, yPos - 12);
        g2d.setTransform(old);
    }
}

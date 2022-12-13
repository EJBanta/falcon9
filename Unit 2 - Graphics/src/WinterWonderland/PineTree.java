package WinterWonderland;

import java.awt.*;

public class PineTree {
    private int xPos;
    private int yPos;
    private Color greenColor;
    private Color trunkColor;

    public PineTree(int x, int y, Color gc, Color tc, Graphics g) {
        xPos = x;
        yPos = y;
        greenColor = gc;
        trunkColor = tc;

        draw(g);
    }

    public void draw(Graphics g) {
        // Trunk
        g.setColor(trunkColor);
        g.fillRect(xPos, yPos, 26, 51);
        
        // Green x - 41; 
        g.setColor(greenColor);
        int[] xPoints = {xPos - 41, xPos + 13, xPos + 66};
        int[] yPoints = {yPos + 23, yPos - 166, yPos + 23};
        g.fillPolygon(xPoints, yPoints, xPoints.length);


    }
}

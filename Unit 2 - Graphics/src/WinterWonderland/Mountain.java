package WinterWonderland;

import java.awt.*;

public class Mountain {
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color color;
    private boolean hasSnow;
    private Color snow1;
    private Color snow2;

    // Triangle drawn from bottom left to top right
    public Mountain(int x, int y, int w, int h, Color c, boolean s, Color s1, Color s2, Graphics g) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        color = c;
        hasSnow = s;
        snow1 = s1;
        snow2 = s2;

        draw(g);

        /*  Original
            Width 15.05 | Height 4.57
            X -2.61 | Y 5.87

            Snow
            Width 4 | Height 1.22
            X 2.91 | Y 1.52

            Snow Shadow
            Width 4.34 | Height 1.32
            X 2.74 | Y 1.62
        */  
        

    }

    public void draw(Graphics g) {
        // Draw the mountain
        g.setColor(color);
        int[] xPoints = {xPos, xPos + width / 2, xPos + width};
        int[] yPoints = {yPos, yPos - height, yPos};
        g.fillPolygon(xPoints, yPoints, xPoints.length);

        // Draw snow
        if (hasSnow == true) {
            createSnow(3.46, snow2, g);
            createSnow(3.76, snow1, g);
        }
    }

    public void createSnow(double factor, Color color, Graphics g) {
        double centroidx = xPos + width / 2;
        double centroidy = yPos - (height / 3);
        double yInc = (yPos - height) - (centroidy - ((height / factor) / 2));

        g.setColor(color);
        int[] xPoints = {(int)(centroidx - ((width / factor) / 2)), (int)(centroidx), (int)(centroidx + ((width / factor) / 2))};
        int[] yPoints = {(int)(centroidy + ((height / factor) / 2) + yInc), (int)(centroidy - ((height / factor) / 2) + yInc), (int)(centroidy + ((height / factor) / 2) + yInc)};
        g.fillPolygon(xPoints, yPoints, xPoints.length);
    }
}

package graphics;

import java.awt.*;

public class fillGradient {
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color color1;
    private Color color2;

    public fillGradient(int x, int y, int w, int h, Color c1, Color c2, Graphics g) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        color1 = c1;
        color2 = c2;

        draw(g);
    }

    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        GradientPaint sky = new GradientPaint(xPos, yPos, color1, width, height, color2);

        g2D.setPaint(sky);
        g2D.fillRect(xPos, yPos, width, height);
    }
}

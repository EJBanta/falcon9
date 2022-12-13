package WinterWonderland;

import java.awt.*;

public class Cloud {
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color color;
    private int density;

    public Cloud(int x, int y, int w, int h, Color c, int d, Graphics g) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        color = c;
        density = d;

        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        int xPlusMinus;
        int yPlusMinus;

        for (int i = 0; i < density; i++) {
            if ((int)(Math.random() * 99 + 1) % 2 == 0) {
                xPlusMinus = 1;
            } else {
                xPlusMinus = -1;
            }
    
            if ((int)(Math.random() * 99 + 1) % 2 == 0) {
                yPlusMinus = 1;
            } else {
                yPlusMinus = -1;
            }

            g.fillOval(xPos + (width/2) + (int)(Math.random() * (width/3) * xPlusMinus), yPos + (height/2) + (int)(Math.random() * (height/3) * yPlusMinus), (int)(width / 3.2), (int)(height / 2.2));
        }
    }
    
}

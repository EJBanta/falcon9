package WinterWonderland;
import java.awt.*;

public class Snowflake {
    int xPos;
    int yPos;
    int width;
    int height;
    Color color;

    public Snowflake(int x, int y, int w, int h, Color c, Graphics g) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        color = c;
    }

    public void draw(Graphics g) {
        int centerX = xPos + (width/2);
        int centerY = yPos + (height/2);

        g.setColor(color);

        // lines
        g.drawLine(centerX, centerY, centerX, centerY - (height/2) * 2);
        g.drawLine(centerX, centerY, centerX, centerY + (height/2) * 2);
        g.drawLine(centerX, centerY, centerX + (width/1), (int)((centerY - (height/2))));
        g.drawLine(centerX, centerY, centerX + (width/1), (int)((centerY + (height/2))));
        g.drawLine(centerX, centerY, centerX - (width/1), (int)((centerY - (height/2))));
        g.drawLine(centerX, centerY, centerX - (width/1), (int)((centerY + (height/2))));

        // Hexagon
        g.drawLine(centerX, centerY - (height/2), centerX + (width/2), (int)((centerY - (height/4))));
        g.drawLine(centerX + (width/2), (int)((centerY - (height/4))), centerX + (width/2), (int)((centerY + (height/4))));
        g.drawLine(centerX + (width/2), (int)((centerY + (height/4))), centerX, centerY + (height/2));
        g.drawLine(centerX, centerY + (height/2), centerX - (width/2), (int)((centerY + (height/4))));
        g.drawLine(centerX - (width/2), (int)((centerY + (height/4))), centerX - (width/2), (int)((centerY - (height/4))));
        g.drawLine(centerX - (width/2), (int)((centerY - (height/4))), centerX, centerY - (height/2));
    }
}

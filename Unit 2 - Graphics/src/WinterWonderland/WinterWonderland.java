package WinterWonderland;
import java.awt.*;
import javax.swing.*;
import graphics.*;

public class WinterWonderland extends JPanel {
    // Frame Constants
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 750;

    // Color Constants
    public static final Color SKY1 = new Color(137, 195, 233);
    public static final Color SKY2 = new Color(110, 154, 231);
    public static final Color SNOW = new Color(243, 243, 243);
    public static final Color CLOUD1 = new Color(217, 217, 217);
    public static final Color CLOUD2 = new Color(204, 204, 204);
    public static final Color TREE1 = new Color(39, 78, 19);
    public static final Color TREE2 = new Color(60, 85, 48);
    public static final Color TRUNK1 = new Color(94, 84, 75);
    public static final Color TRUNK2 = new Color(94, 87, 82);
    public static final Color MTN1 = new Color(212, 220, 228);
    public static final Color MTN2 = new Color(182, 193, 202);
    public static final Color MTN3 = new Color(192, 203, 213);
    public static final Color SIGN1 = new Color(180, 115, 47);
    public static final Color SIGN2 = new Color (165, 108, 48);

    public void paintComponent(Graphics g) {
        drawGround(g);
        drawSky(g);
        drawMountains(g);
        drawGrass(g);
        drawSign(g);
        drawTrees(g);
        drawClouds(g);
        drawSnow(g);
    }

    public static void drawGround(Graphics g) {
        g.setColor(SNOW);
        g.fillRect(0, 587, WIDTH, HEIGHT);
    }

    public static void drawSky(Graphics g) {
        new fillGradient(0, 0, WIDTH, 587, SKY1, SKY2, g);
    }

    public static void drawMountains(Graphics g) {
        // Mountain 2, back layer
        new Mountain(-261, 587, 1505, 457, MTN2, true, SNOW, CLOUD1, g);

        // Mountain 3, middle layer
        new Mountain(332, 587, 993, 301, MTN3, true, SNOW, CLOUD1, g);

        // Mountain 1, front layer
        new Mountain(-432, 587, 1193, 362, MTN1, true, SNOW, CLOUD1, g);
    }

    public static void drawGrass(Graphics g) {
        g.setColor(TREE1);
        int x1;
        int y1;
        for (int i = 0; i < 20; i++) {
            x1 = (int)(Math.random() * WIDTH);
            y1 = (int)(Math.random() * (HEIGHT - 587) + 599);
            g.drawLine(x1, y1, x1, y1 - 12);
        }
    }

    public static void drawSign(Graphics g) {
        new SmallSign(811, 686, SIGN1, SIGN2, Color.BLACK, g);
    }

    public static void drawTrees(Graphics g) {
        for (int i = 0; i < 6; i++) {
            new PineTree((76 + i * 162), 600 + (int)(Math.random() * 35 - 17.5), TREE2, TRUNK2, g);
        }

        for (int i = 0; i < 7; i++) {
            new PineTree(-5 + i * 162, 583 + (int)(Math.random() * 35 - 17.5), TREE1, TRUNK1, g);
        }
    }

    public static void drawClouds(Graphics g) {
        new Cloud(-19, -11, 191, 132, CLOUD1, 22, g);
        new Cloud(234, 14, 209, 144, CLOUD2, 22, g);
        new Cloud(527, -11, 157, 109, CLOUD1, 22, g);
        new Cloud(735, 46, 233, 160, CLOUD2, 22, g);
    }

    public static void drawSnow(Graphics g) {
        int width;
        Color color;
        Snowflake[] snowflakes = new Snowflake[500];
        for (int i = 0; i < 500; i++) {
            // Old snow
            //g.setColor(new Color(243, 243, 243, (int)(Math.random() * 255)));
            //g.fillOval((int)(Math.random() * WIDTH), (int)(Math.random() * (HEIGHT - 233) + 233), 28, 28);
            
            // Fancy snow
            width = (int)(Math.random() * 14 + 1);
            color = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
            snowflakes[i] = new Snowflake((int)(Math.random() * WIDTH), (int)(Math.random() * (HEIGHT - 233) + 233), width, (int)(width * 1.1547005), color, g);
        }

        for (int i = 0; i < snowflakes.length; i++) {
            snowflakes[i].draw(g);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("WinterWonderland");
        frame.setSize(WIDTH, HEIGHT + 37);
        frame.setLocation (50, 0);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new WinterWonderland());
        frame.setVisible(true);
    }
}
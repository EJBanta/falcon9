package Falcon9;

//required import statements
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Falcon9LiftOff extends JPanel {
	private static final double DT = 0.05;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;

	// required global variables
	private BufferedImage image;
	private Graphics g;
	private Timer timer;
	private Falcon9 f;

	// Constructor required by BufferedImage
	public Falcon9LiftOff() {

		// Setup Buffered Image and Graphics objects
		image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
		
		// Setup background
		g.setColor(new Color(28, 45, 112).darker());
        g.fillRect(0, 0, WIDTH, HEIGHT);

		// Setup rocket
		f = new Falcon9(WIDTH/2, HEIGHT, 8, 30);
		f.setDT(DT);
		f.setDM(398900 * (f.getDT() / 162));

		// Setup and start the Timer
		timer = new Timer((int)(DT * 1000), new TimerListener());
		timer.start();
	}
	
	// TimerListener class that is called repeatedly by the timer
	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			drawBackground(g);
			if (f.getT() <= 162) {
				System.out.println(f.getT() + "," + f.getM() + "," + f.getF() + "," + f.getA() + "," + f.getV() + "," + f.getH());
				f.move(HEIGHT, g);
			}
			if (f.getT() > 162 && f.getT() < 162 + DT*2 - 0.0000001) { // Awkward transition to stage 2
				f.setM(96570);
				f.setDM(92670 * (f.getDT() / 235));
				f.setFT(934000);
			}
			if (f.getT() <= 397 && f.getT() > 162) {
				System.out.println(f.getT() + "," + f.getM() + "," + f.getF() + "," + f.getA() + "," + f.getV() + "," + f.getH());
				f.move(HEIGHT, g);
			}

			repaint(); // leave this alone, it MUST  be the last thing in this method
		}
		
	}

	public static void drawBackground(Graphics g) {
		g.setColor(new Color(28, 45, 112).darker());
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}

	// DO NOT MODIFY THIS
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

	// Main method with standard graphics code
	public static void main(String[] args) {
		JFrame frame = new JFrame("Animation Shell");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Falcon9LiftOff());
		frame.setVisible(true);
	}
}

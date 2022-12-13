package AngryRobots;
//ITCS and Physics - Integrated Projectile Project

import general.DropDownMenu;
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import javax.swing.JOptionPane;

public class AngryRobotsPt2E {

	/* GLOBAL VARIABLES */
	
	// Acceleration
	public static double g = -9.8;
	public static final double Ax = 0;
	
	// Setup Parameters
	public static double v0 = 0.0;
	public static double angleDegrees = 0.0;
	public static double h = 0.0; // Starting height
	public static double m = 0.0; // Mass (UNUSED)
	public static double c = 0.0; // Drag coefficient (UNUSED)
	public static double rho = 0.0; // Air Density (UNUSED)
	
	// Position
	public static double y = 0.0;
	public static double x = 0.0;
	public static double maxHeight = 0.0;
	
	// Velocity
	public static double v0x = 0.0;
	public static double v0y = 0.0;
	
	// Time
	public static double t = 0.0;
	public static double dt = 0.2;
	
	// Goal Variables
	public static double targetx = 0;

	
	
	/* MAIN METHOD */
	
	public static void main(String[] args) {
		// Open default map and set speed
		Display.openWorld("");
		Display.setSize(100, 100);
		Display.setSpeed(10);
		
		// User input and parsing is all contained in setupAndRun function
		setupAndRun();

	}

	/* FINDING VARIABLES AND PARAMETERS */
	
	public static double getInitX(double v0, double angleDegrees) {
		return v0 * Math.cos(Math.toRadians(angleDegrees));
	}

	public static double getInitY(double v0, double angleDegrees) {
		return v0 * Math.sin(Math.toRadians(angleDegrees));
	}

	public static double getXPos(double v0x, double t) {
		// takes initial x velocity and time
		// method outputs x position at any given moment
		return v0x * t;
	}

	public static double getYPos(double v0y, double t) {
		// takes initial y velocity and time
		// method outputs y position at any given moment
		// y = v0y * t + g/2 * t^2
		return (v0y * t) + ((g / 2) * Math.pow(t, 2)) + h;
	}
	
	public static double getXVel() {
		return v0x;
	}
	
	public static double getYVel() {
		return v0y + g * t;
	}
	
	public static double getTotalVel() {
		return Math.sqrt(Math.pow(getXVel(), 2) + Math.pow(getYVel(), 2));
	}
	
	public static double getDragForce() {
		// UNUSED CODE
		return 0.5 * c * rho * 0.1 * Math.pow(getTotalVel(), 2);
	}
	
	/* GRAPH CALCULATIONS AND CREATION */
	
	public static void plotPoint(double x, double y) {
		Robot point = new Robot((int) x, (int) y, Display.NORTH, 0);
		
		// I did this because I was getting annoyed with the yellow unused object error
		// It's arbitrary and does literally nothing
		point.getClass(); 
	}

	public static void graphMotion(double v0, double angleDegrees) {
		x = 0;
		y = 0;
		t = 0;
		maxHeight = 0;
		double vfy = getInitY(v0, angleDegrees) + g * t;

		while (vfy >= 0 || y > 0) {
			x = getXPos(getInitX(v0, angleDegrees), t);
			y = getYPos(getInitY(v0, angleDegrees), t);
			plotPoint(x, y);
			t += dt;
			vfy = getInitY(v0, angleDegrees) + g * t;
			if (y > maxHeight) {
				maxHeight = y;
			}
		}
	}

	public static double getRange(double v0, double angleDegrees) {
		x = 0;
		y = 0;
		t = 0;
		double vfy = getInitY(v0, angleDegrees) + g * t;

		while (vfy >= 0 || y > 0) {
			x = getXPos(getInitX(v0, angleDegrees), t);
			y = getYPos(getInitY(v0, angleDegrees), t);
			t += dt;
			vfy = getInitY(v0, angleDegrees) + g * t;
		}

		return x;
	}

	public static double getBestAngle(double v0) {
		double maxAngle = 0;
		double maxRange = 0;
		double range = 0;
		for (int a = 89; a > 0; a--) {
			x = 0;
			y = 0;
			range = getRange(v0, a);
			if (getRange(v0, a) > maxRange) {
				maxAngle = a;
				maxRange = getRange(v0, a);
			}

			System.out.println("For launch angle " + a + ", range is " + range);
		}
		System.out.println("Optimal angle for maximum range is: " + maxAngle);
		System.out.println("For an initial velocity of: " + v0 + " max range was " + maxRange);
		return maxAngle;
	}

	public static void graphBestMotion(double v0) {
		double maxAngle = getBestAngle(v0);
		System.out.println("Optimal angle for maximum range is: " + maxAngle);
		System.out.println("For an initial velocity of: " + v0 + " max range was " + getRange(v0, maxAngle));
		for (int a = 30; a >= -30; a -= 15) {
			graphMotion(v0, maxAngle + a);
			System.out.println("The Range for " + (maxAngle + a) + " degrees is " + getRange(v0, maxAngle + a));
			System.out.println("The time of flight was " + t + " and the maximum height was " + maxHeight + ".");
		}
	}
	
	public static void graphAngleForRange(double v0, double targetx) {
		double closestRange = Math.abs(targetx - getRange(v0, 45));
		int bestAngle = 45;
		for (int a = 1; a < 90; a++) {
			if (Math.abs(targetx - getRange(v0, a)) < closestRange) {
				bestAngle = a;
				closestRange = Math.abs(targetx - getRange(v0, a));
			}
		}
		System.out.println(bestAngle);
		graphMotion(v0, bestAngle);
	}
	
	public static void graphVelocityForRange(double angleDegrees, double targetx) {
		double closestRange = Math.abs(targetx - getRange(100, angleDegrees));
		int bestVelocity = 100;
		int v = 1;
		while (getRange(v, angleDegrees) < targetx) {
			if (Math.abs(targetx - getRange(v, angleDegrees)) < closestRange) {
				bestVelocity = v;
				closestRange = Math.abs(targetx - getRange(v, angleDegrees));
			}
			v++;
		}
		if (Math.abs(targetx - getRange(v, angleDegrees)) < closestRange) {
			bestVelocity = v;
		}
		System.out.println(bestVelocity);
		graphMotion(bestVelocity, angleDegrees);
	}
	
	/* SETUP AND RUN MANAGEMENT */
	
	public static void setupAndRun() {
		String choice = "";
		String[] options = {"Single Trajectory", "Angle for Farthest Distance", "Angle for Specified Distance", "Velocity for Specified Distance"};
		DropDownMenu menu = new DropDownMenu("Input", "What operation would you like to complete? Calculate...", options, 1);
		choice = menu.showMenu();
		if (choice.equals("Single Trajectory")) {
			v0 = Double.parseDouble(JOptionPane.showInputDialog("Please enter an initial velocity in m/s."));
			angleDegrees = Double.parseDouble(JOptionPane.showInputDialog("Please enter a launch angle in degrees."));
			h = Double.parseDouble(JOptionPane.showInputDialog("Please enter starting height in m."));
			g = getPlanet();
			// setDragParameters();
			graphMotion(v0, angleDegrees);
		} else if (choice.equals("Angle for Farthest Distance")) {
			v0 = Double.parseDouble(JOptionPane.showInputDialog("Please enter an initial velocity in m/s."));
			h = Double.parseDouble(JOptionPane.showInputDialog("Please enter starting height in m."));
			g = getPlanet();
			// setDragParameters();
			graphBestMotion(v0);
		} else if (choice.equals("Angle for Specified Distance")) {
			targetx =  Double.parseDouble(JOptionPane.showInputDialog("Please enter a target distance in m."));
			v0 = Double.parseDouble(JOptionPane.showInputDialog("Please enter an initial velocity in m/s."));
			h = Double.parseDouble(JOptionPane.showInputDialog("Please enter starting height in m."));
			g = getPlanet();
			// setDragParameters();
			graphAngleForRange(v0, targetx);
		} else if (choice.equals("Velocity for Specified Distance")) {
			targetx =  Double.parseDouble(JOptionPane.showInputDialog("Please enter a target distance in m."));
			angleDegrees = Double.parseDouble(JOptionPane.showInputDialog("Please enter a launch angle in degrees."));
			h = Double.parseDouble(JOptionPane.showInputDialog("Please enter starting height in m."));
			g = getPlanet();
			// setDragParameters();
			graphVelocityForRange(angleDegrees, targetx);
		}
	}
	
	public static double getPlanet() {
		String choice = "";
		String[] options = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "The Sun", "PSR B1257+12 b"};
		DropDownMenu menu = new DropDownMenu("Input", "Please select a planet.", options, 3);
		choice = menu.showMenu();
		if (choice.equals("Mercury")) {
			return -3.7;
		} else if (choice.equals("Venus")) {
			return -8.87;
		} else if (choice.equals("Earth")) {
			return -9.807;
		} else if (choice.equals("Mars")) {
			return -3.721;
		} else if (choice.equals("Jupiter")) {
			return -24.79;
		} else if (choice.equals("Saturn")) {
			return -10.44;
		} else if (choice.equals("Uranus")) {
			return -8.87;
		} else if (choice.equals("Neptune")) {
			return -11.15;
		} else if (choice.equals("The Sun")) {
			return -274;
		} else if (choice.equals("PSR B1257+12 b")) {
			return -1.9094229;
			// supposedly the gravity of the supposed least massive planet, lacking much clarity
		} else {
			System.out.println("ERROR: Gravity value 0 or positive.");
			System.exit(0);
			return 0.0;
		}
	}

	public static void setDragParameters() {
		// UNUSED
		c = Double.parseDouble(JOptionPane.showInputDialog("On a scale of 1 to 10, how much drag should the object have?"));
		c = ((0.6 * (c - 1)) / 9) + 0.4;
		
		rho = Double.parseDouble(JOptionPane.showInputDialog("On a scale of 1 to 10, how dense should the air be?"));
		rho = ((0.1 * (rho - 1)) / 9) + 1.2; // in kg/m^3
	}
	
}
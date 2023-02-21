package Falcon9;

// Falcon9Tester.java
// This class is designed to test your Falcon 9 calculations for
// time, mass, net Force, y-acceleration, y-velocity, altitude
// It will also be used to output your data in a format that can be imported to Google sheets for analysis
// Please follow the format carefully!

public class Falcon9Tester {
	private static final int WIDTH = 1920;
	private static final int HEIGHT = 1040;

	public static void main(String[] args) {
		// Step 1: 
		// Using your Falcon9 constructor, declare and instantiate a Falcon9 rocket object
		// Using your setter, set deltaTime to 0.5 sec
		Falcon9 f = new Falcon9(WIDTH/2, HEIGHT, 80, 300);
		f.setDT(0.05);
		f.setDM(398900 * (f.getDT() / 162));

		
		// Step 2: 
		// Using a while loop, print out your rocket data until time <= burnTime. 
		// Use your getters to access your data.  Don't forget to move your rocket in the loop as well!
		// To make the data usable in google sheets, each time step should be printed on a single line, with the data separated by commas
		// time, mass, net Force, y-Acceleration, y-velocity, altitude
		// For example:
		// 0.5,540068.8271604938,1513325.4938271604,2.8020974692868936,1.4010487346434468,0.7005243673217234
		while (f.getT() <= 162) {
			System.out.println(f.getT() + "," + f.getM() + "," + f.getF() + "," + f.getA() + "," + f.getV() + "," + f.getH());
			f.move();
		}
		f.setM(96570);
		f.setDM(92670 * (f.getDT() / 235));
		f.setFT(934000);
		while (f.getT() <= 397) {
			System.out.println(f.getT() + "," + f.getM() + "," + f.getF() + "," + f.getA() + "," + f.getV() + "," + f.getH());
			f.move();
		}

	}

}
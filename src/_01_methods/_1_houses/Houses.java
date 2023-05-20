package _01_methods._1_houses;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */
public class Houses {
	Robot rob = new Robot();

	public void run() {

		Robot.setWindowColor(Color.BLACK);

		rob.setX(50);
		rob.setY(450);
		rob.setSpeed(30);
		rob.setPenWidth(5);
		rob.penDown();

		drawHouse("small", "red");
		drawHouse("large", "blue");
		drawHouse("small", "orange");
		drawHouse("large", "green");
		drawHouse("medium", "blue");
		drawHouse("small", "yellow");
		drawHouse("medium", "green");
		drawHouse("small", "blue");
		drawHouse("medium", "yellow");
		drawHouse("large", "pink");

	}

	public void drawHouse(String height, String colorString) {
		int heightInt = 0;

		if(height.equals("small")) {
			heightInt = 60;
		}
		else if(height.equals("medium")) {
			heightInt = 120;
		}
		else if(height.equals("large")) {
			heightInt = 250;
		}


		if(colorString.equals("red")) {
			rob.setPenColor(Color.RED);
		}
		else if(colorString.equals("orange")) {
			rob.setPenColor(Color.ORANGE);
		}
		else if(colorString.equals("yellow")) {
			rob.setPenColor(Color.YELLOW);
		}
		else if(colorString.equals("green")) {
			rob.setPenColor(Color.GREEN);
		}
		else if(colorString.equals("blue")) {
			rob.setPenColor(Color.BLUE);
		}
		else if(colorString.equals("pink")) {
			rob.setPenColor(Color.PINK);
		}



		rob.move(heightInt);


		if (height.equals("large")) {
			drawFlatRoof();
		}
		else {
			drawPointyRoof();
		}

		rob.move(heightInt);

		rob.setPenColor(0,255,0);
		rob.turn(-90);
		rob.move(30);
		rob.turn(-90);


	}

	public void drawFlatRoof() {

		rob.turn(90);
		rob.move(50);
		rob.turn(90);

	}

	public void drawPointyRoof() {

		rob.turn(45);
		rob.move(50);
		rob.turn(90);
		rob.move(50);
		rob.turn(45);

	}


}

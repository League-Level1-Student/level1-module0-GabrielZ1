package _01_methods._5_FlappyBird;

import processing.core.PApplet;

public class FlappyBird extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	int posX = 150;
	int posY = 200;
	int birdYVelocity = -10;
	int gravity = 1;

	int pipeX = 700;

	int upperPipeHeight = (int) random(100, 400);

	int pipeGap = 150;


	@Override
	public void settings() {
		size(WIDTH, HEIGHT);
	}

	@Override
	public void setup() {
		teleportPipes();

	}

	@Override
	public void draw() {
		background(0, 255, 255);
		fill(255, 255, 0);
		stroke(255, 255, 0);
		ellipse(posX,posY+birdYVelocity, 25, 25);
		birdYVelocity += 3;

		stroke(0,0,0);
		fill(0,255,0);
		rect(pipeX,-1,100,upperPipeHeight);

		int lowerY = upperPipeHeight + pipeGap;

		rect(pipeX,lowerY,100,1000);

		pipeX -= 5;

		if(pipeX <= -100) {
			teleportPipes();
		}



	}

	public void mousePressed() {
		birdYVelocity = 0;

	}

	public void teleportPipes() {
		upperPipeHeight = (int) random(100, 400);
		pipeX = 700;

	}


	static public void main(String[] args) {
		PApplet.main(FlappyBird.class.getName());
	}
}

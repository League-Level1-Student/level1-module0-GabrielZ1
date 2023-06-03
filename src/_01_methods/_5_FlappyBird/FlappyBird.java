package _01_methods._5_FlappyBird;

import processing.core.PApplet;
import processing.core.PImage;

public class FlappyBird extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	int posX = 150;
	int posY = 200;
	int birdYVelocity = -10;
	int gravity = 1;

	int pipeX = 800;

	int upperPipeHeight = (int) random(100, 400);

	int pipeWidth = 100;

	int pipeGap = 150;

	int lowerPipeTop;

	boolean gameEnded = false;


	int score = 0;

	PImage back;
	PImage bird;


	@Override
	public void settings() {
		size(WIDTH, HEIGHT);
	}

	@Override
	public void setup() {
		back = loadImage("flappyBackground.jpg");
		back.resize(WIDTH, HEIGHT);

		bird = loadImage("bird.png");
		bird.resize(50,50);

		teleportPipes();

	}

	@Override
	public void draw() {
		if(gameEnded) {
			background(255,0,0);

			fill(0,100,255);
			textSize(50);
			text("You lost.\nYour score was " + score + ".\nPress any key to restart.", 100, 200);		



			if(keyPressed) {
				score = 0;
				posY = 200;
				pipeX = 700;
				birdYVelocity = -10;

				upperPipeHeight = (int) random(100, 400);
				
				
				gameEnded = false;	
			}

		}

		else {
			background(back);

			fill(255,0,0);
			textSize(25);
			text("Score: " + score, WIDTH/2-100, HEIGHT/2-50);

			fill(255, 255, 0);
			stroke(255, 255, 0);
			image (bird,posX,posY);
			birdYVelocity += gravity;
			posY += birdYVelocity;

			stroke(0,0,0);
			fill(0,255,0);
			rect(pipeX,-1,pipeWidth,upperPipeHeight);

			lowerPipeTop = upperPipeHeight + pipeGap;

			rect(pipeX,lowerPipeTop,pipeWidth,1000);

			pipeX -= 5;

			if(pipeX <= -pipeWidth) {
				teleportPipes();
			}

			fill(0,150,0);
			rect(-5,HEIGHT-90,WIDTH+5,90);


			if(intersectsPipes() || intersectsFloor()) {
				gameEnded = true;
			}

		}

		if(posX == (pipeX+pipeWidth)) {
			score +=1;
		}


	}

	public void mousePressed() {
		birdYVelocity = -10;

	}

	public void teleportPipes() {
		upperPipeHeight = (int) random(100, 400);
		pipeX = 800;

	}


	boolean intersectsPipes() { 
		if (posY+10 < upperPipeHeight && posX+50 > pipeX && posX < (pipeX+pipeWidth)){
			return true;
		}
		else if (posY+40 >lowerPipeTop && posX+50 > pipeX && posX < (pipeX+pipeWidth)) {
			return true;
		}
		else {
			return false;
		}
	}

	boolean intersectsFloor() {
		if(posY+35>HEIGHT-90) {
			return true;
		}
		else {
			return false;
		}

	}

	static public void main(String[] args) {
		PApplet.main(FlappyBird.class.getName());
	}
}

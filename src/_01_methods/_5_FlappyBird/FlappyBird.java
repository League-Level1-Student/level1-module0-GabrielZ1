package _01_methods._5_FlappyBird;

import processing.core.PApplet;

public class FlappyBird extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;

	@Override
	public void settings() {
		size(WIDTH, HEIGHT);
	}

	@Override
	public void setup() {

	}

	@Override
	public void draw() {
		background(0, 255, 255);
		fill(255, 255, 0);
		stroke(255, 255, 0);
		ellipse(150, 200, 50, 50);
		
		
		
	}

	static public void main(String[] args) {
		PApplet.main(FlappyBird.class.getName());
	}
}

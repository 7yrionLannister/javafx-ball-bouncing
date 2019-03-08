package threads;

import javafx.scene.shape.Circle;
import ui.CircleController;

public class CircleThread extends Thread{
	private CircleController circleController;
	private Circle circle;
	public boolean endOfApplication = false;
	public static boolean moveOn = false;
	private int bounces;

	public CircleThread(CircleController circleC, Circle circle) {
		circleController = circleC;
		this.circle = circle;
		bounces = 0;
	}

	public void run() {
		while(true) {
			if(moveOn) {
				System.out.print("");
				if(!circleController.moveCircle(circle, bounces)) {
					bounces += 1;
					if(circle.getLayoutX() < 0) {
						circle.setLayoutX(5);
					}
					else {
						circle.setLayoutX(550);
					}
				}
				try {
					sleep(100);
				} catch (InterruptedException e) {
				}
			}
		}
	}
	
	public void setMoveOn(boolean move) {
		moveOn = move;
	}
}

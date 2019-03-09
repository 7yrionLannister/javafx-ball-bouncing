package threads;

import javafx.scene.shape.Circle;
import ui.CircleController;

public class CircleThread extends Thread {
	private CircleController circleController;
	private Circle circle;
	public boolean endOfApplication = false;
	private int bounces;

	public CircleThread(CircleController circleC, Circle circle) {
		circleController = circleC;
		this.circle = circle;
		bounces = 0;
	}

	@Override
	public void run() {
		while(circleController.moveOn) {
			System.out.println();
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
			} 
			catch (InterruptedException e) {
				
			}
		}
	}
}

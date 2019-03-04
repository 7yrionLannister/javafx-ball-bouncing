package threads;

import ui.CircleController;

public class CircleThread extends Thread{
	private CircleController circleController;
	
	public CircleThread(CircleController circleC) {
		circleController = circleC;
	}
	
	public void run() {
		while(true) {
			circleController.moveBlueCircle();
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

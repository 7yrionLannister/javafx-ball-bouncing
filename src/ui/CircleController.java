package ui;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import threads.CircleThread;

public class CircleController {

	public boolean moveOn;
	@FXML
	private Circle blueCircle;
	
	private int circles;

	@FXML
	private Pane map;
	
	private ExecutorService ex;
	
	private CircleThread ct;

	@FXML
	public void initialize() {
		ct = new CircleThread(this, blueCircle, "n");
		ex = Executors.newCachedThreadPool();
		ex.execute(ct);
		moveOn = false;
		circles = 1;
	}

	@FXML
	public void moveCircle(ActionEvent event) {
			moveOn = true;
	}

	public boolean moveCircle(Circle circle, int bounces) {
		if(circle.getLayoutX() >= 0 && circle.getLayoutX()+circle.getRadius() < 580) {
			if(bounces%2 == 0) {
				circle.setLayoutX(circle.getLayoutX()+5);
			}
			else {
				circle.setLayoutX(circle.getLayoutX()-5);
			}
		}
		return circle.getLayoutX() >= 0 &&
				circle.getLayoutX() + circle.getRadius() < 580;
	}

	@FXML
	public void createCircle(MouseEvent event) {
		circles += 1;
		Circle circle = new Circle(17, blueCircle.getFill());
		circle.setStroke(blueCircle.getStroke());
		circle.setLayoutX(event.getX());
		circle.setLayoutY(event.getY());
		CircleThread cirt = new CircleThread(this, circle, ""+circles);
		ex.execute(cirt);
		map.getChildren().add(circle);
	}
	
	@FXML
	public void stopCircles(ActionEvent event) {
			moveOn = false;
	}
}

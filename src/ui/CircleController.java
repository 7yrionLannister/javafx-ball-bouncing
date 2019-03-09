package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import threads.CircleThread;

public class CircleController {

	public boolean moveOn;
	@FXML
	private Circle blueCircle;

	@FXML
	private Pane map;
	
	private CircleThread ct;

	@FXML
	public void initialize() {
		ct = new CircleThread(this, blueCircle);
		moveOn = false;
		ct.start();
	}

	@FXML
	public void moveCircle(ActionEvent event) {
			moveOn = true;
			CircleThread ct;
			for(Node node : map.getChildren()) {
				if(node instanceof Circle) {
					ct = new CircleThread(this, (Circle)node);
					ct.start();
				}
			}
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
		Circle circle = new Circle(17, blueCircle.getFill());
		circle.setStroke(blueCircle.getStroke());
		circle.setLayoutX(event.getX());
		circle.setLayoutY(event.getY());
		ct = new CircleThread(this, circle);
		ct.start();
		map.getChildren().add(circle);
	}
	
	@FXML
	public void stopCircles(ActionEvent event) {
			moveOn = false;
	}
}

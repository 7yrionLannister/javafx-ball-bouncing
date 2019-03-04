package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import threads.CircleThread;

public class CircleController {

    @FXML
    private Circle blueCircle;

    @FXML
    public void moveCircle(ActionEvent event) {
    	CircleThread ct = new CircleThread(this);
    	ct.start();
    }
    
    public void moveBlueCircle() {
    	blueCircle.setLayoutX(blueCircle.getLayoutX()+5);
    }

}

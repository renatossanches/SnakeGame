package controller;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import service.API;

public class SnakeGameController {

	@FXML
	private GridPane defaultGridPane;

	private int position[] = API.generatePositionRandom();
	private int positionX = position[0];
	private int positionY =  position[1];
	
	@FXML
	private void initialize() {
		 Platform.runLater(() -> {
		        spawn();
		    });

	}
	
	private void spawn() {
	    Image img = new Image(getClass().getResource("/images/texture.jpg").toExternalForm());
	    ImageView imageView = new ImageView(img);

	    imageView.setFitWidth(45);
	    imageView.setFitHeight(18);
	    imageView.setPreserveRatio(true);
	    
	    Image img1 = new Image(getClass().getResource("/images/head.jpg").toExternalForm());
	    ImageView imageView1 = new ImageView(img1);
	    imageView1.setFitWidth(45);
	    imageView1.setFitHeight(18);
	    imageView1.setPreserveRatio(true);
	    
	  
	    defaultGridPane.add(imageView, positionX, positionY);
	    try {
	    defaultGridPane.add(imageView1, positionX, positionY-1);
	    }
	    catch(Exception e) {
	    	defaultGridPane.add(imageView1, positionX, positionY+1);
	    }
	}
	public void movement(KeyCode keyBoard) {
		if(keyBoard == keyBoard.RIGHT) {

		}
	}
}

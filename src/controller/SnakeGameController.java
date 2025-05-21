package controller;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import service.API;
import service.SnakeGameService;

public class SnakeGameController {

	@FXML
	private GridPane defaultGridPane;

	private int position[] = API.generatePositionRandom(0, 14);
	private int positionX = position[0];
	private int positionY =  position[1];
	
	@FXML
	private void initialize() {
		 Platform.runLater(() -> {
			 
		       	defaultGridPane.getScene().setOnKeyPressed(event -> {
		            SnakeGameService.updateDirection(event.getCode());
		        });
		        SnakeGameService.startGameLoop(this); 
		    });

	}
	
	public void movement(KeyCode keyBoard) {
		SnakeGameService.removeNodeAt(defaultGridPane,positionX, positionY);

	    if (keyBoard == KeyCode.UP) {
	        positionY -= 1;
	    } else if (keyBoard == KeyCode.DOWN) {
	        positionY += 1;
	    } else if (keyBoard == KeyCode.LEFT) {
	        positionX -= 1;
	    } else if (keyBoard == KeyCode.RIGHT) {
	        positionX += 1;
	    }
    	if(positionX <= 0) {
    		positionX= 0;
    	}
    	if(positionY <=0) {
    		positionY= 0;
    	}
	    SnakeGameService.addSnakeAt(defaultGridPane, positionX, positionY);
	}

}

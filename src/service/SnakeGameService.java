package service;

import java.util.ArrayList;

import controller.SnakeGameController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class SnakeGameService {

	private static Timeline gameLoop;
	private static final int SPEED_MS = 200; // speed: lower is faster
	private static KeyCode currentDirection = KeyCode.UP;

	public static void startGameLoop(SnakeGameController controller) {
	    gameLoop = new Timeline(new KeyFrame(Duration.millis(SPEED_MS), event -> {
	    	controller.movement(currentDirection);
	    }));
	    gameLoop.setCycleCount(Timeline.INDEFINITE); // run forever
	    gameLoop.play();
	}
	public static void updateDirection(KeyCode newDirection) {
	    if ((currentDirection == KeyCode.RIGHT && newDirection != KeyCode.LEFT) ||
	        (currentDirection == KeyCode.LEFT && newDirection != KeyCode.RIGHT) ||
	        (currentDirection == KeyCode.UP && newDirection != KeyCode.DOWN) ||
	        (currentDirection == KeyCode.DOWN && newDirection != KeyCode.UP)) {
	        
	        currentDirection = newDirection;
	    }
	}
	
	private static void randomCandy() {
		int[] position =API.generatePositionRandom(0, 14);
		int row = position[0];
		int column = position[1];
		
	}
	
	public static void addSnakeAt(GridPane grid,int x, int y) {
	    Circle snake = new Circle();
	    snake.setFill(Color.PURPLE);
	    snake.setRadius(10);
	    grid.add(snake, x, y);
	}
	public static void removeNodeAt(GridPane grid,int col, int row) {
	    for (Node node : new ArrayList<>(grid.getChildren())) {  

	        Integer colIndex = GridPane.getColumnIndex(node);
	        Integer rowIndex = GridPane.getRowIndex(node);
	    	
	        if (colIndex != null && rowIndex != null && colIndex == col && rowIndex == row) {
	        	grid.getChildren().remove(node);
	            break;  // Always break after removal
	        }
	    }
	}
}

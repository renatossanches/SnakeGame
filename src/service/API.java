package service;

public class API {

	public static int[] generatePositionRandom(int min, int max) {
		int range = max - min +1;
		int[] position = new int[2];
		for(int i = 0; i<=1;i++) {
			position[i] = (int) (Math.random() * range) + min;
		}
		return position;
	}
}

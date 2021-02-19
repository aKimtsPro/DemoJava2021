package POO.game.classes;

import java.util.Random;

public class De {

	private int minimum;
	private int maximum;
	private Random alea;
	
	public int getMinimum() {
		return minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public De() {
		// TODO Auto-generated constructor stub
		alea = new Random();
		minimum = 1;
	}
	
	public int lance(int max) {
		int temp = alea.nextInt(max);
		if(temp == 0 ) {
			return minimum;
		}else {
			return temp;
		}
	}
	
	public int lanceZero(int max) {
		int temp = alea.nextInt(max);
		return temp;
	}

}

package model;
import java.util.Random;

public class RNG {
	
	public boolean generator(int rate, int modifier) {
		Random dice = new Random();
		int num;
		
		num = 1+dice.nextInt(100);
		System.out.printf("Encounter/Catch is %d out of %d\n", num, rate+modifier);
		if(num <= rate+modifier) {
			return true;
		}
		return true;
	}
	
}

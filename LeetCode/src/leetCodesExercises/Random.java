package leetCodesExercises;


/**
 * @author Victor Gil
 * Class to mimic the Random pseudocode generator
 */
public class Random {
	
	public Random() {
		
	}
	
	public double getRandom() {
		
		//Take variables based on nano time and current time system variables
		double nanoTime1= ((System.nanoTime()% 100000)/100)+1.5;
		double nanoTime2 = ((System.nanoTime()% 1000000)/1000)+1.5;
		double currentTime = (System.currentTimeMillis()% 50)+1.5;
		//make math calculations to get a pseudo random number
		double calc1 = nanoTime1*Math.PI/(nanoTime1*currentTime);
		double calc2= nanoTime2*Math.PI/(nanoTime1*calc1);
		double calc3 = calc1*Math.pow(Math.PI*currentTime,3)/calc2;	
		double finalRandom =  (calc1*calc2/calc3*10000000)% 1;
		//Return the final calculation taking the low decimals of the resultant number
		
		return finalRandom;
	}
	

}

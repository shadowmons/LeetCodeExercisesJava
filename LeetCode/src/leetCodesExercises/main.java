package leetCodesExercises;

import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int [] array1 = new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
		System.out.println(LeetCodeE.JumpGameII(array1)); 
		
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime)/1000 + " micro s"); 
		
		
		/**for (int i = 0; i < 10000000; i++) {
			
			acumMyRandom = acumMyRandom + (Math.random() - new Random().getRandom());
			//System.out.println(String.format("%.7f",random));
			
		}
		
		System.out.println(acumMyRandom);
		**/
		
	}

}


 
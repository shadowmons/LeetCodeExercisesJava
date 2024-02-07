package leetCodesExercises;

import java.util.Arrays;

public class LeetCodeE {
	
	
	
	
	
	public static void MergeSortedArray1 (int[] nums1, int[] nums2, int m, int n) {
	
			for (int j = 0, i = m; j < n; j++) {
	            nums1[i] = nums2[j];
	            i++;
	        }
		        Arrays.sort(nums1);
			}
	
	public static void MergeSortedArray2 (int[] nums1, int[] nums2, int m, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
	
	/**int [] array1 = new int[]{1,2,3,0,0,0};
		int [] array2 = new int[]{2,5,6};
		System.out.println(Arrays.toString(array1));
		
		LeetCodeE.MergeSortedArray2(array1,array2, 3,3);
		
		System.out.println(Arrays.toString(array1));**/
	
	public static int removeElement1 (int[]nums, int val) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]!=val) {
				nums[j] = nums[i];
 				j++;
			}
			
		}
		return j;
	}
	
	/** int r = LeetCodeE.removeElement1(array1, 2);
	System.out.println(Arrays.toString(array1));
	System.out.println(r);  **/
	
	public static int removeDuplicatesSort1(int[]nums) {
		int j = 1;
		int aux = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != aux) {
				aux= nums[i];
				nums[j]=nums[i];
				j++;
			}else {
				
			}
		}
		return j;
	}
	
	/**int [] array1 = new int[]{0,0,1,1,1,2,2,3,3,4};
		int r= LeetCodeE.removeDuplicatesSort1(array1);
		System.out.println(Arrays.toString(array1)); 
		System.out.println(r);**/

	//Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
	
	public static int removeDuplicatesSortTwice(int[]nums) {
		int j = 1;
		int cont =0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i-1]) {
				nums[j]=nums[i];
				j++;
				cont =0;
			}else {
				cont+=1;
				if (cont < 2) {
					nums[j]=nums[i];
					j++;
				}
				
				
			}
		}
		return j;
	}
	
	public static int removeDuplicatesSortTwice2(int[]nums) {
		int j = 1;
		int cont =0;
		for (int i = 1; i < nums.length; i++) {
			
			if (nums[i] == nums[i-1]) {
				cont +=1;
			} else {
				cont = 0;
			}
			if (cont < 2) {
				nums[j]=nums[i];
				j++;
			}
		}
		return j;
	}
	
	/*int [] array1 = new int[]{0,0,1,1,1,2,2,2,3,3,4};
		int r= LeetCodeE.removeDuplicatesSortTwice2(array1);
		System.out.println(Arrays.toString(array1)); 
		System.out.println(r);*/
	
	// Given an array nums of size n, return the majority element.
	//The majority element is the element that appears more than n/2 times. You may assume that the majority element always exists in the array.
	public static int MajorityElement (int[] nums) {
		int cont = 1;
		int aux = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			
			cont = nums[i]==aux ? cont+1 : cont -1;
			
			if (cont==0) {
				aux = nums[i];
				cont=1;

			}
			
		}
		
		return aux;
	}
	
	public static int MajorityElement2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
       
    }
	
	/**int [] array1 = new int[]{2,0,0,1,1,1,2,2,3,3,4,2,2,2,2,2};
		int r= LeetCodeE.MajorityElement(array1);
		System.out.println(Arrays.toString(array1)); 
		System.out.println(r);**/
	
	
	public static void RotateArray1(int[]nums, int k) {
		k = k%nums.length;
		int aux = 0;
		int b[] = nums.clone(); 
		for (int i = 0; i < nums.length; i++) {
			aux = i+k < nums.length ? i + k : i + k - nums.length;
			nums[aux]=b[i];
			
		}
	}
	
	public static void RotateArray2(int[]nums, int k) {
		k = k%nums.length;
		int aux1 = 0;
		int aux2 = 0;
		for (int j = 0; j < k; j++) {
			aux1 =nums[nums.length-1];
			for (int i = 0; i < nums.length; i++) {
				aux2= nums[i];
				nums[i]=aux1;
				aux1=aux2;		
				
			}
		
		}
	}
	
	public static void RotateArray3(int[]nums, int k) {
		k = k%nums.length;
		ReverseArray(nums, 0,nums.length-k -1 );
		ReverseArray(nums,nums.length-k,nums.length -1);
		ReverseArray(nums,0, nums.length-1);
		
	}
	
	public static void ReverseArray(int[]nums, int i, int j) {
		int li = i, ri = j, aux= 0;
		
		while (li<ri) {
			aux = nums[ri];
			nums[ri]= nums[li];
			nums[li]=aux;
			li++;
			ri--;
		}
		
		
	}
	
	/**int [] array1 = new int[]{1,2,3,4,5,6,7,8,9};
		LeetCodeE.RotateArray3(array1,3);
		System.out.println(Arrays.toString(array1)); **/
	
	//You are given an array prices where prices[i] is the price of a given stock on the ith day.
	//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
	//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
	public static int BestTimetoBuyandSellStock (int[]prices) {
		int min = prices[0],diff = 0;
		for (int i = 1; i < prices.length; i++) {
			if(prices[i]<min) {
				min = prices[i];
			}
			if(prices[i]-min>0) {
				diff = Math.max(diff,prices[i]-min);
			}
		}
		return diff;
	}
	
	public static int BestTimetoBuyandSellStock2 (int[]prices) {
		int diff = 0;
		for (int i = 1; i < prices.length; i++) {
			if(prices[i]>prices[i-1]) {
				diff = diff + prices[i]-prices[i-1];	
			}
		
		}
		return diff;
	}
	
	/**
	  int [] array1 = new int[]{7,1,5,3,6,7,4,6,2};
		int a = LeetCodeE.BestTimetoBuyandSellStock2(array1);
		System.out.println(a); 
	 **/
	
	
	
	
	//You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
	//Return true if you can reach the last index, or false otherwise.
	
	public static boolean JumpGame(int[] nums) {
        int destination=nums.length-1; 
        for(int i=nums.length-2;i>=0;i--){ 
        	if(i+nums[i]>=destination){  
                destination=i;
            }
        }
        return destination==0; 
    }
	
	
	public static boolean JumpGame2(int[] nums) {
		int jumpHigh = nums[0]; 
		
		for (int i = 1; i < nums.length; i++) {
			jumpHigh -=1;
			if(jumpHigh<0) {
				return false;
			}
			jumpHigh = Math.max(jumpHigh,nums[i]);
			
			
		}
		return true;
	}
	
	public static int JumpGameII(int[] nums) {
		int jumpHigh = 0; 
		int count = 0;
			for (int i = 1; i < nums.length; i++) {
				jumpHigh -=1;
				if (jumpHigh+i>=nums.length-1) {
					return count;
				}
				if (jumpHigh<nums[i]) {
					count++;
					jumpHigh=nums[i];
				}
				
				
			}
			
		
		return count;
	}
	//2,3,1,1,4


	
	
}


//Metodos de Arrays
//Arrays.sort
//System.out.println(Arrays.toString(array1));
// to descending order >>> Arrays.sort(array, Collections.reverseOrder());
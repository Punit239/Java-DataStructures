// PUNIT SHARMA :: 3/14/2015
// PROGRAM TO FIND LARGEST SUM OF CONTINOUS SUBARRAY

package arrays;

public class MaxSubArray {

	public static void main(String[] args) {
		
		MaxSubArray m = new MaxSubArray();
		int[] a = {4,-1,9,-5,2,-3,1,-2};
		System.out.println(m.findMaxSum(a));
	}
	
	public static int findMaxSum(int[ ] anArray){
	  
	  int currentSum = 0;
	  int currentMax = 0;

	  for (int j=0; j < anArray.length; j++)
	  {
	    currentSum += anArray[ j ];

	   if (currentMax < currentSum) 
	     currentMax = currentSum;
	   else if (currentSum < 0)
	     currentSum = 0;
	  }
	 
	  return currentMax;
	}
}

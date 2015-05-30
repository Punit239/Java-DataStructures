// PUNIT SHARMA :: 9/8/2014
// PROGRAM TO FIND SUB ARRAY WITH GIVEN SUM

package arrays;

import java.util.Scanner;

public class FindSubArray {

	int[] arr = {5, 30 , 40, 20, 35, 15, 10, 25};
	int length = arr.length;
	public static void main(String[] args) {
		
		FindSubArray f = new FindSubArray();
		Scanner s = new Scanner(System.in);
		System.out.println("Find subarray with sum : ");
		f.findSubArray(s.nextInt());
		s.close();
	}
	
	public void findSubArray(int sum){
		
		int total = 0;
		int start = 0;
		for(int i = 0; i<length-1; i++){
			
			if(total == sum){
				
				System.out.println("Sub Array index " + start + " to " + (i-1));
				return;
			}
			
			total += arr[i];	
			// SUBTRACT ELEMENTS FROM THE BEGINNING OF THE ARRAY TILL THE TOTAL IS 
			// LESS THAN THE DESIRED SUM. RUNS ONLY IF TOTAL EXCEEDS DESIRED SUM. 
			while(total > sum)
					total -= arr[start++];
		}
		System.out.println("Sub array not found.");
	}
}

package arrays;

import java.util.HashMap;
import java.util.Scanner;

public class PairInArray {

	int[] arr = {25,5,15,45,100,50,10,40};
	public static void main(String[] args) {
		
		PairInArray p = new PairInArray();
		Scanner s = new Scanner(System.in);
		System.out.println("Find pair with sum of : ");
		p.findPair(s.nextInt());
	}
	
	public void findPair(int sum){
		
		HashMap<Integer, Integer> pair = new HashMap<Integer, Integer>();
		
		for(int i=0; i < arr.length-1; i++)
			pair.put(arr[i], i);
		
		for(int i=0; i < arr.length-1; i++){
			
			if(pair.containsKey(sum - arr[i]) && pair.get(sum - arr[i]) != i)
				System.out.println("Pair is : " + i + " , " + pair.get(sum - arr[i]));
		}
	}
}

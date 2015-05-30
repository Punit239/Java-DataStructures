// PUNIT SHARMA :: 3/15/2015
// PROGRAM TO FIND TRIANGLE IN A RANDOM LIST OF NUMBERS

package misc;

import java.util.HashSet;

public class TriangleVertices {

	public static void main(String[] args) {
		
		int[] arr = {15,4,5,9,2,3};
		TriangleVertices t = new TriangleVertices();
		t.findTriangle(arr);
		
	}

	public void findTriangle(int[] a){
		
		HashSet<HashSet<Integer>> triangle = new HashSet<HashSet<Integer>>();
		HashSet<Integer> tmp;
		for(int i=0;i<a.length;i++){
			int sum=a[i];
			for(int j=0;j<a.length;j++){
				int first = a[j];
				if(first!=sum){
					for(int k=0;k<a.length;k++){
						int sec = a[k];
						if(sec!=first && sec!=sum 
							&& (first + sec > sum) 
							&& (sec + sum > first)
							&& (first + sum > sec)){
							tmp = new HashSet<Integer>();
							tmp.add(first);
							tmp.add(sec);
							tmp.add(sum);
							triangle.add(tmp);
						}
					}		
				}
			}
		}
		
		for(HashSet<Integer> hs : triangle)
			System.out.println(hs);
	}
}

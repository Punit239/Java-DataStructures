// PUNIT SHARMA :: 09/11/2014
// PROGRAM TO PERFORM BINARY SEARCH

package misc;

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] arr = {11,22,33,44,55,66,77,88,99};
		BinarySearch bs = new BinarySearch();
		bs.display(arr);
		bs.binarySearchArray(arr, 55);
	}
	
	public void display(int[] tmpArr){
		
		for(int i : tmpArr)
			System.out.print(i + "   ");
		System.out.println();
	}
	
	public void binarySearchArray(int[] tmpArr, int num){
		
		int start = 0;
		int end = tmpArr.length - 1;
		
		while(start <= end){
			
			int mid = (start+end)/2;
			if(tmpArr[mid] == num){
				
				System.out.println(num + " found at position " + (mid+1));
				return;
			}
			
			if(num < tmpArr[mid])
				end = mid-1;
			else
				start = mid+1;
		}
		
		System.out.println(num + " not found.");
	}

}

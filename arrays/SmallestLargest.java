// PUNIT SHARAM :: 2/18/2015
// PROGRAM TO FIND SMALLEST AND LARGEST ELEMENT IN AN ARRAY

package arrays;

public class SmallestLargest {

	int[] arr = {22,5,77,99,55,8,9};
	public static void main(String[] args) {
		
		SmallestLargest sl = new SmallestLargest();
		sl.printSmallLarge(sl.arr);
	}

	void printSmallLarge(int[] tmparr){
		
		int s = tmparr[0];
		int l = tmparr[0];
		
		for(int i=0;i<tmparr.length-1;i++){
			
			if(tmparr[i]>l)
				l = tmparr[i];
			if(tmparr[i]<s)
				s = tmparr[i];
		}
		System.out.println("Highest element : "+ l + " , Lowest element : " + s);
	}
}

// PUNIT SHARMA :: 1/8/2015
// PROGRAM TO FIND SECOND HIGHEST NUMBER IN THE ARRAY

package arrays;

public class SecondHighest {

	int arr[] = {33,4,7,11,3,22,99,8,55,9,2};
	
	public static void main(String[] args) {
		
		SecondHighest  s = new SecondHighest();
		s.secondHighestNum();
	}
	
	public void secondHighestNum(){
		
		int first,second;
		
		if(arr[0] > arr[1]){
			
			first = arr[0];
			second = arr[1];
		} else{
			
			first = arr[1];
			second = arr[0];
		}
		
		for(int i=0; i < arr.length; i++){
			
			if(arr[i] > first){
				
				second = first;
				first = arr[i];
			}
			
			if(arr[i] < first && arr[i] > second)
				second = arr[i];
		}
		
		System.out.println("Second highest number : " + second);
	}
}

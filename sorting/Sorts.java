// PUNIT SHARMA :: 2/28/2015
// PROGRAM TO PERFORM BUBBLE AND INSERTION SORT

package sorting;

public class Sorts {
	
	public static void main(String[] args) {
		
		int[] a = {4,6,1,9,5,2};
		Sorts s = new Sorts();
		s.insertionSort(a);
		s.bubbleSort(a);
	}

	public void insertionSort(int[] arr){
		
		System.out.println("Insertion sort : ");
		int i,j;
		for(i=1; i<arr.length; i++){
			
			int tmp=arr[i];
			for(j=i-1; ((j>=0) && (tmp<arr[j])); j--)
				arr[j+1] = arr[j];
			arr[j+1] = tmp;
		}
		
		display(arr);
		System.out.println();
	}
	
	public void bubbleSort(int[] arr){
		
		System.out.println("Bubble sort :");
		for(int i=0; i<arr.length; i++)
			for(int j=0; j<arr.length-i-1; j++){
				if(arr[j+1]<arr[j]){
					
					int t = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = t;
				}
			}
		
		display(arr);
	}
	
	public void display(int[] arr){
		
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + "  ");
	}
}

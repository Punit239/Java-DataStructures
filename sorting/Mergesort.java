package sorting;

public class Mergesort {

	public int[] arrayToSort = {6,7,9,11,4,21,99,2,1,10};
	
	public static void main(String[] args) {

		Mergesort m = new Mergesort();
		for(int i=0; i<m.arrayToSort.length; i++)
			System.out.print(m.arrayToSort[i] + "  ");
		
		m.mergeSortArray(m.arrayToSort);
		System.out.println();
		for(int i=0; i<m.arrayToSort.length; i++)
			System.out.print(m.arrayToSort[i] + "  ");
		
	}
	
	public void mergeSortArray(int[] arrayToSortTmp){
		
		int arraySize = arrayToSortTmp.length;
		
		if(arraySize < 2)
			return;
		
		int mid = arraySize/2;
		int[] left = new int[mid]; 
		int[] right = new int[arraySize-mid];
		
		mergeSortArray(left);
		mergeSortArray(right);
		merge(left, right, arrayToSortTmp);
	}
	
	public void merge(int[] leftArray, int[] rightArray, int[] array){
		
		int leftIndex = 0;
		int rightIndex = 0;
		int OriginalIndex = 0;
		int sizeLeft = leftArray.length;
		int sizeRight = rightArray.length;
		
		while ((leftIndex < sizeLeft) && (rightIndex < sizeRight)){
			
			if(leftArray[leftIndex] <= rightArray[rightIndex]){
				
				array[OriginalIndex] = leftArray[leftIndex];
				leftIndex++;
			}
			else{
				
				array[OriginalIndex] = rightArray[rightIndex];
				rightIndex++;
			}
			OriginalIndex++;
		}
		
		while(leftIndex < sizeLeft){
			
			array[OriginalIndex] = leftArray[leftIndex];
			OriginalIndex++;
			leftIndex++;
		}
		
		while(rightIndex < sizeRight){
			
			array[OriginalIndex] = rightArray[rightIndex];
			OriginalIndex++;
			rightIndex++;
		}
		
	}
}

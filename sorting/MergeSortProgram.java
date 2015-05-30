package sorting;

public class MergeSortProgram {

	int[] arrayToSort = {5,78,99,1,9,44,54,89,24,68};
	int[] tmp = new int[arrayToSort.length];
	
	public static void main(String[] args) {

		MergeSortProgram m = new MergeSortProgram();
		m.display(m.arrayToSort);
		int length = m.arrayToSort.length;
		m.divide(0, length - 1);
		m.display(m.tmp);
	}
	
	public void divide(int first, int last){
		
		if(first < last){
			
			int mid = (first+last)/2;
			
			divide(first, mid);
			divide(mid+1, last);
			merge(first, mid, last);
		}
	}
	
	public void merge(int start, int mid, int end){
		
		int leftFirst = start;
		int leftEnd = mid;
		
		int rightFirst = mid+1;
		int rightEnd = end;
		
		int index = start;
		
		while((leftFirst <= leftEnd) && (rightFirst <= rightEnd)){
			
			if(arrayToSort[leftFirst] <= arrayToSort[rightFirst])
				tmp[index++] = arrayToSort[leftFirst++];
			else
				tmp[index++] = arrayToSort[rightFirst++];
		}
		
		while(leftFirst <= leftEnd)
			tmp[index++] = arrayToSort[leftFirst++];
			
		while(rightFirst <= rightEnd)
			tmp[index++] = arrayToSort[rightFirst++];
			
	}
	
	public void display(int[] arr){
		
		for(int i=0; i < arr.length; i++)
			System.out.print(arr[i] + "  ");
		System.out.println();
	}
}

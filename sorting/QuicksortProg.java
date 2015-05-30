package sorting;

public class QuicksortProg {

	int[] arrayToSort = {28,77,1,88,99,22,66,11,22};
	
	public static void main(String[] args) {
		
		QuicksortProg q = new QuicksortProg();
		q.display();
		q.quickSort(0, (q.arrayToSort.length-1));
		q.display();
	}
	
	void quickSort(int low, int high){
		
		if(low < high){
			
			int partitionIndex = partition(low, high);
			quickSort(low, partitionIndex-1);
			quickSort(partitionIndex+1, high);
		}
	}
	
	public int partition(int start, int end){
		
		int pivot = arrayToSort[end];
		int pIndex = start;
		
		while(start <= end-1){
			
			if(arrayToSort[start] <= pivot)
				swap(start, pIndex++);
			start++;
		}
		
		swap(pIndex, end);
		return pIndex;
	}
	
	public void swap(int i, int j){
		
		int tmp = arrayToSort[i];
		arrayToSort[j] = arrayToSort[i];
		arrayToSort[i] = tmp;
	}
	
	public void display(){
		
		System.out.println("Current array :");
		for(int i : arrayToSort)
			System.out.print(i + "   ");
		System.out.println();
	}
}

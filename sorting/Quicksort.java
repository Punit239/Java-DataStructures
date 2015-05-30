package sorting;

public class Quicksort {

	int[] arrayUnsorted = {2,77,1,88,99,22,66,11,22};
	public static void main(String[] args) {

		Quicksort q = new Quicksort();
		int arrLength = q.arrayUnsorted.length;
		q.display();
		q.quickSort(0, arrLength-1);
		q.display();
	}
	
	int partition(int left, int right)
	{
	      int i = left, j = right;
	      int pivot = arrayUnsorted[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arrayUnsorted[i] < pivot)
	                  i++;
	            while (arrayUnsorted[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  swap(i,j);
	                  i++;
	                  j--;
	            }
	      }
	     
	      return i;
	}
	 
	public void quickSort(int left, int right) {
	      
		  int index = partition(left, right);
	      if (left < index - 1)
	            quickSort(left, index - 1);
	      if (index < right)
	            quickSort(index, right);
	}
	
	public void swap(int i, int j){
		
		int tmp = arrayUnsorted[i];
		arrayUnsorted[i] = arrayUnsorted[j];
		arrayUnsorted[j] = tmp;
    }

	public void display(){
		
		System.out.println("Current array :");
		for(int i : arrayUnsorted)
			System.out.print(i + "   ");
		System.out.println();
	}

}

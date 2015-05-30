// PUNIT SHARMA :: 3/14/2015
// PROGRAM TO  MERGE TWO SORTED ARRAYS

package arrays;

public class MergeArrays {

	public static void main(String[] args) {
		
		MergeArrays ma = new MergeArrays();
		
		int arr1[] = {22,54,59,69,99};
		int arr2[] = {44,66,79,89,91,94};
		ma.display(arr1);
		ma.display(arr2);
		ma.display(ma.mergeArr(arr1, arr2));
		
	}
	
	public int[] mergeArr(int a[], int b[]){
		
		int indexA=0;
		int indexB=0;
		int index=0;
		int[] arr = new int[a.length + b.length];
		
		while((indexA < a.length) && (indexB < b.length)){
			
			if(a[indexA] <= b[indexB]){
				
				arr[index++] = a[indexA++];
			} else {
				
				arr[index++] = b[indexB++];
			}
		}
		
		while(indexA < a.length)
			arr[index++] = a[indexA++];
		while(indexB < b.length)
			arr[index++] = b[indexB++];
		
		return arr;
	}
	
	void display(int arr[]){
		
		for(int i : arr)
			System.out.print(i + "  ");
		System.out.println();
	}
}

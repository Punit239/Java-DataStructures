// PUNIT SHARMA :: 1/8/2015
// PROGRAM TO FIND ALL DUPLICATES IN AN ARRAY IN O(N) TIME 
// AND 0(1) SPACE WHERE ALL NUMBERS LIE BETWEEN 1 TO N-1

package arrays;

public class Duplicates {

	int arr[] = {3,4,7,1,3,2,9,8,5,9,2};
	int size = arr.length-1;
	
	public static void main(String[] args) {
		
		Duplicates d = new Duplicates();
		d.printDups();

	}
	
	// PRINTS ALL THE DUPLICATE VALUES PRESENT IN THE ARRAY
	public void printDups(){
		
		// LOOP THROUGH THE ARRAY. CHANGE SIGN OF THE NUMBER SCANNED i.e
		// MAKE IT NEGETIVE. IF A NEGETIVE NUMBER IS ENCOUNTERED AGAIN, IT
		// IMPLIES THIS NUMBER IS GETTING REPEATED.
		for(int i=0; i<=size; i++){
			
			if(arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.print(Math.abs(arr[i]) + "   ");
		}
	}
}

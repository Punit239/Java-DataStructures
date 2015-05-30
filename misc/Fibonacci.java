// PUNIT SHARMA :: 2/19/2015
// PROGRAM TO PRINT N NUMBERS OF FIBONACCI SERIES

package misc;

public class Fibonacci {

	public static void main(String[] args) {

		Fibonacci f = new Fibonacci();
		f.printFib(10);
	}
	
	void printFib(int n){
		
		if(n==1)
			System.out.print("0");
		else{
			int first = 0;
			int sec = 1;
			int total = 0;
			
			System.out.print("0");
			for(int i=1; i<n; i++){
				
				total = first + sec;
				System.out.print(" : " + total);
				sec = first;
				first = total;
			}
		}
	}

}

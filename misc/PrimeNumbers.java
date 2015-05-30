// PUNIT SHARMA :: 10/3/2014
// PROGRAM TO FIND ALL PRIME NUMBERS LESS THAN N

package misc;

public class PrimeNumbers {

	public static void main(String[] args) {
		
		PrimeNumbers p = new PrimeNumbers();
		System.out.println("No. of prime numbers less than 50 are " 
							+ p.primeNumbers(100));
	}
	
	public int primeNumbers(int n){
		
		int current = 1;
		int count = 0;
		while(current<n){
			
			if(isPrime(current)){
				
				count++;
				System.out.println(current);
			}
				
			current++;
		}
		return count;
	}
	
	public boolean isPrime(int num){
		
		for(int i=2; i<=Math.sqrt(num); i++){
			if(num%i == 0)
				return false;
		}
		
		return true;
	}
}

package misc;

import java.util.HashSet;

public class PrimeFactors {

 // This method calculate prime factor and add it to primeFactor list
	 public static HashSet<Integer> primeFactors(int number) {
		  int n = number;
		  HashSet<Integer> primeFactors = new HashSet<Integer>();
		  for (int i = 2; i <= n; i++) {
			   while (n % i == 0) {
			    
				   primeFactors.add(i);
				   n /= i;
			   }
		  }
		  return primeFactors;
	 }

 	public static void main(String[] args) {
		  System.out.println("Primefactors of 15 are : ");
		  System.out.printf("%s %n",primeFactors(15));
		
		  System.out.println("Primefactors of 50 are :");
		  System.out.printf("%s %n",primeFactors(48));
		
		  System.out.println("Primefactors of 91");
		  System.out.printf("%s %n",primeFactors(91));
		
	 }
} 

// Punit Sharma :: 11/08/2014
// Program to find if one string is permutation of other.

package arrays;

import java.util.Arrays;

public class PermutationOfStrings {

	public static void main(String[] args) {

		PermutationOfStrings pos = new PermutationOfStrings();
		
		if(pos.permutation("string check a", "check a string"))
			System.out.println("Given strings are permutation of other");
		else
			System.out.println("Given strings are not permutation of other");
		
		System.out.println();

		if(pos.permutationAlternate("string check a", "string check b"))
			System.out.println("Given strings are permutation of other");
		else
			System.out.println("Given strings are not permutation of other");

	}
	
	// Returns sorted string
	public String sortString(String str){
		
		char[] tmpStr = str.toCharArray();
		Arrays.sort(tmpStr);
		return new String(tmpStr);
		
	}
	
	// Returns true if passed strings are permutation of each other.
	public boolean permutation(String s1, String s2){
		
		System.out.println("Results from function \"permutation\"");
		// If length of the strings is not equal, they can't be permutation of other
		if(s1.length() != s2.length())
			return false;
		// Sorts passed strings and compares them character by character. If all characters
		// at same index in two sorted strings matches strings are permutation of each other.
		else if(sortString(s1).equals(sortString(s2)))
			return true;
		else
			return false;
	}
	
	// Alternate for above method. Number of occurrence of each character in one 
	// string is stored in an array and occurrence of each character in other string
	// is matched with the occurrences of previous one.
	public boolean permutationAlternate(String s1, String s2){
		
		System.out.println("Results from function \"permutationAlternate\"");
		if(s1.length() != s2.length())
			return false;
		
		int[] timesCharScanned = new int[256];
		
		char[] s1CharArray = s1.toCharArray();
		for(char c : s1CharArray)
			// Holds occurrences of characters in s1. For characters not present in s1 
			// corresponding values will be 0
			timesCharScanned[c]++;
		
		for(int i=0; i<s2.length(); i++){
			
			int index = (int) s2.charAt(i);
			// If character is found in s1 but not in s2 then value corresponding to that index 
			// is positive and loop will continue. If value is there in s2 but not in s1 then 
			// its corresponding value in array at that index will be 0 and --timesCharScanned 
			// at that index will become negative and false will be returned.
			if(--timesCharScanned[index] < 0)
				return false;
			
		}
		
		return true;
	}
}

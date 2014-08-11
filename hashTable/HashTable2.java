// Punit Sharma :: 09/08/2014
// Program to create hash table, increase size of array holding 
// hash table, minimizing collision and clustering

package hashTable;

import java.util.ArrayList;
import java.util.Arrays;

public class HashTable2 {

	// Array to maintain hash table
	String[] theArray;
	int arraySize;
	int itemsInArray = 0;

	public HashTable2(int size) {
		
		this.arraySize = size;
		this.theArray = new String[size];
		
		// Initializing array with -1 to know which positions in array
		// have not been used. This step is optional.
		fillArrayWithNeg1();
		
	}

	public static void main(String[] args) {
		
		HashTable2 hTable = new HashTable2(30);		
		
		String[] elementsToAdd = { "30", "60", "90", "120", "150", "180",
				"210", "240", "270", "300", "330", "360", "390", "420", "450",
				"480", "510", "540", "570", "600", "989", "984", "320", "321",
				"400", "415", "450", "50", "660", "624" };
		
		hTable.hashFunction(elementsToAdd);
		hTable.displayHashTable(hTable);
		hTable.increaseArraySize(35);
		hTable.displayHashTable(hTable);
		hTable.fillArrayWithNeg1();
		hTable.doubleHashFunction(elementsToAdd);
		hTable.displayHashTable(hTable);

	}
	
	// Simple hash function that converts value to be stored to its integer value 
	// to produce key to insert actual value into array maintained for hashtable
	public void hashFunction(String[] stringsForArray){
		
		for(int i = 0; i < stringsForArray.length; i++){
			
			int key = (Integer.parseInt(stringsForArray[i])) % arraySize;
			
			while(this.theArray[key] != "-1"){
				
				System.out.println("Collision at key : " + key + ". Try key " + (key+1));
				//if(key == this.theArray.length)
				//	key = 0;
				key++;
				key %= arraySize;
				
			}
				
			System.out.println("Inserting " + stringsForArray[i] + " at index " + key);
			this.theArray[key] = stringsForArray[i];
			
		}
		
	}

	// Hash function to generate hash key by taking mod of integer value
	// of element to be stored and calculated array size to maintain hash table
	public void doubleHashFunction(String[] stringsForArray){
		
		for(int i = 0; i < stringsForArray.length; i++){
			
			int key = (Integer.parseInt(stringsForArray[i])) % arraySize;
			
			// Calculating random step index to increment key(or index)
			// to look for next available index. 
			int stepIndex = 7 - ((Integer.parseInt(stringsForArray[i])) % 7);
			
			while(this.theArray[key] != "-1"){
				
				System.out.println("Collision at key : " + key + ". Try key " + (key + stepIndex));
				// Instead of incrementing key by 1 to look for next available index
				// it is incremented by random step index to avoid clustering
				key += stepIndex;
				
				// If key has reached array size, key is made 0 to start
				// searching key from the beginning
				key %= arraySize;
				
			}
				
			System.out.println("Inserting " + stringsForArray[i] + " at index " + key);
			this.theArray[key] = stringsForArray[i];
			
		}
		
	}

	// Check if a number is prime
	public boolean isPrime(int number) {

		// Eliminate even numbers
		if (number % 2 == 0)
			return false;

		// Check if its a multiple of odd numbers
		for (int i = 3; i * i <= number; i += 2) {

			if (number % i == 0)
				return false;

		}

		// If we make it here we know it is prime
		return true;

	}
	
	// Retruns first prime number after the given number
	public int getNextPrime(int minNumbertoCheck){
		
		for(int i=minNumbertoCheck; true; i++){
			
			if(isPrime(i))
				return i;	
			
		}
		
	}
	
	// Calculating proper array size to avoid collisions. First prime number after 
	// the given array size is taken as new array size.
	public void increaseArraySize(int minArraySize){
		
		int newArraySize = getNextPrime(minArraySize);
		moveOldArray(newArraySize);
		
	}
	
	// Resizing array as per new size calculated
	public void moveOldArray(int newArraySize){
		
		String[] cleanArray = removeEmptySpacesInArray(theArray);
		this.theArray = new String[newArraySize];
		this.arraySize = newArraySize;
		
		fillArrayWithNeg1();
		hashFunction(cleanArray);
		
	}
	
	// Removes empty spaces from the array
	public String[] removeEmptySpacesInArray(String[] arrayToClean){
		
		ArrayList<String> stringList = new ArrayList<String>();
		for(String theString : arrayToClean){
			
			if(theString != "-1" && theString != "")
				stringList.add(theString);
			
		}
		
		return stringList.toArray(new String[stringList.size()]);
		
	}
	
	// Display all keys and values of hash table	
	public void displayHashTable(HashTable2 hTable){
		
		System.out.println("Index  " + "Value");
		for(int i=0; i < hTable.theArray.length; i++){
			
			System.out.println("  " + i + "  ==>  " + hTable.theArray[i] );
			
		}
		
	}
	
	// Fill array for hash table with "-1"
	public void fillArrayWithNeg1(){
		
		Arrays.fill(this.theArray, "-1");
		
	}
	
}

// Punit Sharma :: 09/08/2014
// Program to create hash table

package hashTable;

import java.util.Arrays;

public class HashTable1 {
	
	// Array to maintain hash table
	String[] theArray;
	int arraySize;
	int itemsInArray = 0;
	
	public HashTable1(int size) {
		
		this.arraySize = size;
		this.theArray = new String[size];
		
		// Initializing array with -1 to know which positions in array
		// have not been used. This step is optional.
		Arrays.fill(this.theArray, "-1");
		
	}
	
	public static void main(String[] args){
		
		HashTable1 table1 = new HashTable1(20);
		HashTable1 table2 = new HashTable1(30);
		String[] elementsToAdd = {"9","16","12","19"};
		String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
				"235", "802", "900", "723", "699", "1", "16", "999", "890",
				"725", "998", "978", "988", "990", "989", "984", "320", "321",
				"400", "415", "450", "50", "660", "624" };
		
		table1.hashFunction1(elementsToAdd);
		table1.displayHashTable(table1);
		table2.hashFunction2(elementsToAdd2);
		table2.displayHashTable(table2);
		
	}
	
	// Simple hash function that converts value to be stored to its integer value 
	// to produce key to insert actual value into array maintained for hashtable
	public void hashFunction1(String[] stringsForArray){
		
		for(int i = 0; i < stringsForArray.length; i++){
			
			// Taking key as integer value of string to be saved as key
			theArray[Integer.parseInt(stringsForArray[i])] = stringsForArray[i];
			
		}
		
		System.out.println("hashFunction1 executed.");
		
	}
	
	// Hash function to generate hash key by taking mod of integer value
	// of element to be stored and array size to maintain hash table
	public void hashFunction2(String[] stringsForArray){
		
		for(int i = 0; i < stringsForArray.length; i++){
			
			// Generating hash key
			int key = (Integer.parseInt(stringsForArray[i])) % arraySize;
			
			// Looping till a key(i.e index) is found which has not been used
			while(this.theArray[key] != "-1"){
				
				// If key found has already been used then 
				// next index is checked
				key++;
				System.out.println("Collision at key : " + (key-1) + ". Try key " + key);
				
				// If key has reached array size, key is made 0 to start
				// searching key from the beginning
				key %= arraySize;
				
			}
				
			System.out.println("Inserting " + stringsForArray[i] + " at index " + key);
			this.theArray[key] = stringsForArray[i];
			
		}
		
	}

	// Display all keys and values of hsh table 
	public void displayHashTable(HashTable1 hTable){
		
		System.out.println("Index  " + "Value");
		for(int i=0; i < hTable.theArray.length; i++){
			
			System.out.println("  " + i + "  ==>  " + hTable.theArray[i] );
			
		}
		
	}

}

// Punit Sharma :: 09/08/2014
// Program to determine if a string has all unique characters.

package arrays;

public class UniqueCharacters {

	public static void main(String[] args) {

		UniqueCharacters uc = new UniqueCharacters();
		String str = "sdkfjhbndfsdm";
		boolean allUnique = uc.uniqueChar(str);
		
		if(allUnique)
			System.out.println("Given string consists of unique characters.");
		else
			System.out.println("Given string does not contain unique characters.");
	
	}
	
	public boolean uniqueChar(String stringToCheck){
		
		// Taking ASCII value of characters as index of array
		// to know if a character has been scanned
		boolean[] charScanned = new boolean[256];
		
		// Only applicable for ASCII strings as there are only 256 ASCII values.
		if(stringToCheck.length() > 256)
			return false;
		
		for(int i=0; i < stringToCheck.length(); i++){
			
			int index = stringToCheck.charAt(i);
			if(charScanned[index])
				return false;
			
			// If a character has been scanned value corresponding to its index
			// in "charScanned" array is set to true.
			charScanned[index] = true; 
				
		}
		
		return true;
		
	}

}

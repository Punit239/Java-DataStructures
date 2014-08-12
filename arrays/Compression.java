// PUNIT SHARMA :: 08/11/2014
// PROGRAM TO PERFORM BASIC COMPRESSION ON STRING. EX. FOR STRING
// AAABBCCCCAA WILL BE A3B2C4A2.

package arrays;

public class Compression {

	public static void main(String[] args) {

		Compression c = new Compression();
		String str = "aaasssvzzzzaaaaa";
		System.out.println("Compressed string of " + str + " is " + c.compressString(str));

	}
	
	// FUNCTION TO COMPRESS GIVEN STRING
	public String compressString(String str){
		
		String compressedString = ""; 
		int count = 1;
		char last = str.charAt(0); // HOLDS A CHARACTER'S FIRST OCCURENCE AMONG 
								   // ITS CONSECTIVE OCCURENCES
		
		for(int i=1; i<str.length(); i++){
			
			if(str.charAt(i) == last)
				count++;
			
			else{
				
				// ADDING CHARACTER AND IS OCCURENCES
				compressedString += last + "" + count;
				count = 1;
				last = str.charAt(i);
			}
			
		}
		
		// CHARACTERS AT END AND THEIR COUNT WILL NOT BE ADDED AFTER THE LOOP
		// IS COMPLETE. HENCE THEY ARE ADDED HERE.
		return compressedString  + last + count;
		
	}

}

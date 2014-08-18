// PUNIT SHARMA :: 08/11/2014
// PROGRAM TO PERFORM BASIC COMPRESSION ON STRING. EX. FOR STRING
// AAABBCCCCAA WILL BE A3B2C4A2.

package arrays;

public class Compression {

	public static void main(String[] args) {

		Compression c = new Compression();
		String str = "abcd";
		System.out.println("Compressed string " + str + " to " + c.compressString(str) + 
							" by \"compressString\" method");
		System.out.println("Compressed string " + str + " to " + c.compressBetter(str) +
							" by \"compressBetter\" method");
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
	
	public String compressBetter(String str){
		
		int size = countCompression(str);
		
		// CHECK IF COMPRESSED STRING IS LARGER THAN ORIGINAL
		if(size>str.length())
			return str;
		
		StringBuffer s = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		
		for(int i=1; i<str.length(); i++){
			
			if(str.charAt(i)==last)
				count++;
			
			else{
				
				s.append(last);
				s.append(Integer.toString(count));
				last = str.charAt(i);
				count=1;
				
			}
			
		}
		
		s.append(last);
		s.append(Integer.toString(count));
		return s.toString();
	}
	
	// RETURNS LENGTH OF COMPRESSED STRING
	public int countCompression(String str){
		
		if(str.equals(null) || str.isEmpty())
			return 0;
			
		char last = str.charAt(0); // HOLDS FIRST CHARACTER OF EVERY OCCURENCE OF 
								   // EVERY SEQUENCE AS THE STRING IS TRAVERSED.
		int size = 0;
		int count = 1;
		
		for(int i=1; i<str.length(); i++){
			
			if(str.charAt(i)==last)
				count++;
			
			else{
				
				// 1 IS ADDED FOR EVERY CHARACTER SEQUENCE
				size += 1 + String.valueOf(count).length();
				last = str.charAt(i);
				count = 1;
				
			}
			
		}
		
		return size;
	}
}

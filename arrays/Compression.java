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
	
	public String compressString(String str){
		
		String compressedString = "";
		int count = 1;
		char last = str.charAt(0);
		for(int i=1; i<str.length(); i++){
			
			if(str.charAt(i) == last)
				count++;
			
			else{
				
				compressedString += last + "" + count;
				count = 1;
				last = str.charAt(i);
			}
			
		}
		
		return compressedString  + last + count;
		
	}

}

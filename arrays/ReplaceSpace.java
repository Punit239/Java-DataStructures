// PUNIT SHARMA :: 08/11/2014
// PROGRAM TO REPLACE ALL SPACES IN STRING WITH %20.

package arrays;

public class ReplaceSpace {

	public static void main(String[] args) {

		ReplaceSpace rs = new ReplaceSpace();
		String str = "Testing this string.";
		System.out.println(rs.replaceAllSpaces(str));

	}
	
	// METHOD TO REPLACE ALL SPACES IN THE GIVEN STRING
	public String replaceAllSpaces(String originalString){
		
		int originalLength = originalString.length();
		char[] originalStringArray = originalString.toCharArray();
		int spaceCount = 0;
		
		for(int i=0; i<originalLength; i++ ){
			
			if(originalStringArray[i] == ' ')
				spaceCount++;
		}
		
		// AS SPACE IS REPLACED BY %20, ARRAY'S SIZE WILL INCREASE WITH EVERY REPLACEMENT.
		// NEW LENGTH IS CALCULATED TO CREATE ANOTHER ARRAY WITH THIS LENGTH.
		int newLength = originalLength + spaceCount * 2 + 1;
		char[] newArray = new char[newLength];
		newArray[--newLength] = '\0';
		
		// READING ORIGINAL ARRAY FROM THE END AND FILLING NEW ARRAY WITH SPACE REPLACEMENT
		// FROM THE END
		for(int i=originalLength-1; i>=0; i--){
			
			if(originalStringArray[i] == ' '){
				
				newArray[newLength-1] = '0';
				newArray[newLength-2] = '2';
				newArray[newLength-3] = '%';
				
				newLength = newLength - 3;
				
			} else{
				
				newArray[newLength-1] = originalStringArray[i];
				newLength--;
			}
		}
		
		return new String(newArray);
		
	}

}

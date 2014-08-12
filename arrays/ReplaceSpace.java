// PUNIT SHARMA :: 08/11/2014
// PROGRAM TO REPLACE ALL SPACES IN STRING WITH %20. ASSUMING LENGTH OF THE STRING
// IS GIVEN AND STRING HAS ENOUGH SPACES AT END TO ACCOMODATE CHANGES.

package arrays;

public class ReplaceSpace {

	public static void main(String[] args) {

		ReplaceSpace rs = new ReplaceSpace();
		String str = "Testing this string.";
		System.out.println(rs.replaceAllSpaces(str));

	}
	
	public String replaceAllSpaces(String originalString){
		
		int originalLength = originalString.length();
		char[] originalStringArray = originalString.toCharArray();
		int spaceCount = 0;
		
		for(int i=0; i<originalLength; i++ ){
			
			if(originalStringArray[i] == ' ')
				spaceCount++;
		}
		
		int newLength = originalLength + spaceCount * 2 + 1;
		char[] newArray = new char[newLength];
		newArray[--newLength] = '\0';
		
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

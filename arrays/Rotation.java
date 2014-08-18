// PUNIT SHARMA :: 08/12/2014
// PROGRAM TO FIND IF ONE STRING IS ROTATION OF ANOTHER

package arrays;

public class Rotation {

	public static void main(String[] args) {
		
		Rotation r = new Rotation();
		String str1 = "stringcheck";
		String str2 = "checkstring";
		
		if(r.checkRotation(str1, str2))
			System.out.println("Strings are rotation of each other");
		else
			System.out.println("Strings are not rotation of each other");
		
	}
	
	// RETURN TRUE IF ONE STRING IS ROTATION OF ANOTHER. A TEMPORARY STRING HOLDS
	// TWICE OF GIVEN STRING. A ROTATION OF STRING S1 WILL ALWAYS BE A SUBSTRING 
	// OF TWICE OF S1 i.e S1S1.
	public boolean checkRotation(String s1, String s2){
		
		int s1Len = s1.length();
		if( s1Len == s2.length() && s1Len > 0){
			
			// TMPORARY STRING HOLDING TWICE OF STRING S1
			String s1s1 = s1 + s1;
			return s1s1.contains(s2);
		}
		else
			return false;
		
	}
}

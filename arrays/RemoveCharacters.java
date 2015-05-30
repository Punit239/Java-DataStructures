// PUNIT SHARMA :: 11/9/2014
// PROGRAM TO REMOVE SPECIFIED CHARACTERS FROM A STRING

package arrays;

import java.util.HashMap;

public class RemoveCharacters {

	public static void main(String[] args) {
		
		RemoveCharacters r = new RemoveCharacters();
		
		String s1 = "TESTING THIS STRING FOR REMOVAL OF CHARACTERS";
		String s2 = "AEIOU";
		System.out.println("ORIGINAL STRING : \n" + s1);
		System.out.println("\nREMOVE CHARS : " + s2);
		System.out.println("\nSTRING AFTER REMOVAL OF CHARACTERS IS : \n" +
							r.removeChars(s1, s2));
	}
	
	// RETURNS STRING AFTER REMOVING SPECIFIED CHARACTERS FROM GIVEN THE STRING
	public String removeChars(String str, String remove){
		
		char[] strArray = str.toCharArray();
		int current = 0;
		int destination = 0;

		// MAP TO HOLD TRUE VALUES AGAINST CHARACTERS TO BE REMOVED
		HashMap<Character, Boolean> removeMap = new HashMap<>();
		
		// INITIALIZING MAP
		for(char c : remove.toCharArray())
			removeMap.put(c, true);
		
		// IN PLACE ALGORITHM TO COPY VALUES, OTHER THAN THE ONE IN MAP,
		// IN THE SAME STRING ARRAY AND RETURNING THE SUB ARRAY
		while(current < str.length()){
			if(removeMap.containsKey(str.charAt(current)))
					current++;
			else
				strArray[destination++] = strArray[current++];
		}
		
		return new String(strArray, 0, destination);
	}

}

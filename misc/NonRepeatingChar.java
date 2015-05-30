// PUNIT SHARMA :: 11/5/2014
// PROGRAM TO FIND FIRST NON REPEATING CHARATER IN THE STRING

package misc;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatingChar {

	public static void main(String[] args) {

		NonRepeatingChar n = new NonRepeatingChar();
		String str = "strings to be checked";
		String str1 = "sttsaabb";
		
		char check = n.firstNonRepeatingChar(str);
		
		if(check == '\0')
			System.out.println("No repeating characters");
		else 
			System.out.println("First non repeating charter in \n\""
					+ str + "\" is " + check);
	}
	
	// RETURNS FIRST NON REPEATING CHARATER IN THE GIVEN STRING.
	// RETURNS NULL CHARACTER IF THERE'S NO REPEATING CHARACTER.
	public char firstNonRepeatingChar(String str){
		
		LinkedHashMap<Character, Integer> count = new LinkedHashMap<>();
		
		// INSERTING ALL KEYS WITH
		for(char c : str.toCharArray())
			count.put(c, count.containsKey(c) ? count.get(c) + 1 : 1);
		
		// AS THE LINKED HASHMAP MAINTAINS THE ORDER IN WHICH THE KEYS WERE INSERTED,
		// THE FIRST CHARACTER WITH THE COUNT 1 WILL BE THE FIRST NON REPEATING CHARATER.
		for(Map.Entry<Character, Integer> entry : count.entrySet()){
			
			if(entry.getValue() == 1)
				return entry.getKey();
		}
		
		return '\0';
	}
}

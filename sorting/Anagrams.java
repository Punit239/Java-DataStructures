// PUNIT SHARMA :: 09/21/2014
// PROGRAM TO PUT ALL ANAGRAMS IN AN ARRAY NEXT TO EACH OTHER

package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Anagrams {

	public static void main(String[] args) {
		
		String[] arrAnagrams = {"punit", "goat", "tinup", "barney", "toag", "yebran"};
		
		Anagrams a = new Anagrams();
		String[] sortedArray = a.sortAnagrams(arrAnagrams);
		
		for(String s : sortedArray)
			System.out.println(s);
		
	}

	// RETURNS SORTED ARRAY WITH ALL ANAGRAMS NEXT TO EACH OTHER. SORTS EVERY STRING IN
	// GIVEN ARRAY AND USE IT AS KEY TO THE HASH MAP WHICH HAS A LINKED LIST FOR EVERY 
	// UNIQUE KEY(SORTED STRING). IF A KEY IS FOUND CURRENT STRING IS ADDED TO THE LIST
	// IN HASH MAP CORRESPONDING TO THAT KEY.
	public String[] sortAnagrams(String[] tmpArr){
		
		HashMap<String, LinkedList<String>> sortedAnagrams = new HashMap<>();
		for(String str : tmpArr){
			
			char[] tmp = str.toCharArray();
			Arrays.sort(tmp);
			String tmpStr = new String(tmp);
			if(!sortedAnagrams.containsKey(tmpStr))
				sortedAnagrams.put(tmpStr, new LinkedList<String>());
			
			LinkedList<String> l = sortedAnagrams.get(tmpStr);
			l.addFirst(str);
		}
		
		// INDEX TO WRITE SORTED VALUES IN ARRAY
		int i=0;
		// FOR ALL KEYS IN HASH MAP WRITE IN GIVEN STRING ARRAY.
		for(String uniqueKeys : sortedAnagrams.keySet()){
			
			LinkedList<String> list = sortedAnagrams.get(uniqueKeys);
			for(String s : list)
				tmpArr[i++] = s;
		}
		return tmpArr;
	}
}

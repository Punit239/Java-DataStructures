// PUNIT SHARMA :: 09/20/2014
// PROGRAM TO FIND ALL PERMUTATIONS OF A STRING 

package misc;

import java.util.ArrayList;
import java.util.Scanner;

public class Permutations {

	public static void main(String[] args) {
		
		Permutations p = new Permutations();
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter your string : ");
		String stringToCheck =  s.next();
		
		System.out.println("Permutations of string \"" + stringToCheck + "\" are : ");
		p.printPermutations(p.getPermutations(stringToCheck));
		
		s.close();
	}
	
	public ArrayList<String> getPermutations(String tmpStr){
		
		if(tmpStr == null)
			return null;
		
		ArrayList<String> perm = new ArrayList<>();
		if(tmpStr.length() == 0){
			
			perm.add("");
			return perm;
		}
		
		char first = tmpStr.charAt(0);
		String remainder = tmpStr.substring(1);
		ArrayList<String> words = getPermutations(remainder);
		for(String word : words){
			for(int j=0; j<=word.length(); j++){
				
				String s = insertCharAt(word, first, j);
				perm.add(s);
			}
		}
		
		return perm;
	}
	
	public String insertCharAt(String word, char first, int i){
		
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + first + end;
	}
	
	public void printPermutations(ArrayList<String> tmpList){
		
		for(String words : tmpList)
			System.out.println(words);
	}
}

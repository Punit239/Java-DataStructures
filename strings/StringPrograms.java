// PUNIT SHARMA :: 2/28/2015
// PROGRAM TO : 
// 1. REVERSE STRING
// 2. REVERSE WORDS OF STRING

package strings;

public class StringPrograms {

	public static void main(String[] args) {

		StringPrograms sp = new StringPrograms();
		sp.reverseWordsOfString("Return the reverse of this string");
		sp.reverseString("Return the reverse of this string");
	}
	
	public void reverseWordsOfString(String s){
		
		if(s.isEmpty())
			return;
		
		StringBuilder sb = new StringBuilder();
		String[] arr = s.split(" ");
		display(arr);
		System.out.println("Reverse words of string:");
		for(int i=arr.length-1; i>=0; i--){
			
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb.substring(0, sb.length()-1));
	}
	
	public void reverseString(String s){
		
		System.out.println("Reverse string:");
		StringBuilder sb = new StringBuilder();
		char[] tmp = s.toCharArray();
		for(int i=tmp.length-1;i>=0;i--)
			sb.append(tmp[i]);
		System.out.println(sb);
	}

	public void display(String[] arr){
		
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}

// PUNIT SHARMA :: 09/21/2014
// PROGRAM TO FIND THE LOCATION OF A STRING IN A SORTED 
// ARRAY OF STRINGS WHICH IS INTERSPERED WITH EMPTY STRINGS. 

package searching;

public class searchInArray {

	public static void main(String[] args) {
		
		String[] names = {"punit", "james", "", "vivek", "shandeep", "", "", "susie", 
							"brittany", "clarice", ""};
		searchInArray s = new searchInArray();
		System.out.println( "\"james\" found at position : " + 
					(s.search(names, "james", 0, (names.length -1)) + 1));
	}
	
	public int search(String[] strArr, String str, int first, int last){
		
		if(strArr == null || str == null || str == "")
			return -1;
		
		return searchArray(strArr, str, first, last);
	}
	
	public int searchArray(String[] strArr, String str, int first, int last){
		
		if(first > last)
			return -1;
		
		int mid = (first+last)/2;
		int left = mid - 1;
		int right = mid + 1;
		
		if(strArr[mid] == ""){
			
			while(true){
				
				if(left < first || right > last)
					return -1;
				else if(left > first && !strArr[left].isEmpty()){
					
					mid = left;
					break;
				}
				else if(right < last && !strArr[right].isEmpty()){
					
					mid = right;
					break;
				}
				right++;
				left--;
			}
		}
		
		if(str.equals(strArr[mid]))
			return mid;
		else if(str.compareTo(strArr[mid]) < 0)
			return searchArray(strArr, str, first, mid - 1);
		else
			return searchArray(strArr, str, mid + 1, last);
	}
}

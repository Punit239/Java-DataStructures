// PROGRAM TO FIND THE LONGEST INCREASING SUBSEQUENCE IN AN ARRAY

package arrays;

public class LongestSubSeq {

	public static void main(String[] args) {
		
		int[] arr = {5,2,10,11,12,19,6,20};
		
		LongestSubSeq lss = new LongestSubSeq();
		lss.longestSubSequence(arr);

	}
	
	public void longestSubSequence(int[] a){
		
		int i=0;
		int maxLen=0;
		int subSeqStart=0;
				
		while(i<a.length-2){
			
			int l = subSeq(a,i);
			if(maxLen<l){
				
				subSeqStart=i;
				maxLen=l;
				i=i+maxLen-1;
			}
			
			i++;
		}
		
		System.out.println("Longest sub sequence is from index : " + a[subSeqStart] + " to " + 
								a[(subSeqStart+maxLen-1)]);
	}
	
	public int subSeq(int[] tmp, int start){
		
		int count=1;
		while(tmp[start]<tmp[start+1]){
			count++;
			start++;
		}
		return count;
	}

}

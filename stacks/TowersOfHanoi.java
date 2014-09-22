// PUNIT SHARMA :: 8/25/2014
// PROGRAM TO SOLVE TOWERS OF HANOI USING STACKS

package stacks;

import java.util.Stack;

public class TowersOfHanoi {
	
	private Stack<Integer> disks;
	private int index;
	public TowersOfHanoi(int i){
		
		disks = new Stack<Integer>();
		index = i;
	}

	public static void main(String[] args) {
		
		int n = 3;
		TowersOfHanoi[] towers = new TowersOfHanoi[n];
		for (int i = 0; i < 3; i++)
			towers[i] = new TowersOfHanoi(i);
		
		for (int i = n - 1; i >= 0; i--)
				towers[0].disks.push(i);
		
		towers[0].moveDisks(n, towers[2], towers[1]);
	}
	
	public int index(){
		
		return index;
	}
	
	public void add(int num){
		
		if(!disks.isEmpty() && (disks.peek() < num) )
			System.out.println("Error placing disk " + num );
		else
			disks.push(num);
	}
	
	public void moveTopTo(TowersOfHanoi t){
		
		int top = disks.pop();
		t.disks.push(top);
		System.out.println("Move disk " + top + " from " + index() + " to " + t.index());
	}
	
	public void moveDisks(int n,  TowersOfHanoi destination, TowersOfHanoi buffer) {
		if (n > 0) {
			moveDisks(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
	}
}

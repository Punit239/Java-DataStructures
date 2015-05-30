// FINDING A NUMBER IN A MATRIX

package searching;

public class SortedMatrix {

	public static void main(String[] args) {

		int[][] sortedMatrix = new int[5][5];
		SortedMatrix s = new SortedMatrix();
		
		int value=100;
		for(int i=0; i<5; i++)
			for(int j=0; j<5; j++){
				
				sortedMatrix[i][j] = value;
				value +=5;
			}
		
		s.display(sortedMatrix);
		s.find(185, sortedMatrix);
	}
	
	public void display(int[][] tmp){
		
		System.out.println("Given matrix :");
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				
				System.out.print(tmp[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	// SCANNING ENTIRE ARRAY TO FIND VALUE. PRINTS INDEX WHERE THE GIVEN ELEMENT IS FOUND.
	public void find(int value, int[][] tmpMat){
		
		int row = 0;
		int col = tmpMat.length-1;
		
		while(row < tmpMat.length && col < tmpMat.length){
			
			if(tmpMat[row][col] == value){
				
				System.out.println(value + " found at index " + row + "," + col);
				return;
			}
			else if(tmpMat[row][col] > value)
				col--;
			else
				row++;
		}
		
		System.out.println(value + "  not found.");
	}
}

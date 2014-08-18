// PUNIT SHARMA :: 08/12/2014
// PROGRAM TO SET ALL ELEMENTS OF A ROW OR COLUMN TO ZERO IF THERE'S 
// ANY ZERO IN THAT ROW OR COLUMN

package arrays;

public class SetZeroes {

	public static void main(String[] args) {

		int[][] mat = {{1,2,0,4}, {5,6,7,8}, {9,0,11,12}, {13,14,15,16}};
		
		SetZeroes sz = new SetZeroes();
		System.out.println("Original array :");
		sz.displayMatrix(mat);
		sz.setRowColToZeroes(mat);
		sz.displayMatrix(mat);
	}
	
	// SET ALL ELEMENTS OF A ROW OR COLUMN WITH ANY ZERO TO ZERO  
	public void setRowColToZeroes(int[][] matrix){
		
		System.out.println("Setting zeroes...");
		boolean[] row = new boolean[matrix.length];
		boolean[] col = new boolean[matrix.length];
		
		// FIND ROW NUMBER AND COLUMN NUMBER HAVING ZEROES
		for(int i=0; i<matrix.length; i++)
			for(int j=0; j<matrix.length; j++){
				
				if(matrix[i][j]==0){
					
					row[i] = true;
					col[j] = true;
					
				}
				
			}
		
		// SETTING ELEMENTS OF ROW AND COLUMN FOUND ABOVE TO ZERO 
		for(int i=0; i<matrix.length; i++)
			for(int j=0; j<matrix.length; j++)
				if(row[i] || col[j])
					matrix[i][j]=0;
	}
	
	// DISPLAYS MATRIX ROW WISE
	public void displayMatrix(int[][] matrix){
		
		for(int i=0; i<matrix.length; i++){
			
			for(int j=0; j<matrix.length; j++)
				System.out.print(matrix[i][j] + "\t");
			
			System.out.println();
		}
		
	}

}

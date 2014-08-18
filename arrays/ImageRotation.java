// PUNIT SHARMA :: 08/12/2014
// ROTATE AN IMAGE REPRESENTED BY N X N MATRIX BY 90 DEGREES

package arrays;

public class ImageRotation {
	
	public static void main(String[] args){
		
		int[][] mat = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}}; 
				   
		ImageRotation ir = new ImageRotation();
		ir.displayMatrix(mat, 4);
		ir.rotateImage(mat, 4);
		ir.displayMatrix(mat, 4);
		
	}
	
	// ROTATES A MATRIX BY 90 DEGREES
	public void rotateImage(int[][] matrix, int n){
		
		System.out.println("Rotating matrix...");
		for(int layer=0; layer<n/2; layer++){
			
			int first = layer;
			int last = n-1-layer;
			
			for(int i=first; i<last; i++){
				
				int offset = i - first;
				
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[i][last];
				matrix[i][last] = top;
				
			}
			
		}
		
	}
	
	// DISPLAYS MATRIX ROW WISE
	public void displayMatrix(int[][] matrix, int n){
		
		for(int i=0; i<n; i++){
			
			for(int j=0; j<n; j++)
				System.out.print(matrix[i][j] + "\t");
			
			System.out.println();
		}
		
	}

}

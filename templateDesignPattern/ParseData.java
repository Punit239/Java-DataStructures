// PUNIT SHARMA :: 2/22/2015
// CLASS DECIDING THE STEPS OF THE ALGORITHM TO BE IMPLEMENTING

package templateDesignPattern;

public abstract class ParseData {

	// METHOD THAT GIVES THE STEPS OF THE ALGORITHM. 
	// THIS IS THE ALGORITHM TO BE IMPLEMENTED. 
	public final void dataParser(){
		
		getData();
		processData();
		writeData();
	}
	
	// SPECIFIC STEPS OF THE ALGORITHM THAT WILL BE DEFINED BY THE SUBCLASSES
	public abstract void getData();
	public abstract void processData();
	
	// COMMON IMPLEMENTATION FOR ALL THE CLASSES
	public void writeData() {
		
		System.out.println("Writing data to the output file.");
	}
}

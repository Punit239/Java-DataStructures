package templateDesignPattern;

public class DatabaseDataParser extends ParseData {

	@Override
	public void getData() {
		
		System.out.println("Getting data from database.");
	}

	@Override
	public void processData() {

		System.out.println("Processing data from database.");
	}
}

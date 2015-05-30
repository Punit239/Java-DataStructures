package factoryDesignPattern;

public class SedanCar implements Car {

	@Override
	public void giveSegment() {
		
		System.out.println("This car belongs to sedan segment");
	}
	
	
}

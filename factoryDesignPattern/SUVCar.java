package factoryDesignPattern;

public class SUVCar implements Car {

	@Override
	public void giveSegment() {
		
		System.out.println("This car belongs to SUV segment");
	}

}

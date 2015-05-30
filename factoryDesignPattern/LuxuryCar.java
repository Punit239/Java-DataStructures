package factoryDesignPattern;

public class LuxuryCar implements Car{

	@Override
	public void giveSegment() {
		
		System.out.println("This car belongs to luxury segment");
	}

}

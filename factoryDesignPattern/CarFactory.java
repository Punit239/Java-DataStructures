package factoryDesignPattern;

public class CarFactory {

	public Car giveCar(String carSegment){
		
		if(carSegment == "Luxury")
			return new LuxuryCar();
		
		if(carSegment == "Sedan")
			return new SedanCar();
		
		if(carSegment == "SUV")
			return new SUVCar();
		
		return null;
	}
}

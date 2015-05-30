package factoryDesignPattern;

public class CheckFactory {

	public static void main(String[] args) {
		
		CarFactory carFactory = new CarFactory();
		
		Car mercedes = carFactory.giveCar("Luxury");
		Car nissan = carFactory.giveCar("Sedan");
		Car jeep = carFactory.giveCar("SUV");
		
		mercedes.giveSegment();
		nissan.giveSegment();
		jeep.giveSegment();
	}

}

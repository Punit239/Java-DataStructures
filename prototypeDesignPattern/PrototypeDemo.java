package prototypeDesignPattern;

public class PrototypeDemo {

	public static void main(String[] args) {
		
		ShapeCache shapeCache = new ShapeCache();
		shapeCache.loadCache();
		
		Shape clonedShape1 = shapeCache.getShape("1");
		clonedShape1.draw();
		
		Shape clonedShape2 = shapeCache.getShape("2");
		clonedShape2.draw();
		
	}
}

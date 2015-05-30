package prototypeDesignPattern;

import java.util.HashMap;

public class ShapeCache {
	
	HashMap<String, Shape> map = new HashMap<String, Shape>();
	
	public Shape getShape(String shapeId){
		
		Shape cachedShape = map.get(shapeId);
		return (Shape) cachedShape.cloneObject();
	}
	
	public void loadCache(){
		
		Circle circle = new Circle();
		circle.setId("1");
		map.put("1", circle);
		
		Rectangle rectangle = new Rectangle();
		rectangle.setId("2");
		map.put("2", rectangle);
	}
}

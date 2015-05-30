package stateDesignPattern;

public class TVOffState implements TVState {

	TV tv;
	
	public TVOffState(TV newTV){
		
		tv = newTV;
		
	}
	
	@Override
	public void turnTVOn() {
		
		System.out.println("TV turned On");
		tv.setTVState(tv.getTVOnState());
		
	}

	@Override
	public void turnTVOff() {
		
		System.out.println("TV already turned off");
		
	}
}

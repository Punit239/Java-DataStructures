package stateDesignPattern;

public class TVOnState implements TVState {

	TV tv;
	
	public TVOnState(TV newTV){
		
		tv = newTV;
		
	}
	
	@Override
	public void turnTVOff() {
		
		System.out.println("TV turned off");
		tv.setTVState(tv.getTVOffState());
		
	}
	
	@Override
	public void turnTVOn() {
		
		System.out.println("TV already turned On");
		
	}
}

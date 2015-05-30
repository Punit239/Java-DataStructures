package stateDesignPattern;

public class TV {

	TVState tvOff;
	TVState tvOn;
	
	TVState tvstate;
	
	public TV(){
		
		tvOff = new TVOffState(this);
		tvOn = new TVOnState(this);
		tvstate = tvOff;
	
	}
	
	public void setTVState(TVState newTVState){
		
		tvstate = newTVState;
	}
	
	public TVState getTVOffState(){
		
		return tvOff;
	}
	
	public TVState getTVOnState(){
		
		return tvOn;
	}
	
	public void turnOnMyTV(){
		
		tvstate.turnTVOn();
	}
	
	public void turnOffMyTV(){
		
		tvstate.turnTVOff();
	}
}

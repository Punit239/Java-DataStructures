// PUNIT SHARMA :: 2/6/2015
// CLASS IMPLEMENTING OLD SYSTEM

package adapter;

public class RoboZ implements OldRobot {

	@Override
	public void walk() {

		System.out.println("Robot is walking");
	}

	@Override
	public void mannualShoot() {
		
		System.out.println("Robot shoots mannually");
	}

	@Override
	public void mannualScan() {
		
		System.out.println("Robot detects danger mannually");
	}	
}

// PUNIT SHARMA :: 2/6/2015
// CLASS UPGRADING OLD SYSTEM BY CALLING
// ADVANCED METHODS USING EXISTING OLD METHODS OR INTERFACE

package adapter;

public class UpgradedRobot implements OldRobot{

	RoboX robox = new RoboX();
	@Override
	public void walk() {
		
		robox.run();
	}

	@Override
	public void mannualShoot() {
		
		robox.autoShoot();
	}

	@Override
	public void mannualScan() {
		
		robox.autoDetect();
	}
}

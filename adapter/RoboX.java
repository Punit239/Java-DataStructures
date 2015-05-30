// PUNIT SHARMA :: 2/6/2015
// CLASS IMPLEMENTING ADVANCED SYSTEM

package adapter;

public class RoboX implements AdvancedRobot {

	@Override
	public void run() {
		
		System.out.println("Robot is running");
	}

	@Override
	public void autoShoot() {

		System.out.println("Robot shoots automatically");
	}

	@Override
	public void autoDetect() {

		System.out.println("Robot detects danger automatically");
	}

}

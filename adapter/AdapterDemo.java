// PUNIT SHARMA :: 2/6/2015
// PROGRAM TO IMPLEMENT ADAPTER DESIGN PATTERN

package adapter;

public class AdapterDemo {

	public static void main(String[] args) {
		
		RoboZ oldy = new RoboZ();
		RoboX advanced = new RoboX();
		UpgradedRobot upgraded = new UpgradedRobot();
		
		System.out.println("Oldy : ");
		oldy.walk();
		oldy.mannualShoot();
		oldy.mannualScan();
		
		System.out.println("Advanced : ");
		advanced.run();
		advanced.autoShoot();
		advanced.autoDetect();
		
		System.out.println("Upgraded : ");
		upgraded.walk();
		upgraded.mannualShoot();
		upgraded.mannualScan();
	}
}

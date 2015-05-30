// PUNIT SHARMA :: 2/22/2015
// PROGRAM TO IMPLEMENT TEMPLATE DESIGN PATTERN

package templateDesignPattern;

public class CheckParser {

	public static void main(String[] args) {
		
		CSVDataParser csv = new CSVDataParser();
		DatabaseDataParser db = new DatabaseDataParser();
		
		csv.dataParser();
		db.dataParser();
	}
}

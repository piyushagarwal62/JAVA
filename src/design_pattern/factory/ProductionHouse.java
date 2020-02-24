package design_pattern.factory;

/**
 * @author piyush
 *
 */
public class ProductionHouse {

	public static void main(String[] args) {
		CarFactory obj = new CarFactory();
		Car honda = obj.createCar("Honda", 4, false);
		Car bmw = obj.createCar("BMW", 2, true);
		System.out.println("Honda object: " + honda);
		System.out.println("BMW object :" + bmw);
	}
}

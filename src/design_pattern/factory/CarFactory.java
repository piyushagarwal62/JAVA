package design_pattern.factory;

/**
 * @author piyush
 * Factory Class to get object of from different model classes.
 */
public class CarFactory {

	public Car createCar(String name, int noOfDoors, boolean isAutomatic){
		Car obj = null;
		if(name.equals("Honda")){
			obj = new Honda("CIVIC", noOfDoors, isAutomatic);
		}else if(name.equals("BMW")){
			obj = new BMW("BMW X3",noOfDoors, isAutomatic);
		}
		return obj;
	}
}

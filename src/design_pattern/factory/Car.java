package design_pattern.factory;

/**
 * @author piyush
 *
 */
public abstract class Car {
	
	int noOfDoors;
	boolean isAutomatic;
	String carName;
	
	public abstract int getNoOfDoors();
	public abstract boolean isAutomatic();
	public abstract String getCarName();
	
	@Override
	public String toString() {
		return this.carName + ":" + noOfDoors + " :" + isAutomatic;
	}

}

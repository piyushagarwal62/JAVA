package design_pattern.factory;

public class Honda extends Car {
	
	public Honda(String carName, int noOfDoors,  boolean isAutomatic){
		this.carName = carName;
		this.noOfDoors = noOfDoors;
		this.isAutomatic = isAutomatic;
	}
	
	public String getCarName(){
		return carName;
	}
	
	@Override
	public int getNoOfDoors() {
		return noOfDoors;
	}

	@Override
	public boolean isAutomatic() {
		return isAutomatic;
	}

}

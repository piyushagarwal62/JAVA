package inheritance;

abstract class Car {

	int noOfDoors;
	static int number;
	
	public Car(){
		System.out.println("Inside Car Constructor");
	}
	
	public void runOnFourWheel(){
		
	}
	
	abstract void runOnFuel();
	
	abstract void getNumberOfDoors();
}

public class Innova extends Car{
	
	public Innova() {
		super();
		noOfDoors = 4;
	}
	
	@Override
	void runOnFuel() {
		System.out.println("It is running on Petrol");		
	}
	
	@Override
	void getNumberOfDoors() {
		System.out.println("The number of doors is : " + noOfDoors);
	}
	
	public static void main(String[] args) {
		Innova obj = new Innova();
		obj.getNumberOfDoors();
		obj.runOnFuel();
		obj.runOnFourWheel(); 
	}
}
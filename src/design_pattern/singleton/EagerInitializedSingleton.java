package design_pattern.singleton;

/**
 * @author piyush
 *
 */
public class EagerInitializedSingleton {

	int number;
	
	//Object gets created during class loading time
	//And get calls only once
	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

	// private constructor to avoid client applications to use constructor
	private EagerInitializedSingleton() {
	}

	public static EagerInitializedSingleton getInstance() {
		return instance;
	}
	
	public int getNumber(){
		return number;
	}
	
	public void setNumber(int number){
		this.number = number;
	}
	
	public static void main(String[] args) {
		EagerInitializedSingleton.getInstance().setNumber(5);
		System.out.println(EagerInitializedSingleton.getInstance()
				.getNumber()); // 5 (Same object is changed)
		EagerInitializedSingleton.getInstance().setNumber(10);
		System.out.println(EagerInitializedSingleton.getInstance()
				.getNumber()); // 10 (Same object is changed)
	}
}

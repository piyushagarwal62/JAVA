package design_pattern.singleton;

/**
 * @author piyush
 *
 */
public class LazyInitializedSingleton {
	private static LazyInitializedSingleton instance;

	int number;

	private LazyInitializedSingleton() {
	}

	//Object is created only once and when it is required.
	public static LazyInitializedSingleton getInstance() {
		if (instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}
		
	public int getNumber(){
		return number;
	}
	
	public void setNumber(int number){
		this.number = number;
	}
	
	public static void main(String[] args) {
		LazyInitializedSingleton.getInstance().setNumber(5);
		System.out.println(LazyInitializedSingleton.getInstance()
				.getNumber()); // 5 (Same object is changed)
		LazyInitializedSingleton.getInstance().setNumber(10);
		System.out.println(LazyInitializedSingleton.getInstance()
				.getNumber()); // 10 (Same object is changed)
	}
}

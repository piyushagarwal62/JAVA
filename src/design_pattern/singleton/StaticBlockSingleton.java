package design_pattern.singleton;

/**
 * @author piyush
 *
 */
public class StaticBlockSingleton {
	private static StaticBlockSingleton instance;

	int number;

	private StaticBlockSingleton() {
	}

	// static block initialization for exception handling
	

	//Object gets created during class loading time
	//static block will be called only once
	static {
		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static StaticBlockSingleton getInstance() {
		return instance;
	}
	
	public int getNumber(){
		return number;
	}
	
	public void setNumber(int number){
		this.number = number;
	}
	
	public static void main(String[] args) {
		StaticBlockSingleton.getInstance().setNumber(5);
		System.out.println(StaticBlockSingleton.getInstance()
				.getNumber()); // 5 (Same object is changed)
		StaticBlockSingleton.getInstance().setNumber(10);
		System.out.println(StaticBlockSingleton.getInstance()
				.getNumber()); // 10 (Same object is changed)
	}

}

package design_pattern.singleton;

/**
 * @author piyush
 *
 */
public class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance;

	int number;
	
	private ThreadSafeSingleton() {
	}

	//Getting the instance by having thread safe execution by using
	//synchronized keyword
	public static synchronized ThreadSafeSingleton getInstance() {
		if (instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}
	
	//Getting the instance using double locking mechanism
	public static synchronized ThreadSafeSingleton getInstanceUsingDoubleLocking(){
	    if(instance == null){
	        synchronized (ThreadSafeSingleton.class) {
	            if(instance == null){
	                instance = new ThreadSafeSingleton();
	            }
	        }
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
		ThreadSafeSingleton.getInstance().setNumber(5);
		System.out.println(ThreadSafeSingleton.getInstance()
				.getNumber()); // 5 (Same object is changed)
		ThreadSafeSingleton.getInstance().setNumber(10);
		System.out.println(ThreadSafeSingleton.getInstance()
				.getNumber()); // 10 (Same object is changed)
	}
}

package thread_implementation.extend;

public class MyThread extends Thread {
	MyThread(String name) {
		// Create a new, second thread
		super(name);
		System.out.println(this.getName() + ": " + this);
		start(); // Start the thread
	}

	public void start1() {
		System.out.println("Inside Start method");

	}

	// This is the entry point for the second thread.
	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println(this.getName() + ": " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println(this.getName() + "Interuppted");
		}
		System.out.println("Exiting " + this.getName());
	}
}

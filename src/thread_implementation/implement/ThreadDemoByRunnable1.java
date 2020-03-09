package thread_implementation.implement;

public class ThreadDemoByRunnable1 {

	public static void main(String[] args) {
		runFromRunnableThread();
	}

	public static void runFromRunnableThread() {
		MyThread1 obj = new MyThread1(); // create a new thread
		Thread thread = new Thread(obj, "ChildThread");
		thread.setPriority(10);
		thread.start();

		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Main Thread: " + i);
				Thread.sleep(1000);
				thread.interrupt();
			}
			System.out.println(Thread.currentThread().isAlive());
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		/*
		 * try { thread.join(); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		System.out.println("Main thread exiting.");
	}

}

class MyThread1 implements Runnable {

	MyThread1() {
		super();
		// Create a new thread
	}

	// This is the entry point for the thread.
	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Child Thread: " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Child interrupted.");
		}
		System.out.println("Exiting child thread.");
	}
}
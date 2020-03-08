package thread_implementation.extend;

public class ThreadDemoByRunnable {

	public static void main(String[] args) {
		runFromRunnableThread();
	}
	
	public static void runFromRunnableThread(){
		MyThread obj = new MyThread(); // create a new thread
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Main Thread: " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		try {
			obj.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread exiting.");		
	}

}



class MyThread implements Runnable {
	Thread thread;

	MyThread() {
		// Create a new, second thread
		thread = new Thread(this, "Demo Thread");
		System.out.println("Child thread: " + thread);
		thread.start(); 
	}

	// This is the entry point for the second thread.
	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Child Thread: " + i);
				Thread.sleep(1500);
			}
		} catch (InterruptedException e) {
			System.out.println("Child interrupted.");
		}
		System.out.println("Exiting child thread.");
	}
}
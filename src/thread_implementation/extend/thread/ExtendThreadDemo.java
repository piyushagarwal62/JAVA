package thread_implementation.extend.thread;

class ExtendThreadDemo {
	public static void main(String args[]) {
		MyThread myThread1 = new MyThread("FirstThread");
		MyThread myThread2 = new MyThread("SecondThread");

		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Main Thread: " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		System.out.println("Main thread exiting.");
	}
}
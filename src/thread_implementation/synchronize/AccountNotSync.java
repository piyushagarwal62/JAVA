package thread_implementation.synchronize;

/**
 * @author piyush
 *
 */
public class AccountNotSync implements Runnable {

	private Account acct = new Account();

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			makeWithdrawal(10);
			if (acct.getBlanace() < 0) {
				System.out.println("Account is overdrawn!");
			}
		}
	}

	//Remove the synchronized keyword to get asynchronous working
	private synchronized void makeWithdrawal(int amt) {
		if (acct.getBlanace() >= amt) {
			System.out.println(Thread.currentThread().getName() + " is going to withdraw");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			acct.withdraw(amt);
			System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
		} else {
			System.out.println("Not enough in the account for " + Thread.currentThread().getName() + " to withdraw "
					+ acct.getBlanace());
		}

	}

	public static void main(String[] args) {

		AccountNotSync obj = new AccountNotSync();
		Thread one = new Thread(obj);
		one.setName("Chintu");

		Thread two = new Thread(obj);
		two.setName("Bantu");

		one.start();
		two.start();
	}

}

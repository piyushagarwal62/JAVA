package thread_implementation.synchronize;

/**
 * @author piyush
 *
 */
public class Account {

	private int balance = 50;

	public int getBlanace() {
		return balance;
	}

	public void withdraw(int amount) {
		balance = balance - amount;
	}

}

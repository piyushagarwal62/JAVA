package innerclass;

public class Bank {

	int ifsccode;
	int customers;
	String name;
	
	public void loanFacility(){
		int number = 122;

		class LoanAccount{
			int totalAmount = 20000;
			
			void depositEMI(int installment){
				totalAmount -= installment;
			}
		}
		LoanAccount obj = new LoanAccount();
		obj.depositEMI(2000);
		
	}
	
	
	abstract class Account{
		int number;
		
		public abstract void typeOfAccount();
		
		public void deposit(int amount){
			
			System.out.println("Deposited money"  + amount);
		}
		
		void printIFSCCode(){
			System.out.println(ifsccode);
		}
	}
	
	final class CurrentAccount extends Account{
		String name;
		@Override
		public void typeOfAccount() {
			System.out.println("it is current account type");
			this.name = "Piyush";
			Bank.this.name = "Rahul";

		}
	}
	
	public int getNumberOfCustomers(){
//		System.out.println(number); //Illegal
		this.ifsccode = 123;
		return customers;
	}
	
	public static void main(String[] args) {
		Bank obj = new Bank();
		obj.getNumberOfCustomers();
		Bank.Account acc = obj.new CurrentAccount();
		
		acc.deposit(1000);
		acc.number = 100;
		Bank.Account acc1 = new Bank().new CurrentAccount();
		acc1.printIFSCCode();
		acc1.deposit(2000);
		
	}

}

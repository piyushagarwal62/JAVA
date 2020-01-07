package arrays;

import java.util.Scanner;

public class FindPrimeNumber {

	static int[] num;
	
	public static void accept(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = sc.nextInt();
		System.out.println("Enter the numbers");
		num = new int[n];
		
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
	}
	
	public static boolean isPrime(int num){
		for(int i =2; i<num/2; i++){
			if(num%i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		accept();
		System.out.println("Prime numbers are");
		for (int i = 0; i < num.length; i++) {
			if(isPrime(num[i])){
				System.out.print(num[i] + ",");
			}
		}
	}

}

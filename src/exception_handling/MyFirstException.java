package exception_handling;

import java.util.Scanner;

/**
 * @author piyush.agarwal
 *
 */
public class MyFirstException {
	
	public static void main(String[] args) {
		try{
			method1();
			System.out.println("After Try block");
		}catch(Exception e){
			System.out.println("Exception handled here");
			e.printStackTrace();
		}
		System.out.println("After Exception handling code");
	}

	private static void method1() {
		int arr[] = new int[5];
		
		arr = null;
		System.out.println("Enter values");
		try(Scanner sc = new Scanner(System.in)){			
			for (int i = 0; i < 5; i++) {
				arr[i] = sc.nextInt();
			}
			arr = null;
			arr[2] = 2;
		}catch(NullPointerException ne){
			ne.printStackTrace();
			arr = new int[5];
			try(Scanner sc = new Scanner(System.in);){
				for (int i = 0; i < 5; i++) {
					arr[i] = sc.nextInt();
				}
				System.exit(0);
				return;
			}catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
				System.out.println("Exception is handled for last index");
			}
		}finally{
			//Finally block is used to close all IO objects
			System.out.println("Its in finally block");
//			sc.close(); // It wont work since using try with resources
		}
		
		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);			
		}
		System.out.println("Code is running");
	}
	
}

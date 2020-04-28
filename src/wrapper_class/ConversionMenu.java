package wrapper_class;

import java.util.Scanner;

public class ConversionMenu {

	public static void main(String[] args) {
		char choice = 'y';
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Enter your preference");
			System.out.println("1. Convert from Decimal to Binary");
			System.out.println("2. Convert from Decimal to Octal");
			System.out.println("3. Convert from Decimal to Hexadecimal");
			int pref = sc.nextInt();

			switch (pref) {
			case 1:
				System.out.println("Enter a decimal values");
				int no = sc.nextInt();
				System.out.println("Binary value is: " + Integer.toBinaryString(no));
				break;
				
			case 2:
				System.out.println("Enter a decimal values");
				no = sc.nextInt();
				System.out.println("Octal value is: " + Integer.toOctalString(no));
				break;

			case 3:
				System.out.println("Enter a decimal values");
				no = sc.nextInt();
				System.out.println("Hexadecimal  value is: " + Integer.toHexString(no));
				break;
				
			case 4:
				System.out.println("Number" + " " + "Binary");
				for (int i = 0; i < 101; i++) {
					System.out.println(" " + i + "\t" + Integer.toBinaryString(i));
					
				}
				break;

			default:
				System.out.println("Please enter valid information");
				break;
			}
			System.out.println("Do you want to enter again, then say \'y\'");
			choice = sc.next().charAt(0);
			
		}while(choice == 'y');
		sc.close();

	}

}
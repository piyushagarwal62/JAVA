package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class StringArrayReverse {

	public static void main(String[] args) {
		System.out.println("Enter the array size");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		System.out.println("Enter the string values");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		for (int i = 0; i < arr.length / 2; i++) {
			String temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}

		System.out.println("After reversing the array");
		System.out.println(Arrays.toString(arr));
		sc.close();
	}
}

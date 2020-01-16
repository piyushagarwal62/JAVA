package strings;

import java.util.Scanner;

public class StringCharFrequency {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = sc.nextLine();
		str = str.toUpperCase();
		int[] arr = new int[26];
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 65;
			if(index < 0 || index > 25)
				continue;
			arr[index] = arr[index] + 1; 
		}
		System.out.println("Character" + "|" + "Frequency");
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > 0 ){
				System.out.println(((char)(i+65)) + "\t" + arr[i]);
			}
		}
		sc.close();
	}
	
}

package string_assignments;

import java.util.Scanner;

/**
 * @author piyush
 * string with all doubled letters in the string replaced by a single letter.
 */
public class RemoveDoubleLetters {

	private static String removeDoubleLetters(String inputString){
		StringBuilder updatedStr = new StringBuilder();

		for (int i = 0; i < inputString.length()-1; i++) {
			char first = inputString.charAt(i);
			char second = inputString.charAt(i+1);
			if(first!= second){
				updatedStr.append(first);				
			}
		}
		updatedStr.append(inputString.charAt(inputString.length()-1));
		return updatedStr.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("Enter a string to remove double letters:");
		Scanner sc = new Scanner(System.in);
		String inputString = sc.next();
		String outputString = removeDoubleLetters(inputString);
		System.out.println("Output:\nString after removing double letters: " + outputString);
		sc.close();
	}

}

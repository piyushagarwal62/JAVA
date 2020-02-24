package string_assignments;

import java.util.Scanner;

/**
 * @author piyush
 * 
 * Scrabble scoring:
 */
public class Scrabble {

	public static void main(String[] args) {
		System.out.println("Enter a string for scrable:");
		Scanner sc = new Scanner(System.in);
		String inputString = sc.next();
		int outputValue = calculatePoints(inputString);
		System.out.println("Scrabble Output: " + outputValue);
		sc.close();
	}
	
	private static int calculatePoints(String word) {
		word = word.toUpperCase();
		int sumOfLetters = 0;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			switch (ch) {
			case 'A':
			case 'E':
			case 'I':
			case 'L':
			case 'N':
			case 'O':
			case 'R':
			case 'S':
			case 'T':
			case 'U':
				sumOfLetters += 1;
				break;
			case 'D':
			case 'G':
				sumOfLetters += 2;
				break;
			case 'B':
			case 'C':
			case 'M':
			case 'P':
				sumOfLetters += 3;
				break;
			case 'F':
			case 'H':
			case 'V':
			case 'W':
			case 'Y':
				sumOfLetters += 4;
				break;
			case 'K':
				sumOfLetters += 5;
				break;
			case 'J':
			case 'X':
				sumOfLetters += 8;
				break;
			case 'Q':
			case 'Z':
				sumOfLetters += 10;
				break;
				
			default:
				sumOfLetters += 0;
			}
		}
		return sumOfLetters;

	}

}

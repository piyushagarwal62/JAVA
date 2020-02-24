package string_assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author piyush
 * Adding commas to numeric strings.
 * ex: 1000 -> 1,000
 */
public class CommasToNumeric {

	public static void main(String[] args) throws IOException {
		while (true) 
		{ 
			System.out.println("Enter a numeric string: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String digits = br.readLine(); 
			if (digits.length() == 0) 
				break; 
			CommasToNumeric obj = new CommasToNumeric();
			System.out.println(obj.addCommasToNumericString(digits)); 
		} 
	}
	
	private String addCommasToNumericString(String digits){
		if(digits.length() < 4){
			return digits;
		}
		StringBuilder commaSepString = new StringBuilder(digits);
		int length = commaSepString.length();
		length -= 3;
		while(length > 0){
			commaSepString.insert(length, ',');
			length -= 3;
		}
		return commaSepString.toString();
	}

}

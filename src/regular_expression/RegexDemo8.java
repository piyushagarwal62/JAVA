package regular_expression;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author piyush.agarwal
 * Few more example for validating names
 */
public class RegexDemo8 {

	public static void main(String[] args) {
		validateIdentifiers();
		validateName1();
		validateName2();
		validateName3();
	}
	
	/**
	 * Regular Expression to Represent All Valid Language Identifiers as per rules
	 * The Allowed Characters are a-z, A-Z, 0-9, #, and $.
	 * The Length of Identifier should be atleast 2.
	 * The 1st Character should be lower case Alphabetical Symbol from a To k.
	 * The 2nd Character should be Digit Divisible by 3 (0, 3, 6, 9).
	 */
	private static void validateIdentifiers(){
		Pattern p = null;
		p = Pattern.compile("[a-z][0369][a-zA-Z0-9#$]*");
		Matcher matcher = p.matcher("a9two$");
		while(matcher.find()){
			System.out.println(matcher.start() + "---" + matcher.group());
		}
	}

	/**
	 * Regular Expression to represent all Names starts with a | A
	 */
	private static void validateName1(){
		Pattern p = null;
		p = Pattern.compile("[aA][a-zA-Z]*");
		Matcher matcher = p.matcher("Amit");
		while(matcher.find()){
			System.out.println(matcher.start() + "---" + matcher.group());
		}
	}

	/**
	 * Regular Expression to represent all Names ends with l or L
	 */
	private static void validateName2(){
		Pattern p = null;
		p = Pattern.compile("[a-zA-Z]*[lL]");
		Matcher matcher = p.matcher("Sunil");
		while(matcher.find()){
			System.out.println(matcher.start() + "---" + matcher.group());
		}
	}

	/**
	 * Regular Expression to represent all Names starts with a or A and ends with l or L
	 */
	private static void validateName3(){
		Pattern p = null;
		p = Pattern.compile("[aA][a-zA-Z]*[lL]");
		Matcher matcher = p.matcher("Anil");
		while(matcher.find()){
			System.out.println(matcher.start() + "---" + matcher.group());
		}
	}
}

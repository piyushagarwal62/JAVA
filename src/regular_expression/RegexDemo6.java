package regular_expression;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author piyush.agarwal
 *	To show example of mobile number
 */
public class RegexDemo6 {

	public static void main(String[] args) {
		validateMobileNumber();
		validateEmailId();
	}
	
	private static void validateMobileNumber(){
		Pattern p = null;
		String str = "457021235731";
//		p = Pattern.compile("[7-9][0-9]{9}");
//		p = Pattern.compile("0?[7-9][0-9]{9}");
		p = Pattern.compile("(0|91)?[7-9][0-9]{9}");
		Matcher matcher = p.matcher(str);
		while(matcher.find() && matcher.group().equals(str)){
			System.out.println(matcher.start() + "---" + matcher.group());
		}
	}

	private static void validateEmailId(){
		Pattern p = null;
		///p@gmail.com
		/// piyush6262.43_34@gmail.com
		///piyush@yahoo.co.in
						
		p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-z]+)+");
//		p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@gmail([.][a-zA-z]+)+");
		Matcher matcher = p.matcher("piyush6262.43_34@gmail.com");
		while(matcher.find()){
			System.out.println(matcher.start() + "---" + matcher.group());
		}
	}

}

package regular_expression;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author piyush.agarwal
 *	To show example of basic pattern matching of string
 */
public class RegexDemo1 {

	public static void main(String[] args) {
		int count = 0;
		Pattern p = Pattern.compile("[\\s]");
		Matcher m = p.matcher("fs%4S.d7( .sdf. !@#");
		while(m.find()){
			count++;
			System.out.println(m.start() + "..." + m.end() + "..." + m.group());
		}
		System.out.println("Total number of match found: " + count);
	}


}

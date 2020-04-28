package regular_expression;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author piyush.agarwal
 *	To show example of basic pattern matching using Quantifiers of regex
 */
public class RegexDemo4 {

	public static void main(String[] args) {
		Pattern p = null;
		p = Pattern.compile("a{2}|a{4}");
//		p = Pattern.compile("[+?]9*");
//		p = Pattern.compile("a*");
//		p = Pattern.compile("a?");
		Matcher m = p.matcher("cat dog hat dat");
//		Matcher m = p.matcher("+919321239899");
		while(m.find()){
			System.out.println(m.start() + "..." + m.group());
		}
	}

}

package regular_expression;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author piyush.agarwal
 *	To show example of basic pattern matching using pre-defined character classes of regex
 */
public class RegexDemo3 {

	public static void main(String[] args) {
		// Done use "\s" directly otherwise compiler error for invalid escape
		// sequence character
		Pattern p = null;
		p = Pattern.compile("\\s");
		p = Pattern.compile("\\S");
		p = Pattern.compile("\\d");
		p = Pattern.compile("\\D");
		p = Pattern.compile("\\w");
		p = Pattern.compile("\\W");
		p = Pattern.compile(".");

		Matcher m = p.matcher("a7b k@9");
		while (m.find()) {
			System.out.println(m.start() + "..." + m.group());
		}
	}

}

package regular_expression;
import static regular_expression.RegularExpUtil.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author piyush.agarwal
 * Demonstrate of Back referencing, atomic group
 *
 */
public class GroupReferenceDemo {

	public static void main(String[] args) {
		groupBackReference();
		groupReferenceAndReplacement();
		atomicGroup();
	}
	
	private static void groupBackReference(){
		//Back Reference Named Group
		testGroup("(?<CHAR>\\w{2,2})[\\S]*\\k<CHAR>", "3434");
		testGroup("(?<CHAR>\\w{2,2})[\\S]*\\k<CHAR>", "weallwelcome");
		
		//Numeric Reference
		testGroup("(?<CHAR>\\d{2,2}[a-z]{2,2})wel\\k<CHAR>", "56abcd56ab");
		testGroup("(?<CHAR>\\d{2,2}[a-z]{2,2})(?<CHAR1>\\d{1})four\\2\\1", "12th3four312thchacha");
	}
	
	private static void groupReferenceAndReplacement(){
		Pattern pattern = Pattern.compile("(?<aCode>[a-z]{1,1})(?<dCode>[0-9]{2,2})");
		Matcher matcher = pattern.matcher("a38 d45");
		while (matcher.find())
			System.out.println(matcher.group("dCode") + "" + matcher.group("aCode"));
		String s = matcher.replaceAll("${dCode}${aCode}");
		System.out.println(s);
	}
	
	private static void atomicGroup() {
		test("p(ut|u)t", "putt");
		test("p(ut|u)t", "put");
		test("p(?>ut|u)t", "put");
		test("p(?>it|u)t", "put");
		test("p(?>ut|u)t", "putt");
		test("p(?>(ut|u))\\1", "putut");
		test("p(?>(ut|u))\\1", "puu");		
	}
}
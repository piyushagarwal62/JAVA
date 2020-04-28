package regular_expression;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author piyush.agarwal
 * Utility class for Regular Expression
 *
 */
public class RegularExpUtil {

	public static void test(String regex, String input) {
		System.out.println("--------------------");
		System.out.printf("Regex: '%s', Input: '%s'\n", regex, input);
		testFind(regex, input);
		testReplaceAll(regex, input, "xyz");
	}

	public static void testGroup(String regex, String input) {
		System.out.println("--------------------");
		System.out.printf("Regex: '%s', Input: '%s'\n", regex, input);
		testMatches(regex, input);
		testGroupFind(regex, input);
		testReplaceAll(regex, input, "xyz");
	}

	private static void testMatches(String regex, String input) {
		System.out.printf("matcher.matches() :  '%s':%n", Pattern.compile(regex).matcher(input).matches());
	}

	private static void testFind(String regex, String input) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);

		while (matcher.find()) {
			String matchedValue = matcher.group();

			System.out.printf("Matched  %s---%s---'%s'%n", matcher.start(),
					matcher.end(), matchedValue);
			showGroupInformation(matcher);
		}
	}

	private static void testGroupFind(String regex, String input) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);

		while (matcher.find()) {
			String matchedValue = matcher.group();

			System.out.printf("Matched (Group zero) %s---%s---'%s'%n", matcher.start(),
					matcher.end(), matchedValue);
			showGroupInformation(matcher);
		}
	}
	
	private static void testReplaceAll(String regex, String input, String replaceString) {
        System.out.printf("Lets replace all matches with xyz=> '%s'%n",
                Pattern.compile(regex).matcher(input).replaceAll(replaceString));
    }
	
	public static void showGroupInformation(Matcher matcher) {

        for (int i = 1; i <= matcher.groupCount(); i++) {
            System.out.printf("Group number: %s, " +
                            "Group matched String: '%s',  start: %s, end: %s%n",
                    i, matcher.group(i), matcher.start(i), matcher.end(i));
        }
    }
}

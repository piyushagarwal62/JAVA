package regular_expression;

import static regular_expression.RegularExpUtil.*;

/**
 * @author piyush.agarwal
 * Character Classes used to demonstrate
 * x
 * [abc]
 * [^abc]
 * [a-z]
 * [A-Z]
 * [a-zA-Z]
 * [0-9]
 * [a-zA-Z0-9]
 * [^a-zA-Z0-9]
 * [a-d[m-p]]
 * [a-z&&[def]]
 * [a-z&&[^bc]]
 * [a-z&&[^m-p]]
 */
public class CharacterClassesDemo {

	public static void main(String[] args) {
		
		test("is", "This is called island");
		test("[aeiou]", "i do understand vowel?");
		test("[^ae$%]", "I want my $400");
		test("[h-p]", "The letters are not arrange");
		test("[A-Z]", "I got 40 OUT of 100");
		test("[0-9]", "I got 40 OUT of 100");
		test("[a-zA-Z0-9]", "I got 40% i.e $500");
		test("[^a-zA-Z0-9 ]", "I got 40% i.e $500");
		test("[a-e[m-p]]", "This is union of regex");
		test("[a-z&&[defu]]", "do you know intersection");
		test("[a-z&&[^adl]]", "I dont want all");
		test("[a-z&&[^m-r]]", "dont accept a range");
	}

}

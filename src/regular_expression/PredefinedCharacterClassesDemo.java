package regular_expression;

import static regular_expression.RegularExpUtil.*;

/**
 * @author piyush.agarwal
 * Predefined Character classes used to demonstrate
 * \s
 * \S
 * \w
 * \W
 * \d
 * \D
 * .
 * \.
 */
public class PredefinedCharacterClassesDemo {

	public static void main(String[] args) {

		test("\\s", "Hey! how you	doing?");
		test("\\S", "Hello dear!!");
		
		test("\\w", "a89A_,.-");
		test("\\W", "a89%A_,.-$");
		
		test("\\d", "Add 40 to 56");
		test("\\D", "When 57-47= $10");
		
		test(".", "&2l+-");
		test("..de", "hide");
		test("\\.", "Connect.all.the.dots.or.periods");
		
	}

}

package regular_expression;

import static regular_expression.RegularExpUtil.*;

/**
 * @author piyush.agarwal
 * Anchors used to demonstrate regular expression
 * ^
 * $
 * \b
 * \B
 */
public class AnchorsDemo {

	public static void main(String[] args) {

		test("^hey", "hey hey!");
		test("ey$", "Hey, who are they");
		test("^Mission Impossible$", "Mission Impossible");

		test("\\bin", "water is inside inland in Minix");

		test("45\\b", "45 is less then 456 and 7445 is greater then 6456");
		test("\\Bin", "water is inside inland in Minix");
		test("in\\B", "water is inside inland in Minix");

		test("\\b45\\b", "45 is equal to 45 and 4545 is greater then 645");		
	}

}

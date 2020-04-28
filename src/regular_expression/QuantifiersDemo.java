package regular_expression;

import static regular_expression.RegularExpUtil.*;

/**
 * @author piyush.agarwal
 * 
 * Quantifiers used to demonstrate regular expression
 * X
 * X+
 * X*
 * X?
 * {m}
 * {m,n}
 * {m,}
 */
public class QuantifiersDemo {

	public static void main(String[] args) {

		test("X", "XXX");
		test("X+", "ttxXXXwX");
		test("X+Y*Z?", "XZ");
		test("X+Y*Z?", "abcXYYZyus");
		test("a.+b", "axyb");
		test("a[.\\S]+b", "aaaxb azzzeb");
		test("(a|b)+", "aaaa bb cabc");
		test("([0-9]|\\W)+", "9823 340");
		test("\\d*[13579]", "3 46 33 88 133");
		test("wall(paper)?", "wall wallpaper paper");
		
		test("(li){2,}", "lilies milliliter");
		test("\\b[a-z]{3,3}\\b", "A fly has big eyes");
		test("[a-z][0-9]{2,3}", "aa29 a3333 3d43");
		test("([a-z][0-9]){2,2}", "aa29 a3d4a3");
		test("x{2,}", "xx xxx, xxxx");
	}

}

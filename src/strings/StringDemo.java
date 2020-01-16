package strings;

import java.util.Arrays;

public class StringDemo {

	public static void main(String[] args) {
		String str = "Hello world";
		String str1 = "Hello world";
		String str2 = new String(str1);
		System.out.println(str == str1);
		System.out.println(str1 == str2);
		String str3 = str2.intern();
		System.out.println(str3 == str);
		String str4 = "hello worLD";
		str.equalsIgnoreCase(str4);
		System.out.println("ADD".compareToIgnoreCase("ABC"));
		str.contains("wo");
		System.out.println(str.indexOf("world"));
		String str5 = str.substring(6,9);
		System.out.println("Substring: " + str5);
		System.out.println(str.startsWith("world", 6));
		str.replace('o', 'i');
		str.lastIndexOf('o');
		str = str.concat(str5);
		str = ", piyush agarwal,";
		// class java to welcome all hello
		String[] splitStr = str.split(",");
		System.out.println(Arrays.deepToString(splitStr));
		//ABC
		//BCD
		
		//
		StringBuffer sb = new StringBuffer("Hello");
		sb.append("World");
		sb.insert(5, "Piyush");
		System.out.println(sb.delete(5, 11));
		
		StringBuilder sbb = new StringBuilder("Hello");
		sbb.length();
	}

}

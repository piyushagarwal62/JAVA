package strings;

public class StringReverse {

	public static void main(String[] args) {
		String str = "Hellohh all welcome to java class";
		// class java to welcome all hello
		String[] split = str.split(" ");
		String string = "";
		for (int i = split.length - 1; i >= 0; i--) {
			string += split[i] + " ";
		}
		System.out.println(string);
	}

}

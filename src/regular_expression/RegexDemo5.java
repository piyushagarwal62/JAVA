package regular_expression;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * @author piyush.agarwal
 *	To show example of basic pattern matching split method using character classes of regex
 *	As well as similar example with StringTokenizer
 */
public class RegexDemo5 {

	public static void main(String[] args) {
		Pattern p = null;
//		p = Pattern.compile("\\s");
		p = Pattern.compile("a");
//		p = Pattern.compile("i");
		String[] s = p.split("Trinaha Institute for Java");
		for (String s1 : s) {
			System.out.println(s1);
		}
		
		System.out.println("\nSplit pattern for dot");
		
		String str = "www.google.com";
//		s = str.split(".");  //This is not value to split on dot since this indicate any character
//		s = str.split("\\.");
		s = str.split("[.]");	//Optional to use instead of \\.
		for (String s1 : s) {
			System.out.println(s1);
		}
		
		useStringTokenizer();
	}
	
	private static void useStringTokenizer(){
		System.out.println("\nExample using String Tokenizer");
		//Default pattern it uses is space " "
		StringTokenizer st = new StringTokenizer("Trinaha Institute for Java","a");
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
		
		//You can pass either regex/pattern/delimeter
		StringTokenizer st1 = new StringTokenizer("29-02-1998", "-");
		while(st1.hasMoreTokens()){
			System.out.println(st1.nextToken());
		}
	}

}

package regular_expression;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author piyush.agarwal
 * 
 *         Write a program to extract number and email id from a file using
 *         regular expression
 */
public class RegexDemo7 {

	public static void main(String[] args) {
		extractNumberFromFile();
		extractEmailFromFile();
	}

	/**
	 * Extract number from a file using regular expression
	 */
	private static void extractNumberFromFile() {
		try (BufferedReader br = new BufferedReader(new FileReader("resource/temp.txt"));) {
			String line = br.readLine();

			Pattern p = Pattern.compile("(0|91)?[7-9][0-9]{9}");
			while (line != null) {
				Matcher matcher = p.matcher(line);
				while (matcher.find()) {
					System.out.println(matcher.group());
				}
				line = br.readLine();
			}
		} catch (IOException io) {
			System.out.println("IO Error" + io);
		}
	}

	/**
	 * Extract email id from a file using regular expression
	 */
	private static void extractEmailFromFile() {
		try (BufferedReader br = new BufferedReader(new FileReader("resource/temp1.txt"));) {
			String line = br.readLine();

			Pattern p = Pattern.compile("[\\w][a-zA-Z0-9_.]*@[\\w]+([.][a-zA-z]+)+");
			while (line != null) {
				Matcher matcher = p.matcher(line);
				while (matcher.find()) {
					System.out.println(matcher.group());
				}
				line = br.readLine();
			}
		} catch (IOException io) {
			System.out.println("IO Error" + io);
		}
	}
}

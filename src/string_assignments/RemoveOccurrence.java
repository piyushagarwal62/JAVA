package string_assignments;

/**
 * @author piyush
 * Remove all occurrence of character from the string
 */
public class RemoveOccurrence {

	public static void main(String[] args) {
		RemoveOccurrence obj = new RemoveOccurrence();
		System.out.println(obj.removeAllOccurrences("---0---", '-'));
		System.out.println(obj.removeAllOccurrences("This is a test", 't'));
		System.out.println(obj.removeAllOccurrences("Summer is here!", 'e'));
	}
	
	public String removeAllOccurrences(String str, char ch) {
		return str.replaceAll(""+ch+"", "");
	}


}

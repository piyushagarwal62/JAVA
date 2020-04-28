package exception_handling;

/**
 * @author piyush.agarwal
 *
 */
class StringNullPointerException extends Exception {

	String message;

	public StringNullPointerException() {
		message = "String cannot be null";
	}
}

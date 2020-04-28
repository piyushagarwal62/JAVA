package assertion;

/**
 * @author piyush.agarwal
 *
 */
public class AssertionDemo {

	public static void main(String[] args) {
		String str = "null";
		assert str == null : "null referece";
		assert false;
		assert 4 > 5;
	}

}

package generics.generic_class;

/**
 * @author piyush.agarwal
 *
 */
public class PairTest1 {
	public static void main(String[] args) {
		String[] words = { "Mary", "had", "little", "a", "lamp" };
		Pair<String> pair = ArrayAlg.minmax(words);
		System.out.println("Min element:" + pair.getFirst());
		System.out.println("Max Element:" + pair.getSecond());
		String middle = ArrayAlg.<String>getMiddle("John", "Q.", "Public");
		System.out.println("Middle value:" + middle);
		//Even a field of generic class can be used without cast
		//VM automatically cast it to the type specified
		String str = pair.first;
		//Error: Type mismatch: cannot convert from Number&Comparable<?> to double
//		double middle = ArrayAlg.getMiddle(3.14, 1729, 0);

		//Error: The parameterized method <Double>getMiddle(Double...) 
		//of type ArrayAlg is not applicable for the arguments (Double, Integer, Integer)
//		Number middle = ArrayAlg.<Double>getMiddle(3.14, 1729, 0);
		
		Number middle1 = ArrayAlg.getMiddle(3.14, 1729, 0);
		System.out.println(middle1);
		Object middle2 = ArrayAlg.getMiddle("Hello", 0, null);
		System.out.println(middle2);
		
	}
}

class ArrayAlg {
	//Using generic class Pair
	//This is not generic method Since we are not having any Type parameter
	//as argument or return type.
	public static Pair<String> minmax(String arr[]) {
		if (arr == null || arr.length == 0)
			return null;
		String min = arr[0];
		String max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (min.compareTo(arr[i]) > 0)
				min = arr[i];
			if (max.compareTo(arr[i]) < 0)
				max = arr[i];
		}
		return new Pair<String>(min, max);
	}

	public static <T> T getMiddle(T... a) {
		return a[a.length / 2];
	}
}

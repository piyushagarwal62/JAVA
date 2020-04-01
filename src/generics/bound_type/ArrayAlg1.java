package generics.bound_type;

public class ArrayAlg1 {

	public static void main(String[] args) {
	}

	public static <T> T min(T[] a) // almost correct
	{
		if (a == null || a.length == 0)
			return null;
		T smallest = a[0];
		for (int i = 1; i < a.length; i++)
			if (((Comparable<String>) smallest).compareTo((String) a[i]) > 0)
				smallest = a[i];
		return smallest;
	}
}

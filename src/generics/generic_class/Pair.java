package generics.generic_class;

import java.util.function.Supplier;

public class Pair<T> {

	T first;
	T second;

	public Pair() {
		// Cannot instantiate type parameter
		// this.first = new T();
		first = null;
		second = null;
	}

	// Type Variables Are Not Valid in Static Contexts of Generic Classes
	/*
	 * private static T singleInstance; // Error
	 * 
	 * public static<T> T getSingleInstance() // Error { if (singleInstance ==
	 * null) construct new instance of T return singleInstance; }
	 */
	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public static <T> Pair<T> makePair(Supplier<T> constr) {
		return new Pair<>(constr.get(), constr.get());
	}

	public static <T> Pair<T> makePair(Class<T> cl) {
		try {
			return new Pair<>(cl.newInstance(), cl.newInstance());
		} catch (Exception ex) {
			return null;
		}
	}

	public T getFirst() {
		return this.first;
	}

	public T getSecond() {
		return this.second;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public void setSecond(T second) {
		this.second = second;
	}

	// Name clash: The method equals(T) of type Pair<T> has the same erasure as
	// equals(Object) of type Object but does not override it
	// public boolean equals(T value) { 
	//	return first.equals(value) && second.equals(value); }

}

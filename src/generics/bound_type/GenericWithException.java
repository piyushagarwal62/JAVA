package generics.bound_type;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//Cannot Throw or Catch Instances of a Generic Class
public class GenericWithException {

	public static <T extends Throwable> void doWork(Class<T> t) {
		try {
			;// do some work
		}
		// catch (T e) // Error--can't catch type variable
		catch (Exception e) {
			System.out.println();
		}
	}

	public static <T extends Throwable> void doWork(T t) throws T // OK
	{
		try {
			;// Do some work
		} catch (Throwable realCause) {
			t.initCause(realCause);
			throw t;
		}
	}

	// Error--can't extend Throwable
	// public class Problem<T> extends Exception { /* . . . */ }

	public static void main(String[] args) {
		new Block() {
			@Override
			public void body() throws Exception {
				System.out.println("Inside Block object: body()");
				Scanner in = new Scanner(new File("ququx"), "UTF-8");
				while (in.hasNext())
				System.out.println(in.next());
			}
		}.toThread().start();
	}

}

abstract class Block {
	public abstract void body() throws Exception;

	public Thread toThread() {
		return new Thread() {
			public void run() {
				try {
					System.out.println("In thread");
					body();
				} catch (Throwable t) {
					System.out.println("In thread catch");
					Block.<RuntimeException>throwAs(t);
				}
			}
		};
	}

	@SuppressWarnings("unchecked")
	public static <T extends Throwable> void throwAs(Throwable e) throws T {
		System.out.println("In thread throwAs");
		throw (T) e;
	}
}

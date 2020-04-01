package generics.bound_type;

import java.time.LocalDate;
import generics.generic_class.Pair;

public class PairTest2 {

	public static void main(String[] args) {
		LocalDate[] birthdays =
		{
			LocalDate.of(1906, 12, 9), // G. Hopper
			LocalDate.of(1815, 12, 10), // A. Lovelace
			LocalDate.of(1903, 12, 3), // J. von Neumann
			LocalDate.of(1910, 6, 22), // K. Zuse
		};
		Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
		System.out.println("min = " + mm.getFirst());
		System.out.println("max = " + mm.getSecond());
		ArrayAlg.demoCheck();
	}

}

class ArrayAlg{
	public static <T extends Comparable> Pair<T> minmax(T[] a){
		if (a == null || a.length == 0) return null;
		T min = a[0];
		T max = a[0];
		for(int i = 1; i < a.length; i++){
			if(min.compareTo(a[i]) > 0) min = a[i];
			if(max.compareTo(a[i]) < 0) max = a[i];
		}
		return new Pair<>(min, max);
	}
	
	public static void demoCheck(){
		Object obj = null;
//		Cannot perform instanceof check against parameterized type Pair<String>. 
//		Use the form Pair<?> instead since further generic type information will be erased at runtime
//		if(obj instanceof Pair<String>);
		//Nor
//		if(obj instanceof Pair<T>);
		//But this can work as below
		if(obj instanceof Pair<?>);
		
		Pair<String> p = (Pair<String>) obj; //Compiler will give warning
		
		//Cannot Create Arrays of Parameterized Types
		Pair<String>[] table = (Pair<String>[])new Pair<?>[10];		
		
		Object[] objarray = table;
		
		objarray[0] = new Pair<String>();
		System.out.println(((Pair<Number>)objarray[0]).getFirst());
	}
}

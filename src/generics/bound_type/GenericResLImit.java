package generics.bound_type;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import generics.generic_class.Pair;

public class GenericResLImit {

	public static void main(String[] args) {
		addAll(new ArrayList<String>(), "Hello");
		
		Pair<String> p = Pair.makePair(String::new);
		Pair<String> p1 = Pair.makePair(String.class);
		Pair<Thread> p2 = Pair.makePair(Thread::new);
		addInheritence();
	}
	
	@SafeVarargs
	public static <T> void addAll(Collection<T> coll, T ...ts)
	{
		for (T t : ts) coll.add(t);
		System.out.println(coll);
	}
	
	@SafeVarargs 
	static <E> E[] array(E... array) {
		return array; 
	}
	
	static void addInheritence(){
		Manager ceo = new Manager();
		Manager cfo = new Manager();
//		Pair<Manager> managerBuddies = new Pair<>(ceo, cfo);
//		Pair<Employee> employeeBuddies = (Pair)managerBuddies; // illegal, but suppose it wasn't
//		employeeBuddies.setFirst(lowlyEmployee);

		Employee lowlyEmployee = new Employee();
		Manager[] managerBuddies = { ceo, cfo };
		Employee[] employeeBuddies = managerBuddies; // OK
		//virtual machine throws an ArrayStoreException.
//		employeeBuddies[0] = lowlyEmployee;
		
		Pair<Manager> managerBuddies1 = new Pair<>(ceo, cfo);
		Pair rawBuddies = managerBuddies1; // OK
		rawBuddies.setFirst(new File(". . .")); // only a compile-time warning
//		Manager mg = (Manager) rawBuddies.getFirst(); // This will give error of ClassCastException
		
		Pair<Manager> managerBuddies2 = new Pair<>(ceo, cfo);
		Pair<? extends Employee> wildcardBuddies = managerBuddies2; // OK
//		wildcardBuddies.setFirst(lowlyEmployee); // compile-time error
		Employee first = wildcardBuddies.getFirst();
		Pair<Employee> employeeBuddies2 = new Pair<>(ceo, cfo);

		wildcardBuddies = employeeBuddies2;
	}
}

class Employee implements Comparable {

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	} 
}
class Manager extends Employee implements Comparable { 
	
	
}
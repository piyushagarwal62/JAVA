package generics.wildcard;

import generics.generic_class.Pair;

public class PairTest3 {
	public static void main(String[] args) {
		Manager ceo = new Manager("Gus Greedy", 800000);
		Manager cfo = new Manager("Sid Sneaky", 600000);
		Pair<Manager> buddies = new Pair<>(ceo, cfo);
		printBuddies(buddies);
		ceo.setBonus(1000000);
		cfo.setBonus(500000);
		Manager[] managers = { ceo, cfo };
		Pair<Employee> result = new Pair<>();
		minmaxBonus(managers, result);
		System.out.println("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());
		maxminBonus(managers, result);
		System.out.println("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());
	}

	public static void printBuddies(Pair<? extends Employee> p) {
		Employee first = p.getFirst();
		Employee second = p.getSecond();
		System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
	}

	public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
		if (a.length == 0)
			return;
		Manager min = a[0];
		Manager max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (min.getBonus() > a[i].getBonus())
				min = a[i];
			if (max.getBonus() < a[i].getBonus())
				max = a[i];
		}
		result.setFirst(min);
		result.setSecond(max);
	}

	public static void maxminBonus(Manager[] a, Pair<? super Manager> result) {
		minmaxBonus(a, result);
		PairAlg.swapHelper(result); // OK--swapHelper captures wildcard type
	}
}

class PairAlg {
	public static boolean hasNulls(Pair<?> p) {
		return p.getFirst() == null || p.getSecond() == null;
	}

	public static void swap(Pair<?> p) {
		swapHelper(p);
	}

	public static <T> void swapHelper(Pair<T> p) {
		T t = p.getFirst();
		p.setFirst(p.getSecond());
		p.setSecond(t);
	}
}

class Employee implements Comparable {

	int bonus;
	String name;
	
	public Employee(String name, int bonus) {
		this.bonus = bonus;
		this.name = name;
	}
	
	public Employee() {
		super();
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Object arg0) {
		return 0;
	} 
}
class Manager extends Employee implements Comparable {

	public Manager() {
		super();
	}

	public Manager(String name, int bonus) {
		super(name, bonus);
	} 
	
}
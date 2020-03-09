package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetImplementation {

	public static void implementHashSet() {
		// Store only unique values
		HashSet<Integer> set = new HashSet<>();
		set.add(4);
		set.add(2);
		set.add(3);
		System.out.println("Doesn't allow duplicate values: " + set.add(2));
		set.add(1);
		set.add(10);
		set.add(18);
		set.add(20);
		System.out.println("HashSet: " + set);
		ArrayList<Integer> arrayList = new ArrayList<Integer>(set);
		Collections.sort(arrayList);
		System.out.println("In ascending order: " + arrayList);
		Collections.sort(arrayList, Collections.reverseOrder());
		System.out.println("In descending order: " + arrayList);
		
		//Using Comparator of type Integer
		Collections.sort(arrayList, new CompareInt());
		System.out.println("Using Comparator:" + arrayList);

		// Using Iterator
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			Integer integer = iterator.next();
			System.out.println(integer);
		}
		//Using forEach method as lambda expression
		set.forEach(n -> {
			System.out.println(n);
		});
	}

	public static void main(String[] args) {
		implementStringComparator();
		implementHashSet();
		implementTreeSet();
		implementLinkedHashSet();
		usingStudentObject();
		implementObjectComparator();

	}

	public static void implementTreeSet() {
		Set<String> hashSet = new HashSet<>();
		hashSet.add("Dan");
		hashSet.add("Sam");
		// Sorts the list by default for numeric and string values
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.addAll(hashSet);
		treeSet.add("Gill");
		treeSet.add("Bill");
		treeSet.add("Zan");
		treeSet.add("Amil");
		treeSet.add("Ami");
		System.out.println("Treeset for String:" + treeSet);
		String ceiling = treeSet.ceiling("ll");
		System.out.println(ceiling);
		SortedSet<String> headSet = treeSet.headSet("Gill");
		System.out.println("Head Set: " + headSet);
		System.out.println("Last Element:" + treeSet.last());
	}

	public static void implementLinkedHashSet() {
		// Maintains the order
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("Gill");
		linkedHashSet.add("Bill");
		linkedHashSet.add("Zan");
		linkedHashSet.add("Amil");
		linkedHashSet.add("Ami");
		System.out.println("LinkedHashSet for String:" + linkedHashSet);
	}

	public static void usingStudentObject() {
		Student student = new Student(3, "Daniel", "Pune");
		HashSet<Student> studList1 = new HashSet<>();
		studList1.add(student);
		studList1.add(new Student(4, "Zen", "Colombo"));
		studList1.add(new Student(5, "Bindu", "Mumbai"));
		studList1.add(new Student(6, "Xomb", "Peru"));
		studList1.add(new Student(7, "Ranveer", "Delhi"));

		Student student1 = new Student(3, "Parth", "Pune");
		HashSet<Student> studList2 = new HashSet<>();
		studList2.add(student1);
		studList2.add(new Student(4, "Sam", "New Jersey"));
		studList2.add(new Student(5, "Sidd", "Mumbai"));
		studList2.add(new Student(6, "Samual", "Dubai"));

		ArrayList<HashSet<Student>> arrList = new ArrayList<>();
		arrList.add(studList1);
		arrList.add(studList2);

		//Using normal looping with iterator
		for (int i = 0; i < arrList.size(); i++) {
			HashSet<Student> hashSet = arrList.get(i);
			System.out.println("Information of class: " + (i + 1));
			Iterator<Student> iterator = hashSet.iterator();
			while (iterator.hasNext()) {
				Student next = iterator.next();
				System.out.println(next);
			}
		}
		System.out.println();
		//Using forEach
		arrList.forEach(arr -> {
			System.out.println("Information of class : ");
			Iterator<Student> iterator = arr.iterator();
			while (iterator.hasNext()) {
				Student next = iterator.next();
				System.out.println(next);
			}
		});
		
	}
	
	public static void implementObjectComparator(){
		Student student = new Student(3, "Daniel", "Pune");
		HashSet<Student> studList1 = new HashSet<>();
		studList1.add(student);
		studList1.add(new Student(4, "Zen", "Colombo"));
		studList1.add(new Student(5, "Bindu", "Mumbai"));
		studList1.add(new Student(6, "Xomb", "Peru"));
		studList1.add(new Student(7, "Ranveer", "Delhi"));

		ArrayList<Student> newStud = new ArrayList<>(studList1);
		Collections.sort(newStud, new CompareObject());
		System.out.println(newStud);
		
	}
	
	public static void implementStringComparator(){
		TreeSet<String> names = new TreeSet<>(new CompareString());
		names.add("Virat Kohli");
		names.add("Rohit Sharma");
		names.add("Ravindra Jadeja");
		names.add("Zen Trivia");
		System.out.println(names);
	}

	static class CompareInt implements Comparator<Integer> {

		@Override
		public int compare(Integer i1, Integer i2) {
			return i2 - i1;
		}

	}
	
	static class CompareString implements Comparator<String>{
		
		@Override
		public int compare(String str1, String str2) {
			int index1 = str1.indexOf(" ");
			int index2 = str2.indexOf(" ");
			
			return str1.substring(index1+1).compareTo(str2.substring(index2+1));
		}
	}
	
	static class CompareObject implements Comparator<Student>{

		@Override
		public int compare(Student arg0, Student arg1) {
			return arg1.name.compareTo(arg0.name);
		}
		
	}
}

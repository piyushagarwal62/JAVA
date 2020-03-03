package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListImplementation {

	public static void main(String[] args) {
		implementArrayList();
		storeNumericValues();
		implementingLinkedListForSorting();
		storeObjectsOfClass();
	}

	public static void implementArrayList() {
		// Array List of String
		ArrayList<String> arrList1 = new ArrayList<>();
		System.out.println("Initial Size: " + arrList1.size());
		arrList1.add("Raj");
		arrList1.add("Simran");
		arrList1.add("Prakash");
		arrList1.add("Nikhil");
		arrList1.add("Rishi");
		arrList1.add("Dan");
		System.out.println("After adding Size: " + arrList1.size());
		arrList1.remove(3);

		ArrayList<Object> arrList2 = new ArrayList<>();
		arrList2.add("Daniel");
		arrList2.add("Rishi");
		arrList2.add("Dan");
		arrList2.add("Shyam");
		arrList2.add("Vicky");
		arrList2.add("Simran");

		arrList2.remove("Vicky");
		arrList2.retainAll(arrList1);

		System.out.println("ArrayList 1: " + arrList2);
		System.out.println("ArrayList 2: " + arrList1);
		Object[] array = arrList1.toArray();
		System.out.println("Converted to array" + Arrays.deepToString(array));

		arrList1.trimToSize();

		arrList1.set(1, "Mike");
		System.out.println("Contains:" + arrList1.contains("Nikhil"));
		System.out.println("Final Array:" + arrList1);
	}

	public static void implementingLinkedListForSorting() {
		ArrayList<String> arrayList = new ArrayList<>(20);
		arrayList.add("Hello");

		List<String> list = new LinkedList<>(arrayList);
		list.add("World");
		list.add("This");
		list.add("is");
		list.add("Java");
		list.add("class");
		// LinkedList gives result with by default sort
		System.out.println("ascending order: " + list);

	}

	public static void storeNumericValues() {
		ArrayList<Float> arrayList = new ArrayList<>(20);
		arrayList.add(2.0f);
		arrayList.add(3.000001f);
		arrayList.add(5.0f);
		arrayList.add(1.0f);
		arrayList.add(10.0f);
		// Increase capacity
		arrayList.ensureCapacity(25);
		arrayList.remove(new Float(3.000001));
		System.out.println(arrayList);
	}

	// Store user define data type
	public static void storeObjectsOfClass() {
		Student student = new Student(3, "Daniel", "Pune");
		ArrayList<Student> studList = new ArrayList<>();
		studList.add(student);
		studList.add(0, new Student(4, "Zen", "Colombo"));
		studList.add(new Student(5, "Bindu", "Mumbai"));
		studList.add(0, new Student(6, "Xomb", "Peru"));
		studList.add(0, new Student(7, "Ranveer", "Delhi"));
		if (studList != null && !studList.isEmpty()) {
			// Using for loop
			for (int i = 0; i < studList.size(); i++) {
				System.out.println(studList.get(i));
			}
			System.out.println(studList);
			System.out.println(studList.size());
		}
		// Using iterator
		Iterator<Student> iterator = studList.iterator();
		int count = 0;
		while (iterator.hasNext()) {
			Student next = iterator.next();
			count++;
			if (count % 2 == 0) {
				iterator.remove();
			}
			System.out.println(next);
		}

		// Using list iterator
		ListIterator<Student> listIterator = studList.listIterator();
		while (listIterator.hasNext()) {
			listIterator.next();
		}
		System.out.println("Using ListIterator");
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previousIndex() + ":" + listIterator.previous());
		}

		System.out.println("Using forEach");
		studList.forEach(n -> System.out.println(n));
		studList.clear();

	}
}

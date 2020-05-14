package stream_api;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author piyush.agarwal
 *
 */
public class StreamWithObjects {

	public static void main(String[] args) {
		// Get 3 highest paid employee details
		System.out.println("Highest Paid employee");
		List<Employee> employees = getAllEmployees();
		employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).limit(3)
				.map(Employee::getName).forEach(System.out::println);

		getCollectionObjectFromStream();
		groupingBy();
	}

	private static void groupingBy(){
		System.out.println("Grouping Examples");
		List<Employee> allEmployees = getAllEmployees();
		String allNames = allEmployees.stream().limit(4).map(Employee::getName).collect(Collectors.joining(", "));
		System.out.println(allNames);
		
		List<Employee> allEmployeesWithDept = getAllEmployeesWithDept();
		Map<String, List<Employee>> groupByDept = allEmployeesWithDept.stream()
				.collect(Collectors.groupingBy(e->e.getDept()));
		
		System.out.println(groupByDept);
		
		Map<String, Long> groupCount = allEmployeesWithDept.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
		System.out.println(groupCount);
		
	}
	
	private static void getCollectionObjectFromStream() {
		System.out.println("Collections Examples");
		List<Employee> allEmployees = getAllEmployees();
		// to List
		List<String> list = allEmployees.stream().limit(3).map(Employee::getName).collect(Collectors.toList());
		System.out.println("List: " + list);

		Set<String> set = allEmployees.stream().limit(3).map(Employee::getName).collect(Collectors.toSet());
		System.out.println("Set: " + set);

		Map<String, Employee> map = allEmployees.stream().limit(3).collect(Collectors.toMap(e -> e.name, e -> e));
		System.out.println("Map: " + map);

	}

	private static List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Rambo", 20000));
		empList.add(new Employee("Rambo R", 30000));
		empList.add(new Employee("Sam", 25000));
		empList.add(new Employee("Sam R", 10000));
		empList.add(new Employee("Larry", 15000));
		empList.add(new Employee("Kattie", 40000));
		empList.add(new Employee("Sergie", 4000));

		return empList;
	}

	private static List<Employee> getAllEmployeesWithDept() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Rambo", 20000, "IT"));
		empList.add(new Employee("Rambo R", 30000, "Civil"));
		empList.add(new Employee("Sam", 25000, "IT"));
		empList.add(new Employee("Sam R", 10000, "Mechanical"));
		empList.add(new Employee("Larry", 15000, "Mechanical"));
		empList.add(new Employee("Kattie", 40000, "Finance"));
		empList.add(new Employee("Sergie", 4000, "Finance"));

		return empList;
	}

	static class Employee {
		String name;

		int salary;
		
		String dept;

		public Employee(String name, int salary) {
			super();
			this.name = name;
			this.salary = salary;
		}

		public Employee(String name, int salary, String dept) {
			super();
			this.name = name;
			this.salary = salary;
			this.dept = dept;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}
		
		public String getDept() {
			return dept;
		}

		public void setDept(String dept) {
			this.dept = dept;
		}

		@Override
		public String toString() {
			return name + " " + salary + " " + dept!=null? dept:"";
		}

	}
}

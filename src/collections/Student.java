package collections;

public class Student implements Comparable<Object>{
	
	int id;
	String name;
	String location;
	public Student(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return id + " " + name + " " + location;
	}
	@Override
	public int compareTo(Object stud1) {
		Student stud = (Student)stud1;
		return this.id - stud.id;
	}
}

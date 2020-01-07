package arrays;

public class Metro {

	public static void main(String[] args) {
		Employees[] emp = new Employees[3];
		emp[0] = new Employees(10000, 3,10);
		emp[0].raiseHike();
		emp[1] = new Employees(12000, 4,15);
		emp[1].raiseHike();
		emp[2] = new Employees(15000, 5,20);
		emp[2].raiseHike();
		for (Employees obj :emp){
			System.out.println(obj);
		}
	}

}

class Employees{
	int salary;
	int empId;
	int hike;
	
	
	public Employees(int salary, int empId, int hike) {
		super();
		this.salary = salary;
		this.empId = empId;
		this.hike = hike;
	}
	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getHike() {
		return hike;
	}
	public void setHike(int hike) {
		this.hike = hike;
	}
	
	public void raiseHike(){
		float amt = (float)(salary *(((float)(hike)/100)));
		salary += amt;
	}
	@Override
	public String toString() {
		return "EmpId: " + empId + " Salary: " + salary + " Hike: " + hike;
	}
}

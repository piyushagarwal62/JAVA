package inheritance;

public class Teacher{

	int empId;
	String desig;

	public Teacher(){
		System.out.println("Inside Teacher");		
	}
	
	public Teacher(int empId, String desig){
		this();
		this.empId = empId;
		this.desig = desig;
		System.out.println("Inside parameterize Teacher");
	}
		
	public static void main(String[] args) throws Exception{
		STeacher obj = new STeacher(12, "Piyush", "Senior Teacher");
		obj.getDesignation();
		obj.attendance();
		Teacher obj1 = new STeacher();// Upcasting
		((STeacher)obj1).getName();
		
		STeacher obj2 = (STeacher)new Teacher(); //Error at runtime // Downcasting
		obj2.getName();// wont work at runtime because of above statement
		
		////////////////
		
		STeacher obj3 = new STeacher();
		Teacher obj4; //Upcasting
		obj4 = obj3;
		
		///
		Teacher arr[] = new Teacher[]{new Teacher(), new STeacher(), new HTeacher()};
		for (int i = 0; i < arr.length; i++) {
			Teacher teacher = arr[i];
			teacher.getDesignation();
//			((STeacher) teacher).getName(); // ClassCastException since teacher is not everytime STeacher
			if(teacher instanceof STeacher){
				((STeacher) teacher).getName();
			}else if(teacher instanceof HTeacher){
				((HTeacher) teacher).getName();
			}
		}
	}
	
	public void attendance(){
		System.out.println("Role of taking attendance");
	}
	
	public String getDesignation() throws Exception{
		System.out.println("Inside Teacher designation");
		return this.desig;
	}

}

class STeacher extends Teacher{

	String name;
	String topic;

	public STeacher(){
		System.out.println("Inside STeacher");
	}
	
	public STeacher(int empId, String name, String desig){
		this();
//		super(empId, desig); // Cannot have super and this on first line
		this.name = name;
	}
	
	public String getDesignation()throws ArrayIndexOutOfBoundsException{
		System.out.println("Inside Steacher designation");
		return this.desig;
	}
	
	public String getName(){
		System.out.println("Inside STeacher getName");
		return name;
	}
}

class HTeacher extends Teacher{
	
	String name;
	String topic;

	public HTeacher(){
		super();
		System.out.println("Inside STeacher");
	}
	
	public HTeacher(int empId, String name, String desig){
		super(empId, desig);
		this.name = name;
	}
	
	public String getDesignation(){
		System.out.println("Inside Hteacher designation");
		return this.desig;
	}
	
	public String getName(){
		System.out.println("Inside STeacher getName");
		return name;
	}
}
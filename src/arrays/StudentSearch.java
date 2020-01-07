package arrays;

import java.util.Scanner;

public class StudentSearch {

	int rollno[];
	String[] name;
	char[] std;
	
	public void acceptDetails()
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of details");
		int n = sc.nextInt();
		rollno = new int[n];
		name = new String[n];
		std = new char[n];
		
		for (int i = 0; i < n; i++) {
			System.out.println("Enter RollNo.: ");
			rollno[i] = sc.nextInt();
			System.out.println("Enter Name.: ");
			name[i] = sc.next();
			System.out.println("Enter Std.: ");
			std[i] = sc.next().charAt(0);
		}
	}
	
	public int searchByRollNo(int rollNo){
		for (int i = 0; i < rollno.length; i++) {
			if(rollno[i] == rollNo){
				return i;
			}
		}
		return -1;
	}
	
	public int searchByName(String stdName){
		for (int i = 0; i < name.length; i++) {
			if(name[i].equals(stdName)){
				return i;
			}
		}
		return -1;
	}
	
	public void displayRecord(int index){
		System.out.println("Rollno: " + rollno[index]);
		System.out.println("Name: " + name[index]);
		System.out.println("Class: " + std[index]);
	}
	
	public static void main(String[] args) {
		StudentSearch obj = new StudentSearch();
		obj.acceptDetails();
		int index = obj.searchByRollNo(4);
		if(index != -1){
			obj.displayRecord(index);
		}else{
			System.out.println("Roll No. not found");
		}
		index = obj.searchByName("Piyush");
		if(index != -1){
			obj.displayRecord(index);
		}else{
			System.out.println("Name not found");
		}
		
	}

}

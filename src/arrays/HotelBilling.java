package arrays;

import java.util.Scanner;

public class HotelBilling {

	Guest[][] arr;
	
	public void acceptDetails(){
		System.out.println("Enter number of floors and rooms");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of floors:");
		int floors = sc.nextInt();
		System.out.println("Enter number of rooms");
		int rooms = sc.nextInt();
		arr = new Guest[floors][rooms];
		System.out.println("Enter each guest information");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println("Enter name : ");
				String name = sc.nextLine();
				System.out.println("Enter its bill");
				int bill = sc.nextInt();
				arr[i][j] = new Guest(name, bill);
			}
		}
	}
	
	public Guest searchGuest(){
		System.out.println("Enter the name to search");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				Guest guest = arr[i][j];
				if(name.equals(guest.getName())){
					System.out.println("Guest found at floor no. :" + i + " and at room : " + j);
					return arr[i][j];
				}
			}
		}
		return null;
	}
	
	public void displayGuestInformation(Guest guest){
		System.out.println("Guest information:");
		System.out.println("Name of Guest :" + guest.getName());
		System.out.println("Total Bill: " + guest.getBill());
	}
	
	public static void main(String[] args) {
		HotelBilling obj = new HotelBilling();
		obj.acceptDetails();
		Guest searchGuest = obj.searchGuest();
		if(searchGuest != null){
			obj.displayGuestInformation(searchGuest);
		}else{
			System.out.println("Guest not found in the list");
		}
		
	}
}

class Guest{

	String name;
	int bill;
	
	public Guest(String name, int bill) {
		super();
		this.name = name;
		this.bill = bill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}
	
}




package use_of_static_instance;

import java.util.Scanner;

public class Product {

	int prodNo;
	String prodName;
	int prodPrice;
	int qty;
	static int totalBill;
	static int noOfProducts;
	
	
	public Product() {
		prodNo = 0;
		prodName = null;
		prodPrice = 0;
		qty = 0;
	}
	
	public Product(int prodNo, String prodName, int prodPrice, int qty) {
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.qty = qty;
	}

	public void accept(){
		System.out.println("Please enter product details");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product No.: ");
		prodNo = sc.nextInt();
		System.out.println("Enter Product Name: ");
		prodName = sc.next();
		System.out.println("Enter Product Price: ");
		prodPrice = sc.nextInt();
		System.out.println("Enter Quantity: ");
		qty = sc.nextInt();
		
//		sc.close();
	}
	
	public void addToCart(){
		noOfProducts++;
		totalBill = totalBill + (prodPrice * qty);
	}
	
	public static void displayTotalBill(){
		System.out.println("Total bill for " + noOfProducts + " Products is: " + totalBill);
	}
	
	
	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++) {
			Product obj = new Product();
			obj.accept();
			obj.addToCart();
		}
		Product.displayTotalBill();

	}

}

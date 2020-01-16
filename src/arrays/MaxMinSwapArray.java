package arrays;

import java.util.Scanner;

public class MaxMinSwapArray {

	public static int findMinimum(int arr[]){
		int min = 0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[min] > arr[i] ){
				min = i;
			}
		}
		return min;
	}

	public static int findMaximum(int arr[]){
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[max] < arr[i] ){
				max = i;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the values");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int min = findMinimum(arr);
		int max = findMaximum(arr);
		System.out.println("Min number: " + arr[min]);
		System.out.println("Max number: " + arr[max]);
		int temp = arr[min];
		arr[min] = arr[max];
		arr[max] = temp;
		System.out.println("After swaping both the numbers");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

}

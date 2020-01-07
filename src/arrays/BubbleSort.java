package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

	public static void bubbleSort(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length-i; j++) {
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr;
		System.out.println("Enter the size of array");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		System.out.println("Enter the values:");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		int[] copyOfRange = Arrays.copyOfRange(arr, 0, 3);
		System.out.println(Arrays.toString(copyOfRange));
		
	}

}

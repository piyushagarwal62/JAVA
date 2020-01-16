package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArrays {

	static Scanner sc; 

	static {
		sc = new Scanner(System.in);
	}
	
	public static void acceptValues(int arr[]){
		System.out.println("Enter the values");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
	}
	
	public static void merge(int arr[], int brr[], int crr[]){
		int i= 0, j =0, k=0;
		while(k < crr.length){
			if(i >= arr.length || j >= brr.length){
				break;
			}
			if(arr[i] <= brr[j]){
				crr[k++] = arr[i++];
			}else if(arr[i] > brr[j]){
				crr[k++] = brr[j++];
			}
		}
		while(i < arr.length){
			crr[k++] = arr[i++];
		}
		while(j < brr.length){
			crr[k++] = brr[j++];
		}
	}
	
	public static void main(String[] args) {
		int arr[], brr[], crr[];
		System.out.println("Enter the size for first array");
		int n = sc.nextInt();
		arr = new int[n];
		acceptValues(arr);
		System.out.println("Enter the size for second array");
		n = sc.nextInt();
		brr = new int[n];
		acceptValues(brr);
		crr = new int[arr.length + brr.length];
		merge(arr, brr, crr);
		System.out.println("Merge array is:");
		for (int i = 0; i < crr.length; i++) {
			System.out.print(crr[i] + ",");
		}
	}
}

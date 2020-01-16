package arrays;

public class FindDuplicate {

	public static void main(String[] args) {
		int arr[] = { 8 , 9, 2, 14, 17, 21};
		int brr[] = { 9, 13, 17, 22, 25};
		
		System.out.println("Duplicate elements:");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < brr.length; j++) {
				if(arr[i] == brr[j]){
					System.out.print( arr[i] + ",");
					break;
				}
				
			}
			
		}
	}

}

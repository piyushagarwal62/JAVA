package wrapper_class;

import java.util.Scanner;

public class WrapperConversion {

	public static void performIntegerOperation(int i){
		Integer ii = new Integer(i);
		System.out.println("Byte Values : "+ ii.byteValue());
		String str = Integer.toString(i);
		System.out.println("Converting from string to int : " + Integer.parseInt(str));
		System.out.println("Octal value : "+Integer.toOctalString(i));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any values");
	
		if(sc.hasNextInt()){
			System.out.println("It is an integer value");
			performIntegerOperation(sc.nextInt());
			
		}else if(sc.hasNextDouble()){
			System.out.println("It is an double value");
		}else if(sc.hasNextBoolean()){
			
		}else if(sc.hasNext()){
			
		}
	}

}

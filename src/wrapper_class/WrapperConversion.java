package wrapper_class;

import java.util.Scanner;

public class WrapperConversion {

	private static void performIntegerOperation(int i){
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
		}/*else if(sc.hasNextDouble()){
			System.out.println("It is an double value");
		}*/else if(sc.hasNextLong()){
			method1(sc.nextLong());
		}else if(sc.hasNextBigDecimal()){
			method1(sc.nextBigDecimal());
		}
		sc.close();
	}
	
	private static void method1(Long... i){
		System.out.println("In Long" + i[0] );
	}

	private static void method1(Long i){
		System.out.println("In Longi" + i );
	}

	public static void method1(Number... i){
		System.out.println("In Number");	
	}


}

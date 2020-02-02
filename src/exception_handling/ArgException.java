package exception_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArgException {

	public static void main(String[] args) throws Exception {
		try{
			method1(args);
		}catch(IOException ie){}
		System.out.println("Hello");
		
	}
	
	private static void method1(String []args) throws IOException, NullPointerException, Exception{
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			if (args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					String string = args[i];
//					findCharacter(string);
					string = null;
					if (string == null) {
						throw new StringNullPointerException();
					}
					System.out.println("Values is:" + string);
				}
			} else {
				throw new ArrayIndexOutOfBoundsException();
			}
		} catch (ArrayIndexOutOfBoundsException ae) {
			System.out.println("Handled in this catch");
			try{
				throw new NullPointerException();
			}catch(NullPointerException ne){
				System.out.println("Inner Null pointer exception");
			}
			throw new NullPointerException();
		}catch(NullPointerException ne){
			System.out.println("Outer Null pointer exception");
		}/*catch(TFoundException te){
			te.printStackTrace();
		}*/
	}
	
	private static void findCharacter(String str) throws TFoundException{
		if(str.indexOf('t') == -1){
			throw new TFoundException("character T found in string");
		}
	}
}

class TFoundException extends Exception{
	String message;
	
	public TFoundException() {
		message = "character T found in the string";
	}
	
	public TFoundException(String msg){
		message = msg;
	}
	
	@Override
	public String toString() {
		return message;
	}
}

class StringNullPointerException extends Exception{
String message;
	
	public StringNullPointerException() {
		message = "String cannot be null";
	}
}

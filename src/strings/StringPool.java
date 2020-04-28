package strings;

public class StringPool{

	public static void main(String[] args) {
		String str = "Hello";
		String str1 = "Hello";
		String str2 = new String("Hello");
		String str3 = new String("Hello");
		if(str == str1){
			System.out.println("str1:Equal");
		}else{
			System.out.println("str1:Not Equal");
		}
		if(str2 == str3){
			System.out.println("str2:Equal");
		}else{
			System.out.println("str2:Not Equal");
		}
	}
}
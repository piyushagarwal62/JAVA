package strings;

public class RemoveDoubleLetters {

	public static void main(String[] args) {
		String str = "Leetteer";
		String str2="";
		for (int i = 0; i < str.length()-1; i++) {
			char first = str.charAt(i);
			char second = str.charAt(i+1);
			if(first!= second){
				str2 += first;				
			}
		}
		str2 += str.charAt(str.length()-1);
		System.out.println(str2);
	}
	
}

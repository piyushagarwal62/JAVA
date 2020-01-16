package strings;

public class EncryptString {

	public static void main(String[] args) {
		String str = "ABEDCOSDU";
		String converted = "";
		for (int i = 0; i < str.length(); i++) {
			char charAt = str.charAt(i);
			switch(charAt){
				case 'A':
					converted += '1';
				break;
				case 'E':
					converted += '2';
				break;
				case 'I':
					converted += '3';
				break;
				case 'O':
					converted += '4';
				break;
				case 'U':
					converted += '5';
				break;
				default:
					converted += (char)(charAt+2);
			}
		}
		System.out.println("Encrypted string: " + converted);
		

	}

}

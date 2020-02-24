package string_assignments;

import java.util.Scanner;

/**
 * @author piyush
 * Encrypting and decrypting text
 */
public class EncryptDecrypt {

	static String key= null;
		
	private String encryptData(String text){
		text = text.toUpperCase();
		StringBuilder encryptedStr = new StringBuilder();
		
		for (int i = 0; i < text.length(); i++) {
			char charAt = text.charAt(i);
			if(charAt >= 65 & charAt <= 97){
				encryptedStr.append(key.charAt(charAt - 65));
			}else{
				encryptedStr.append(charAt);
			}
		}
		return encryptedStr.toString();
	}

	private String decryptData(String text){
		text = text.toUpperCase();
		StringBuilder decryptedStr = new StringBuilder();
		
		for (int i = 0; i < text.length(); i++) {
			char charAt = text.charAt(i);
			if(charAt >= 65 & charAt <= 97){
				decryptedStr.append((char)(key.indexOf(charAt) + 65));
			}else{
				decryptedStr.append(charAt);
			}
		}
		return decryptedStr.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("Enter a 26 letter key");
		Scanner sc = new Scanner(System.in);
		key = sc.nextLine();
		System.out.println("Enter Plain text");
		String plainText = sc.nextLine();
		EncryptDecrypt obj = new EncryptDecrypt();
		String encryptedData = obj.encryptData(plainText);
		System.out.println("Ciphertext: " + encryptedData);
		String decyptedData = obj.decryptData(encryptedData);
		System.out.println("Decryption: " + decyptedData);
		sc.close();
	}

}

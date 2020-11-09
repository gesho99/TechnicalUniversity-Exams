package caesarCipher;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String message = sc.nextLine();
		
		if(message.length() > 80) {
			System.out.println("Your message is too big. It should not be with more than 80 symbols.");
		}
		
		String encryptedMessage = CaesarCipher.encrypt(message);
		System.out.println("Encrypted message: " + encryptedMessage);
		
		String decryptedMessage = CaesarCipher.decrypt(encryptedMessage);
		System.out.println("Decrypted message: " + decryptedMessage);
	}
	
}

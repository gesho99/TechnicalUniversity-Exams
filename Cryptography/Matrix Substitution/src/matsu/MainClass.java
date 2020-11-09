package matsu;

import java.util.Arrays;
import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		String message = sc.nextLine();
		String key = sc.nextLine();
		MATSU.createMatrix();
		MATSU.createKeyMatrix(key);
		String encryptedMessage = MATSU.encrypt(message, key);
		System.out.println("Encrypted Message: " + encryptedMessage);
	}
	
}

package bsa;

import java.util.List;
import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter message: ");
		String message = sc.nextLine();
		System.out.println("Enter key: ");
		String key = sc.nextLine();
		
		List<String> encryptedBlocks = BSA.encrypt(message, key);
		
		System.out.println("Encrypted message: ");
		
		for(String block : encryptedBlocks) {
			System.out.print(block);
		}
	}
	
}

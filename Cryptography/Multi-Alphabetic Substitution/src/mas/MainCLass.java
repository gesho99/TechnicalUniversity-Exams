package mas;

import java.util.List;
import java.util.Scanner;

public class MainCLass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String message = sc.nextLine();
		String key = sc.nextLine();
		
		if(message.length() > 300) {
			System.out.println("Your message is too big. It should not be with more than 80 symbols.");
		}
		
		try {
			List<String> encryptedMessage = MAS.encrypt(message, key);
			System.out.println("Encrypted message: " + encryptedMessage.toString());
		} catch(NullPointerException e) {
			
		}
	}
}

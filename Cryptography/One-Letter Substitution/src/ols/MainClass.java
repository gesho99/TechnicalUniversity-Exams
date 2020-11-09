package ols;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
	//ÎÒ ÑÌÅÒÊÀ Ñ ¹ 320 201 642 881 7 ÍÀ ÁÀÍÊÀ "ÁÈÎÕÈÌ" ÄÀ ÑÅ ÏÐÅÕÂÚÐËßÒ USD 10 000 000 Â ÊÎÐÅÑÏÎÍÄÅÍÒÑÊÀ ÁÀÍÊÀ NY 20361-8975
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String message = sc.nextLine();
		
		if(message.length() > 300) {
			System.out.println("Your message is too big. It should not be with more than 80 symbols.");
		}
		
		ArrayList<String> removables = new ArrayList<String>(List.of("{", "}", ","));	
		
		List<String> encryptedMessage = OLS.encryptWithoutSpaces(message);
		encryptedMessage.removeAll(removables);
		System.out.println("Encrypted message without white spaces: " + encryptedMessage.toString().replace("[", "").replace("]", "").replace(",", ""));
		
		encryptedMessage = OLS.encryptWithSpaces(message);
		System.out.println("Encrypted message with white spaces: " + encryptedMessage.toString().replace("[", "").replace("]", "").replace(",", ""));
		
//		String decryptedMessage = OLS.decrypt(encryptedMessage);
//		System.out.println("Decrypted message: " + decryptedMessage);
		
	}
	
}

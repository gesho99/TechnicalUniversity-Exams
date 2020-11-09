package mas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MAS {
	static List<String> letters = Arrays.asList("А", "Б", "В", "Г", "Д", 
			"Е", "Ж", "З", "И", "Й",
			"К", "Л", "М", "Н", "О", 
			"П", "Р", "С", "Т", "У", 
			"Ф", "Х", "Ц", "Ч", "Ш", 
			"Щ", "Ъ", "Ь", "Ю", "Я");
	
	public static List<String> encrypt(String message, String key){
		
		if(key.length() > 6) {
			System.out.println("Криптографският ключ е с повече от 6 символа.");
			return null;
		}
		
		List<String> messageLetters = Arrays.asList(message.split(""));
		List<String> keyLetters = Arrays.asList(key.split(""));
		Integer indx = 0, counter1 = -1, counter2 = -1;
		List<String> encryptedMessage = new ArrayList<String>();
		
		for(String letter : messageLetters) {
			counter1 += 1;
			counter2 += 1;
			
			if(counter2 < keyLetters.size()) {
				indx = letters.indexOf(messageLetters.get(counter1)) + letters.indexOf(keyLetters.get(counter2));
			}
			else {
				counter2 = 0;
				indx = letters.indexOf(messageLetters.get(counter1)) + letters.indexOf(keyLetters.get(counter2));
			}
			
			while(indx >= 29) {
				indx = indx - 30;
			}
			encryptedMessage.add(letters.get(indx+1));
		}
		
		return encryptedMessage;
	}
}

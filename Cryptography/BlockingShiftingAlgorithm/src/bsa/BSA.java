package bsa;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BSA {
	
	static String[] letters = new String[] {"А", "Б", "В", "Г", "Д", 
			"Е", "Ж", "З", "И", "Й",
			"К", "Л", "М", "Н", "О", 
			"П", "Р", "С", "Т", "У", 
			"Ф", "Х", "Ц", "Ч", "Ш", 
			"Щ", "Ъ", "Ь", "Ю", "Я", 
			" ", "1", "2", "3", "4", 
			"5", "6", "7", "8", "9" };
	
	public static List<String> encrypt(String message, String key) {
		
		List<String> blockedMessage = new ArrayList<String>(), encryptedBlockedMessage = new ArrayList<String>();
		String encryptedBlock = "";
		int counter = 0;
		
		//Проверява дали размерът на съобщението е кратен на размера на ключа
		if(message.length() % key.length() == 0) {
			for(int i = 1; i <= message.length() / key.length(); i++) {
				blockedMessage.add(message.substring(counter, counter+key.length()));
				counter += key.length();
			}
		}
		//Ако не е кратен ще трябва да се допълни до размера на ключа
		else {
			for(int i = 1; i <= message.length() % key.length(); i++) {
				message = message.concat("9");
			}
			for(int i = 1; i <= message.length() / key.length(); i++) {
				blockedMessage.add(message.substring(counter, counter+key.length()));
				counter += key.length();
			}
		}
		
		//Всеки блок от съобщението (всеки блок = дължината на ключа) се сплитва и на всяка буква от сплитнатия блок се променя позицията спрямо цифрата в ключа
		for(String block : blockedMessage) {
			counter = 0;
			List<String> splittedBlock = Arrays.asList(block.split(""));
			List<String> encryptedSplittedBlock = new ArrayList<String>(List.of("0", "0", "0", "0", "0"));
			for(String letter : splittedBlock) {
				encryptedSplittedBlock.set(Character.getNumericValue(key.charAt(counter)) - 1, letter);
				counter++;
			}
			for(String letter : encryptedSplittedBlock) {
				encryptedBlock += letter;
			}
			encryptedBlockedMessage.add(encryptedBlock);
			encryptedBlock = "";
		}
		
		return encryptedBlockedMessage;
	}
}

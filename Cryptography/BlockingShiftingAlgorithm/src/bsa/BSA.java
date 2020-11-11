package bsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSA {
	
	static String[] letters = new String[] {"À", "Á", "Â", "Ã", "Ä", 
			"Å", "Æ", "Ç", "È", "É",
			"Ê", "Ë", "Ì", "Í", "Î", 
			"Ï", "Ð", "Ñ", "Ò", "Ó", 
			"Ô", "Õ", "Ö", "×", "Ø", 
			"Ù", "Ú", "Ü", "Þ", "ß", 
			" ", "1", "2", "3", "4", 
			"5", "6", "7", "8", "9" };
	
	public static List<String> encrypt(String message, String key) {
		
		List<String> blockedMessage = new ArrayList<String>(), encryptedBlockedMessage = new ArrayList<String>();
		String encryptedBlock = "";
		int counter = 0;
		
		if(message.length() % key.length() == 0) {
			for(int i = 1; i <= message.length() / key.length(); i++) {
				blockedMessage.add(message.substring(counter, counter+5));
				counter += 5;
			}
		}
		else {
			
		}
		
		
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

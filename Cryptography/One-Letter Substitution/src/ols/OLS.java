package ols;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OLS {
	
	static List<String> letters =  Arrays.asList( "А", "Б", "В", "Г", "Д", "Е", 
			"Ж", "З", "И", "Й", "К", 
			"Л", "М", "Н", "О", "П", 
			"Р", "С", "Т", "У", "Ф", 
			"Х", "Ц", "Ч", "Ш", "Щ", 
			"Ъ", "Ь", "Ю", "Я", "0", 
			"1", "2", "3", "4", "5", 
			"6", "7", "8", "9", " ", 
			".", "-", "#" );
	
	static List<String> encryptedLetters = Arrays.asList( "10", "20", "30", "40", "15", "25",
			"11", "21", "31", "41", "35", 
			"45", "12", "22", "32", "42", 
			"13", "23", "33", "43", "14", 
			"24", "34", "16", "26", "36", 
			"17", "27", "37", "18", "28", 
			"38", "19", "29", "39", "1", 
			"2", "3", "4", "5", "6",
			"7", "8", "9");
	
	public static List<String> encryptWithoutSpaces(String message) {
		String[] messageLetters = message.split("");
		List<String> encryptedWord = new ArrayList<String>();
		
		for(String letter : messageLetters) {
			if(letters.indexOf(letter) == -1 && !letter.equals(" ")) {
				System.out.println("Символът " + letter + " от съобщението не е позволен.");
				break;
			}
			else {
				if(letter.contentEquals(" ")) {
					encryptedWord.add(" ");
				}
				else {
					encryptedWord.add(encryptedLetters.get(letters.indexOf(letter)));
				}
			}
		}
		encryptedWord.add("#");
		return encryptedWord;
	}
	
	public static List<String> encryptWithSpaces(String message) {
		String[] messageLetters = message.split("");
		List<String> encryptedWord = new ArrayList<String>();
		
		for(String letter : messageLetters) {
			if(letters.indexOf(letter) == -1) {
				System.out.println("Символът " + letter + " от съобщението не е позволен.");
				break;
			}
			else {
				if(letter.equals(" ")) {
					encryptedWord.add(" ");
					encryptedWord.add(encryptedLetters.get(letters.indexOf(letter)));
				}
				else {
					encryptedWord.add(encryptedLetters.get(letters.indexOf(letter)));
				}
			}
		}
		encryptedWord.add("#");
		return encryptedWord;
	}
	
	public static String decrypt(String message) {
		String[] messageLetters = message.split("");
		String decryptedWord = "";
		
		for(String letter : messageLetters) {
			decryptedWord += letters.get(encryptedLetters.indexOf(letter));
		}
		
		return decryptedWord;
	}
}

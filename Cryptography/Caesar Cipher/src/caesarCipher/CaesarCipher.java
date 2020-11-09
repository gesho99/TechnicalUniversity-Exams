package caesarCipher;

public class CaesarCipher {
	
	static String[] letters = new String[]{ "Ã", "Ç", "Ë", "Ï", "Ó", "×", "Ü", 
								"À", "Ä", "È", "Ì", "Ð", "Ô", "Ø", 
								"Þ", "Á", "Å", "É", "Í", "Ñ", "Õ",
								"Ù", "ß", "Â", "Æ", "Ê", "Î", "Ò", 
								"Ö", "Ú", "A", "B", "C", "D", "E",
								"F", "G", "H", "I", "J", "K", "L",
								"M", "N", "O", "P", "Q", "R", "S",
								"T", "U", "V", "W", "X", "Y", "Z",
								"0", "1", "2", "3", "4", "5", "6",
								"7", "8", "9", " ", ".", ",", ":",
								"/"};
	
	public static String encrypt(String message) {
		String[] messageLetters = message.split("");
		String encryptedWord = "";
		
		for(String letter : messageLetters) {
			encryptedWord += letters[java.util.Arrays.asList(letters).indexOf(letter) + 3];
		}
		
		return encryptedWord;
	}
	
	public static String decrypt(String message) {
		String[] messageLetters = message.split("");
		String decryptedWord = "";
		
		for(String letter : messageLetters) {
			decryptedWord += letters[java.util.Arrays.asList(letters).indexOf(letter) - 3];
		}
		
		return decryptedWord;
	}
	
}

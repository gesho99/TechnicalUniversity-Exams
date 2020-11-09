package matsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MATSU {
		
		static String[] letters = new String[] {"À", "Á", "Â", "Ã", "Ä", 
				"Å", "Æ", "Ç", "È", "É",
				"Ê", "Ë", "Ì", "Í", "Î", 
				"Ï", "Ð", "Ñ", "Ò", "Ó", 
				"Ô", "Õ", "Ö", "×", "Ø", 
				"Ù", "Ú", "Ü", "Þ", "ß" };
		
		static String[][] matrix = new String[letters.length][letters.length];
		static String[][] keyMatrix;
		
		public static void createMatrix() {
			Integer counter = 0, counter2 = 0;
			
			for(String letter : letters) {
				matrix[0][counter] = letter;
				counter++;
			}
			
			counter = 1;
			
			for(int row = 1; row < matrix.length; row++) {
				for(int col = 0; col < matrix.length; col++) {
					if((col+counter) >= matrix.length) {
						matrix[row][col] = matrix[0][counter2];
						counter2++;
					}
					else {
						matrix[row][col] = matrix[0][col+counter];
					}
				}
				counter++;
				counter2 = 0;
			}
		}
		
		public static void createKeyMatrix(String key) {
			keyMatrix = new String[key.length() + 1][letters.length];
			String[] keyLetters = key.split("");
			Integer counter = 0, matrixRow;
			
			for(String letter : letters) {
				keyMatrix[0][counter] = letter;
				counter++;
			}
			
			for(int row = 1; row < key.length() + 1; row++) {
				for(int col = 0; col < letters.length; col++) {
					for(matrixRow = 0; matrixRow < matrix.length; matrixRow++) {
						if(matrix[matrixRow][0].equals(keyLetters[row-1])) {
							break;
						}
					}
					keyMatrix[row][col] = matrix[matrixRow][col];
				}
			}
		}
		
		public static <T> List<T> twoDArrayToList(T[][] twoDArray) {
		    List<T> list = new ArrayList<T>();
		    for (T[] array : twoDArray) {
		        list.addAll(Arrays.asList(array));
		    }
		    return list;
		}
		
		public static String encrypt(String message, String key) {
			Integer matrixRow = 0, row = 0, col = 0, counter = 0, counter2 = 0, counter3 = 0;
			String[] messageLetters = message.trim().split("");
			String[] keyLetters = key.split("");
			String encryptedMessage = "";
			List<String> keyMatrixList = twoDArrayToList(keyMatrix);
			
			for(counter2 = 0; counter2 <= (messageLetters.length / keyLetters.length); counter2++) {
				counter3 = 0;
				for(String keyLetter : keyLetters) {
					if(counter2 == messageLetters.length / keyLetters.length 
							&& counter3 == messageLetters.length % keyLetters.length) {
						break;
					}
					for(matrixRow = 0; matrixRow < key.length() + 1 ; matrixRow++) {
						if(keyMatrix[matrixRow][0].equals(keyLetter)) {
							row = matrixRow;
							break;
						}
					}
					if(messageLetters[counter].equals(" ")) {
						encryptedMessage += " ";
						counter++;
						counter3++;
						continue;
					}
					else {
						col = keyMatrixList.indexOf(messageLetters[counter]);
					}
					encryptedMessage += keyMatrix[row][col];
					counter++;
					counter3++;
				}
			}
			return encryptedMessage;
		}
}

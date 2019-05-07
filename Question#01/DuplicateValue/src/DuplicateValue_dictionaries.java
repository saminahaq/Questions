import java.util.HashMap;
import java.util.Map;

//Question # 01 (Part # 02 (With Dictionaries))
//write code that will find a duplicate value in an array. Do the same for dictionaries.

public class DuplicateValue_dictionaries {
	public static boolean isDuplicateValueFound(String[] strArray) {
		boolean duplicateFound = false;
		Map<Integer, String> dictionary = new HashMap<Integer, String>(); // create a Dictionary
		
		for (int i = 0; i < strArray.length; i++) {
			String str = strArray[i];
			if (dictionary.containsValue(str)) { // check if already has this value
				duplicateFound = true;
				System.out.println("Duplicate value found for this test case is : " + str);
			}
			dictionary.put(i, str); // add the value to the set
			if (duplicateFound) {
				break;
			}

		} // end of for loop
		if (!duplicateFound) {
			System.out.println("There is no duplicate value in the given case");
		}
		return duplicateFound;
	}

	public static void main(String[] args) {

		// Test Cases # 01 Duplicate at the end
		String[] strArray_01 = { "GOOGL", "TSLA", "AAPL", "MA", "MA" };
		isDuplicateValueFound(strArray_01);
		// Test Cases # 02 Duplicate at the end
		String[] strArray_02 = { "GOOGL", "GOOGL", "TSLA", "AAPL", "MA" };
		isDuplicateValueFound(strArray_02);
		// Test Cases # 03 Duplicate at the end
		String[] strArray_03 = { "GOOGL", "TSLA", "AAPL", "MA" };
		isDuplicateValueFound(strArray_03);
	}
}

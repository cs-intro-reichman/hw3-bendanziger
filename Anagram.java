/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String cleanS1 = preProcess(str1);
		String cleanS2 = preProcess(str2);
		if(cleanS1.length() != cleanS2.length()){
			return false;
		}
		for (int i = 0; i < cleanS1.length(); i++) {
		char charToFind = cleanS1.charAt(i);
        int indexInS2 = cleanS2.indexOf(charToFind);
        if (indexInS2 == -1) {
            return false;
        } else {
            String part1 = cleanS2.substring(0, indexInS2);
            String part2 = cleanS2.substring(indexInS2 + 1);
            cleanS2 = part1 + part2;
        }
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
        str = str.replaceAll("[^a-z ]", "");
    
    return str;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String result = "";
		String source = str; 
        while (source.length() > 0) {
        int randomIndex = (int)(Math.random() * source.length());
        char c = source.charAt(randomIndex);
        result = result + c;
        String part1 = source.substring(0, randomIndex);
        String part2 = source.substring(randomIndex + 1);
        source = part1 + part2;
    }
		return result;
	}
}

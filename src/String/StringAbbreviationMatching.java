package String;

public class StringAbbreviationMatching {
	public static boolean match(String input, String pattern) {
		char[] inputArray = input.toCharArray();
		char[] patternArray = pattern.toCharArray();
		int i = 0;
		int j = 0;
		while (j < patternArray.length && i < inputArray.length) {
			if (Character.isDigit(patternArray[j])) {
				StringBuilder sb = new StringBuilder();
				while (j < patternArray.length) {
					if (Character.isDigit(patternArray[j])) {
						sb.append(patternArray[j++]);
					} else {
						break;
					}
				}
				for (int k = 0; k < Integer.valueOf(sb.toString()); k++) {
					i++;
				}
				if (i > inputArray.length) {
					return false;
				}
			} else {
				if (inputArray[i] != patternArray[j]) {
					return false;
				}
				i++;
				j++;
			}
		}
		if (j == patternArray.length && i == inputArray.length) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String input = "book";
		String pattern = "4";
		System.out.println(match(input, pattern));
	}
}

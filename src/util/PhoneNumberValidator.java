package util;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneNumberValidator {
	private static final Set<Character> VALID_CHARACTERS = Stream
			.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '#', '+').collect(Collectors.toSet());

	public static boolean validate(String phoneNumber) {
		boolean validFlag = false;

		// Check if phoneNumber contains any invalid characters
		for (Character c : phoneNumber.toCharArray()) {
			if (!VALID_CHARACTERS.contains(c)) {
				return validFlag;
			}
		}

		// If reached this line, no invalid characters found.
		validFlag = true;

		return validFlag;
	}
}

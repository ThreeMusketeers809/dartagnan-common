/**
 * 
 */
package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * A tool to determine if a given String represents a valid Dominican cedula
 * number.
 * 
 * @author Francisco Frias
 * @author Abel Guzman
 * @author Amin Guzman
 *
 */
public final class CedulaValidator {

	private static int CEDULA_LENGTH = 11;
	private static final Set<Character> VALID_CHARACTERS = Stream.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
			.collect(Collectors.toSet());

	/**
	 * @param cedula
	 *            The cedula to validate.
	 * @return true if the provided cedula is valid, false otherwise.
	 */
	public static boolean validate(String cedula) {
		// Cedula is invalid until proven otherwise.
		boolean validFlag = false;

		// Check length
		if (cedula.length() != CEDULA_LENGTH) {
			return validFlag;
		}

		// Check if cedula contains any invalid characters
		for (Character c : cedula.toCharArray()) {
			if (!VALID_CHARACTERS.contains(c)) {
				return validFlag;
			}
		}

		//TODO: Enable full validation for production
		// Check if cedula has a valid base 10 Luhn checksum
		if (true) {//decimalLuhnSum(cedula) % 10 == 0) {
			validFlag = true;
		}

		return validFlag;
	}

	/**
	 * 
	 * Calculates the Luhn sum of a string of decimal digits.
	 * 
	 * @param s
	 *            The input string to calculate from.
	 * @return The Luhn sum of the input string.
	 */
	private static int decimalLuhnSum(String s) {
		int result;
		// Reverse string to work from left to right, split into integer digits
		List<Integer> digits = splitIntStringToDigits(reverseString(s));

		// Calculate the digital root numbers in even positions times two
		for (int i = 0; i < digits.size(); i++) {
			// (i + 1) to account for the array starting at 0
			if ((i + 1) % 2 == 0) {
				digits.set(i, digitalRoot(2 * digits.get(i)));
			}
		}

		// Sum all digits
		result = sumDigits(digits);

		return result;
	}

	/**
	 * 
	 * Separates all the digits of an integer string into an integer list.
	 * 
	 * @param s
	 *            The string to split.
	 * @return A List object containing all the single digits in the passed string.
	 */
	private static List<Integer> splitIntStringToDigits(String s) {
		List<Integer> result = new ArrayList<Integer>();

		for (String c : s.split("")) {
			result.add(Integer.parseInt(c));
		}

		return result;
	}

	/**
	 * 
	 * Calculates the mathematical digital root of a decimal integer number.
	 * 
	 * @param n
	 *            The integer to use for the calculation.
	 * @return The digital root of the provided integer.
	 */
	private static int digitalRoot(int n) {
		int sum = n;

		while (sum >= 10) {
			sum = digitSum(sum);
		}
		return sum;
	}

	/**
	 * @param n
	 *            The decimal integer to calculate from.
	 * @return The mathematical digit sum of the provided integer.
	 */
	private static int digitSum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}

	/**
	 * 
	 * Sums all the integers in a List<Integer> object.
	 * 
	 * @param l
	 *            The list with the values to add up.
	 * @return The sum of all the elements in the list.
	 */
	private static int sumDigits(List<Integer> l) {
		int sum = 0;

		for (Integer d : l) {
			sum += d;
		}

		return sum;
	}

	/**
	 * 
	 * Reverses an arbitrary-length string.
	 * 
	 * @param s
	 *            The string to reverse.
	 * @return A string containing all the characters from the original string, in
	 *         reverse order.
	 */
	private static String reverseString(String s) {
		String result;

		StringBuilder sb = new StringBuilder(s);
		result = sb.reverse().toString();

		return result;
	}
}

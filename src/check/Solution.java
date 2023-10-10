package check;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer
 * (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'.
 * Read this character in if it is either. This determines if the final result is negative or positive respectively.
 * Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached.
 * The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0.
 * Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1],
 * then clamp the integer so that it remains in the range. Specifically,
 * integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 *
 * Example 1:
 * Input: s = "42"
 * Output: 42
 *
 * Example 2:
 * Input: s = "   -42"
 * Output: -42
 *
 * Example 3:
 * Input: s = "4193 with words"
 * Output: 4193
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(myAtoi("   -42"));
    }

    public static int myAtoi(String s) {
        boolean isNegative = false;
        int index = 0;
        while (index <= s.length() - 1) {
            if (s.charAt(index) == ' ') {
                index++;
            } else {
                break;
            }
        }

        while (index <= s.length() - 1) {
            if (s.charAt(index) == '-') {
                index++;
                isNegative = true;
            } else if (s.charAt(index) == '+'){
                index++;
            }
            break;
        }

        StringBuilder sb = new StringBuilder();
        while (index <= s.length() - 1) {
            String str = s.substring(index, index + 1);
            if (str.matches("[0-9]")) {
                sb.append(str);
                index++;
            } else {
                break;
            }
        }
        int output;
        if (sb.length() != 0) {
            try {
                output = Integer.parseInt(sb.toString());
                return isNegative ? -1 * output : output;
            } catch (NumberFormatException e) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        } else {
            return 0;
        }
    }
}

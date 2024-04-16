package org.launchcode;

public class BalancedBrackets {
    /*
     * The function hasBalancedBrackets should return true if and only if
     * the input string has a set of "balanced" brackets.
     *
     * Balanced brackets mean that every opening bracket '[' has a corresponding
     * closing bracket ']', and the brackets are properly nested.
     *
     * Examples of strings with balanced brackets include:
     * "[LaunchCode]", "Launch[Code]", "[]LaunchCode", "", "[]"
     *
     * Examples of strings without balanced brackets include:
     * "[LaunchCode", "Launch]Code[", "[", "]["
     *
     * @param str - the string to be validated
     * @return true if the brackets in the string are balanced, false otherwise
     */
    public static boolean hasBalancedBrackets(String str) {
        if (str == null) {
            return false; // Return false if the input string is null
        }

        int balance = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '[') {
                balance++;
            } else if (ch == ']') {
                if (balance == 0) {
                    return false;
                }
                balance--;
            }
        }
        return balance == 0;
    }
}
package ru.ershova.lab25;

/**
 * @author Anna
 */
public class ReverseString {
    public static String reverseString(String stringBeforeReverse) {
        String stringAfterReverse = new StringBuffer(stringBeforeReverse).reverse().toString();

        return stringAfterReverse;
    }
}

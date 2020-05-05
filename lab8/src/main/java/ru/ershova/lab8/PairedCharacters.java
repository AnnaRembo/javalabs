package ru.ershova.lab8;

/**
 * @author Anna
 */
public class PairedCharacters {
    /*
     * идет поиск вхождения маски "одна буква", чувствителеной к регистру
     *
     * поиск regex основан на алгоритме Бойера-Мура
     * сложность ~ 2 * string.length / размер алфавита
     *
     */
    public static String removePairCharacters(String oldString) {
        String newString = new String("");

        // одинаковая длина - больше нечего искать
        while (newString.length() != oldString.length()) {
            newString = oldString.intern();
            oldString = oldString.replaceAll("(\\w)\\1", "").intern();
        }

        return newString;
    }
}

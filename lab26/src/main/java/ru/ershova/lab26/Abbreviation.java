package ru.ershova.lab26;

/**
 * @author Anna
 */
public class Abbreviation {

    public static String createAbbreviation(String string) {

        string = string.replaceAll("Петербург", "ПБ");
        string = string.replaceAll("[^А-Я]", "");
        string = string.replaceAll(" ", "");

        return string;
    }
}

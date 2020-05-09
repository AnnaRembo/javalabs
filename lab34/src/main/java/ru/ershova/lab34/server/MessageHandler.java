package ru.ershova.lab34.server;

import java.util.*;

/**
 * @author Anna
 *
 * обработка сообщений - разделение, выбор ответа
 */
public class MessageHandler {

    private final static Random random = new Random();

    public static String processString(String message) {
        String answer = "";
        Set<String> stringSet = separateString(message);

        if (stringSet.size() > 0) {
            int count = 0;
            int index = random.nextInt(stringSet.size());
            for (String string: stringSet) {
                if (count == index){
                    answer = string;
                    break;
                }
                count++;
            }
        }

        answer = askAlisa(answer);

        return answer;
    }

    // разделить строку на слова
    public static Set<String> separateString(String string) {
        Set<String> stringSet = new HashSet<>();

        // разделить по любым символам, кроме букв
        string = string.replaceAll("[^\\w\u0430-\u044f\u0410-\u042f]", " ");
        String[] parts = string.split(" +");

        // убрать повторы
        Collections.addAll(stringSet, parts);

        return stringSet;
    }

    public static String askAlisa(String answer) {

        if (answer.equalsIgnoreCase("Алиса")) {
            answer = "Я Вас слушаю";
        } else if (answer.equals("") || answer.equals(" ")) {
            answer = "Не поняла, что Вы хотели";
        } else if (answer.equalsIgnoreCase("Ты") || answer.equalsIgnoreCase("Вы")) {
            answer = "Я?";
        } else answer += "?";

        return answer;
    }
}

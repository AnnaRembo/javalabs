package ru.ershova.lab5;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Anna
 */
public class MinList {

    public static <T extends Comparable<T>> T min (int begin, int end, List<T> list) {
        List<T> sublist;

        if (isCorrectParam(begin, end, list.size())) {
            sublist = new LinkedList<>(list.subList(begin, end));

            T min = sublist.get(0);

            for (T element: sublist
            ) {
                if (min.compareTo(element) > 0) {
                    min = element;
                }
            }
            //System.out.println("Тип T: " + sublist.get(0).getClass().getName());

            return min;
        } else {
            return null;
        }
    }

    // Вместо IndexOutOfBoundsException
    public static boolean isCorrectParam(int begin, int end, int size) {
        if (begin < end && begin > -1 && end < size)
            return true;
        else
            return false;
    }
}

package ru.ershova.lab7;

import java.util.*;

/**
 * @author Anna
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> set1 = new LinkedList<>();
        Set<Integer> set2 = new TreeSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(4);
        set1.add(1);
        set1.add(3);

        set2.add(1);
        set2.add(5);
        set2.add(1);
        set2.add(3);
        set2.add(9);

        Iterator<Integer> iterator1 = set1.iterator();
        Iterator<Integer> iterator2 = set2.iterator();
        System.out.println(TwoIterators.getDifference(iterator1, iterator2));
    }
}

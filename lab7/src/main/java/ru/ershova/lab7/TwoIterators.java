package ru.ershova.lab7;

import java.util.*;

/**
 * @author Anna
 */
public class TwoIterators {

    public static Set<Integer> getDifference(Iterator<Integer> iterator1, Iterator<Integer> iterator2) {
        Set<Integer> resultSet = new LinkedHashSet<>();
        // коллекции для упорядочивания и уникальности
        Collection<Integer> tempset1 = new TreeSet<>();
        Collection<Integer> tempset2 = new TreeSet<>();

        while (iterator1.hasNext()) {
            tempset1.add(iterator1.next());
        }
        while (iterator2.hasNext()) {
            tempset2.add(iterator2.next());
        }

        List<Integer> list1 = new LinkedList<>(tempset1);
        List<Integer> list2 = new LinkedList<>(tempset2);

        // обратно в итераторы
        ListIterator<Integer> tempiterator1 = (ListIterator<Integer>) list1.iterator();
        ListIterator<Integer> tempiterator2 = (ListIterator<Integer>) list2.iterator();

        // переменные для сравнения
        int item1;
        int item2;

        while (tempiterator1.hasNext()) {
            item1 = tempiterator1.next();
            while (tempiterator2.hasNext()) {
                item2 = tempiterator2.next();
                if (item1 == item2) {
                    // пропуск
                    break;
                } else if (item1 > item2) {
                    // пропуск
                } else {
                    // добавить в список
                    resultSet.add(item1);
                    tempiterator2.previous();
                    break;
                }
            }
            if (!tempiterator2.hasNext()) {
                tempiterator2.previous();
                if(item1 != tempiterator2.next())
                    // добавить в список
                    resultSet.add(item1);
            }
        }
        return resultSet;
    }
}

package ru.ershova.lab4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Anna
 */
public class Swap {
    private Swap() { }

    public static <T> List<T> swap(int i, int j, List<T> objectList) throws IndexOutOfBoundsException{
        // чтобы передаваемый объект не менялся
        List<T> objectList2 = new ArrayList<>(objectList);

        if (i > -1 && j > -1 && i < objectList.size() && j < objectList.size()) {
            T temp = objectList2.get(i);
            objectList2.set(i, objectList.get(j));
            objectList2.set(j, temp);
        } else {
            throw new IndexOutOfBoundsException("Вышли за предел списка, список прежний");
        }

        return objectList2;
    }
}

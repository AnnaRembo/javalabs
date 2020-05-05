package ru.ershova.lab4;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anna
 */
public class Main {
    private static Log log = LogFactory.getLog(Swap.class.getName());

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            stringList.add("string " + i);
        }

        try {
            stringList = Swap.swap(1, 5, stringList);
        } catch (IndexOutOfBoundsException e) {
            log.error(e, e.fillInStackTrace());
        }


        for (String string: stringList
             ) {
            System.out.println(string);
        }
    }
}

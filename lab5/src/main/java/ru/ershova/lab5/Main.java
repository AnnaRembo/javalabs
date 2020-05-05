package ru.ershova.lab5;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Anna
 */
public class Main {
    private static Log log = LogFactory.getLog(MinList.class.getName());
    final static Random random = new Random();

    public static void main(String[] args) {

        List<Integer> integerList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            integerList.add(random.nextInt(100));
            System.out.printf("%4d", integerList.get(i));
        }

        System.out.println("\nMin val: " + MinList.min(1, 7, integerList));
    }
}

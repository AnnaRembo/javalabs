package ru.ershova.lab6;

/**
 * @author Anna
 */
public class Computer implements Calculator {
    @Override
    public int summ(int x, int y) {
        return x + y;
    }
}

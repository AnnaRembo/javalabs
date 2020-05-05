package ru.ershova.lab18;

import java.math.BigInteger;

/**
 * @author Anna
 */
public class ArbitraryPrecision {
    public static void main(String[] args) {

        BigInteger a = new BigInteger("9000000000000000000");
        BigInteger b = new BigInteger("8444444444444444444");
        BigInteger c = new BigInteger("0");

        c = avg(a, b);
        System.out.println(c);
    }

    public static BigInteger avg(BigInteger a, BigInteger b) {
        BigInteger c = new BigInteger("0");
        BigInteger div = new BigInteger("2");

        c = a.add(b);
        c = c.divide(div);

        return c;
    }
}

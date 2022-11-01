package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ExtraLongFactorials {

    @Test
    public void test1() {
        extraLongFactorials(25);
    }

    public static void extraLongFactorials(int n) {

        BigInteger total = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            total = total.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(total);

    }

}

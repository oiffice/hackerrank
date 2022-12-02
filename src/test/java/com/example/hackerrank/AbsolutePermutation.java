package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AbsolutePermutation {
    @Test
    public void test1() {
        System.out.println(absolutePermutation(2, 1));
    }
    @Test
    public void test2() {
        System.out.println(absolutePermutation(10, 1));
    }
    @Test
    public void test3() {
        System.out.println(absolutePermutation(10,  0));
        System.out.println(absolutePermutation(10,  1));
        System.out.println(absolutePermutation(7,  0));
        System.out.println(absolutePermutation(10,  9));
        System.out.println(absolutePermutation(9,  0));
        System.out.println(absolutePermutation(8,  2));
        System.out.println(absolutePermutation(8,  0));
        System.out.println(absolutePermutation(7,  0));
        System.out.println(absolutePermutation(10,  1));
    }
    public static List<Integer> absolutePermutation(int n, int k) {

        List<Integer> result = new ArrayList<>();
        result.add(-1);

        if (k != 0 && ((n/2) % k) != 0) {
            return result;
        }

        int tempK = k;
        for (int i = 1; i < 2 * k + 1; i++) {
            result.add(i,  tempK + i);

            if (tempK + i == 2*k) {
                tempK -= 2 * tempK;
            }
        }

        if (k == 0) {
            for (int i = result.size(); i <= n; i++) {
                result.add(i, i);
            }
        } else {
            for (int i = 2*k + 1; i<=n; i++) {
                int targetIdx = i - 2*k;
                result.add(i, result.get(targetIdx) + 2*k);
            }
        }

        result.remove(0);
        return result;
    }
}

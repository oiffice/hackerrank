package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonDivisibleSubset {
    @Test
    public void test1() {
        assertEquals(3, nonDivisibleSubset(3, new ArrayList<>() {{ add(1); add(7); add(4); add(2); }}));
    }
    public int nonDivisibleSubset(int k, List<Integer> s) {

        int[] mods = new int[k];

        for (Integer integer : s) {
            mods[integer % k] += 1;
        }

        int count = Math.min(mods[0], 1);

        for (int i = 1; i <= k / 2 ; i++) {
            if (i != k-i) {
                count += Math.max(mods[i], mods[k-i]);
            } else {
                count += 1;
            }
        }

        return count;

    }
}

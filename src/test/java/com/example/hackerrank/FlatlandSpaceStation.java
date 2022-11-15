package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlatlandSpaceStation {
    @Test
    public void test1() {
        assertEquals(2, flatlandSpaceStations(5, new int[]{0, 4}));
    }
    @Test
    public void test2() {
        assertEquals(1, flatlandSpaceStations(6, new int[]{0, 3, 5}));
    }
    @Test
    public void test3() {
        assertEquals(0, flatlandSpaceStations(6, new int[]{0, 1,2,4,3,5}));
    }
    @Test
    public void test4() {
        assertEquals(6, flatlandSpaceStations(20, new int[]{13, 1, 11, 10, 6}));
    }
    static int flatlandSpaceStations(int n, int[] c) {

        List<Integer> dis = new ArrayList<>();
        List<Integer> cList = Arrays.stream(c).boxed().sorted().collect(Collectors.toList());

        for (int i = 0; i < cList.size() - 1; i++) {

            int lBound = cList.get(i);
            int rBound = cList.get(i+1);

            for (int j = lBound + 1; j < rBound; j++) {
                dis.add(Math.min(Math.abs(j - lBound), Math.abs(j - rBound)));
            }
        }
        int firstC = cList.get(0);
        int lastC = cList.get(cList.size() - 1);
        for (int i = 0; i < firstC; i++ ) {
            dis.add(Math.abs(firstC - i));
        }

        for (int i = lastC + 1; i < n; i++ ) {
            dis.add(Math.abs(lastC - i));
        }

        return dis.stream().mapToInt(k -> k).max().orElse(0);
    }
}

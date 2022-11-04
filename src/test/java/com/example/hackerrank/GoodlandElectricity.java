package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoodlandElectricity {
    @Test
    public void test1() {
        assertEquals(-1, pylons(3, new ArrayList<Integer>() {{
            add(0); add(1);add(1);add(1);add(0);add(0);add(0);
        }}));
    }
    @Test
    public void test2() {
        assertEquals(2, pylons(3, new ArrayList<Integer>() {{
            add(0); add(1);add(1);add(1);add(0);add(0);add(1);
        }}));
    }
    @Test
    public void test3() {
        assertEquals(3, pylons(3, new ArrayList<Integer>() {{
            add(0); add(1);add(0);add(0);add(0);add(1);add(1);add(1);add(1);add(1);
        }}));
    }
    @Test
    public void test4() {
        assertEquals(-1, pylons(2, new ArrayList<Integer>() {{
            add(0); add(1);add(0);add(0);add(0);add(1);add(0);
        }}));
    }
    @Test
    public void test5() {
        assertEquals(-1, pylons(10, new ArrayList<Integer>() {{
            add(0); add(0);add(0);add(0);add(0);add(0);add(0);
            add(0); add(0);add(0);add(0);add(0);add(0);add(0);
        }}));
    }
    public static int pylons(int k, List<Integer> arr) {
        int count = 0;
        int gap = k - 1;
        int idx = gap;

        while (idx >= 0 && idx < arr.size()) {
            if (arr.get(idx) == 1) {
                count++;
            } else {
                idx--;
                continue;
            }
            if (arr.size() - 1 - idx >= 0 && arr.size() - 1 - idx <= gap) {
                return count;
            }

            int nextIdx = idx + 1 + 2 * gap;
            if (nextIdx > arr.size() - 1) {
                nextIdx = arr.size() - 1;
                while (arr.get(nextIdx) != 1) {
                    nextIdx--;
                }
                if (nextIdx == idx) {
                    return -1;
                }
            } else if (arr.get(nextIdx) != 1) {
                while (arr.get(nextIdx) != 1) {
                    nextIdx--;
                }
                if (nextIdx == idx) {
                    return -1;
                }
            }
            idx = nextIdx;
        }

        return idx > 0 ? count : -1;

    }
}

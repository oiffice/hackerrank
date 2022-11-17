package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pairs {
    @Test
    public void test1() {
        assertEquals(4,pairs(2, new ArrayList<>() {{
            add(1);
            add(7);
            add(5);
            add(9);
            add(11);
            add(239);
            add(241);
        }}));
    }
    @Test
    public void test2() {
        assertEquals(5, pairs(2, new ArrayList<>() {{
            add(1);
            add(3);
            add(5);
            add(8);
            add(6);
            add(4);
            add(2);
        }}));
    }
    @Test
    public void test3() {
        assertEquals(3, pairs(2, new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }}));
    }
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        arr = arr.stream().sorted().collect(Collectors.toList());
        int count = 0;
        for(int i = 0; i < arr.size() - 1; i++) {

            for (int j = i+1; j < arr.size() && arr.get(j) - arr.get(i) <= k; j++) {
                if (arr.get(j) - arr.get(i) == k) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}

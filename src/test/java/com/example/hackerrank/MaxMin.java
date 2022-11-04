package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxMin {
    @Test
    public void test1() {

        List<Integer> list = new ArrayList<>();
        list.add(4504);
        list.add(1520);
        list.add(5857);
        list.add(4094);
        list.add(4157);
        list.add(3902);
        list.add(822);
        list.add(6643);
        list.add(2422);
        list.add(7288);
        list.add(8245);
        list.add(9948);
        list.add(2822);
        list.add(1784);
        list.add(7802);
        list.add(3142);
        list.add(9739);
        list.add(5629);
        list.add(5413);
        list.add(7232);
        assertEquals(1335, maxMin(5, list));

    }
    public static int maxMin(int k, List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);

        int min = Integer.MAX_VALUE;
        int shift = k-1;
        for (int i = 0; i < arr.size() - shift; i++ ) {
            int temp = arr.get(i+shift) - arr.get(i);
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }
}

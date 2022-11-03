package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LilysHomework {
    @Test
    public void test1() {
        assertEquals(2, lilysHomework(new ArrayList<>(){{ add(12); add(7); add(15); add(3); }}));
    }
    @Test
    public void test2() {
        assertEquals(2, lilysHomework(new ArrayList<>(){{ add(3); add(4); add(2); add(5); add(1); }}));
    }
    public static int lilysHomework(List<Integer> arr) {
        List<Integer> reverseSort = new ArrayList<>(arr);
        return Math.min(sort(reverseSort, true), sort(arr, false));
    }

    private static int sort(List<Integer> arr, boolean isReverse) {

        PriorityQueue<Integer> queue;
        if (isReverse) {
            queue = new PriorityQueue<>(Collections.reverseOrder());
        } else {
            queue = new PriorityQueue<>();
        }
        queue.addAll(arr);
        Map<Integer, Integer> map = new HashMap<>();
        int countIdx = 0;
        while (!queue.isEmpty()) {
            map.put(queue.poll(), countIdx++);
        }
        boolean isSwap = true;
        int count = 0;
        while (isSwap) {
            isSwap = false;
            for (int i = 0; i < arr.size(); i++) {
                int num = arr.get(i);
                int actualIdx = map.get(num);

                if (i != actualIdx) {
                    isSwap = true;
                    int temp = arr.get(actualIdx);
                    arr.set(actualIdx, num);
                    arr.set(i, temp);
                    count++;
                }
            }
        }
        return count;
    }
}

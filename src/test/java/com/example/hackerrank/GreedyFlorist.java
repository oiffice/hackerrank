package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreedyFlorist {
    @Test
    public void test1() {
        assertEquals(29, getMinimumCost(3, new int[]{1,3,5,7,9}));
    }
    static int getMinimumCost(int k, int[] c) {
        int[] people = new int[k];
        Arrays.fill(people, 1);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(Arrays.stream(c).boxed().collect(Collectors.toList()));
        int count = 0;
        int price = 0;
        while (!queue.isEmpty()) {
            int idx = count % k;
            price += people[idx] * queue.poll();
            people[idx] = people[idx] + 1;
            count++;
        }
        return price;
    }

}

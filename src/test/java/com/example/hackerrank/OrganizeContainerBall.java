package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrganizeContainerBall {
    @Test
    public void test1() {
        List<Integer> list1 = new ArrayList<>(){{add(1);add(1);}};
        List<Integer> list2 = new ArrayList<>(){{add(1);add(1);}};
        assertEquals("Possible", organizingContainers(
                new ArrayList<List<Integer>>(){{add(list1);add(list2);}}));

    }
    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here

        int[] row = new int[container.size()];
        int[] col = new int[container.get(0).size()];

        for(int i = 0; i < container.size(); i++) {
            for(int j = 0; j < container.get(i).size(); j++) {
                row[i] += container.get(i).get(j);
                col[i] += container.get(j).get(i);
            }
        }
        Arrays.sort(row);
        Arrays.sort(col);
        return Arrays.equals(row, col) ? "Possible" : "Impossible";

    }
}

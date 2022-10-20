package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoDArrayDS {
    @Test
    public void test1() {

        List<List<Integer>> arr = new ArrayList<>() {{
            add(new ArrayList<>() {{ add (1); add (1); add (1); add (0); add (0); add (0); }} );
            add(new ArrayList<>() {{ add (0); add (1); add (0); add (0); add (0); add (0); }} );
            add(new ArrayList<>() {{ add (1); add (1); add (1); add (0); add (0); add (0); }} );
            add(new ArrayList<>() {{ add (0); add (0); add (2); add (4); add (4); add (0); }} );
            add(new ArrayList<>() {{ add (0); add (0); add (0); add (2); add (0); add (0); }} );
            add(new ArrayList<>() {{ add (0); add (0); add (1); add (2); add (4); add (0); }} );
        }};

        assertEquals(19, hourglassSum(arr));

    }
    @Test
    public void test2() {

        List<List<Integer>> arr = new ArrayList<>() {{
            add(new ArrayList<>() {{ add (-1); add (-1); add (0); add (-9); add (-2); add (-2); }} );
            add(new ArrayList<>() {{ add (-2); add (-1); add (-6); add (-8); add (-2); add (-5); }} );
            add(new ArrayList<>() {{ add (-1); add (-1); add (-1); add (-2); add (-3); add (-4); }} );
            add(new ArrayList<>() {{ add (-1); add (-9); add (-2); add (-4); add (-4); add (-5); }} );
            add(new ArrayList<>() {{ add (-7); add (-3); add (-3); add (-2); add (-9); add (-9); }} );
            add(new ArrayList<>() {{ add (-1); add (-3); add (-1); add (-2); add (-4); add (-5); }} );
        }};

        assertEquals(-6, hourglassSum(arr));

    }

    public int hourglassSum(List<List<Integer>> arr) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {

            List<Integer> first = arr.get(i);
            List<Integer> second = arr.get(i+1);
            List<Integer> third = arr.get(i+2);
            for (int j = 0; j < 4; j++) {
                int temp = first.get(j) + first.get(j+1) + first.get(j+2) +
                        second.get(j+1) +
                        third.get(j) + third.get(j+1) + third.get(j+2);
                max = Math.max(max, temp);
            }

        }
        return max;
    }


}

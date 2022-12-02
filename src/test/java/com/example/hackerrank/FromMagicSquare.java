package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FromMagicSquare {

    @Test
    public void test1() {
        formingMagicSquare(new ArrayList<>() {{
            add(new ArrayList<>() {{ add(2);add(2);add(7);}});
            add(new ArrayList<>() {{ add(8);add(6);add(4);}});
            add(new ArrayList<>() {{ add(1);add(2);add(9);}});
        }});
    }

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        int[][] allMatrix = new int[][] {
                {8,3,4,1,5,9,6,7,2},
                {4,3,8,9,5,1,2,7,6},
                {8,1,6,3,5,7,4,9,2},
                {6,1,8,7,5,3,2,9,4},
                {2,9,4,7,5,3,6,1,8},
                {4,9,2,3,5,7,8,1,6},
                {6,7,2,1,5,9,8,3,4},
                {2,7,6,9,5,1,4,3,8}
        };

        int min = Integer.MAX_VALUE;
        for (int[] ary: allMatrix) {
            int count= 0;
            for(int i = 0; i < ary.length; i++) {
                count += Math.abs(s.get(i/3).get(i%3) - ary[i]);
            }
            if (count < min) {
                min = count;
            }
        }

        return min;
    }
}

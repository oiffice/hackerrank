package com.example.hackerrank;

import java.util.List;

public class SimpleArraySum {
    public static int simpleArraySum(List<Integer> ar) {
        // Write your code here
        return ar.stream().mapToInt(i -> i).sum();
    }
}

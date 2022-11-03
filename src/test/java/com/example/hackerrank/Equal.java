package com.example.hackerrank;

import java.util.Collections;
import java.util.List;

public class Equal {
    public static int equal(List<Integer> arr) {
        // Write your code here
        int min = Collections.min(arr);
        int result = Integer.MAX_VALUE;

        for (int i = min; i >= min - 5; i--) {
            int sum= 0;
            for (Integer integer: arr ) {
                int diff = integer - i;
                sum += (diff / 5 + (diff%5) / 2 + ((diff%5)%2));
            }
            result = Math.min(result, sum);
        }
        return result;
    }
}

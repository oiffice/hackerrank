package com.example.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompareTheTriple {
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        int[] arr = new int[2];


        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                arr[0]++;
            } else if (a.get(i) < b.get(i)) {
                arr[1]++;
            }
        }

        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
}

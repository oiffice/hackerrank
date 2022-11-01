package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlmostSorted {
    @Test
    public void test1() {
        almostSorted(new ArrayList<>() {{ add(1); add(3); add(2); add(6);}});
        almostSorted(new ArrayList<>() {{ add(1); add(5); add(4); add(3); add(2); add(6);}});
    }

    public static void almostSorted(List<Integer> arr) {
        List<Integer> sortedArr = new ArrayList<>(arr);
        sortedArr = sortedArr.stream().sorted().collect(Collectors.toList());

        int l = 0;
        int r = arr.size() - 1;

        while (l + 1 < arr.size() && arr.get(l) < arr.get(l+1)) {
            l++;
        }

        if (l == r) {
            System.out.println("yes");
            return;
        }

        while (r > 0 && arr.get(r) > arr.get(r-1)) {
            r--;
        }

        List<Integer> temp = new ArrayList<>(arr);
        int t = arr.get(l);
        temp.set(l, arr.get(r));
        temp.set(r, t);
        if(isSorted(temp)) {
            System.out.println("yes");
            System.out.println("swap " + (l + 1) + " " + (r + 1));
            return;
        }
        temp = new ArrayList<>(arr);
        for (int i = l, j = r; i < r; i++, j--) {
            int tt = arr.get(i);
            temp.set(i, arr.get(j));
            temp.set(j, tt);
        }

        if (isSorted(temp)) {
            System.out.println("yes");
            System.out.println("revers " + (l + 1) + " " + (r + 1));
            return;
        }

        System.out.println("no");

    }

    private static boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}

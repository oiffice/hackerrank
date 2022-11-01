package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiggerIsGreater {
    @Test
    public void test() {
        assertEquals("ba", biggerIsGreater("ab"));
    }
    @Test
    public void test2() {
        assertEquals("no answer", biggerIsGreater("bb"));
    }
    @Test
    public void test3() {
        assertEquals("fhcdk", biggerIsGreater("fdkhc"));
    }
    public String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();
        int i;
        boolean isSwap = false;

        for(i = chars.length - 1; i > 0; i--) {
            if (chars[i] > chars[i -1]) {
                for (int j = chars.length - 1; j >= i; j--) {
                    if (chars[i-1] < chars[j]) {
                        swap(chars, j, i-1);
                        isSwap = true;
                        break;
                    }
                }
                break;
            }
        }
        if (isSwap) {
            char[] temp = Arrays.copyOfRange(chars, i, chars.length);
            mergeSort(temp);
            System.arraycopy(temp, 0, chars, i, temp.length);
            return String.valueOf(chars);
        }

        return "no answer";
    }

    private void swap(char[] chars, int i, int j) {
        char tempC = chars[i];
        chars[i] = chars[j];
        chars[j] = tempC;
    }

    private void mergeSort(char[] chars) {

        if (chars.length == 1) {
            return;
        }
        int half = chars.length / 2;
        char[] left = Arrays.copyOfRange(chars, 0, half);
        char[] right = Arrays.copyOfRange(chars, half, chars.length);

        mergeSort(left);
        mergeSort(right);
        merge(chars, left, right, half, chars.length - half);
    }
    private void merge(char[] chars, char[] left, char[] right, int l, int r) {

        int i = 0, j = 0, k = 0;

        while (i < l && j  < r) {
            if (right[j] <= left[i]) {
                chars[k++] = right[j++];
            } else {
                chars[k++] = left[i++];
            }
        }

        while (i < l) {
            chars[k++] = left[i++];
        }

        while (j < r) {
            chars[k++] = right[j++];
        }

    }
}

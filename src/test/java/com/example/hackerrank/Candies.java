package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Candies {
    @Test
    public void test1() {
        System.out.println(candies(10, new ArrayList<>() {{
            add(2);add(4);add(2);add(6);add(1);
            add(7);add(8);add(9);add(2);add(1);
        }}));
    }
    @Test
    public void test2() {
        System.out.println(candies(10, new ArrayList<>() {{
            add(2);add(4);add(2);add(6);add(1);
            add(7);add(8);add(9);add(9);add(1);
        }}));
    }
    @Test
    public void test3() {
        System.out.println(candies(10, new ArrayList<>() {{
            add(4);add(2);add(2);add(6);add(1);
            add(7);add(8);add(9);add(2);add(1);
        }}));
    }
    @Test
    public void test4() throws IOException {
        candies2();
    }

    public static void candies2() throws IOException {

        File file = new File("input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long result = candies(n, arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
    }

    public static long candies(int n, List<Integer> arr) {
        // Write your code here
        int[] ary = new int[n];
        Arrays.fill(ary, 1);

        for(int i = 1; i < arr.size(); i++) {

            if (arr.get(i) > arr.get(i-1)) {
                ary[i] += ary[i - 1];
            }
        }

        for(int i = n - 2; i >= 0; i--) {
            if (arr.get(i) > arr.get(i+1) && ary[i] < ary[i+1] + 1) {
                ary[i] = ary[i+1] + 1;
            }
        }

        int result = 0;
        for(int i: ary) {
            result += i;
        }
        return result;
    }
}

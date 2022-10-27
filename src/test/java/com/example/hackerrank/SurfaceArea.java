package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SurfaceArea {

    @Test
    public void test1() {
        System.out.println(surfaceArea(new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(1);
                add(2);
                add(4);
            }});
            add(new ArrayList<>() {{
                add(2);
                add(2);
                add(3);
            }});
            add(new ArrayList<>() {{
                add(1);
                add(3);
                add(4);
            }});
        }}));
    }

    public int surfaceArea(List<List<Integer>> A) {
        int h = A.size();
        int w = A.get(0).size();
        int area = 2 * h * w; // top & bottom

        for(int i = 1; i < h; i++) {
            for(int j = 0; j < w; j++) {

                area += A.get(i).get(j) > A.get(i - 1).get(j) ? A.get(i).get(j) - A.get(i - 1).get(j) : 0;
                area += A.get(i-1).get(j) > A.get(i).get(j) ? A.get(i-1).get(j) - A.get(i).get(j) : 0;
            }
        }
        for (int i = 0; i < w; i++) {
            area += A.get(0).get(i);
            area += A.get(h - 1).get(i);
        }
        for (int i = 1; i < w; i++) {
            for (List<Integer> integers : A) {
                area += integers.get(i) > integers.get(i - 1) ? integers.get(i) - integers.get(i - 1) : 0;
                area += integers.get(i - 1) > integers.get(i) ? integers.get(i - 1) - integers.get(i) : 0;
            }
        }
        for (List<Integer> integers : A) {
            area += integers.get(0);
            area += integers.get(w - 1);
        }

        return area;

    }
}

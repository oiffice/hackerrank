package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectedCellInGrid {
    @Test
    public void test1() {
        List<List<Integer>> matrix = new ArrayList<>(){{

            add(new ArrayList<>(){{ add(1); add(1); add(0); add(0);}});
            add(new ArrayList<>(){{ add(0); add(1); add(1); add(0);}});
            add(new ArrayList<>(){{ add(0); add(0); add(1); add(0);}});
            add(new ArrayList<>(){{ add(1); add(0); add(0); add(0);}});
        }};

        assertEquals(5, connectedCell(matrix));

    }
    @Test
    public void test2() {
        List<List<Integer>> matrix = new ArrayList<>(){{

            add(new ArrayList<>(){{ add(0); add(1); add(1); add(1); add(1);}});
            add(new ArrayList<>(){{ add(1); add(0); add(0); add(0); add(1);}});
            add(new ArrayList<>(){{ add(1); add(1); add(0); add(1); add(0);}});
            add(new ArrayList<>(){{ add(0); add(1); add(0); add(1); add(1);}});
            add(new ArrayList<>(){{ add(0); add(1); add(1); add(1); add(0);}});
        }};

        assertEquals(15, connectedCell(matrix));

    }


    public static int connectedCell(List<List<Integer>> matrix) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) != -1) {
                    count += dfs(matrix, i , j);
                    if (count > max) {
                        max = count;
                    }
                    count = 0;
                }
            }
        }
        return max;
    }

    public static int dfs(List<List<Integer>> matrix, int x, int y) {
        boolean isNeedToFind = (
                x > -1 && y > -1 && x < matrix.size() && y < matrix.get(x).size() && matrix.get(x).get(y) == 1);
        int count = 0;
        if (isNeedToFind) {
            matrix.get(x).set(y, -1);
            // up
            count += dfs(matrix, x, y - 1);
            // down
            count += dfs(matrix, x, y+1);
            // left
            count += dfs(matrix, x - 1, y);
            // right
            count += dfs(matrix, x + 1, y);
            // left-top
            count += dfs(matrix, x -1, y - 1);
            // right-top
            count += dfs(matrix, x + 1, y - 1);
            // right-bottom diagonally
            count += dfs(matrix, x+1, y+1);
            // left-bottom diagonally
            count += dfs(matrix, x-1, y+1);
            count++;
        }
        return count;
    }
}

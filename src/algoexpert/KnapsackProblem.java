package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[][] items = new int[][] {
                {1,2},
                {4,3},
                {5,6},
                {6,7}
        };
        int capacity = 10;

        List<List<Integer>> lists = knapsackProblem(items, capacity);
        System.out.println(lists.get(0).get(0));
    }
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        // Write your code here.


        int[][] knapsack = new int[items.length + 1][capacity + 1];

        for (int i = 1; i < knapsack.length; i++) {
            int itemValue = items[i-1][0];
            int itemWeight = items[i-1][1];
            for (int j = 0; j <= capacity; j++) {
                if (itemWeight <= j) {
                    int newWeight = itemValue + knapsack[i - 1][j - itemWeight];
                    knapsack[i][j] = Math.max(knapsack[i - 1][j], newWeight);
                } else {
                    knapsack[i][j] = knapsack[i - 1][j];
                }
            }
        }

        return backTrackKnapsack(knapsack, items, capacity);
    }

    private static List<List<Integer>> backTrackKnapsack(int[][] knapsack, int[][] items, int capacity) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> indices = new ArrayList<Integer>();
        result.add(0, Collections.singletonList(knapsack[knapsack.length - 1][capacity]));
        int i = knapsack.length - 1;
        int j = knapsack[0].length - 1;
        while (i >= 0 && j >= 0) {
            if (knapsack[i][j] == 0) break;
            if (knapsack[i][j] == knapsack[i -1][j]) {
                i--;
            } else {
                indices.add(i - 1);
                j = j - items[i - 1][1];
                i--;
            }
        }
        result.add(1, indices);
        return result;
    }
}

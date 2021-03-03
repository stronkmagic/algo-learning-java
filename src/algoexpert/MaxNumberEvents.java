package algoexpert;

import java.util.Arrays;
import java.util.Comparator;

public class MaxNumberEvents {
    public static void main(String[] args) {
        int[][] events = new int[][] {
                {1,4},
                {4,4},
                {2,2},
                {3,4},
                {1,1}
        };

        Arrays.sort(events, (a, b) -> {
            int idx = (a[0] == b[0]) ? 1 : 0;
            return  a[idx] - b[idx];
        });
        System.out.println(1);
    }
}

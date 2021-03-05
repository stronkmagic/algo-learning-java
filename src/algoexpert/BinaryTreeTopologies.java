package algoexpert;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeTopologies {

    static Map<Integer, Integer> cache = new HashMap<>();
    static {
        cache.put(0,1);
    }

    public static void main(String[] args) {
        int n = 20;
        int res = recursion(n);
        System.out.println(res);
    }

    public static int recursion(int n) {
        if (cache.containsKey(n)) return cache.get(n);
        //if (n == 0) return 1;
        int topologies = 0;
        for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
            int rightTreeSize = n - 1 - leftTreeSize;
            int numberOfLeftTrees = recursion(leftTreeSize);
            int numberOfRightTrees = recursion(rightTreeSize);
            topologies += numberOfLeftTrees * numberOfRightTrees;
        }
        cache.put(n, topologies);
        return topologies;
    }
}
/**
 [
 [7, 8, 5,      4, 3, 9,    1, 2, 6],
 [6, 1, 2,      8, 7, 5,    3, 4, 9],
 [3, 4, 9,      6, 2, 1,    5, 7, 8],

 [3, 5, 7,      1, 4, 9,    2, 6, 8],
 [2, 6, 1,      7, 5, 8,    9, 3, 4],
 [9, 8, 4,      2, 6, 3,    1, 7, 5],

 [5, 7, 6,      3, 4, 8,    9, 1, 2],
 [1, 2, 3,      5, 9, 7,    4, 6, 8],
 [8, 4, 9,      2, 1, 6,    3, 5, 7]
 ]*/
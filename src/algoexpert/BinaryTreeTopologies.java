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
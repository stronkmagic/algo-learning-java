package leetcode;

import java.util.*;

public class SmallestStingWithSwaps {
    public static void main(String[] args) {
        String test = "dcab";

        List<List<Integer>> testSwaps = new ArrayList<>();
        testSwaps.add(Arrays.asList(0,3));
        testSwaps.add(Arrays.asList(1,2));
        testSwaps.add(Arrays.asList(0,2));

        SmallestStingWithSwaps solution = new SmallestStingWithSwaps();
        solution.smallestStringWithSwaps(test, testSwaps);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Set<String> swappedStrings = new HashSet<>();
        for (List<Integer> pair: pairs) {
            Set<String> currentSwappedStrings = new HashSet<>();
            smallestString(s.toCharArray(), pair.get(0), pair.get(1), pairs, currentSwappedStrings);
            swappedStrings.addAll(currentSwappedStrings);
        }

        int smallestIdx = Integer.MAX_VALUE;
        String res = s;
        for (String currentString: swappedStrings) {
            int currentLex = 0;
            for (int i = 1; i < currentString.length(); i++) {
                int charDiff = currentString.charAt(i - 1) - currentString.charAt(i);
                if (charDiff > 0) {
                    currentLex += charDiff;
                }
            }
            if (currentLex < smallestIdx) {
                smallestIdx = currentLex;
                res = currentString;
            }
        }
        return res;
    }

    private void smallestString(char[] arr, int i, int j,  List<List<Integer>> pairs, Set<String> swappedStrings) {
        if (arr[i] - arr[j] > 0) {
            char[] copy = arr;
            swap(copy, i, j);
            for (List<Integer> pair: pairs) {
                smallestString(copy, pair.get(0), pair.get(1), pairs, swappedStrings);
            }
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c: arr) {
                sb.append(c);
            }
            swappedStrings.add(sb.toString());
            return;
        }
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

package leetcode;

import javafx.util.Pair;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates2 {

    public static void main(String[] args) {
        String str = "yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy";
        int k = 4;
        RemoveAllAdjacentDuplicates2 s = new RemoveAllAdjacentDuplicates2();

        System.out.println(s.removeDuplicates(str, k));
    }

    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() <= k) return s;
        Stack<Pair<Character, Integer>> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek().getKey() == c) {
                Pair<Character, Integer> pair = stack.pop();
                if (pair.getValue() + 1 < k) stack.push(new Pair<>(c, pair.getValue() + 1));
            } else {
                stack.push(new Pair<>(c, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        Character[] arr = new Character[stack.size()];
        int idx = arr.length - 1;
        while (!stack.isEmpty() && idx >= 0) {
            arr[idx--] = stack.pop().getKey();
        }

        for (Character c: arr) sb.append(c);

        return sb.toString();
    }
}

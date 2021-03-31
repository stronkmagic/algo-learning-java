package leetcode;

import java.util.*;

public class StampTheSequence {
    public static void main(String[] args) {
        String stamp = "abca";
        String target = "aabcaca";

        StampTheSequence solution = new StampTheSequence();
        int[] ints = solution.movesToStamp(stamp, target);
        for (int i: ints) {
            System.out.println(i);
        }
    }

    public int[] movesToStamp(String stamp, String target) {
        int S = stamp.length(), T = target.length();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] done = new boolean[T];
        Stack<Integer> ans = new Stack<>();
        List<Node> windows = new ArrayList<>();

        for (int i = 0; i <= T-S; ++i) {
            Set<Integer> made = new HashSet<>();
            Set<Integer> todo = new HashSet<>();

            for (int j = 0; j < S; ++j) {
                if (target.charAt(i+j) == stamp.charAt(j))
                    made.add(i+j);
                else
                    todo.add(i+j);
            }

            windows.add(new Node(made, todo));

            if (todo.isEmpty()) {
                ans.push(i);
                for (int j = i; j < i + S; ++j) {
                    if (!done[j]) {
                        queue.add(j);
                        done[j] = true;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();

            int windowStart = Math.max(0 , i - S+1);
            int windowEnd = Math.min(T-S, i);
            for (int j = windowStart; j <= windowEnd; ++j) {
                if (windows.get(j).todo.contains(i)) {
                    windows.get(j).todo.remove(i);
                    if (windows.get(j).todo.isEmpty()) {
                        ans.push(j);
                        for (int m: windows.get(j).made) {
                            if (!done[m]) {
                                queue.add(m);
                                done[m] = true;
                            }
                        }
                    }
                }
            }
        }

        for (boolean b: done) {
            if (!b) return new int[0];
        }

        int[] res = new int[ans.size()];
        int t = 0;
        while (!ans.isEmpty()) {
            res[t++] = ans.pop();
        }
        return res;
    }

    static class Node {
        Set<Integer> made, todo;
        Node(Set<Integer> m, Set<Integer> t) {
            made = m;
            todo = t;
        }
    }
}

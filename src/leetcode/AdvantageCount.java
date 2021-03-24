package leetcode;

import java.util.*;

public class AdvantageCount {
    public static void main(String[] args) {
        int[] A = {12,24,8,32};
        int[] B = {13,25,32,11};
        int[] A1 = {2,0,4,1,2};
        int[] B1 = {1,3,0,0,2};
        AdvantageCount s = new AdvantageCount();
        int[] ints = s.advantageCount(A, B);
        int[] ints2 = s.advantageCount(A1, B1);

        for (int i: ints) System.out.println(i);
        for (int i: ints2) System.out.println(i);
    }

    public int[] advantageCount(int[] A, int[] B) {
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);

        // assigned[b] = list of a that are assigned to beat b
        Map<Integer, Deque<Integer>> assigned = new HashMap<>();
        for (int b: B) assigned.put(b, new LinkedList<>());

        // remaining = list of a that are not assigned to any b
        Deque<Integer> remaining = new LinkedList();

        // populate (assigned, remaining) appropriately
        // sortedB[j] is always the smallest unassigned element in B
        int j = 0;
        for (int a: sortedA) {
            if (a > sortedB[j]) {
                assigned.get(sortedB[j++]).add(a);
            } else {
                remaining.add(a);
            }
        }

        // Reconstruct the answer from annotations (assigned, remaining)
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; ++i) {
            // if there is some a assigned to b...
            if (assigned.get(B[i]).size() > 0)
                ans[i] = assigned.get(B[i]).pop();
            else
                ans[i] = remaining.pop();
        }
        return ans;
    }

}

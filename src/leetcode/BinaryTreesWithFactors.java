package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreesWithFactors {
    public static void main(String[] args) {
        int[] numsTest = {2,4,5,10,11};
        BinaryTreesWithFactors solution = new BinaryTreesWithFactors();
        int i = solution.numFactoredBinaryTrees(numsTest);
        System.out.println(i);
    }

    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1_000_000_007;
        Arrays.sort(arr);

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) map.put(arr[i], i);

        int[] dp = new int[arr.length];
        Arrays.fill(dp , 1);
        for (int i = 0; i < arr.length; i++) {
            int rootCandidate = arr[i];
            for (int j = 0; j < i; j++) {
                if (rootCandidate % arr[j] == 0) {
                    int val = rootCandidate / arr[j];
                    if (map.containsKey(val)) {
                        int key = map.get(val);
                        dp[i] += (dp[j] * dp[key]) % mod;
                    }
                }
            }
        }

        long ans = 0;
        for (long d: dp) ans += d;

        return (int) (ans % mod);
    }
}

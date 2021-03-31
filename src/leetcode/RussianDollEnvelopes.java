package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
//        int[][] envelopes = {
//                {77,81},
//                {72,45},
//                {52,68},
//                {50,53},
//                {50,52},
//                {46,89}
//        };
        int[][] envelopes = {
                {5,4},
                {6,4},
                {6,7},
                {2,3}
        };
        RussianDollEnvelopes solution = new RussianDollEnvelopes();
        int res = solution.maxEnvelopes(envelopes);
        System.out.println(res);
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (x, x1) -> {
            if (x[0] == x1[0]) {
                return x1[1] - x[1];
            }
            return x[0] - x1[0];
        });

        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        return lengthOfLIS(heights);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}

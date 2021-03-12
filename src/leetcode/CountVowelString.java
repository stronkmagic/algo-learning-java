package leetcode;

import java.util.Arrays;

public class CountVowelString {
    public static void main(String[] args) {
        CountVowelString solution = new CountVowelString();

        solution.countVowelStrings(33);
    }

    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= n; i++) {
//            int dp1 = dp[0] + dp[1];
//            int dp2 = dp[0] + dp[1] + dp[2];
//            int dp3 = dp[0] + dp[1] + dp[2] + dp[3];
//            int dp4 = dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
//            dp[1] = dp1;
//            dp[2] = dp2;
//            dp[3] = dp3;
//            dp[4] = dp4;
            for (int j = 0; j < dp.length; j++) {
                int sum = 0;
                for (int k = j; k < dp.length; k++) {
                    sum += dp[k];
                }
                dp[j] = sum;
            }
        }
        //return dp[dp.length-1];
        return dp[0];
    }

    /**
     *
     *
     */
}

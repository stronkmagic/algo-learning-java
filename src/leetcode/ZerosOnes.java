package leetcode;

public class ZerosOnes {
    public static void main(String[] args) {
        ZerosOnes solution = new ZerosOnes();


        String[] strs = {"10", "0001", "111001", "1", "0"};
        int n = 3;
        int m = 5;

        solution.findMaxForm(strs, m, n);
    }

    public int findMaxForm(String[] strs, int m, int n) {

        int[][]dp = new int[m+1][n+1];

        for (String str: strs) {
            int zeros = 0, ones = 0;
            char[] chars = str.toCharArray();
            for (char c: chars) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--)  {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones]+1);
                }
            }
        }

        return dp[m][n];
    }
}

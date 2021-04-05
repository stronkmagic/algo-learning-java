package leetcode;

import java.util.Stack;

public class LongestValidParathenteses {
    public static void main(String[] args) {
        String test1 = "(())(()()()())";
        // 0 1 2 3 4 5 6 7 8 9 10) 11)
        // 0 0 2 0 4 0 6 0 8 0 10
        // 0 0 2 2
        String test2 = "(()(((()()))))";
        LongestValidParathenteses parathenteses = new LongestValidParathenteses();
        int i1 = parathenteses.longestValidParentheses(test1);
        int i2 = parathenteses.longestValidParentheses(test2);
        System.out.println(i1);
        System.out.println(i2);
    }
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}

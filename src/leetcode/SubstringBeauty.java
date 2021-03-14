package leetcode;

import java.util.Map;

public class SubstringBeauty {
    public static void main(String[] args) {
        String test = "aabcbaa";

        Solution s = new Solution();
        int i = s.beautySum(test);
        System.out.println(i);
    }
}

class Solution {

    public int beautySum(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            for (int j = i; j < s.length(); j++) {
                ++cnt[s.charAt(j)-'a'];

                int max = 0, min = s.length();
                for (int x: cnt) if (x > 0) {
                    max = Math.max(max, x);
                    min = Math.min(min, x);
                }
                ans += max - min;
            }
        }
        return ans;
    }
}

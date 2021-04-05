package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairs {

    private int MOD = 1_000_000_000;
    public static void main(String[] args){
        int[] test1 = {42,11,1,97};
        CountNicePairs c = new CountNicePairs();
        c.countNicePairs(test1);
    }

    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int answer = 0;

        for (int num : nums) {
            int cur = num - rev(num);
            int count = counts.getOrDefault(cur, 0);

            answer += count;
            answer %= MOD;
            counts.put(cur, count + 1);
        }

        return answer;
    }


    private int rev(int num) {
        int reversed = 0;
        num %= MOD;
        while(num != 0) {

            int digit = num % 10;
            reversed = reversed * 10 + digit;
            reversed %= MOD;
            num /= 10;
        }
        return reversed;
    }
}

package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ThreeSumWithMulti {
    public static void main(String[] args) {
        int[] arr1 = {16,51,36,29,84,80,46,97,84,16};
        int target = 171;
        ThreeSumWithMulti solution = new ThreeSumWithMulti();
        solution.threeSumMulti(arr1, target);
    }

    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        long ans = 0;
        int MOD = 1_000_000_007;
        LinkedHashMap<Integer, Long> countMap = new LinkedHashMap<>();
        for (int num: arr) {
            long count = countMap.getOrDefault(num, 0L);
            countMap.put(num, count+1);
        }


        int[] keys = new int[countMap.size()];
        int idx = 0;
        for (int k: countMap.keySet()) {
            keys[idx++] = k;
        }


        for (int i = 0; i < keys.length; i++) {
            int T = target - keys[i];
            int l = i, r = keys.length - 1;
            while (r >= l) {
                if (keys[l] + keys[r] < T) {
                    l++;
                } else if (keys[l] + keys[r] > T) {
                    r--;
                } else {

                    long countI = countMap.get(keys[i]);
                    long countL = countMap.get(keys[l]);
                    long countR = countMap.get(keys[r]);
                    if (i < l && l < r) {
                        ans += countI * countL * countR;
                    } else if (i == l && l < r) {
                        ans += countI * (countI - 1) / 2 * countR;
                    } else if (i < l && l == r) {
                        ans += countI * countL * (countL - 1) / 2;
                    } else {  // i == l == r
                        ans += countI * (countI - 1) * (countI - 2) / 6;
                    }
                    ans %= MOD;
                    l++;
                    r--;
                }
            }
        }

        return (int) ans;
    }
}

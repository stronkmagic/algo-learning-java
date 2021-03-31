package leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public static void main(String[] args) {
        String[] A = {"amazon","apple","facebook","google","leetcode"};
        String[] B = {"lo","eo"};

        WordSubsets solution = new WordSubsets();
        List<String> strings = solution.wordSubsets(A, B);
        for(String s: strings) System.out.println(s);
    }

    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = count("");
        for (String b: B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList();
        search: for (String a: A) {
            int[] aCount = count(a);
            for (int i = 0; i < 26; ++i)
                if (aCount[i] < bmax[i])
                    continue search;
            ans.add(a);
        }

        return ans;
    }

    public int[] count(String S) {
        int[] ans = new int[26];
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }
}

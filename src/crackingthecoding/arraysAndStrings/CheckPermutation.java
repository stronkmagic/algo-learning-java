package crackingthecoding.arraysAndStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckPermutation {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";

        CheckPermutation solution = new CheckPermutation();

    }

    private boolean checkPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;

        int[] charCounts = new int[128];

        for (char c: s1.toCharArray()) {
            charCounts[c]++;
        }

        //
        for (char c: s2.toCharArray()) {
            charCounts[c]--;
            if (charCounts[c] < 0) return false;
        }


        return true;
    }
}

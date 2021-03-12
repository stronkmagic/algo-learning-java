package leetcode;

import java.io.IOException;
import java.util.*;

public class BinaryStringSubstringCodesK {
    public static void main(String[] args) throws IOException {
        int k = 2;
String test  = "00110";
        BinaryStringSubstringCodesK solution = new BinaryStringSubstringCodesK();
        boolean b = solution.hasAllCodesHash(test, k);
        System.out.println(b);
    }

    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        Set<String> kStrings = new HashSet<>();

        for (int i = k; i <= s.length(); i++) {
            String substring = s.substring(i - k, i);
            if (!kStrings.contains(substring)) {
                kStrings.add(substring);
                need --;
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasAllCodesHash(String s, int k) {
        int need = 1 << k;
        BitSet got = new BitSet(need);
        int allOne = need - 1;
        int hashVal = 0;

        for (int i = 0; i < s.length(); i++) {
            hashVal =  ((hashVal << 1) & allOne) | (s.charAt(i) - '0');

            if (i >= k - 1 && !got.get(hashVal)) {
                got.set(hashVal, true);
                need--;
                if (need == 0) {
                    return true;
                }
            }
        }

        return false;
    }
 }

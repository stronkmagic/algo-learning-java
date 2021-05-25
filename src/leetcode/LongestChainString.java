package leetcode;

import java.util.*;

public class LongestChainString {
    public static void main(String[] args) {
        String[] words1 = {"a","b","ba","bca","bda","bdca"};
        String[] words2 = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        String[] words3 = {"a","b","ab","bac"};

        Solution longestChainString = new Solution();
        System.out.println(longestChainString.longestStrChain(words1));
        System.out.println(longestChainString.longestStrChain(words2));
        System.out.println(longestChainString.longestStrChain(words3));
    }

    static class Solution {
        HashMap<Integer, List<String>> map;
        int ans;

        public int longestStrChain(String[] words) {
            if (words.length == 0) return 0;
            Arrays.sort(words, Comparator.comparing(String::length));
            map = new HashMap<>();

            for (String w : words) {
                int lvl = w.length();
                List<String> wordsWithLength = map.getOrDefault(lvl, new ArrayList<>());
                wordsWithLength.add(w);
                map.put(lvl, wordsWithLength);
            }
            ans = 0;

            int lvl = words[0].length();
            for (String wordAtLvl : map.get(lvl)) {
                ans = Math.max(ans, recursion(wordAtLvl, lvl + 1, 1));
            }


            return ans;
        }

        private int recursion(String current, int lvl, int len) {
            if (!map.containsKey(lvl)) return len;

            for (String wordAtLvl : map.get(lvl)) {
                if (isPredecessor(current, wordAtLvl)) {
                    ans = Math.max(ans, recursion(wordAtLvl, lvl + 1, len + 1));
                }
            }
            return ans;
        }

        private int[] countChars(String s) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) count[c - 'a']++;
            return count;
        }

        private boolean isPredecessor(String s1, String s2) {
            if (s2.length() <= s1.length()) return false;

            int[] s1Chars = countChars(s1);
            int[] s2Chars = countChars(s2);

            for (int i = 0; i < 26; i++) {
                if (Math.abs(s1Chars[i] - s2Chars[i]) > 1) return false;
            }

            return true;
        }
    }
}

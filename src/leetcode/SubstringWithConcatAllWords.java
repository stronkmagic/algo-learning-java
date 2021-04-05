package leetcode;
import java.util.*;

public class SubstringWithConcatAllWords {
    public static void main(String[] args) {
//        String str = "barfoofoobarthefoobarman";
//        String[] words = {"bar", "foo", "the"};
        String str = "wordgoodgoodgoodbestword";
        //String str = "barfoothefoobarman";
        String[] words = {"word","good","best","good"};
        //bar foo the
        //bar the foo
        SubstringWithConcatAllWords s = new SubstringWithConcatAllWords();
        List<Integer> res = s.findSubstring(str, words);
        for (Integer r: res) {
            System.out.println(r);
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        int substringLength = words[0].length() * words.length;

        HashMap<String, Integer> wordsCount = new HashMap<>();

        for (String word: words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        //sliding window
        for (int i = 0; i < s.length() - substringLength + 1; i++) {
            String sub = s.substring(i, i + substringLength);

            if (check(sub, wordsCount, words.length)) res.add(i);
        }
        return res;
    }
    private boolean check(String sub, HashMap<String, Integer> counts, int wordLength) {
        HashMap<String, Integer> seen = new HashMap<>();
        for (int i = 0; i < sub.length(); i+= wordLength) {
            String wordString = sub.substring(i, i + wordLength);
            if (!counts.containsKey(wordString))
                return false;

            seen.put(wordString, seen.getOrDefault(wordString, 0) + 1);

            if (seen.get(wordString) > counts.get(wordString)) return false;
        }

        return true;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class SentenceSimilarity {
    public static void main(String[] args) {
        String s1 = "eTUny i b R UFKQJ EZx JBJ Q xXz";

        String s2 = "eTUny i R EZx JBJ xXz";
        SentenceSimilarity s = new SentenceSimilarity();
        boolean res = s.areSentencesSimilar(s1, s2);
        System.out.println(res);
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        // sent 1 always bigger than sentence2
        if (sentence1.length() < sentence2.length()) return areSentencesSimilar(sentence2, sentence1);

        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        ArrayList<String> word2List = new ArrayList<>(Arrays.asList(words2));

        int i = 0;
        while (i < words2.length && words2[i].equals(words1[i]) && !word2List.isEmpty()) {
            word2List.remove(0);
            i++;
        }

        if (word2List.isEmpty()) return true;

        int j = words2.length - 1;
        int m = words1.length - 1;
        while (j >= 0 && m >= 0 && words2[j--].equals(words1[m--]) && !word2List.isEmpty()) word2List.remove(word2List.size() - 1);

        return word2List.isEmpty();
    }
}

package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class VowelSpellChecker {
    public static void main(String[] args) {
        String[] words = {"YellOw","KiTe","kite","hare","Hare"};
        String[] queries = {"yollow","kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        VowelSpellChecker soltuion = new VowelSpellChecker();
        String[] spellchecker = soltuion.spellchecker(words, queries);
        for (String checkedStr: spellchecker) {
            System.out.println(checkedStr);
        }
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {

        String[] checkedWords = new String[queries.length];

        HashSet<String> wordSet = new HashSet<>();
        HashMap<String, Integer> lowerCaseWordMap = new HashMap<>();
        HashMap<String, Integer> vowelMap = new HashMap<>();

        for (int i = 0; i < wordlist.length; i++) {
            String word = wordlist[i];
            wordSet.add(word);
            if (!lowerCaseWordMap.containsKey(word.toLowerCase()))
                lowerCaseWordMap.put(word.toLowerCase(), i);

            String myPreciousVowel = convertToAVowel(word);
            if (!vowelMap.containsKey(myPreciousVowel))
                vowelMap.put(myPreciousVowel, i);
        }

        int i = 0;
        for (String query: queries) {
            //Exactmatch
            if (wordSet.contains(query)) {
                checkedWords[i++] = query;
                continue;
            }
            if (lowerCaseWordMap.containsKey(query.toLowerCase())) {
                Integer firstMatchIndex = lowerCaseWordMap.get(query.toLowerCase());
                checkedWords[i++] = wordlist[firstMatchIndex];
                continue;
            }
            String vowelString = convertToAVowel(query);
            if (vowelMap.containsKey(vowelString)) {
                Integer firstMatchIndex = vowelMap.get(vowelString);
                checkedWords[i++] = wordlist[firstMatchIndex];
                continue;
            }
            checkedWords[i++] = "";
        }
        return checkedWords;
    }

    private String convertToAVowel(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> vowelChars = new HashSet<>(Arrays.asList('a', 'e', 'i', 'u', 'o', 'A', 'E', 'I', 'U', 'O'));
        for (char c: str.toCharArray()) {
            if (vowelChars.contains(c)) {
                sb.append('a');
                continue;
            }
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}

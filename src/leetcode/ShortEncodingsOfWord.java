package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortEncodingsOfWord {
    public static void main(String[] args) {
        String[] test1 = new String[]{"time","me","bell"};
        String[] test2 = new String[]{"me","time"};

        int test1Res = minimumLengthEncoding(test1);
        System.out.println(test1Res);
        int test2Res = minimumLengthEncoding(test2);
        System.out.println(test2Res);
    }
    public static int minimumLengthEncoding(String[] words) {
        return myNaiveSolution(words);
    }

    private static int trieSolution(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode curr = trie;
            for(int j = word.length() - 1; j >= 0; j--)
                curr = curr.get(word.charAt(j));
            nodes.put(curr, i);
        }

        int ans = 0;
        for (TrieNode node: nodes.keySet()) {
            if (node.count == 0)
                ans += words[nodes.get(node)].length() + 1;
        }
        return ans;
    }

    private static int myNaiveSolution(String[] words) {
        StringBuilder sb = new StringBuilder();
        List<String> strings = new ArrayList<>();

        for (String word: words) {
            if (strings.isEmpty()) {
                strings.add(word);
                continue;
            }
            boolean skip = false;
            for (int i = 0; i < strings.size(); i++) {
                String encoding = strings.get(i);
                if (word.length() > encoding.length() && word.endsWith(encoding)) {
                    strings.set(i, word);
                    skip = true;
                } else if (encoding.endsWith(word)) {
                    skip = true;
                }
            }
            if (!skip) {
                strings.add(word);
            }
        }

        for (String encoding: strings) {
            sb.append(encoding);
            sb.append("#");
        }

        return sb.toString().length();
    }
    static class TrieNode {
        TrieNode[] children;
        int count;
        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }

        public TrieNode get(char c) {
            if (children[c-'a'] == null) {
                children[c-'a'] = new TrieNode();
                count++;
            }
            return children[c-'a'];
        }

    }

}


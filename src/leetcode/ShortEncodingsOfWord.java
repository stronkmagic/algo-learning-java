package leetcode;

import java.util.ArrayList;
import java.util.List;

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
}

package algoexpert;

import java.util.ArrayList;

public class DivGenerator {
    public static void main(String[] args) {
        DivGenerator solution = new DivGenerator();
        solution.generateDivTags(3);
        solution.generateDivTags(4);
        solution.generateDivTags(5);
        solution.generateDivTags(6);
    }

    private final static String OPEN_TAG = "<div>";
    private final static String CLOSE_TAG = "</div>";

    public ArrayList<String> generateDivTags(int numberOfTags) {
        // Write your code here.
        ArrayList<String> divs = new ArrayList<>();
        generate(numberOfTags, numberOfTags, "", divs);
        return divs;
    }

    public void generate(int openTags, int closingTags, String prefix, ArrayList<String> res) {
        if (openTags > 0) {
            String newPrefix = prefix + OPEN_TAG;
            generate(openTags - 1, closingTags, newPrefix, res);
        }

        if (closingTags > openTags) {
            String newPrefix = prefix + CLOSE_TAG;
            generate(openTags, closingTags - 1, newPrefix, res);
        }

        if (closingTags == 0) {
            res.add(prefix);
        }
    }
}

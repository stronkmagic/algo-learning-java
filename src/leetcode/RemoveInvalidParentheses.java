package leetcode;

import java.util.*;

public class RemoveInvalidParentheses {

    public static void main(String[] args) {

        String exampleOne = "()())()";

//        RemoveInvalidParentheses solution = new RemoveInvalidParentheses();
//        List<String> removeParentheses = solution.removeParentheses(exampleOne);
//        for (String parentheses: removeParentheses) {
//            System.out.println(parentheses);
//        }

        Solution solution = new Solution();
        List<String> strings = solution.removeInvalidParentheses(exampleOne);
        for (String s: strings) System.out.println(s);
    }

    public List<String> removeParentheses(String s) {
        List<String> res = new ArrayList<>();

        if (s == null) return res;

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);
        boolean found = false;
        //bfs
        while (!queue.isEmpty()) {
            String currString = queue.poll();

            if (isValid(currString)) {
                res.add(currString);
                found = true;
            }

            if (found) continue;

            for (int i = 0; i < currString.length(); ++i) {
                char character = currString.charAt(i);
                if (character != '(' && character != ')') continue;

                String newState = currString.substring(0, i)  + currString.substring(i + 1);

                if (!visited.contains(newState)) {
                    queue.add(newState);
                    visited.add(newState);
                }
            }

        }

        return res;
    }

    private boolean isValid(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            int character = s.charAt(i);
            if (character == '(') {
                balance++;
            }
            if (character == ')' && balance-- == 0) return false;
        }
        return balance == 0;
    }

    static class Solution {

        private Set<String> validExpressions = new HashSet<String>();
        private int minimumRemoved;

        private void reset() {
            this.validExpressions.clear();
            this.minimumRemoved = Integer.MAX_VALUE;
        }

        private void recurse(
                String s,
                int index,
                int leftCount,
                int rightCount,
                StringBuilder expression,
                int removedCount) {

            // If we have reached the end of string.
            if (index == s.length()) {

                // If the current expression is valid.
                if (leftCount == rightCount) {

                    // If the current count of removed parentheses is <= the current minimum count
                    if (removedCount <= this.minimumRemoved) {

                        // Convert StringBuilder to a String. This is an expensive operation.
                        // So we only perform this when needed.
                        String possibleAnswer = expression.toString();

                        // If the current count beats the overall minimum we have till now
                        if (removedCount < this.minimumRemoved) {
                            this.validExpressions.clear();
                            this.minimumRemoved = removedCount;
                        }
                        this.validExpressions.add(possibleAnswer);
                    }
                }
            } else {

                char currentCharacter = s.charAt(index);
                int length = expression.length();

                // If the current character is neither an opening bracket nor a closing one,
                // simply recurse further by adding it to the expression StringBuilder
                if (currentCharacter != '(' && currentCharacter != ')') {
                    expression.append(currentCharacter);
                    this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
                    expression.deleteCharAt(length);
                } else {

                    // Recursion where we delete the current character and move forward
                    this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
                    expression.append(currentCharacter);

                    // If it's an opening parenthesis, consider it and recurse
                    if (currentCharacter == '(') {
                        this.recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
                    } else if (rightCount < leftCount) {
                        // For a closing parenthesis, only recurse if right < left
                        this.recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
                    }

                    // Undoing the append operation for other recursions.
                    expression.deleteCharAt(length);
                }
            }
        }

        public List<String> removeInvalidParentheses(String s) {

            this.reset();
            this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
            return new ArrayList(this.validExpressions);
        }
    }
}



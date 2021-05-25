package leetcode;
import java.util.*;
public class evaluateReversePolishNotation {
    public static void main(String[] args ){
        String[] tokens = {"2","1","+","3","*"};
        Solution solution = new Solution();
        solution.evalRPN(tokens);
    }
    static class Solution {
        Set<String> operators = new HashSet<>();

        public int evalRPN(String[] tokens) {
            operators.addAll(Arrays.asList("+","-","*","/"));
            Stack<Integer> stack = new Stack<>();

            for (String val: tokens) {
                if (isOperator(val)) {
                    operation(val, stack);
                } else {
                    stack.push(Integer.parseInt(val));
                }
                //System.out.printf("%s %n", stack.peek());
            }
            //System.out.printf("%s %n", stack.peek());
            return stack.pop();
        }

        private boolean isOperator(String token) {
            return operators.contains(token);
        }

        private void operation(String operator, Stack<Integer> stack) {
            int operator2 = stack.pop();
            int operator1 = stack.pop();
            Integer res = null;
            switch (operator) {
                case "+":
                    res = sum(operator1, operator2);
                    break;
                case "-":
                    res = subtract(operator1, operator2);
                    break;
                case "/":
                    res = divide(operator1, operator2);
                    break;
                case "*":
                    res = multiply(operator1, operator2);
                    break;
            }
            stack.push(res);
        }

        private int sum(int a, int b) {
            return a+b;
        }
        private int divide(int a, int b) {
            //zero division not needed
            return a/b;
        }
        private int multiply(int a, int b) {
            return a*b;
        }
        private int subtract(int a, int b) {
            return a-b;
        }
    }
/**

 "10","6","9","3","+","-11","*","/","*","17","+","5","+"

 prev - null
 stack - 17
 operator2 = pop 3 -11 -132
 operator1 = pop 3 12 6


 **/

}

package algoexpert;

import java.util.*;

public class SortStack {

    public static void main(String[] args) {
        SortStack s = new SortStack();
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(-5, 2, -10, 4, 3, 1));
        ArrayList<Integer> sorted = s.sortStack(list);

        System.out.println(sorted);
    }

    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        // base
        if (stack.size() == 0) {
            return stack;
        }

        Integer top = popStack(stack);
        sortStack(stack);

        insertSorted(stack, top);

        return stack;
    }

    private void insertSorted(ArrayList<Integer> stack, int val) {
        if (stack.size() == 0 || (peekStack(stack) <= val)) {
            stack.add(val);
            return;
        }

        int top = popStack(stack);

        insertSorted(stack, val);

        stack.add(top);
    }

    private Integer popStack(ArrayList<Integer> stack) {
        if (stack.size() == 0) throw new RuntimeException("stack is empty");
        return stack.remove(stack.size() - 1);
    }

    private Integer peekStack(ArrayList<Integer> stack) {
        if (stack.size() == 0) throw new RuntimeException("stack is empty");
        return stack.get(stack.size() - 1);
    }
}

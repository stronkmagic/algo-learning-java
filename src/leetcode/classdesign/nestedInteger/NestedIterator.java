package leetcode.classdesign.nestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    private Deque<NestedInteger> stack = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        flatten(nestedList);
    }

    @Override
    public Integer next() {
        return (hasNext()) ? stack.pop().getInteger() : null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            flatten(list);
        }
        return !stack.isEmpty();
    }

    private void flatten(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
    }
}

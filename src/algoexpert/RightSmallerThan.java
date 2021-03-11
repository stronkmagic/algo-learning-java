package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightSmallerThan {

    public static void main(String[] args) {
        List<Integer> arrTest = new ArrayList<>(Arrays.asList(6, 5, 11, -1, 3, 4, 2));
        rightSmallerThan(arrTest);
    }

    public static List<Integer> rightSmallerThan(List<Integer> array) {
        // Write your code here.
        if (array.size() == 0) return new ArrayList<>();

        int lastIdx = array.size() - 1;
        SpecialBST bst = new SpecialBST(array.get(lastIdx), lastIdx, 0);
        for (int i = array.size() - 2; i >= 0; i--) {
            bst.insert(array.get(i), i);
        }
        List<Integer> smaller = new ArrayList<>();
        getRightSmaller(bst, smaller);
        return smaller;
    }

    public static void getRightSmaller(SpecialBST bst, List<Integer> smaller) {
        if (bst == null) return;
        smaller.set(bst.idx, bst.numSmallerAtInsert);
        getRightSmaller(bst.left, smaller);
        getRightSmaller(bst.right, smaller);
    }


    static class SpecialBST {
        public int value;
        public int idx;
        public int leftSubtreeSize;
        public int numSmallerAtInsert;

        public SpecialBST left;
        public SpecialBST right;

        public SpecialBST(int value, int idx, int numSmallerAtInsert) {
            this.value = value;
            this.idx = idx;
            this.numSmallerAtInsert = numSmallerAtInsert;
            leftSubtreeSize = 0;
            left = null;
            right = null;
        }

        public void insert(int value, int idx) {
            insertHelper(value, idx, 0);
        }

        public void insertHelper(int value, int idx, int numSmallerAtInsert) {
            if (value < this.value) {
                leftSubtreeSize++;
                if (left == null) {
                    left = new SpecialBST(value, idx, numSmallerAtInsert);
                } else {
                    left.insertHelper(value, idx, numSmallerAtInsert);
                }
            } else  {
                numSmallerAtInsert += leftSubtreeSize;
                if (value > this.value) numSmallerAtInsert++;
                if (right == null) {
                    right = new SpecialBST(value, idx, numSmallerAtInsert);
                } else {
                    right.insertHelper(value, idx, numSmallerAtInsert);
                }
            }
        }
    }
}

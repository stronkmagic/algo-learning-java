package algoexpert;

import java.util.*;

public class FlattenBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);

        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.left.right.left = new BinaryTree(7);
        tree.left.right.right = new BinaryTree(8);

        tree.right = new BinaryTree(3);
        tree.right.left = new BinaryTree(6);

        BinaryTree res1 = flattenBinaryTreeLinear(tree);
        BinaryTree res2 = flattenBinaryTreeOptimal(tree);
    }

    // O(n) time | O(d) space
    public static BinaryTree flattenBinaryTreeOptimal(BinaryTree root) {
        return helper(root)[0];
    }

    private static BinaryTree[] helper(BinaryTree node) {
        BinaryTree left, right;

        if (node.left == null) {
            left = node;
        } else {
            BinaryTree[] nodes = helper(node.left);
            connectNode(nodes[1], node);
            left = nodes[0];
        }

        if (node.right == null) {
            right = node;
        } else {
            BinaryTree[] nodes = helper(node.right);
            connectNode(node, nodes[0]);
            right = nodes[1];
        }
        return new BinaryTree[] {left, right};
    }

    private static void connectNode(BinaryTree left, BinaryTree right) {
        left.right = right;
        right.left = left;
    }
    // O(n) space | O(n) time
    public static BinaryTree flattenBinaryTreeLinear(BinaryTree root) {
        // Write your code here.
                List<BinaryTree> inOrderNodes = inOrder(root, new ArrayList<>());
        for (int i = 0; i < inOrderNodes.size() - 1; i++) {
            BinaryTree leftNode = inOrderNodes.get(i);
            BinaryTree rightNode = inOrderNodes.get(i+1);
            leftNode.right = rightNode;
            rightNode.left = leftNode;
        }
        return inOrderNodes.get(0);
    }

    public static List<BinaryTree> inOrder(BinaryTree tree, List<BinaryTree> arr) {
        if (tree == null) return arr;
        inOrder(tree.left, arr);
        arr.add(tree);
        inOrder(tree.right, arr);
        return arr;
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}

package algoexpert;

import java.util.LinkedList;
import java.util.Queue;

public class RightSiblingTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.right = new BinaryTree(9);
        tree.left.right.right = new BinaryTree(10);
        tree.right.left.left = new BinaryTree(11);
        tree.right.right.left = new BinaryTree(12);
        tree.right.right.right = new BinaryTree(13);
        tree.right.left.left.left = new BinaryTree(14);
        BinaryTree tree1 = rightSiblingTree(tree);
        System.out.println("Finished");
    }

    public static BinaryTree rightSiblingTree(BinaryTree root) {
        // Write your code here.
        if (root == null) return root;
        Queue<BinaryTreeInfo> queue = new LinkedList<>();
        queue.add(new BinaryTreeInfo(root, false));

        while (!queue.isEmpty()) {
            int lvlSize = queue.size();

            BinaryTreeInfo prevNode = null;
            while (lvlSize-- > 0) {
                BinaryTreeInfo node = queue.poll();
                if (node.tree.left != null) queue.add(new BinaryTreeInfo(node.tree.left, true));
                if (node.tree.right != null) queue.add(new BinaryTreeInfo(node.tree.right, false));

                if (prevNode != null && node != null) {
                    if ((prevNode.isLeft && !node.isLeft) || //isLeft && isRight
                            (!prevNode.isLeft && node.isLeft)) { //isRight && isLeft
                        prevNode.tree.right = node.tree;
                    }
                }
                prevNode = node;
                node.tree.right = null;
            }
        }

        return root;
    }

    static class BinaryTreeInfo {
        BinaryTree tree;
        boolean isLeft;
        public BinaryTreeInfo(BinaryTree tree, boolean isLeft) {
            this.tree = tree;
            this.isLeft = isLeft;
        }
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

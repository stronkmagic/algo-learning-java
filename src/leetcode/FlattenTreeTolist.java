package leetcode;

public class FlattenTreeTolist {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);


        FlattenTreeTolist solution = new FlattenTreeTolist();
        solution.flatten(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }

    public void flatten(TreeNode root) {
        flatten(root, root.right);
    }
    private void flatten(TreeNode root, TreeNode rightNode) {
        if (root == null) return;


        TreeNode right = (root.right != null) ? root.right : rightNode;
        if (root.left != null) {
            root.right = root.left;
        } else {
            root.right = rightNode;
        }

        flatten(root.left, right);
        flatten(root.right, right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

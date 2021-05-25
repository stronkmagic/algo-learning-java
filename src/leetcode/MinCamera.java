package leetcode;

import java.util.*;
public class MinCamera {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);

        MinCamera camera = new MinCamera();
        camera.minCameraCover(root);
    }

    int ans;
    Set<TreeNode> covered;
    public int minCameraCover(TreeNode root) {
        ans = 0;
        covered = new HashSet<>();
        covered.add(null);

        dfs(root, null);
        return ans;
    }

    public void dfs(TreeNode node, TreeNode parent) {
        if (node == null) return;
        dfs(node.left, node);
        dfs(node.right, node);

        if (parent == null && !covered.contains(node) ||
                !covered.contains(node.left) ||
                !covered.contains(node.right)) {
            ans++;
            covered.add(node);
            covered.add(node.left);
            covered.add(node.right);
            covered.add(parent);
        }
    }

    static class TreeNode {
        TreeNode left, right;
        int val;
        TreeNode(int val){
            this.val = val;
        }
    }
}


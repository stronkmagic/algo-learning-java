package leetcode.BfsDfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MaxDepthNaryTree {

    public static void main(String[] args) {

        Node tree = new Node(1);
        tree.children = new ArrayList<>(Arrays.asList(new Node(3), new Node(2), new Node(4)));
        tree.children.get(0).children = new ArrayList<>(Arrays.asList(new Node(5), new Node(6)));

        MaxDepthNaryTree solution = new MaxDepthNaryTree();
        solution.maxDepth(tree);
    }
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        for(Node child: root.children){
            max = Math.max(maxDepth(child), max);
        }
        return max + 1;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}

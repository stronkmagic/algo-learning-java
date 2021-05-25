package crackingthecoding.DataStructure;

public class AVLTree {
    public static class Node {
        private Node left;
        private Node right;
        private int height = 1;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node leftRotate(Node node) {
        Node right = node.right;
        Node left = right.left;

        right.left = node;
        node.right = left;

        node.height = max(height(node.left), height(node.right)) + 1;
        right.height = max(height(right.right),height(right.left)) + 1;
        return right;
    }

    private Node rightRotate(Node node) {
        Node left = node.left;
        Node right = left.right;

        left.right = node;
        node.left = left;

        node.height = max(height(node.left),height(node.right)) + 1;
        left.height = max(height(left.left),height(left.right)) + 1;

        return left;
    }

    private int height(Node n) {
        if (n == null) return 0;
        return n.height;
    }
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    int getBalance(Node n) {
        if (n == null) return 0;

        return height(n.left) - height(n.right);
    }



    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(node.left,value);
        } else if (value > node.value) {
            node.right = insert(node.right,value);
        } else {
            //duplicate
            return  node;
        }

        node.height = 1 + max(height(node.left), height(node.right));
        int balance = getBalance(node);

        //LL case
        if (balance < 1 && value < node.left.value) {
            return rightRotate(node);
        }

        //RR case
        if (balance > 1 && value > node.right.value) {
            return leftRotate(node);
        }

        //LR case
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node);
            return rightRotate(node);
        }

        //RL case
        if (balance < 1 && value < node.right.value) {
            node.right = rightRotate(node);
            return leftRotate(node);
        }

        return node;
    }
}

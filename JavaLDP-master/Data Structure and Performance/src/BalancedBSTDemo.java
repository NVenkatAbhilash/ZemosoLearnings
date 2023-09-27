import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class AVLTree {
    private class Node {
        private int data;
        private Node left;
        private Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node head;

    AVLTree() {
        head = null;
    }

    static int height(Node node) {
        if (node == null)
            return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    static Node rRotate(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        return leftChild;
    }

    static Node lRotate(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        return rightChild;
    }

    static Node lrRotate(Node node) {
        node.left = lRotate(node.left);
        return rRotate(node);
    }

    static Node rlRotate(Node node) {
        node.right = rRotate(node.right);
        return lRotate(node);
    }

    static int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    Node insert(int data, Node node) {
        if (node == null) {
            node = new Node(data);
            return node;
        }
        if (node.data < data) {
            node.right = insert(data, node.right);
        } else {
            node.left = insert(data, node.left);
        }

        int balance = getBalance(node);

        if (balance > 1 && data < node.left.data) {
            System.out.println("right Rotate at " + node.data);
            return rRotate(node);
        }
        if (balance < -1 && data > node.right.data) {
            System.out.println("left Rotate at " + node.data);
            return lRotate(node);
        }
        if (balance > 1 && data > node.left.data) {
            System.out.println("left right Rotate at " + node.data);
            return lrRotate(node);
        }
        if (balance < -1 && data < node.right.data) {
            System.out.println("right left Rotate at " + node.data);
            return rlRotate(node);
        }
        return node;
    }

    static boolean search(Node node, int data) {
        if (node == null)
            return false;
        if (node.data == data)
            return true;
        if (node.data < data)
            return search(node.right, data);
        else
            return search(node.left, data);
    }

    static void preOrder(Node node) {
        System.out.println("Preorder traversal : ");
        if (node == null)
            return;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                System.out.print(node.data + " ");
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        System.out.println();
    }

    static void inOrder(Node node) {
        System.out.println("Inorder traversal : ");
        if (node == null)
            return;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.data + " ");
            node = node.right;
        }
        System.out.println();
    }

    static void postOrder(Node node) {
        System.out.println("Postorder traversal : ");
        if (node == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Stack<Node> out = new Stack<>();
        while (!stack.empty()) {
            node = stack.pop();
            out.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!out.empty()) {
            System.out.print(out.pop().data + " ");
        }
        System.out.println();
    }
}

public class BalancedBSTDemo {
    public static void main(String args[]) {
        AVLTree tree = new AVLTree();
        tree.head = tree.insert(5, tree.head);
        tree.head = tree.insert(8, tree.head);
        tree.head = tree.insert(11, tree.head);
        tree.head = tree.insert(9, tree.head);
        tree.head = tree.insert(10, tree.head);
        tree.head = tree.insert(7, tree.head);
        tree.head = tree.insert(6, tree.head);
        tree.head = tree.insert(3, tree.head);
        tree.head = tree.insert(2, tree.head);
        tree.preOrder(tree.head);
        tree.inOrder(tree.head);
        tree.postOrder(tree.head);
        System.out.println();
        if (tree.search(tree.head, 10))
            System.out.println("10 found");
        if (tree.search(tree.head, 3))
            System.out.println("3 found");
        if (tree.search(tree.head, 13))
            System.out.println("13 found");
    }
}

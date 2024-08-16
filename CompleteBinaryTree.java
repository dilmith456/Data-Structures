package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

    // Definition of a binary tree node
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Root of the binary tree
    private Node root;

    // Constructor
    public CompleteBinaryTree() {
        root = null;
    }

    // Function to insert a node in the complete binary tree
    public void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        }

        // Use a queue to perform level-order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left == null) {
                current.left = newNode;
                break;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = newNode;
                break;
            } else {
                queue.add(current.right);
            }
        }
    }

    // Function for in-order traversal
    public void inOrderTraversal() {
        System.out.print("In-order Traversal: ");
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    // Function for pre-order traversal
    public void preOrderTraversal() {
        System.out.print("Pre-order Traversal: ");
        preOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    // Function for post-order traversal
    public void postOrderTraversal() {
        System.out.print("Post-order Traversal: ");
        postOrderTraversal(root);
        System.out.println();
    }

    private void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Function to check if the binary tree is complete
    public boolean isCompleteBinaryTree() {
        if (root == null) return true;

        // Use a queue for level-order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left != null) {
                if (flag) return false;
                queue.add(current.left);
            } else {
                flag = true;
            }

            if (current.right != null) {
                if (flag) return false;
                queue.add(current.right);
            } else {
                flag = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree();

        // Insert nodes into the complete binary tree
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);

        // Print traversals
        tree.inOrderTraversal();
        tree.preOrderTraversal();
        tree.postOrderTraversal();

        // Check if the tree is complete
        if (tree.isCompleteBinaryTree()) {
            System.out.println("The tree is a complete binary tree.");
        } else {
            System.out.println("The tree is not a complete binary tree.");
        }
    }
}

package datastructures;

public class FullBinaryTree {

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
    public FullBinaryTree() {
        root = null;
    }

    // Function to create a full binary tree with given elements
    public void createFullBinaryTree(int[] elements) {
        if (elements.length == 0) return;
        root = createFullBinaryTree(elements, 0);
    }

    private Node createFullBinaryTree(int[] elements, int index) {
        if (index >= elements.length) return null;

        Node node = new Node(elements[index]);

        // Full binary tree property: Each node has 0 or 2 children
        // Calculate left and right child indices
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        // Recursively create left and right subtrees
        if (leftIndex < elements.length && rightIndex < elements.length) {
            node.left = createFullBinaryTree(elements, leftIndex);
            node.right = createFullBinaryTree(elements, rightIndex);
        }

        return node;
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

    // Function to check if the binary tree is full
    public boolean isFullBinaryTree() {
        return isFullBinaryTree(root);
    }

    private boolean isFullBinaryTree(Node node) {
        if (node == null) return true; // An empty tree is considered full

        // If leaf node, return true
        if (node.left == null && node.right == null) return true;

        // If both children are present
        if (node.left != null && node.right != null) {
            return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
        }

        // If one child is missing
        return false;
    }

    public static void main(String[] args) {
        FullBinaryTree tree = new FullBinaryTree();

        // Example array to create a full binary tree
        int[] elements = {1, 2, 3, 4, 5, 6, 7};
        tree.createFullBinaryTree(elements);

        // Print traversals
        tree.inOrderTraversal();
        tree.preOrderTraversal();
        tree.postOrderTraversal();

        // Check if the tree is full
        if (tree.isFullBinaryTree()) {
            System.out.println("The tree is a full binary tree.");
        } else {
            System.out.println("The tree is not a full binary tree.");
        }
    }
}

package datastructures;

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BinaryTree tree = new BinaryTree();

	        // Insert nodes into the binary tree
	        tree.insert(50);
	        tree.insert(30);
	        tree.insert(20);
	        tree.insert(40);
	        tree.insert(70);
	        tree.insert(60);
	        tree.insert(80);

	        // Print traversals
	        tree.inOrderTraversal();
	        tree.preOrderTraversal();
	        tree.postOrderTraversal();
	}

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
	    public BinaryTree() {
	        root = null;
	    }

	    // Function to insert a node in the binary tree
	    public void insert(int data) {
	        root = insertNode(root, data);
	    }

	    private Node insertNode(Node root, int data) {
	        if (root == null) {
	            // Tree is empty, create a new node
	            return new Node(data);
	        }

	        if (data < root.data) {
	            // Insert in the left subtree
	            root.left = insertNode(root.left, data);
	        } else {
	            // Insert in the right subtree
	            root.right = insertNode(root.right, data);
	        }

	        return root;
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

}

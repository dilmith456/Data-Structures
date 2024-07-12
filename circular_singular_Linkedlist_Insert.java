package datastructures;

public class circular_singular_Linkedlist_Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 circular_singular_Linkedlist_Insert csll = new circular_singular_Linkedlist_Insert();
	        csll.insertAtBeginning(10);
	        csll.insertAtBeginning(20);
	        csll.insertAtEnd(30);
	        csll.insertAfter(csll.head.next, 25);

	        System.out.println("Circular Singly Linked List:");
	        csll.displayList();
	}

	 static class Node {
	        int data;
	        Node next;

	        // Constructor to create a new node
	        Node(int data) {
	            this.data = data;
	            this.next = null;
	        }
	    }

	    // Head of the circular singly linked list
	    private Node head;

	    // Constructor to create an empty circular singly linked list
	    public circular_singular_Linkedlist_Insert() {
	        head = null;
	    }

	    // Method to insert a new node at the beginning of the list
	    public void insertAtBeginning(int data) {
	        Node newNode = new Node(data);
	        if (head == null) {
	            head = newNode;
	            newNode.next = head;
	        } else {
	            Node temp = head;
	            while (temp.next != head) {
	                temp = temp.next;
	            }
	            newNode.next = head;
	            temp.next = newNode;
	            head = newNode;
	        }
	    }

	    // Method to insert a new node at the end of the list
	    public void insertAtEnd(int data) {
	        Node newNode = new Node(data);
	        if (head == null) {
	            head = newNode;
	            newNode.next = head;
	        } else {
	            Node temp = head;
	            while (temp.next != head) {
	                temp = temp.next;
	            }
	            temp.next = newNode;
	            newNode.next = head;
	        }
	    }

	    // Method to insert a new node after a given node
	    public void insertAfter(Node prevNode, int data) {
	        if (prevNode == null) {
	            System.out.println("The given previous node cannot be null");
	            return;
	        }
	        Node newNode = new Node(data);
	        newNode.next = prevNode.next;
	        prevNode.next = newNode;
	    }

	    // Method to display the list
	    public void displayList() {
	        if (head == null) {
	            System.out.println("List is empty");
	            return;
	        }
	        Node temp = head;
	        do {
	            System.out.print(temp.data + " ");
	            temp = temp.next;
	        } while (temp != head);
	        System.out.println();
	    }
}

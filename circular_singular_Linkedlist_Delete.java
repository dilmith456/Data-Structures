package datastructures;

public class circular_singular_Linkedlist_Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		circular_singular_Linkedlist_Delete csll = new circular_singular_Linkedlist_Delete();
        csll.insertAtEnd(10);
        csll.insertAtEnd(20);
        csll.insertAtEnd(30);
        csll.insertAtEnd(40);

        System.out.println("Circular Singly Linked List:");
        csll.displayList();

        csll.deleteFromBeginning();
        System.out.println("List after deleting from beginning:");
        csll.displayList();

        csll.deleteFromEnd();
        System.out.println("List after deleting from end:");
        csll.displayList();

        csll.deleteNode(30);
        System.out.println("List after deleting node with value 30:");
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
	    public circular_singular_Linkedlist_Delete() {
	        head = null;
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

	    // Method to delete a node from the beginning of the list
	    public void deleteFromBeginning() {
	        if (head == null) {
	            System.out.println("List is empty, no node to delete.");
	            return;
	        }
	        if (head.next == head) {
	            head = null;
	        } else {
	            Node temp = head;
	            while (temp.next != head) {
	                temp = temp.next;
	            }
	            temp.next = head.next;
	            head = head.next;
	        }
	    }

	    // Method to delete a node from the end of the list
	    public void deleteFromEnd() {
	        if (head == null) {
	            System.out.println("List is empty, no node to delete.");
	            return;
	        }
	        if (head.next == head) {
	            head = null;
	        } else {
	            Node temp = head;
	            Node prev = null;
	            while (temp.next != head) {
	                prev = temp;
	                temp = temp.next;
	            }
	            prev.next = head;
	        }
	    }

	    // Method to delete a specific node
	    public void deleteNode(int key) {
	        if (head == null) {
	            System.out.println("List is empty, no node to delete.");
	            return;
	        }

	        // If head needs to be removed
	        if (head.data == key) {
	            deleteFromBeginning();
	            return;
	        }

	        Node temp = head;
	        Node prev = null;

	        // Search for the node to be deleted
	        do {
	            prev = temp;
	            temp = temp.next;
	        } while (temp != head && temp.data != key);

	        // If node to be deleted was found
	        if (temp.data == key) {
	            prev.next = temp.next;
	        }
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

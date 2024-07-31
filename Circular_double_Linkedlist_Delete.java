package datastructures;

public class Circular_double_Linkedlist_Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Circular_double_Linkedlist_Delete cdll = new Circular_double_Linkedlist_Delete();
	        cdll.insertAtEnd(10);
	        cdll.insertAtEnd(20);
	        cdll.insertAtEnd(30);
	        cdll.insertAtEnd(40);

	        System.out.println("Circular Doubly Linked List (Forward):");
	        cdll.displayForward();

	        cdll.deleteFromBeginning();
	        System.out.println("List after deleting from beginning:");
	        cdll.displayForward();

	        cdll.deleteFromEnd();
	        System.out.println("List after deleting from end:");
	        cdll.displayForward();

	        cdll.deleteNode(cdll.head.next);
	        System.out.println("List after deleting specific node:");
	        cdll.displayForward();
	}

	static class Node {
        int data;
        Node prev;
        Node next;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Head and tail of the circular doubly linked list
    private Node head;
    private Node tail;

    // Constructor to create an empty circular doubly linked list
    public Circular_double_Linkedlist_Delete() {
        head = null;
        tail = null;
    }

    // Method to insert a new node at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            newNode.prev = tail;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
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
            tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
    }

    // Method to delete a node from the end of the list
    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is empty, no node to delete.");
            return;
        }
        if (tail.prev == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
    }

    // Method to delete a specific node
    public void deleteNode(Node delNode) {
        if (head == null || delNode == null) {
            System.out.println("List is empty or node to delete is null.");
            return;
        }

        // If node to be deleted is head node
        if (head == delNode) {
            deleteFromBeginning();
            return;
        }

        // If node to be deleted is tail node
        if (tail == delNode) {
            deleteFromEnd();
            return;
        }

        delNode.prev.next = delNode.next;
        delNode.next.prev = delNode.prev;
    }

    // Method to display the list from head to tail
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // Method to display the list from tail to head
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = tail;
        do {
            System.out.print(current.data + " ");
            current = current.prev;
        } while (current != tail);
        System.out.println();
    }
}

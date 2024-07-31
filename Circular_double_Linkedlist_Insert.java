package datastructures;

public class Circular_double_Linkedlist_Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Circular_double_Linkedlist_Insert cdll = new Circular_double_Linkedlist_Insert();
	        cdll.insertAtBeginning(10);
	        cdll.insertAtBeginning(20);
	        cdll.insertAtEnd(30);
	        cdll.insertAfter(cdll.head.next, 25);

	        System.out.println("Circular Doubly Linked List (Forward):");
	        cdll.displayForward();

	        System.out.println("Circular Doubly Linked List (Backward):");
	        cdll.displayBackward();
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
    public Circular_double_Linkedlist_Insert() {
        head = null;
        tail = null;
    }

    // Method to insert a new node at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            newNode.prev = tail;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
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

    // Method to insert a new node after a given node
    public void insertAfter(Node prevNode, int data) {
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
        if (prevNode == tail) {
            tail = newNode;
        }
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

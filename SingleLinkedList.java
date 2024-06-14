package datastructures;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class SingleLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		  SingleLinkedList list = new SingleLinkedList();
	        
	        // Insertion at the beginning
	        list.insertAtBeginning(5);
	        list.insertAtBeginning(4);
	        
	        // Insertion at the end
	        list.insertAtEnd(7);
	        list.insertAtEnd(9);
	        
	        // Insertion at specific location
	        list.insertAtLocation(4, 2);
	        list.insertAtLocation(6, 3);
	        
	        // Print the linked list
	        list.printList();
	}
	
	Node head;

    SingleLinkedList() {
        this.head = null;
    }

    // Insertion at the beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
 // Insertion at the end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    
 // Insertion at a specific location
    void insertAtLocation(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

 // Utility function to print the linked list
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}

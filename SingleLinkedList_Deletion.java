package datastructures;



public class SingleLinkedList_Deletion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SingleLinkedList_Deletion list = new SingleLinkedList_Deletion();

        // Insertion at the beginning
        list.insertAtBeginning(5);
        list.insertAtBeginning(3);

        // Insertion at the end
        list.insertAtEnd(7);
        list.insertAtEnd(9);

        // Deletion at the beginning
        list.deleteAtBeginning();

        // Deletion at the end
        list.deleteAtEnd();

        // Insertion at the end
        list.insertAtEnd(11);

        // Deletion at specific location
        list.deleteAtLocation(1);

        // Print the linked list
        list.printList();
    
	}

	
	 Node head;

	    SingleLinkedList_Deletion() {
	        this.head = null;
	    }

	    // Insertion at the beginning
	    void insertAtBeginning(int data) {
	        Node newNode = new Node(data);
	        newNode.next = head;
	        head = newNode;
	    }

	    // Deletion at the beginning
	    void deleteAtBeginning() {
	        if (head == null) {
	            System.out.println("List is empty. Nothing to delete.");
	            return;
	        }
	        head = head.next;
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

	    // Deletion at the end
	    void deleteAtEnd() {
	        if (head == null) {
	            System.out.println("List is empty. Nothing to delete.");
	            return;
	        }
	        if (head.next == null) {
	            head = null;
	            return;
	        }
	        Node temp = head;
	        while (temp.next.next != null) {
	            temp = temp.next;
	        }
	        temp.next = null;
	    }

	    // Deletion at a specific location
	    void deleteAtLocation(int position) {
	        if (head == null) {
	            System.out.println("List is empty. Nothing to delete.");
	            return;
	        }
	        if (position == 0) {
	            head = head.next;
	            return;
	        }
	        Node temp = head;
	        for (int i = 0; temp != null && i < position - 1; i++) {
	            temp = temp.next;
	        }
	        if (temp == null || temp.next == null) {
	            return;
	        }
	        temp.next = temp.next.next;
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

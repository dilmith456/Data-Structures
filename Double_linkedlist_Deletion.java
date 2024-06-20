// Double_linkedlist_Deletion class manages the doubly linked list operations
package datastructures;
public class Double_linkedlist_Deletion {
    private class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public Double_linkedlist_Deletion() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Method to delete node from the beginning of the doubly linked list
    public void deleteFromBeginning() {
        if (isEmpty()) {
            System.out.println("Doubly linked list is empty. Deletion not possible.");
            return;
        }
        if (head == tail) { // Only one element in the list
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    // Method to delete node from the end of the doubly linked list
    public void deleteFromEnd() {
        if (isEmpty()) {
            System.out.println("Doubly linked list is empty. Deletion not possible.");
            return;
        }
        if (head == tail) { // Only one element in the list
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    // Method to delete node at a specific index in the doubly linked list
    public void deleteAt(int index) {
        if (isEmpty()) {
            System.out.println("Doubly linked list is empty. Deletion not possible.");
            return;
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            deleteFromBeginning();
        } else if (index == size - 1) {
            deleteFromEnd();
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    // Method to check if the doubly linked list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to display the elements of the doubly linked list
    public void display() {
        Node current = head;
        System.out.print("Doubly linked list: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Double_linkedlist_Deletion dll = new Double_linkedlist_Deletion();

        // Inserting elements for demonstration
        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        dll.insertAtEnd(50);
        dll.display(); // Output: Doubly linked list: 10 20 30 40 50

        // Deleting element from the beginning
        dll.deleteFromBeginning();
        dll.display(); // Output: Doubly linked list: 20 30 40 50

        // Deleting element from the end
        dll.deleteFromEnd();
        dll.display(); // Output: Doubly linked list: 20 30 40

        // Deleting element at specific index
        dll.deleteAt(1); // Deleting element at index 1
        dll.display(); // Output: Doubly linked list: 20 40
    }

    // Method to insert data at the end of the doubly linked list (used for demonstration)
    private void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
}

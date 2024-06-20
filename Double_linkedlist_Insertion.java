package datastructures;
public class Double_linkedlist_Insertion {

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// Double_linkedlist_Insertion class manages the doubly linked list operations

    private Node head;
    private Node tail;
    private int size;

    public Double_linkedlist_Insertion() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Method to insert data at the beginning of the doubly linked list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Method to insert data at the end of the doubly linked list
    public void insertAtEnd(int data) {
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

    // Method to insert data at a specific index in the doubly linked list
    public void insertAt(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            insertAtBeginning(data);
        } else if (index == size) {
            insertAtEnd(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
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
        Double_linkedlist_Insertion dll = new Double_linkedlist_Insertion();

        // Inserting elements at the beginning
        dll.insertAtBeginning(10);
        dll.insertAtBeginning(20);
        dll.insertAtBeginning(30);
        dll.display(); // Output: Doubly linked list: 30 20 10

        // Inserting elements at the end
        dll.insertAtEnd(40);
        dll.insertAtEnd(50);
        dll.display(); // Output: Doubly linked list: 30 20 10 40 50

        // Inserting element at specific index
        dll.insertAt(2, 25); // Inserting 25 at index 2
        dll.display(); // Output: Doubly linked list: 30 20 25 10 40 50
    }
}

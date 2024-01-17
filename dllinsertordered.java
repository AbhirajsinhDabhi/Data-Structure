import java.util.Scanner;

class DoublyLinkedList {
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

    Node head;

    void insertOrdered(int data) {
        Node newNode = new Node(data);
        if (head == null || data < head.data) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < data) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
        }
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class dllinsertordered {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);

        list.insertOrdered(5);
        list.insertOrdered(2);
        list.insertOrdered(7);
        list.insertOrdered(4);

        System.out.println("Ordered Doubly Linked List:");
        list.display();
        scanner.close();
    }
}
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public void deleteDuplicates() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class duplicatevalue {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(2);
        Node fourth = new Node(3);
        Node fifth = new Node(3);
        list.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        System.out.println("Linked List before deleting duplicates:");
        list.display();

        list.deleteDuplicates();
        System.out.println("Linked List after deleting duplicates:");
        list.display();
    }
}

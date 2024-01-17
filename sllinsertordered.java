import java.util.Scanner;

class LinkedList {
    class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    node first = null;

    void insertOrdered(int data) {
        node n = new node(data);
        if (first == null || data < first.data) {
            n.next = first;
            first = n;
        } else {
            node current = first;
            while (current.next != null && current.next.data < data) {
                current = current.next;
            }
            n.next = current.next;
            current.next = n;
        }
    }

    void display() {
        node current = first;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class sllinsertordered {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        list.insertOrdered(5);
        list.insertOrdered(2);
        list.insertOrdered(7);
        list.insertOrdered(4);

        System.out.println("Ordered Linked List:");
        list.display();

        System.out.print("Enter a value to insert in an ordered way: ");
        int x = scanner.nextInt();
        list.insertOrdered(x);

        System.out.println("Ordered Linked List after insertion:");
        list.display();
        scanner.close();
    }
}
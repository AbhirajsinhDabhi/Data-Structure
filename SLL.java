import java.util.*;

class SLL {
    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    Node first = null;

    void insertAtFirst(int x) {
        Node n = new Node(x);
        if (first == null) {
            first = n;
        } else {
            n.next = first;
            first = n;
        }
    }

    void insertAtLast(int x) {
        Node n = new Node(x);
        if (first == null) {
            first = n;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    void insertBeforeValue(int x, int y) {
        int flag = 0;
        Node t = first;
        while (t != null) {
            if (t.data == y) {
                flag = 1;
            }
            t = t.next;
        }
        if (flag == 0) {
            System.out.println("Search Node Not Found");
        } else {
            Node n = new Node(x);
            if (first.data == y) {
                n.next = first;
                first = n;
            } else {
                Node temp = first;
                while (temp.next.data != y) {
                    temp = temp.next;
                }
                n.next = temp.next;
                temp.next = n;
            }
        }
    }

    void insertAfterValue(int x, int y) {
        int flag = 0;
        Node t = first;
        while (t != null) {
            if (t.data == y) {
                flag = 1;
            }
            t = t.next;
        }
        if (flag == 0) {
            System.out.println("Search Node Not Found");
        } else {
            Node n = new Node(x);
            Node temp = first;
            while (temp.data != y) {
                temp = temp.next;
            }
            n.next = temp.next;
            temp.next = n;
        }
    }

    int deleteAtFirst() {
        if (first == null) {
            System.out.println("Unserflow");
            return 0;
        } else {
            int del = first.data;
            first = first.next;
            return del;
        }
    }

    void deleteAtLast() {
        if (first == null) {
            System.out.println("Underflow");
        } else {
            Node temp = first;
            Node pre = null;
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;
            }
            int del = pre.next.data;
            pre.next = null;
            System.out.println("Deleted Element : " + del);
        }
    }

    void deleteSpecificValue(int del) {
        Node t = first;
        int flag = 0;
        while (t != null) {
            if (t.data == del) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("Search Node Note Found");
        } else {
            if (first.data == del) {
                first = first.next;
            } else {
                Node pre = null;
                Node temp = first;
                while (temp.next.data != del) {
                    pre = temp;
                    temp = temp.next;
                }
                int delete = temp.next.data;
                temp.next = pre.next.next;
                System.out.println("Deleted Element : " + delete);
            }
        }
    }

    void display() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.data + "--->");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}

class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL s = new SLL();
        while (true) {
            System.out.println(
                    "1. Insert At First \n2. Insert At Last \n3. Insert Before Value \n4. Insert After Value \n5. Delete At First \n6. Delete At Last \n7. Delete Specific Value \n8. Display \n9. Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter Element");
                    int n1 = sc.nextInt();
                    s.insertAtFirst(n1);
                    break;

                case 2:
                    System.out.println("Enter Element");
                    int n2 = sc.nextInt();
                    s.insertAtLast(n2);
                    break;

                case 3:
                    System.out.println("Enter Element : ");
                    int n3 = sc.nextInt();
                    System.out.println("Enter Position : ");
                    int y = sc.nextInt();
                    s.insertBeforeValue(n3, y);
                    break;

                case 4:
                    System.out.println("Enter Element : ");
                    int n4 = sc.nextInt();
                    System.out.println("Enter Position : ");
                    int y1 = sc.nextInt();
                    s.insertAfterValue(n4, y1);
                    break;

                case 5:
                    s.deleteAtFirst();
                    break;

                case 6:
                    s.deleteAtLast();
                    break;

                case 7:
                    System.out.println("Enter Index You want to delete");
                    int a = sc.nextInt();
                    s.deleteSpecificValue(a);
                    break;

                case 8:
                    s.display();
                    break;

                case 9:
                    System.exit(0);
                    break;
            }
            sc.close();
        }
    }
}
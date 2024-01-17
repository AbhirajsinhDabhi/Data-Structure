import java.util.Scanner;

class DLL {
    class Node {
        int data;
        Node next;
        Node pre;

        Node(int data) {
            this.data = data;
            next = null;
            pre = null;
        }
    }

    Node first = null;

    void insertFirst(int data) {
        Node n = new Node(data);
        if (first == null) {
            first = n;
        } else {
            n.next = first;
            first.pre = n;
            first = n;
        }
    }

    void insertLast(int data) {
        Node n = new Node(data);
        if (first == null) {
            first = n;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            n.pre = temp;
            temp.next = n;
        }
    }

    void delteFirst() {
        if (first == null) {
            System.out.println("LinkedList IS Empty");
        } else if (first.next == null && first.pre == null) {
            first = null;
        } else {
            Node del = first;
            first = first.next;
            first.pre = null;
            del.next = null;
        }
    }

    void deleteLast() {
        if (first == null) {
            System.out.println("LinkedList Is Empty");
        } else if (first.next == null && first.pre == null) {
            first = null;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.pre.next = null;
            temp.pre = null;
        }
    }

    void insertBeforeValue(int data, int x) {
        int flag = 0;
        Node p = first;
        while (p != null) {
            if (p.data == x) {
                flag = 1;
            }
            p = p.next;
        }
        if (flag == 0) {
            System.out.println("Value Does NOt Available or LinkedList is Empty");
        } else {
            Node n = new Node(data);
            if (first.data == x) {
                n.next = first;
                first.pre = n;
                first = n;
            } else {
                Node temp = first;
                while (temp.next.data != x) {
                    temp = temp.next;
                }
                n.next = temp.next;
                n.pre = temp;
                temp.next.pre = n;
                temp.next = n;
            }
        }
    }

    void insertaftervalue(int data, int x) {
        int flag = 0;
        Node p = first;
        while (p != null) {
            if (p.data == x) {
                flag = 1;
            }
            p = p.next;
        }
        if (flag == 0) {
            System.out.println("Value Does NOt Available or LinkedList is Empty");
        } else {
            Node n = new Node(data);
            if (first.data == x) {
                n.next = first.next;
                n.pre = first;
                first.next = n;
            } else {
                Node temp = first;
                while (temp.data != x) {
                    temp = temp.next;
                }
                n.next = temp.next;
                n.pre = temp;
                temp.next.pre = n;
                temp.next = n;
            }
        }
    }

    void deleteParticularValue(int x) {
        int flag = 0;
        Node p = first;
        while (p != null) {
            if (p.data == x) {
                flag = 1;
            }
            p = p.next;
        }
        if (flag == 0) {
            System.out.println("Value Does Not Exist Or LinkedList Is Empty");
        } else {
            Node q = first;
            if (first.data == x && first.next == null) {
                first = null;
            } else if (first.data == x && first.next != null) {
                first = first.next;
                first.pre = null;
                q.next = null;
            } else {
                Node temp = first;
                while (temp.next.data != x) {
                    temp = temp.next;
                }
                if (temp.next.next == null) {
                    temp.next.pre = null;
                    temp.next = null;
                } else {
                    Node r = temp.next;
                    r.next.pre = temp;
                    temp.next = r.next;
                    r.next = null;
                    r.pre = null;
                }
            }
        }
    }

    void display() {
        if (first == null) {
            System.out.println("LinkedList Is Empty");
        } else {
            Node temp = first;
            while (temp.next != null) {
                System.out.print(temp.data + "-->");
                temp = temp.next;
            }
            System.out.println(temp.data + "-->null");
        }
    }
}

class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL d = new DLL();
        while (true) {
            System.out.println(
                    "1. Insert At First \n2. Insert At Last \n3. Delete At First \n4. Delete At Last \n5. insert Before Value \n6. insert after Value \n7. Delete Particular Value \n8. Display \n9. Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter Element");
                    int n1 = sc.nextInt();
                    d.insertFirst(n1);
                    break;

                case 2:
                    System.out.println("Enter Element");
                    int n2 = sc.nextInt();
                    d.insertLast(n2);
                    break;

                case 3:
                    d.delteFirst();
                    break;

                case 4:
                    d.deleteLast();
                    break;

                case 5:
                    System.out.println("Enter Element : ");
                    int i = sc.nextInt();
                    System.out.println("Enter Position : ");
                    int i1 = sc.nextInt();
                    d.insertBeforeValue(i, i1);
                    break;

                case 6:
                    System.out.println("Enter Element : ");
                    int ii = sc.nextInt();
                    System.out.println("Enter Position : ");
                    int i11 = sc.nextInt();
                    d.insertBeforeValue(ii, i11);
                    break;

                case 7:
                    System.out.println("Enter Value That You Want To Delete : ");
                    int i2 = sc.nextInt();
                    d.deleteParticularValue(i2);
                    break;

                case 8:
                    d.display();
                    break;

                case 9:
                    System.exit(0);
            }
            sc.close();
        }
    }
}
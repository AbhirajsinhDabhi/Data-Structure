import java.util.Scanner;

class cll {
    class node {
        int data;
        node next;

        node(int n) {
            data = n;
            next = null;
        }
    }

    node first = null;

    void insertatfirst(int x) {
        node n = new node(x);
        if (first == null) {
            first = n;
            n.next = first;
        } else {
            node temp = first;
            while (temp.next != first) {
                temp = temp.next;
            }
            n.next = first;
            first = n;
            temp.next = n;
        }
    }

    void insertatlast(int x) {
        node n = new node(x);
        if (first == null) {
            first = n;
            n.next = first;
        } else {
            node temp = first;
            while (temp.next != first) {
                temp = temp.next;
            }
            n.next = first;
            temp.next = n;
        }
    }

    void deleteatfirst() {
        if (first == null) {
            System.out.println("cll is empty");
        } else {
            node temp = first;
            if (temp.next == first) {
                first = null;
            } else {
                while (temp.next != first) {
                    temp = temp.next;
                }
                node delete = first;
                first = first.next;
                temp.next = first;
                delete.next = null;
            }
        }
    }

    void deleteatlast() {
        if (first == null) {
            System.out.println("cll is empty");
        } else {
            node temp = first;
            if (temp.next == first) {
                first = null;

            } else {
                while (temp.next.next != first) {
                    temp = temp.next;
                }
                temp.next.next = null;
                temp.next = first;
            }
        }
    }

    void insertbeforevalue(int x, int y) {
        int flag = 0;
        node temp = first;
        while (temp != first) {
            if (temp.data == y) {
                flag = 1;
            }
            temp = temp.next;
        }
        if (flag == 0) {
            System.out.println("seach element is not found");
        } else {
            node n = new node(x);
            if (first.data == y && first.next == first) {
                first = n;
            } else if (first.data == y && first.next != first) {
                while (temp.next != first) {
                    temp = temp.next;
                }
                n.next = first;
                first = n;
                temp.next = first;
            } else {
                while (temp.next.data != y) {
                    temp = temp.next;
                }
                n.next = temp.next;
                temp.next = n;
            }
        }
    }

    void insertaftervalue(int x, int y) {
        int flag = 0;
        node temp = first;
        while (temp != first) {
            if (temp.data == y) {
                flag = 1;
            }
            temp = temp.next;
        }
        if (flag == 0) {
            System.out.println("seach element is not found");
        } else {
            node n = new node(x);
            if (first.data == y && first.next != first) {
                node tempp = first;
                while (tempp.next != first) {
                    tempp = tempp.next;
                }
                n.next = first;
                first.next = n;
                // temp.next = first;
            } else {
                node test = first;
                while (test.data != y) {
                    test = test.next;
                }
                n.next = test.next;
                test.next = n;
            }
        }
    }

    void deleteSpecificValue(int x) {
        int flag = 0;
        node t = first;
        while (t != first) {
            if (t.data == x) {
                flag = 1;
            }
            t = t.next;
        }
        if (flag == 0) {
            System.out.println("seach element is not found");
        } else {
            node temp = first;

            if (first.data == x && first.next == first) {
                first = null;
            } else if (first.data == x && first.next != first) {
                while (temp.next != first) {
                    temp = temp.next;
                }
                node delete = first;
                first = first.next;
                temp.next = first;
                delete.next = null;
            } else {
                while (temp.next.data != x) {
                    temp = temp.next;
                }
                node q = temp.next;
                temp.next = temp.next.next;
                q.next = null;
            }
        }
    }

    void display() {
        if (first == null) {
            System.out.println("cll is empty");
        } else {
            node temp = first;
            while (temp.next != first) {
                System.out.print(temp.data + "-->");
                temp = temp.next;
            }
            System.out.print(temp.data + "-->first");
        }
    }
}

class circulerl1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cll s = new cll();
        while (true) {
            System.out.println(
                    "1. Insert At First \n2. Insert At Last \n3. Insert Before Value \n4. Delete At First \n5. Delete At Last \n6. Delete Specific Value \n7. Display \n8. Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter Element");
                    int n1 = sc.nextInt();
                    s.insertatfirst(n1);
                    break;

                case 2:
                    System.out.println("Enter Element");
                    int n2 = sc.nextInt();
                    s.insertatlast(n2);
                    break;

                case 3:
                    System.out.println("Enter Element : ");
                    int n3 = sc.nextInt();
                    System.out.println("Enter Position : ");
                    int y = sc.nextInt();
                    s.insertbeforevalue(n3, y);
                    break;

                case 4:
                    s.deleteatfirst();
                    break;

                case 5:
                    s.deleteatlast();
                    break;

                case 6:
                    System.out.println("Enter Index You want to delete");
                    int a = sc.nextInt();
                    s.deleteSpecificValue(a);
                    break;

                case 7:
                    s.display();
                    break;

                case 8:
                    System.exit(0);
            }
            sc.close();
        }
    }

}

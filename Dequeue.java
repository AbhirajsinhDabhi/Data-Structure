import java.util.*;

class Dequeue {
    int F = -1;
    int R = -1;
    int N;
    int Q[];

    Dequeue(int n) {
        Q = new int[n];
        N = n;
    }

    void insertAtRear(int x) {
        if ((R == N - 1 && F == 0) || (F == R + 1)) {
            System.out.println("Queue Is Overflow");
        } else if (R == N - 1) {
            R = 0;
            Q[R] = x;

        } else if (R == -1 && F == -1) {
            F = 0;
            R = 0;
            Q[R] = x;
        } else {
            R++;
            Q[R] = x;
        }
    }

    void insertAtFront(int x) {
        if ((R == N - 1 && F == 0) || (F == R + 1)) {
            System.out.println("Queue Is Overflow");
        } else if (F == 0) {
            F = N - 1;
            Q[F] = x;
        } else if (F == -1 && R == -1) {
            F = 0;
            R = 0;
            Q[F] = x;
        } else {
            F = F - 1;
            Q[F] = x;
        }
    }

    void deleteAtfront() {
        if (F == -1 && R == -1) {
            System.out.println("Queue Is Underflow");
        } else {
            int x = Q[F];
            if (F == R) {
                F = -1;
                R = -1;
            } else if (F == N - 1) {
                F = 0;
            } else {
                F++;
            }
            System.out.println("Deleted Element : " + x);
        }
    }

    void deleteAtRear() {
        if (F == -1 && R == -1) {
            System.out.println("Queue Is Underflow");
        } else {
            int x = Q[R];
            if (F == R) {
                R = -1;
                F = -1;

            } else if (R == 0) {
                R = N - 1;
            } else {
                R--;
            }
            System.out.println("Deleted Element : " + x);
        }
    }

    void getRearPointer() {
        System.out.println("Rear Pointer Is : " + R);
    }

    void getFrontPointer() {
        System.out.println("Front Pointer Is : " + F);
    }

    void checkForQueueIsEmpty() {
        if (F == -1) {
            System.out.println("Queue Is Empty");
        } else {
            System.out.println("Queue Note Is Empty");

        }
    }

    void checkForQueueIsFull() {
        if ((R == N - 1 && F == 0) || F == R + 1) {
            System.out.println("Queue Is Overflow");
        } else {
            System.out.println("queue is not overflow");
        }
    }

    void display() {
        if (F == -1) {
            System.out.println("Queue Is Empty");
        } else {
            int i;
            for (i = F; i != R; i = (i + 1) % N) {
                System.out.println(Q[i] + "-->");
            }
            // System.out.println(Q[i]);
            // int i=F;
            // while(i!=R)
            // {
            // System.out.println(Q[i]+" ");
            // i=(i+1)%N;

            // }
            // System.out.println(Q[i]);
        }

    }
}

class main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size Of Queue");
        int n = sc.nextInt();
        Dequeue d = new Dequeue(n);

        while (true) {
            System.out.println(
                    "1. Insert At Reat \n2. Insert At Front \n3. Delete At Front \n4. Delete At Rear \n5. Get Rear Point \n6. Get Front Point \n7. Check For Queue Is Empty \n8. Check FOr Queue Is Full \n9. Display \n10. Exit");
            System.out.println("Enter Your Choice : ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter Queue Element : ");
                    int i = sc.nextInt();
                    d.insertAtRear(i);
                    break;

                case 2:
                    System.out.println("Enter Queue Element : ");
                    int i1 = sc.nextInt();
                    d.insertAtFront(i1);
                    break;

                case 3:
                    d.deleteAtfront();
                    break;

                case 4:
                    d.deleteAtRear();
                    break;

                case 5:
                    d.getRearPointer();
                    break;

                case 6:
                    d.getRearPointer();
                    break;

                case 7:
                    d.checkForQueueIsEmpty();
                    break;

                case 8:
                    d.checkForQueueIsFull();
                    break;

                case 9:
                    d.display();
                    break;

                case 10:
                    System.exit(0);
            }
            sc.close();
        }
    }
}
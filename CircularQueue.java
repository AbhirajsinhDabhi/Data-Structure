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

    void insert(int x) {
        if ((R == N - 1 && F == 0) || (F == R + 1)) {
            System.out.println("Queue Is Overflow");
        } else {
            if (F == -1) {
                F = 0;
            }
            R = (R + 1) % N;
            Q[R] = x;
        }
    }

    void delete() {
        if (F == -1) {
            System.out.println("Queue Is Underflow");
        } else {
            int y = Q[F];
            if (F == R) {
                F = -1;
                R = -1;
            } else {
                F = (F + 1) % N;

            }
            System.out.println("deleted element =" + y);
        }
    }

    void getRearPointer() {
        System.out.println("Rear Pointer Is : " + R);
    }

    void getFrontPointer() {
        System.out.println("Front Pointer Is : " + F);
    }

    void display() {
        if (F == -1) {
            System.out.println("Queue Is Empty");
        } else {
            int i;
            for (i = F; i != R; i = (i + 1) % N) {
                System.out.println(Q[i]);
            }
            System.out.println(Q[i]);
        }
    }
}

class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size Of Queue");
        int n = sc.nextInt();
        Dequeue d = new Dequeue(n);

        while (true) {
            System.out.println(
                    "1. Insert \n2.Delete \n3. Get Rear Point \n4. Get Front Point \n5. Display \n6. Exit");
            System.out.println("Enter Your Choice : ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter Queue Element : ");
                    int i = sc.nextInt();
                    d.insert(i);
                    break;

                case 2:
                    d.delete();
                    break;

                case 3:
                    d.getRearPointer();
                    break;

                case 4:
                    d.getRearPointer();
                    break;

                case 5:
                    d.display();
                    break;

                case 6:
                    System.exit(0);
                    break;
            }
            sc.close();
        }
    }
}
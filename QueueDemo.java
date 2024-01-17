import java.util.*;

class QueueDemo {
    int F = -1;
    int R = -1;
    int N;
    int Q[];

    QueueDemo(int n) {
        Q = new int[n];
        N = n;
    }

    void insert(int x) {
        if (R >= N - 1) {
            System.out.println("Queue Is Overflow");
        } else {
            R++;
            Q[R] = x;
            if (F == -1) {
                F = 0;
            }
        }
    }

    void delete() {
        if (F == -1) {
            System.out.println("Queue Is Underflow");
        } else {
            int y = Q[F];
            if (F == R) {
                F = R = -1;
            } else {
                F = F + 1;
            }
            System.out.println("Deleted Element : " + y);
        }
    }

    void display() {
        if (F == -1) {
            System.out.println("Queue Is Empty");
        } else {
            for (int i = F; i <= R; i++) {
                System.out.println(Q[i]);
            }
        }
    }
}

class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size Of Queue : ");
        int n = sc.nextInt();
        QueueDemo q = new QueueDemo(n);

        while (true) {
            System.out.println("1. Insert \n2. Delete \n3. Display\n4. Exit");
            System.out.println("Enter Your Choice : ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter Queue Element : ");
                    int i = sc.nextInt();
                    q.insert(i);
                    break;

                case 2:
                    q.delete();
                    break;

                case 3:
                    q.display();
                    break;

                case 4:
                    System.exit(0);
            }
            sc.close();
        }
    }
}
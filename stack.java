import java.util.Scanner;

public class stack {
    int a[];
    int top = -1;
    int size;

    stack(int n) {
        a = new int[n];
        size = n;
    }

    void push(int x) {
        if (top == size - 1) {
            System.out.println("stack is overflow");
        } else {
            top++;
            a[top] = x;
        }
    }

    void pop() {
        if (top == -1) {
            System.out.println("stack is underflow");
        } else {
            int data = a[top];
            top--;
            System.out.println("poped element is =" + data);
        }
    }

    void peep(int i) {
        if ((top - i + 1) <= 0) {
            System.out.println("stack is underflow");
        } else {
            System.out.println("deleted element is " + a[top - i + 1]);
        }
    }

    void change(int index, int value) {
        if (index >= 0 && index <= top) {
            a[index] = value;
        } else {
            System.out.println("not index you want to change");
        }
    }

    void display() {
        for (int i = 0; i <= top; i++) {
            System.out.println(a[i]);
        }
    }

}

class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of stack =");
        int n = sc.nextInt();
        stack s = new stack(n);
        while (true) {
            System.out.println("======================");
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peep");
            System.out.println("4. change");
            System.out.println("5. dispaly");
            System.out.println("6. exist");
            System.out.println("======================");
            System.out.println("enter your chice =");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("enter element that you want to add =");
                    int x = sc.nextInt();
                    s.push(x);
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    System.out.println("enter element that you want to peep =");
                    int y = sc.nextInt();
                    s.peep(y);
                    break;
                case 4:
                    System.out.println("enter element =");
                    int q = sc.nextInt();
                    System.out.println("enter position =");
                    int p = sc.nextInt();
                    s.change(q, p);
                    break;
                case 5:
                    s.display();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("enter valid choice =");
                    break;
            }
            sc.close();
        }
    }
}
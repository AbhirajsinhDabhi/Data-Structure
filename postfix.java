import java.util.Stack;

public class postfix {
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                // If the character is a digit, push it onto the stack
                stack.push(ch - '0');
            } else {
                // If the character is an operator, pop the top two operands from the stack,
                // perform the operation, and push the result back onto the stack
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }
        // The result of the postfix expression will be at the top of the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixExpression = "23*5+"; // Example postfix expression: 2 * 3 + 5
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result of the postfix expression is: " + result);
    }
}